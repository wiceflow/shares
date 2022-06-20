package com.wiceflow.shares.impl;

import com.wiceflow.shares.SharesApplicationTests;
import com.wiceflow.shares.service.inter.ReptileSharesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BF
 * @date 2022/6/20
 */
@Slf4j
public class ReptileSharesServiceImplTest extends SharesApplicationTests {

    @Autowired
    private ReptileSharesService reptileSharesService;

    @Test
    public void test() {
        String str = reptileSharesService.reptileSharesDayInfo();
        log.info(str);
    }
}
