package com.wiceflow.shares.service.inter.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiceflow.shares.common.dto.SharesDateRoamDTO;
import com.wiceflow.shares.common.entity.SharesDate;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 日期保存表，主要和十日股票信息保存表联合使用 Service
 */
public interface SharesDateService extends IService<SharesDate> {

    /**
     * 插入一条记录
     *
     * @return [SharesDateRoamDTO]  股票日期流转类
     */
    SharesDateRoamDTO insertSharesDate();
}
