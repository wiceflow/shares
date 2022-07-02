package com.wiceflow.shares.service.inter.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiceflow.shares.common.entity.SharesTenDayBaseInfo;

import java.util.Date;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 十日股票信息 基础 Service
 */
public interface SharesTenDayInfoService extends IService<SharesTenDayBaseInfo> {

    /**
     * 按日期删除旧的数据
     *
     * @param date [Date] 日期
     * @return     [boolean] true 删除成功
     */
    boolean deleteTenLastInfo(Date date);
}
