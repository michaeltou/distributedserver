package net.shuzun.openapi.demo;

import net.shuzun.openapi.client.ApiClient;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String accountID = "xxxxxx"; // 账号 由数尊分配
        String privateKey = "xxxxxx"; // privatekey  由数尊分配
        String url = "http://api.shuzunbao.com/openapi/api/searchreport/"; // 接口url
        
        String select = "MD001"; // 需要查询字段，可同时查询多个字段，中间以英文逗号分隔（见文档说明）

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile", "手机号"); // 查询参数
        ApiClient client = ApiClient.getClient(accountID, privateKey);
        try {
            String result = client.sendGet(url, select,paramMap);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
