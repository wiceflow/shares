package com.wiceflow.shares.contorller.api;

import com.wiceflow.shares.service.inter.common.ReptileSharesService;
import com.wiceflow.shares.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BF
 * @date 2022/6/30
 */
@Slf4j
@RestController
@RequestMapping("reptile")
public class ReptileSharesController {

    @Autowired
    private ReptileSharesService reptileSharesService;


    @GetMapping(value = "save",produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResult obtainSharesDataInfo() {
        reptileSharesService.insetSharesInfoInDataBase();

        log.info("保存每日数据，十日数据，更新日期 成功");
        log.info("--------------------------------------------------分割线---------------------------------------------");
        return AjaxResult.okResponse();
    }
}
