package com.wiceflow.shares.common.net;

import lombok.Data;

import java.util.List;

/**
 * @author BF
 * @date 2022/6/21
 * <p>
 * 接收参数DTO
 */
@Data
public class SharesDayNetOriginDTO {
    private Integer rc;
    private Integer rt;
    private Long svr;
    private Integer lt;
    private Integer full;
    private String dlmkts;
    private SharesData data;

    public List<SharesDayInfoOriginalDTO> getSharesDayInfoOriginalDTO(){
        return data == null ? null : data.getDiff();
    }
}

class SharesData {
    /** 股票总数 */
    private Integer total;
    /** 具体股票信息 */
    List<SharesDayInfoOriginalDTO> diff;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SharesDayInfoOriginalDTO> getDiff() {
        return diff;
    }

    public void setDiff(List<SharesDayInfoOriginalDTO> diff) {
        this.diff = diff;
    }
}
