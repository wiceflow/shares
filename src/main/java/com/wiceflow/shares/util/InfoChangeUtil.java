package com.wiceflow.shares.util;

import com.wiceflow.shares.common.dto.SharesDayInfoDTO;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 数据转换 util
 */
public class InfoChangeUtil {


    /**
     * 每日数据转成入库 DTO
     *
     * @param originalDTO [SharesDayInfoOriginalDTO] JSON 转换原数据
     * @return [SharesDayInfoDTO] 入库 DTO
     * <p>
     * 可以用反射重写这里  对边两边的注释，如果一样的话就写值
     */
    public static SharesDayInfoDTO originChangeDTO(SharesDayInfoOriginalDTO originalDTO) {
        SharesDayInfoDTO sharesDayInfoDTO = new SharesDayInfoDTO();
        sharesDayInfoDTO.setSharesName(originalDTO.getF14());
        sharesDayInfoDTO.setSharesNum(originalDTO.getF12());
        sharesDayInfoDTO.setSharesNewPrice(originalDTO.getF2());
        sharesDayInfoDTO.setSharesFluctuationRange(originalDTO.getF3());
        sharesDayInfoDTO.setSharesUpDownAmount(originalDTO.getF4());
        sharesDayInfoDTO.setSharesDealNum(originalDTO.getF5());
        sharesDayInfoDTO.setSharesDealMoney(originalDTO.getF6());
        sharesDayInfoDTO.setSharesAmplitude(originalDTO.getF7());
        sharesDayInfoDTO.setSharesHighest(originalDTO.getF15());
        sharesDayInfoDTO.setSharesMinimum(originalDTO.getF16());
        sharesDayInfoDTO.setSharesTodayOpen(originalDTO.getF17());
        sharesDayInfoDTO.setSharesReceivedYesterday(originalDTO.getF18());
        sharesDayInfoDTO.setPriceToBookRatio(originalDTO.getF23());
        sharesDayInfoDTO.setTurnoverRate(originalDTO.getF8());
        sharesDayInfoDTO.setPeRatio(originalDTO.getF9());
        sharesDayInfoDTO.setVolumeRatio(originalDTO.getF10());
        return null;
    }
}
