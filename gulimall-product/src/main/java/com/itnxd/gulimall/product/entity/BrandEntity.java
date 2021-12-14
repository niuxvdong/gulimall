package com.itnxd.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.itnxd.common.valid.AddGroup;
import com.itnxd.common.valid.ListValue;
import com.itnxd.common.valid.UpdateGroup;
import com.itnxd.common.valid.UpdateStatusGroup;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 17:38:31
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@Null(message = "新增不能指定id", groups = {AddGroup.class})
	@NotNull(message = "修改必须指定id", groups = {UpdateGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
 *        @NotEmpty // not null or empty
	 *    @NotNull // not null
	 */
	@NotBlank(message = "品牌名必须提交", groups = {AddGroup.class}) // not null or at least one non-whitespace character.
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "添加时Logo地址必须不为空", groups = {AddGroup.class})
	@URL(message = "Logo必须是一个合法的URL地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(message = "添加商品必须有showStatus字段", groups = {AddGroup.class})
	@ListValue(vals = {0, 1}, groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(message = "添加商品必须有首字母", groups = {AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "添加商品必须排序字段", groups = {AddGroup.class})
	@Min(value = 0, message = "排序字段必须大于等于0", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
