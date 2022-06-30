package com.wiceflow.shares.service.impl.common;

import com.alibaba.fastjson.JSON;
import com.wiceflow.shares.common.entity.SharesDayInfo;
import com.wiceflow.shares.common.entity.SharesTenDayInfo;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;
import com.wiceflow.shares.common.net.SharesDayNetOriginDTO;
import com.wiceflow.shares.config.RestTemplateConfig;
import com.wiceflow.shares.service.inter.common.ReptileSharesService;
import com.wiceflow.shares.service.inter.mapper.SharesDayInfoService;
import com.wiceflow.shares.service.inter.mapper.SharesTenDayInfoService;
import com.wiceflow.shares.util.InfoChangeUtil;
import com.wiceflow.shares.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 爬虫实现类
 */
@Slf4j
@Service
@PropertySource("/url.properties")
public class ReptileSharesServiceImpl implements ReptileSharesService {

    @Autowired
    private RestTemplateConfig config;

    @Value("${shares.day.all.info}")
    private String sharesDayAllInfoUrl;

    @Autowired
    private SharesDayInfoService sharesDayInfoService;
    @Autowired
    private SharesTenDayInfoService sharesTenDayInfoService;

    /**
     * 爬取每日股票交易数据
     * <p>
     * 全量交易数据
     *
     * @return 未解析的数据
     */
    @Override
    public String reptileSharesDayInfo() {
        RestTemplate restTemplate = new RestTemplate(config.getFactory());
        ResponseEntity<String> response = restTemplate.getForEntity(sharesDayAllInfoUrl, String.class);
        if (Objects.equals(response.getStatusCode(), HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    /**
     * 解析每日股票交易数据
     *
     * @return 解析的数据
     */
    @Override
    public List<SharesDayInfoOriginalDTO> analysisSharesDayInfo() {
        String reptileStringData = reptileSharesDayInfo();
        if (StringUtil.isEmpty(reptileStringData)) {
            return null;
        }
        // 正则匹配大括号内容
        reptileStringData = reptileStringData.replaceAll("^.+?\\((\\{.+})\\);$", "$1");
        if (StringUtil.isEmpty(reptileStringData)) {
            return null;
        }
        SharesDayNetOriginDTO sharesDayNetOriginDTO = JSON.parseObject(reptileStringData, SharesDayNetOriginDTO.class);
        return sharesDayNetOriginDTO.getSharesDayInfoOriginalDTO();
    }

    /**
     * 解析每日股票交易数据
     * <p>
     *
     * @param reptileStringData [String] 未全量交易数据
     * @return 解析的数据
     */
    @Override
    public List<SharesDayInfoOriginalDTO> analysisSharesDayInfo(String reptileStringData) {
        if (StringUtil.isEmpty(reptileStringData)) {
            return null;
        }
        // 正则匹配大括号内容
        reptileStringData = reptileStringData.replaceAll("^.+?\\((\\{.+})\\);$", "$1");
        if (StringUtil.isEmpty(reptileStringData)) {
            return null;
        }
        SharesDayNetOriginDTO sharesDayNetOriginDTO = JSON.parseObject(reptileStringData, SharesDayNetOriginDTO.class);
        return sharesDayNetOriginDTO.getSharesDayInfoOriginalDTO();
    }


    /**
     * 解析每日股票交易数据
     *
     * 并保存起来
     */
    @Override
    public void insetSharesInfoInDataBase() {
        String reptileStringData = reptileSharesDayInfo();
        // 正则匹配大括号内容
        reptileStringData = reptileStringData.replaceAll("^.+?\\((\\{.+})\\);$", "$1");
        if (StringUtil.isEmpty(reptileStringData)) {
            return;
        }
        SharesDayNetOriginDTO sharesDayNetOriginDTO = JSON.parseObject(reptileStringData, SharesDayNetOriginDTO.class);
        // 获取实际内容
        List<SharesDayInfoOriginalDTO> sharesDayInfoOriginalDTO = sharesDayNetOriginDTO.getSharesDayInfoOriginalDTO();
        // 每日数据
        List<SharesDayInfo> resultList = InfoChangeUtil.originChangeInfoList(sharesDayInfoOriginalDTO, new ArrayList<>(), SharesDayInfo.class);
        // 十日数据
        List<SharesTenDayInfo> tenList = InfoChangeUtil.originChangeInfoList(sharesDayInfoOriginalDTO, new ArrayList<>(), SharesTenDayInfo.class);
        sharesDayInfoService.saveBatch(resultList);
        sharesTenDayInfoService.saveBatch(tenList);
    }
}
