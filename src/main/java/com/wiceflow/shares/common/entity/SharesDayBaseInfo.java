package com.wiceflow.shares.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 每日股票信息表
 */
@Data
@TableName("shares_day_info")
@EqualsAndHashCode(callSuper = true)
public class SharesDayBaseInfo extends SharesBaseInfoField {

}
