package com.wiceflow.shares;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiceflow.shares.common.net.SharesDayInfoOriginalDTO;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BF
 * @date 2022/6/20
 */
public class test {
    public static void main(String[] args) {
        String str = "jQuery112407181340807650426_1654707379503({\"rc\":0,\"rt\":6,\"svr\":182998659,\"lt\":1,\"full\":1,\"dlmkts\":\"0,1,2,8,10,90,128\",\"data\":{\"total\":5008,\"diff\":[{\"f1\":2,\"f2\":24.1,\"f3\":20.02,\"f4\":4.02,\"f5\":55527,\"f6\":133577172.0,\"f7\":3.93,\"f8\":4.7,\"f9\":-67.51,\"f10\":1.82,\"f11\":0.0,\"f12\":\"300731\",\"f13\":0,\"f14\":\"科创新源\",\"f15\":24.1,\"f16\":23.31,\"f17\":24.07,\"f18\":20.08,\"f20\":3014628199,\"f21\":2845369922,\"f22\":0.0,\"f23\":5.22,\"f24\":13.84,\"f25\":-33.97,\"f62\":18021943.0,\"f115\":-80.12,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":28.42,\"f3\":20.02,\"f4\":4.74,\"f5\":165301,\"f6\":430179696.0,\"f7\":19.13,\"f8\":13.17,\"f9\":26.57,\"f10\":4.39,\"f11\":0.0,\"f12\":\"300660\",\"f13\":0,\"f14\":\"江苏雷利\",\"f15\":28.42,\"f16\":23.89,\"f17\":24.55,\"f18\":23.68,\"f20\":7370054242,\"f21\":3567042599,\"f22\":0.0,\"f23\":2.72,\"f24\":36.77,\"f25\":-1.49,\"f62\":48443754.0,\"f115\":32.01,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":181.24,\"f3\":20.0,\"f4\":30.21,\"f5\":98474,\"f6\":1698710672.0,\"f7\":13.4,\"f8\":3.35,\"f9\":102.37,\"f10\":1.58,\"f11\":0.0,\"f12\":\"300763\",\"f13\":0,\"f14\":\"锦浪科技\",\"f15\":181.24,\"f16\":161.0,\"f17\":161.0,\"f18\":151.03,\"f20\":67307165678,\"f21\":53261121137,\"f22\":0.0,\"f23\":27.96,\"f24\":20.34,\"f25\":17.41,\"f62\":269235616.0,\"f115\":126.48,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2}]}});";
//        Pattern pattern = Pattern.compile("^.+?\\((\\{.+\\})\\);$");
//        Matcher matcher = pattern.matcher(str);
//        matcher.find();
//        String group = matcher.group(1);
       str = str.replaceAll("^.+?\\((\\{.+})\\);$", "$1");
        String string = JSON.parseObject(str).getJSONObject("data").getString("diff");
        List<SharesDayInfoOriginalDTO> list = JSONObject.parseArray(string,SharesDayInfoOriginalDTO.class);
        System.out.println(list);
    }
}
