package com.wiceflow.shares.service.impl.mapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wiceflow.shares.common.entity.SharesDayInfo;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;
import com.wiceflow.shares.mapper.SharesDayInfoMapper;
import com.wiceflow.shares.service.inter.common.ReptileSharesService;
import com.wiceflow.shares.service.inter.mapper.SharesDayInfoService;
import com.wiceflow.shares.util.CollectionUtil;
import com.wiceflow.shares.util.InfoChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 每日股票信息 Service
 */
@Service
@Transactional
public class SharesDayInfoServiceImpl extends ServiceImpl<SharesDayInfoMapper, SharesDayInfo> implements SharesDayInfoService {

}
