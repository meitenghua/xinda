package com.xhwl.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-06-09 14:48
 */
@Data
public class EquipmentData {
    @ExcelProperty(value = "ID号",index = 0)
    private Integer id;
    @ExcelProperty(value = "设备名称",index = 1)
    private String equipmentname;
    @ExcelProperty(value = "设备类型",index = 2)
    private String equipmentType;
    @ExcelProperty(value = "品牌",index = 3)
    private String equipmentBrand;
    @ExcelProperty(value = "型号",index = 4)
    private String equipmentMode;
    @ExcelProperty(value = "规格",index = 5)
    private String equipmentSpecificat;
    @ExcelProperty(value = "状态",index = 6)
    private String equipmentStatus;
    @ExcelProperty(value = "空间位置",index = 7)
    private String spatialLocation;
    @ExcelProperty(value = "所属区域",index = 8)
    private String areaName;
}


