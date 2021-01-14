package com.gmhu.mycoupon.common.dto;

import com.gmhu.mycoupon.common.entry.Category;
import com.gmhu.mycoupon.common.entry.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    private List<Category> category;
    private List<Project> projects;
}
