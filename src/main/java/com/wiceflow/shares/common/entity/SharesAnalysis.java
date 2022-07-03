package com.wiceflow.shares.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 保存分析的股票类
 */
@Data
@TableName("shares_analysis")
@EqualsAndHashCode(callSuper = true)
public class SharesAnalysis extends SharesBaseField {

    /** 是否退市 0 - 否，1 - 是 **/
    private Integer isDelisted;
    /** 股票最新价 f2 **/
    private String sharesNewPrice;
    /** 股票昨收 f18 **/
    private String sharesReceivedYesterday;
    /** 是否满足三阴转阳 **/
    private Integer greenToRed;
    /** 是否满足黄金拐点 **/
    private Integer goldenInflectionPoint;
}
