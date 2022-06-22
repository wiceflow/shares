package com.wiceflow.shares.common.net;

import lombok.Data;

/**
 * @author BF
 * @date 2022/6/20
 */
@Data
public class SharesDayInfoOriginalDTO {

    /** 股票名称 **/
    private String f14;
    /** 股票代码 **/
    private String f12;
    /** 股票最新价 **/
    private String f2;
    /** 股票涨跌幅 **/
    private String f3;
    /** 股票涨跌额 **/
    private String f4;
    /** 股票成交量手 **/
    private String f5;
    /** 股票成交额 **/
    private String f6;
    /** 股票振幅 **/
    private String f7;
    /** 股票最高 **/
    private String f15;
    /** 股票最低 **/
    private String f16;
    /** 股票今开 **/
    private String f17;
    /** 股票昨收 **/
    private String f18;
    /** 市净率 **/
    private String f23;
    /** 换手率 **/
    private String f8;
    /** 市盈率（动态） **/
    private String f9;
    /** 量比 **/
    private String f10;
}
