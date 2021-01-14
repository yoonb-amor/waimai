package com.gmhu.mycoupon.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/21
 */
public class CacheUtil {
    public static ConcurrentHashMap<String,String> map =new ConcurrentHashMap<String,String>();

    public static String getValue(String key){
        for(Map.Entry<String,String> entry:map.entrySet()){
            if(StringUtils.equals(entry.getKey(),key)){
                return entry.getValue();
            }
        }
        return null;
    }
    public static void add(String key,String value){
        map.put(key,value);
    }

    public static void clear(){
        map.clear();
    }
}
