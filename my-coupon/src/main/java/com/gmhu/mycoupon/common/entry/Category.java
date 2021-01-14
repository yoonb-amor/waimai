package com.gmhu.mycoupon.common.entry;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_category")
public class Category {
    private Integer tabId;
    private String text;
    private String icon;
}
