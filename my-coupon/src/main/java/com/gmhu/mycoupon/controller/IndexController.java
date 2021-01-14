package com.gmhu.mycoupon.controller;

import com.gmhu.mycoupon.service.impl.IndexServiceImpl;
import com.gmhu.mycoupon.utils.CacheUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/18
 */
@RestController()
public class IndexController {

    @Resource
    private IndexServiceImpl indexService;

    @GetMapping("/index")
    public Object getCoupon(String cateId){
        return indexService.getCoupon(cateId);
    }

    @GetMapping("/clear")
    public void clear(){
         CacheUtil.clear();
    }
}
