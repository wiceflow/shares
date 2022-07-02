package com.wiceflow.shares.common.entity;

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
public class SharesDate extends BaseField{

    /** 日期 年月日 */
    private Date sharesDate;
    /** 软删除，不用硬删除是可以溯源，看有没哪一天数据漏了 **/
    private Integer softDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SharesDate that = (SharesDate) o;
        return Objects.equals(sharesDate, that.sharesDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sharesDate);
    }
}
