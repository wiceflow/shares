package com.wiceflow.shares.service.inter.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiceflow.shares.common.entity.SharesAnalysis;
import com.wiceflow.shares.common.entity.SharesDayBaseInfo;

import java.util.List;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 保存分析的股票类 Service
 */
public interface SharesAnalysisService extends IService<SharesAnalysis> {

    /**
     * 每日股票信息检查，是否有新上市与退市的
     *
     * @param sharesDayBaseInfos [SharesDayBaseInfo] 每日股票信息
     */
    void inspectBaseShares(List<SharesDayBaseInfo> sharesDayBaseInfos);
}

