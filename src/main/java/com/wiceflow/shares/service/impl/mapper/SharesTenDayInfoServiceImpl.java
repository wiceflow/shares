package com.wiceflow.shares.service.impl.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wiceflow.shares.common.entity.SharesBaseInfoField;
import com.wiceflow.shares.common.entity.SharesTenDayBaseInfo;
import com.wiceflow.shares.mapper.SharesTenDayInfoMapper;
import com.wiceflow.shares.service.inter.mapper.SharesTenDayInfoService;
import com.wiceflow.shares.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 十日股票信息 Service
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SharesTenDayInfoServiceImpl extends ServiceImpl<SharesTenDayInfoMapper, SharesTenDayBaseInfo> implements SharesTenDayInfoService {


    /**
     * 按日期删除旧的数据
     *
     * @param date [Date] 日期
     * @return     [boolean] true 删除成功
     */
    @Override
    public boolean deleteTenLastInfo(Date date) {
        return remove(Wrappers.<SharesTenDayBaseInfo>lambdaQuery().eq(SharesBaseInfoField::getSharesDate, date));
    }
}
