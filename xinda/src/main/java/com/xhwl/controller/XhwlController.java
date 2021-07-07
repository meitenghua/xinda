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
        /*List<EquipmentData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            EquipmentData data = new EquipmentData();
            data.setId(i);
            data.setEquipmentname("Equipmentname"+i);
            data.setBrand("品牌"+i);
            data.setMode("型号"+i);
            data.setType("类型"+i);
            data.setSpecificat("规格"+i);
            data.setStatus("在线"+i);
            data.setSpatialLocation("空间位置"+i);
            data.setAreaName("区域"+i);

            list.add(data);
        }*/
        //String str="[{\"areaName\":\"区域0\",\"brand\":\"品牌0\",\"equipmentname\":\"Equipmentname0\",\"id\":0,\"mode\":\"型号0\",\"spatialLocation\":\"空间位置0\",\"specificat\":\"规格0\",\"status\":\"在线0\",\"type\":\"类型0\"},{\"areaName\":\"区域1\",\"brand\":\"品牌1\",\"equipmentname\":\"Equipmentname1\",\"id\":1,\"mode\":\"型号1\",\"spatialLocation\":\"空间位置1\",\"specificat\":\"规格1\",\"status\":\"在线1\",\"type\":\"类型1\"},{\"areaName\":\"区域2\",\"brand\":\"品牌2\",\"equipmentname\":\"Equipmentname2\",\"id\":2,\"mode\":\"型号2\",\"spatialLocation\":\"空间位置2\",\"specificat\":\"规格2\",\"status\":\"在线2\",\"type\":\"类型2\"},{\"areaName\":\"区域3\",\"brand\":\"品牌3\",\"equipmentname\":\"Equipmentname3\",\"id\":3,\"mode\":\"型号3\",\"spatialLocation\":\"空间位置3\",\"specificat\":\"规格3\",\"status\":\"在线3\",\"type\":\"类型3\"},{\"areaName\":\"区域4\",\"brand\":\"品牌4\",\"equipmentname\":\"Equipmentname4\",\"id\":4,\"mode\":\"型号4\",\"spatialLocation\":\"空间位置4\",\"specificat\":\"规格4\",\"status\":\"在线4\",\"type\":\"类型4\"},{\"areaName\":\"区域5\",\"brand\":\"品牌5\",\"equipmentname\":\"Equipmentname5\",\"id\":5,\"mode\":\"型号5\",\"spatialLocation\":\"空间位置5\",\"specificat\":\"规格5\",\"status\":\"在线5\",\"type\":\"类型5\"},{\"areaName\":\"区域6\",\"brand\":\"品牌6\",\"equipmentname\":\"Equipmentname6\",\"id\":6,\"mode\":\"型号6\",\"spatialLocation\":\"空间位置6\",\"specificat\":\"规格6\",\"status\":\"在线6\",\"type\":\"类型6\"},{\"areaName\":\"区域7\",\"brand\":\"品牌7\",\"equipmentname\":\"Equipmentname7\",\"id\":7,\"mode\":\"型号7\",\"spatialLocation\":\"空间位置7\",\"specificat\":\"规格7\",\"status\":\"在线7\",\"type\":\"类型7\"},{\"areaName\":\"区域8\",\"brand\":\"品牌8\",\"equipmentname\":\"Equipmentname8\",\"id\":8,\"mode\":\"型号8\",\"spatialLocation\":\"空间位置8\",\"specificat\":\"规格8\",\"status\":\"在线8\",\"type\":\"类型8\"},{\"areaName\":\"区域9\",\"brand\":\"品牌9\",\"equipmentname\":\"Equipmentname9\",\"id\":9,\"mode\":\"型号9\",\"spatialLocation\":\"空间位置9\",\"specificat\":\"规格9\",\"status\":\"在线9\",\"type\":\"类型9\"}]\n";

        //JSONObject jsonObject = JSON.parseObject(str);

        //String data = jsonObject.getString("equipment");

        List<EquipmentData> list = JSON.parseArray(str, EquipmentData.class);
        return list;
    }


    /*public static void main(String[] args) {
        *//*List<EquipmentData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            EquipmentData data = new EquipmentData();
            data.setId(i);
            data.setEquipmentname("Equipmentname"+i);
            data.setBrand("品牌"+i);
            data.setMode("型号"+i);
            data.setType("类型"+i);
            data.setSpecificat("规格"+i);
            data.setStatus("在线"+i);
            data.setSpatialLocation("空间位置"+i);
            data.setAreaName("区域"+i);

            list.add(data);

        }
        String s = JSON.toJSONString(list);*//*

        String str="[{\"areaName\":\"区域0\",\"brand\":\"品牌0\",\"equipmentname\":\"Equipmentname0\",\"id\":0,\"mode\":\"型号0\",\"spatialLocation\":\"空间位置0\",\"specificat\":\"规格0\",\"status\":\"在线0\",\"type\":\"类型0\"},{\"areaName\":\"区域1\",\"brand\":\"品牌1\",\"equipmentname\":\"Equipmentname1\",\"id\":1,\"mode\":\"型号1\",\"spatialLocation\":\"空间位置1\",\"specificat\":\"规格1\",\"status\":\"在线1\",\"type\":\"类型1\"},{\"areaName\":\"区域2\",\"brand\":\"品牌2\",\"equipmentname\":\"Equipmentname2\",\"id\":2,\"mode\":\"型号2\",\"spatialLocation\":\"空间位置2\",\"specificat\":\"规格2\",\"status\":\"在线2\",\"type\":\"类型2\"},{\"areaName\":\"区域3\",\"brand\":\"品牌3\",\"equipmentname\":\"Equipmentname3\",\"id\":3,\"mode\":\"型号3\",\"spatialLocation\":\"空间位置3\",\"specificat\":\"规格3\",\"status\":\"在线3\",\"type\":\"类型3\"},{\"areaName\":\"区域4\",\"brand\":\"品牌4\",\"equipmentname\":\"Equipmentname4\",\"id\":4,\"mode\":\"型号4\",\"spatialLocation\":\"空间位置4\",\"specificat\":\"规格4\",\"status\":\"在线4\",\"type\":\"类型4\"},{\"areaName\":\"区域5\",\"brand\":\"品牌5\",\"equipmentname\":\"Equipmentname5\",\"id\":5,\"mode\":\"型号5\",\"spatialLocation\":\"空间位置5\",\"specificat\":\"规格5\",\"status\":\"在线5\",\"type\":\"类型5\"},{\"areaName\":\"区域6\",\"brand\":\"品牌6\",\"equipmentname\":\"Equipmentname6\",\"id\":6,\"mode\":\"型号6\",\"spatialLocation\":\"空间位置6\",\"specificat\":\"规格6\",\"status\":\"在线6\",\"type\":\"类型6\"},{\"areaName\":\"区域7\",\"brand\":\"品牌7\",\"equipmentname\":\"Equipmentname7\",\"id\":7,\"mode\":\"型号7\",\"spatialLocation\":\"空间位置7\",\"specificat\":\"规格7\",\"status\":\"在线7\",\"type\":\"类型7\"},{\"areaName\":\"区域8\",\"brand\":\"品牌8\",\"equipmentname\":\"Equipmentname8\",\"id\":8,\"mode\":\"型号8\",\"spatialLocation\":\"空间位置8\",\"specificat\":\"规格8\",\"status\":\"在线8\",\"type\":\"类型8\"},{\"areaName\":\"区域9\",\"brand\":\"品牌9\",\"equipmentname\":\"Equipmentname9\",\"id\":9,\"mode\":\"型号9\",\"spatialLocation\":\"空间位置9\",\"specificat\":\"规格9\",\"status\":\"在线9\",\"type\":\"类型9\"}]\n";
        List<EquipmentData> equipmentData = JSON.parseArray(str, EquipmentData.class);
        String filename = "G:\\write1234567.xlsx";
        // 2 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename, EquipmentData.class).sheet("设备列表").doWrite(getData(str));

        EasyExcel.write(filename, EquipmentData.class).sheet("设备列表").doWrite(getData(str));
    }*/
}

