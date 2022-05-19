package com.moon.flowerservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Flower对象", description="")
public class Flower implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "flo_id", type = IdType.AUTO)
    private Integer floId;

    private String floName;

    private String floLanguage;

    private Float floPrice;

    private String floShape;

    private String floColor;

    private String floSeries;


}
