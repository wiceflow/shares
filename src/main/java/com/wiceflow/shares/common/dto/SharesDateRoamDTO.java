package com.wiceflow.shares.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 股票日期流转类
 */
@Data
public class SharesDateRoamDTO {

    /** 是否删除成功 */

    private Boolean insertSuccess;
    /** 需要删除数据的日期 */
    private Date deleteDate;
}
