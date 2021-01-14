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
@TableName("t_project")
public class Project {
    private Integer id;
    private Integer cateId;
    private String title;
    private String logo;
    private String image;
    private String appId;
    private String path;
    private String url;
    private Integer sort;
}
