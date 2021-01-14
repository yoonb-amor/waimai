package com.gmhu.mycoupon.config;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/23
 */
public interface ApiService {
    String b1688_products = "cps-mesh.cpslink.b1688.products.get";
    String links = "cps-mesh.cpslink.links.post";
    String links_put = "cps-mesh.cpslink.links.put";
    String links_crypt = "cps-mesh.cpslink.links.crypt.post";
    String links_short = "cps-mesh.cpslink.links.short.post";
    String links_crypt_get = "cps-mesh.cpslink.links.crypt.get";
    String jd_categorys = "cps-mesh.cpslink.jd.categorys.get";
}
