package com.wiceflow.shares.impl;

import com.wiceflow.shares.SharesApplicationTests;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;
import com.wiceflow.shares.service.inter.common.ReptileSharesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<SharesDayInfoOriginalDTO> list = reptileSharesService.analysisSharesDayInfo(str);
        System.out.println(list);
        System.out.println(list.size());
    }
}
