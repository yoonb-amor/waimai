package com.gmhu.mycoupon.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;
import com.cps.opensdk.CpsOpenApi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/22
 */
public class SignUtil {
    public static String app_key="402635";
    public static String app_secret="9c730ef23a04e2434a4cde75c9c6214d";
    public static String base_url="https://open.duomai.com/apis";
    public static String service="cps-mesh.cpslink.jd.categorys.get";
    public static String common="app_key=402635&timestamp=1596699247&service=cps-mesh.cpslink.links.post";

    public static void main(String[] args) throws Exception{
        String appKey = "402635";
        String appSecret = "9c730ef23a04e2434a4cde75c9c6214d";
        CpsOpenApi api = new CpsOpenApi(appKey, appSecret);

        String service_b1688_products = "cps-mesh.cpslink.jd.categorys.get";
        Map param = new HashMap<String, Object>();
        param.put("parent_id", "652");
        param.put("grade", "0");

        String result = api.doReq(service_b1688_products, param);
        System.out.println("" + result);
    }
}
