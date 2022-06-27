package com.wiceflow.shares.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 每日股票信息表
 */
@Data
@TableName("shares_day_info")
public class SharesDayInfo extends BaseSharesInfoField<SharesDayInfo>{

}
