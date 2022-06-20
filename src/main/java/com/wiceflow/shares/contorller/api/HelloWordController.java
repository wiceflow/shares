package com.wiceflow.shares.contorller.api;

import com.wiceflow.shares.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BF
 * @date 2022/6/20
 */
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloWordController {

    @GetMapping(value = "long/time",produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResult sayHelloWord(@RequestParam(value = "param",required = false)String param) {

        log.info("第一次接收参数，参数为：{}",param);

        return AjaxResult.okResponse("好久没写代码了");
    }
}
