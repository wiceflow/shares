package com.wiceflow.shares.service.impl;

import com.wiceflow.shares.config.RestTemplateConfig;
import com.wiceflow.shares.service.inter.ReptileSharesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private String sharesDayAllInfo;

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
        ResponseEntity<String> response = restTemplate.getForEntity(sharesDayAllInfo, String.class);
        String body = response.getBody();
        System.out.println(body);
        return response.getBody();
    }
}
