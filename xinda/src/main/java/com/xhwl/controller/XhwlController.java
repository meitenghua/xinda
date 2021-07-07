package com.xhwl.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xhwl.pojo.EquipmentData;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-06-04 11:15
 */
@RestController
@RequestMapping("/xhwl")
public class XhwlController {

    @PostMapping(value = "/exportExcel" )
    public void exportExcel(@RequestBody String str, HttpServletResponse res) throws IOException {

        //实现excel写的操作
        //1 设置写入文件夹地址和excel文件名称
        //String filename = "G:\\write123456789.xlsx";
        // 2 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        //EasyExcel.write(filename, EquipmentData.class).sheet("设备列表").doWrite(getData());

        String fileName = "设备列表.xls";
        //String sheetName = "模板";
        res.setContentType("application/vnd.ms-excel");
        res.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        res.setHeader("Content-disposition", "attachment;filename=" + fileName );
        //res.getOutputStream()
        EasyExcel.write(res.getOutputStream(), EquipmentData.class).sheet("设备列表").doWrite(getData(str));
    }

    private List<EquipmentData> getData(String str) {
        List<EquipmentData> list = JSON.parseArray(str, EquipmentData.class);
        return list;
    }
}

