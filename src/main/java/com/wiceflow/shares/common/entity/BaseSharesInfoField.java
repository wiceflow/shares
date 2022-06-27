package com.wiceflow.shares.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BF
 * @date 2022/6/27
 *
 * 股票基本信息父类
 */
@Data
public class BaseSharesInfoField<T> extends BaseField<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 日期 年月日 */
    private Date sharesDate;
    /** 股票名称 f14 */
    private String sharesName;
    /** 股票代码 f12 **/
    private String sharesNum;
    /** 股票最新价 f2 **/
    private String sharesNewPrice;
    /** 股票涨跌幅 f3 **/
    private String sharesFluctuationRange;
    /** 股票涨跌额 f4 **/
    private String sharesUpDownAmount;
    /** 股票成交量手 f5 **/
    private String sharesDealNum;
    /** 股票成交额 f6 **/
    private String sharesDealMoney;
    /** 股票振幅 f7 **/
    private String sharesAmplitude;
    /** 股票最高 f15 **/
    private String sharesHighest;
    /** 股票最低 f16 **/
    private String sharesMinimum;
    /** 股票今开 f17 **/
    private String sharesTodayOpen;
    /** 股票昨收 f18 **/
    private String sharesReceivedYesterday;
    /** 市净率 f23 **/
    private String priceToBookRatio;
    /** 换手率 f8 **/
    private String turnoverRate;
    /** 市盈率（动态) f9 **/
    private String peRatio;
    /** 量比 f10 **/
    private String volumeRatio;
}
