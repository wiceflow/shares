package com.wiceflow.shares.service.inter.common;

import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;

import java.util.List;

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

    /**
     * 解析每日股票交易数据
     *
     * @return 解析的数据
     */
    List<SharesDayInfoOriginalDTO> analysisSharesDayInfo();

    /**
     * 解析每日股票交易数据
     * <p>
     * @param reptileStringData [String] 未全量交易数据
     *
     * @return 解析的数据
     */
    List<SharesDayInfoOriginalDTO> analysisSharesDayInfo(String reptileStringData);

    /**
     * 解析每日股票交易数据
     *
     * 并保存起来
     */
    void insetSharesInfoInDataBase();
}
