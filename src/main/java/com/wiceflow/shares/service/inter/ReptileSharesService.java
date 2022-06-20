package com.wiceflow.shares.service.inter;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 爬虫接口
 */
public interface ReptileSharesService {


    /**
     * 爬取每日股票交易数据
     * <p>
     * 全量交易数据
     *
     * @return 未解析的数据
     */
    String reptileSharesDayInfo();
}
