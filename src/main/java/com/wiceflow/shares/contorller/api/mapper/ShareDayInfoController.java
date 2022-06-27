package com.wiceflow.shares.contorller.api.mapper;

import com.wiceflow.shares.service.inter.mapper.SharesDayInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 每日股票信息 控制类
 */
@Slf4j
@RestController
@RequestMapping("shares")
public class ShareDayInfoController {
    @Autowired
    private SharesDayInfoService sharesDayInfoService;

    @GetMapping("getInfo")
    public void insertSharesDayInfo() {
        sharesDayInfoService.insertSharesInfo();
    }
}
