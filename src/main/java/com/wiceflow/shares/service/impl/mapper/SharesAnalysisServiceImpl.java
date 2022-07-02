package com.wiceflow.shares.service.impl.mapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wiceflow.shares.common.entity.SharesAnalysis;
import com.wiceflow.shares.common.entity.SharesBaseField;
import com.wiceflow.shares.common.entity.SharesDayBaseInfo;
import com.wiceflow.shares.mapper.SharesAnalysisMapper;
import com.wiceflow.shares.service.inter.mapper.SharesAnalysisService;
import com.wiceflow.shares.util.CollectionUtil;
import com.wiceflow.shares.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author BF
 * @date 2022/7/2
 * <p>
 * 存分析的股票类 Service 具体实现类
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SharesAnalysisServiceImpl extends ServiceImpl<SharesAnalysisMapper, SharesAnalysis> implements SharesAnalysisService {


    /**
     * 每日股票信息检查，是否有新上市与退市的
     *
     * @param sharesDayBaseInfos [SharesDayBaseInfo] 每日股票信息
     */
    @Override
    public void inspectBaseShares(List<SharesDayBaseInfo> sharesDayBaseInfos) {
        if (CollectionUtil.isEmpty(sharesDayBaseInfos)) {
            return;
        }
        List<SharesAnalysis> analysisDataList = list();
        if (CollectionUtil.isEmpty(analysisDataList)) {
            log.info("第一次更新分析类股票，正在创建... ...");
            saveBatch(baseToAnalysis(sharesDayBaseInfos));
            return;
        }
        inspectBaseShares(sharesDayBaseInfos, analysisDataList);
    }


    /**
     * 比对股票信息是否有新上市或退市
     *
     * @param sharesDayBaseInfos [SharesDayBaseInfo] 每日股票信息
     * @param analysisDataList   [SharesAnalysis] 分析股票表
     */
    private void inspectBaseShares(List<SharesDayBaseInfo> sharesDayBaseInfos, List<SharesAnalysis> analysisDataList) {
        // 新的股票故居和已存在的股票数据做对比，若找不到，则为新上市股票，入库
        Map<String, String> exitMap = analysisDataList.stream().collect(Collectors.toMap(SharesAnalysis::getSharesNum, SharesAnalysis::getSharesName));
        List<SharesDayBaseInfo> newSharesData = new ArrayList<>();
        sharesDayBaseInfos.forEach(e -> {
            String sharesNum = e.getSharesNum();
            String sharesName = exitMap.get(sharesNum);
            // 如果为空，则代表这是一只新的股票
            if (StringUtil.isEmpty(sharesName)) {
                newSharesData.add(e);
            }
        });
        // 已存在的股票和新的股票做对比，若不存在，则代表股票已退市，软删除
        Map<String, String> newMap = sharesDayBaseInfos.stream().collect(Collectors.toMap(SharesBaseField::getSharesNum, SharesBaseField::getSharesName));
        List<SharesAnalysis> deleteSharesData = new ArrayList<>();
        analysisDataList.forEach(e -> {
            String sharesNum = e.getSharesNum();
            String sharesName = newMap.get(sharesNum);
            // 如果为空，则代表股票退市了
            if (StringUtil.isEmpty(sharesName)) {
                deleteSharesData.add(e);
            }
        });
        // 更新数据库操作 保存新上市股票
        if (CollectionUtil.isNotEmpty(newSharesData)) {
            log.info("出现新上市股票，正在入库... 正在入库更新... ");
            log.info("新上市股票为  ->  {}", newSharesData.toString());
            saveBatch(baseToAnalysis(newSharesData));
        }
        // 更新数据库操作 软删除
        if (CollectionUtil.isNotEmpty(deleteSharesData)) {
            log.info("出现退市股票，正在进行软删除... 正在更新数据库...");
            log.info("退市股票为  -  {}>", deleteSharesData.toString());
            deleteSharesData.forEach(e -> e.setIsDelisted(1));
            updateBatchById(deleteSharesData);
        }
    }


    /**
     * 将每日股票数据转为 分析股票表
     *
     * @param sharesDayBaseInfos [SharesDayBaseInfo] 每日股票信息
     * @return [SharesAnalysis] 分析股票表
     */
    private List<SharesAnalysis> baseToAnalysis(List<SharesDayBaseInfo> sharesDayBaseInfos) {
        List<SharesAnalysis> list = new ArrayList<>(sharesDayBaseInfos.size());
        sharesDayBaseInfos.forEach(e -> {
            SharesAnalysis analysis = new SharesAnalysis();
            analysis.setSharesName(e.getSharesName());
            analysis.setSharesNum(e.getSharesNum());
            // 默认没有退市
            analysis.setIsDelisted(0);
            analysis.setSharesNewPrice(e.getSharesNewPrice());
            analysis.setSharesReceivedYesterday(e.getSharesReceivedYesterday());
            list.add(analysis);
        });
        return list;
    }
}
