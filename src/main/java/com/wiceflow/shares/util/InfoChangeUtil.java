package com.wiceflow.shares.util;

import com.wiceflow.shares.common.dto.SharesDayInfoDTO;
import com.wiceflow.shares.common.entity.BaseSharesInfoField;
import com.wiceflow.shares.common.entity.SharesDayInfo;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BF
 * @date 2022/6/20
 * <p>
 * 数据转换 util
 */
public class InfoChangeUtil {


    /**
     * 每日数据转成入库文件
     *
     * @param originalDTO [SharesDayInfoOriginalDTO] JSON 转换原数据
     * @return [SharesDayInfo] 入库
     * <p>
     * 可以用反射重写这里  对边两边的注释，如果一样的话就写值
     */
    public static <T extends BaseSharesInfoField<T>> T originChange(SharesDayInfoOriginalDTO originalDTO, Class<T> aaa )  {
        try {
            T result = aaa.newInstance();
            result.setSharesDate(new Date());
            result.setSharesName(originalDTO.getF14());
            result.setSharesNum(originalDTO.getF12());
            result.setSharesNewPrice(originalDTO.getF2());
            result.setSharesFluctuationRange(originalDTO.getF3());
            result.setSharesUpDownAmount(originalDTO.getF4());
            result.setSharesDealNum(originalDTO.getF5());
            result.setSharesDealMoney(originalDTO.getF6());
            result.setSharesAmplitude(originalDTO.getF7());
            result.setSharesHighest(originalDTO.getF15());
            result.setSharesMinimum(originalDTO.getF16());
            result.setSharesTodayOpen(originalDTO.getF17());
            result.setSharesReceivedYesterday(originalDTO.getF18());
            result.setPriceToBookRatio(originalDTO.getF23());
            result.setTurnoverRate(originalDTO.getF8());
            result.setPeRatio(originalDTO.getF9());
            result.setVolumeRatio(originalDTO.getF10());
            return result;
        }catch (Exception e){
            System.out.println(originalDTO.toString());
            return null;
        }
    }

    /**
     * 每日数据转成入库文件
     *
     * @param list [SharesDayInfoOriginalDTO] JSON 转换原数据
     * @return List [SharesDayInfo] 入库
     */
    public static <T extends BaseSharesInfoField<T>> List<T> originChangeInfoList(List<SharesDayInfoOriginalDTO> list, List<T> resultList, Class<T> result) {
        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>(1);
        }

        for (int i = 0; i < list.size(); i++) {
            resultList.add(originChange(list.get(i), result));
        }
        return resultList;
    }
}
