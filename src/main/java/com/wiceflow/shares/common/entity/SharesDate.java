package com.wiceflow.shares.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * @author BF
 * @date 2022/7/2
 *
 * 日期保存表，主要和十日股票信息保存表联合使用
 */
@Data
@TableName("shares_date")
public class SharesDate extends BaseField{

    /** 日期 年月日 */
    private Date sharesDate;
    /** 软删除，不用硬删除是可以溯源，看有没哪一天数据漏了 **/
    private Integer softDelete;

}
