package com.wiceflow.shares.service.impl.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wiceflow.shares.common.dto.SharesDateRoamDTO;
import com.wiceflow.shares.common.entity.SharesDate;
import com.wiceflow.shares.mapper.SharesDateMapper;
import com.wiceflow.shares.service.inter.mapper.SharesDateService;
import com.wiceflow.shares.util.CollectionUtil;
import com.wiceflow.shares.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author BF
 * @date 2022/7/2
 * <p>
 * 日期保存表，主要和十日股票信息保存表联合使用 具体实现类
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SharesDateServiceImpl extends ServiceImpl<SharesDateMapper, SharesDate> implements SharesDateService {

    /**
     * 日期数据默认为10条
     */
    public static final Integer DATE_LIST_SIZE = 10;

    /**
     * 插入一条记录
     *
     * @return [SharesDateRoamDTO]  股票日期流转类
     */
    @Override
    public SharesDateRoamDTO insertSharesDate() {
        SharesDateRoamDTO sharesDateRoamDTO = new SharesDateRoamDTO();
        // 默认设置成功
        sharesDateRoamDTO.setInsertSuccess(true);

        Date date = DateUtil.getWeekDays();
        SharesDate sharesDate = new SharesDate();
        sharesDate.setSharesDate(date);
        sharesDate.setSoftDelete(0);
        // 获取所有未被软删除的数据
        List<SharesDate> list = list(Wrappers.<SharesDate>lambdaQuery().eq(SharesDate::getSoftDelete, 0));
        if (CollectionUtil.isEmpty(list)) {
            save(sharesDate);
            return sharesDateRoamDTO;
        }
        boolean contains = false;
        for (SharesDate shares : list) {
            if (Objects.equals(shares.getSharesDate(), date)) {
                contains = true;
                break;
            }
        }
        // 先判断是否包含，若包含则返回
        if (contains) {
            sharesDateRoamDTO.setInsertSuccess(false);
            log.error("已经存在当前日期数据，重复插入！拒绝请求");
            return sharesDateRoamDTO;
        }
        if (list.size() > DATE_LIST_SIZE) {
            list.sort(Comparator.comparing(SharesDate::getSharesDate));
            SharesDate deleteShares = list.get(0);
            deleteShares.setSoftDelete(1);
            save(deleteShares);
            // 将删除的日期写入实体
            sharesDateRoamDTO.setDeleteDate(deleteShares.getSharesDate());
            log.info("十日表数据已满，正在清除日期数据... 日期为：{} ...", deleteShares.getSharesDate());
        }
        save(sharesDate);
        return sharesDateRoamDTO;
    }


}
