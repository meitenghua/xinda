package com.xhwl.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.xhwl.pojo.EquipmentData;
import com.xhwl.pojo.MissionHistory;
import com.xhwl.pojo.TaskConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-06-04 11:15
 * 导出设备列表接口
 */
@RestController
@RequestMapping("/xhwl")
public class ExportController {


    @PostMapping(value = "/exportEquipmentExcel" )
    public void exportEquipmentExcel(@RequestBody String str, HttpServletResponse res) throws IOException {

        //实现excel写的操作
        //1 设置写入文件夹地址和excel文件名称
        String filename = "G:\\设备列表.xlsx";
         //2 调用easyexcel里面的方法实现写操作
         //write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename, EquipmentData.class).sheet("设备列表").doWrite(getData(str, EquipmentData.class));

        /*String fileName = "G:\\设备列表.xlsx";
        //String sheetName = "模板";
        res.setContentType("application/vnd.ms-excel");
        res.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        res.setHeader("Content-disposition", "attachment;filename=" + fileName );
        //res.getOutputStream()
        EasyExcel.write(fileName, EquipmentData.class).sheet("设备列表").doWrite(getData(str,EquipmentData.class));*/
    }


    @PostMapping(value = "/exportTaskConfigurationExcel" )
    public void exportTaskConfigurationExcel(@RequestBody String str, HttpServletResponse res) throws IOException {

        String fileName = "任务配置.xls";
        //String sheetName = "模板";
        res.setContentType("application/vnd.ms-excel");
        res.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        res.setHeader("Content-disposition", "attachment;filename=" + fileName );
        //res.getOutputStream()
        EasyExcel.write(res.getOutputStream(), TaskConfiguration.class).sheet("设备列表").doWrite(getData(str, TaskConfiguration.class));
    }

    @PostMapping(value = "/exportMissionHistoryExcel" )
    public void exportMissionHistoryExcel(@RequestBody String str, HttpServletResponse res) throws IOException {

        String fileName = "任务历史记录.xls";
        //String sheetName = "模板";
        res.setContentType("application/vnd.ms-excel");
        res.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        res.setHeader("Content-disposition", "attachment;filename=" + fileName );
        //res.getOutputStream()
        EasyExcel.write(res.getOutputStream(), MissionHistory.class).sheet("设备列表").doWrite(getData(str, MissionHistory.class));
    }

    /*private List<EquipmentData> getData(String str) {
        List<EquipmentData> list = JSON.parseArray(str, EquipmentData.class);
        return list;
    }*/

    private <T> List<T> getData(String str, Class<T> object ) {
        List<T> list = JSON.parseArray(str, object);
        return list;
    }
}

