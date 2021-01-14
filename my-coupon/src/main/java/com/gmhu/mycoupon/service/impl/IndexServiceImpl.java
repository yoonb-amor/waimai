package com.gmhu.mycoupon.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gmhu.mycoupon.common.dto.Coupon;
import com.gmhu.mycoupon.common.entry.Category;
import com.gmhu.mycoupon.common.entry.Project;
import com.gmhu.mycoupon.dao.CategoryMapper;
import com.gmhu.mycoupon.dao.ProjectMapper;
import com.gmhu.mycoupon.service.IndexService;
import com.gmhu.mycoupon.utils.CacheUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/18
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Coupon getCoupon(String cateId) {
        String v = CacheUtil.getValue("category");
        List<Category> categories = null;
        List<Project> projects = null;
        if (StringUtils.isBlank(v)) {
            categories = categoryMapper.selectList(new QueryWrapper<Category>().apply(" deleted ={0}",1));
            CacheUtil.add("category", JSONUtil.toJsonStr(categories));
        } else {
            categories = JSONUtil.toList(JSONUtil.parseArray(v), Category.class);
        }
        if(StringUtils.isBlank(cateId)){
            cateId="0";
        }
        String project = CacheUtil.getValue(cateId);
        if (StringUtils.isBlank(project)) {
            if(StringUtils.equals("0",cateId)){
                projects = projectMapper.selectList(new QueryWrapper<Project>().apply("deleted = {0}", 1));
            }else {
                projects = projectMapper.selectList(new QueryWrapper<Project>().apply("cate_id = {0} and deleted = {1}", cateId, 1));
            }
            CacheUtil.add(cateId, JSONUtil.toJsonStr(projects));
        } else {
            projects = JSONUtil.toList(JSONUtil.parseArray(project), Project.class);
        }
        return Coupon.builder().category(categories).projects(projects).build();
    }
}
