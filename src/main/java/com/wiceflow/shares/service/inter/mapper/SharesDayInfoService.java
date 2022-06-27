package com.wiceflow.shares.service.inter.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiceflow.shares.common.entity.SharesDayInfo;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 每日股票信息 基础 Service
 */
public interface SharesDayInfoService extends IService<SharesDayInfo> {

    /**
     * 保存每日股票数据
     */
    void insertSharesInfo();
}