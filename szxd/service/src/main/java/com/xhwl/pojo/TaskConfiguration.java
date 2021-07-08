package com.xhwl.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-07-07 17:31
 *
 * 任务配置
 */
@Data
public class TaskConfiguration {
    @ExcelProperty(value = "计划名称",index = 0)
    private String planName;
    @ExcelProperty(value = "有效期",index = 1)
    private String validityDate;
    @ExcelProperty(value = "周期",index = 2)
    private String inspectionCycle;
    @ExcelProperty(value = "巡视监控",index = 3)
    private String videoInspectionNum;
    @ExcelProperty(value = "创建人",index = 4)
    private String createdBy;
    @ExcelProperty(value = "计划状态",index = 5)
    private String status;
}

