package com.xhwl.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-07-08 10:08
 * 任务历史记录
 */
@Data
public class MissionHistory {
    @ExcelProperty(value = "所属计划",index = 0)
    private String planName;
    @ExcelProperty(value = "计划巡视日期",index = 1)
    private String inspectionDate;
    @ExcelProperty(value = "计划巡视时段",index = 2)
    private String inspectionTime;
    @ExcelProperty(value = "实际执行时段",index = 3)
    private String executionPeriod;
    @ExcelProperty(value = "任务状态",index = 4)
    private String status;
    @ExcelProperty(value = "上报异常",index = 5)
    private String reportException;
}

