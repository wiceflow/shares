package com.wiceflow.shares.service.impl.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wiceflow.shares.common.entity.SharesDayBaseInfo;
import com.wiceflow.shares.mapper.SharesDayInfoMapper;
import com.wiceflow.shares.service.inter.mapper.SharesDayInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 每日股票信息 Service
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SharesDayInfoServiceImpl extends ServiceImpl<SharesDayInfoMapper, SharesDayBaseInfo> implements SharesDayInfoService {


    /**
     * 更新每日股票信息
     *
     * @param list [SharesDayBaseInfo] 基本股票信息
     */
    @Override
    public void updateShares(List<SharesDayBaseInfo> list) {
        remove(null);
        saveBatch(list);
    }
}
