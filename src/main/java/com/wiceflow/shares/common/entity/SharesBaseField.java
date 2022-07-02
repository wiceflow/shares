package com.wiceflow.shares.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 股票基本字段实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SharesBaseField extends BaseField implements Serializable {
    /** 股票名称 f14 */
    private String sharesName;
    /** 股票代码 f12 **/
    private String sharesNum;
}
