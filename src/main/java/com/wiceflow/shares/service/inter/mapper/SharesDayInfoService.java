package com.wiceflow.shares.service.inter.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiceflow.shares.common.entity.SharesDayBaseInfo;

import java.util.List;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 每日股票信息 基础 Service
 */
public interface SharesDayInfoService extends IService<SharesDayBaseInfo> {

    /**
     * 更新每日股票信息
     *
     * @param list [SharesDayBaseInfo] 基本股票信息
     */
    void updateShares(List<SharesDayBaseInfo> list);
}
