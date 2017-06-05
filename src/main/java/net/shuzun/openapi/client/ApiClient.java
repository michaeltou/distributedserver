package net.shuzun.openapi.client;

import net.shuzun.openapi.util.RequestUtil;

import java.security.MessageDigest;
import java.util.*;
import java.util.Map.Entry;

public class ApiClient {

    private static ApiClient client = null;

    private String accountID;
    private String privateKey;

    private static final String PARAM_SELECT = "select";
    private static final String PARAM_SIGN = "sign";
    private static final String PARAM_ACCOUNT = "accountID";
    private static final String METHOD_POST = "post";
    private static final String METHOD_GET = "get";

    private ApiClient(String accountID, String privateKey) {
        this.accountID = accountID;
        this.privateKey = privateKey;
    }

    public static ApiClient getClient(String accountID, String privateKey) {
        if (null == client) {
            synchronized (ApiClient.class) {
                if (null == client) {
                    client = new ApiClient(accountID, privateKey);
                }
            }
        }
        return client;
    }

    public String sendGet(String url, String select, Map<String, String> paramMap) throws Exception {
        return this.send(url, select, paramMap, METHOD_GET);
    }

    public String sendPost(String url, String select, Map<String, String> paramMap) throws Exception {
        return this.send(url, select, paramMap, METHOD_POST);
    }

    private String send(String url, String select, Map<String, String> paramMap, String method) throws Exception {
        if (url == null || "".equals(url.trim())) {
            throw new Exception("url is empty");
        }
        if (select == null || "".equals(select.trim())) {
            throw new Exception("select is empty");
        }
        if (null == paramMap || paramMap.isEmpty()) {
            throw new Exception("parameter is empty");
        }

        paramMap.put(PARAM_SELECT, select);
        paramMap.put(PARAM_ACCOUNT, this.accountID);
        String sign = this.getSign(paramMap);
        paramMap.put(PARAM_SIGN, sign);

        if (METHOD_POST.equals(method)) {
            return RequestUtil.sendPost(url, paramMap);
        } else {
            return RequestUtil.sendGet(url, paramMap);
        }
    }

    private String getSign(Map<String, String> paramMap) {

        List<String> list = new ArrayList<>();

        Entry<String, String> entry;
        for (Iterator<Entry<String, String>> iterator = paramMap.entrySet().iterator(); iterator.hasNext();) {
            entry = iterator.next();
            list.add(entry.getKey() + entry.getValue());
        }

        Collections.sort(list);

        StringBuffer buffer = new StringBuffer();
        for (String str : list) {
            buffer.append(str);
        }
        buffer.append(privateKey);
        System.out.println("签名前字符串：" + buffer);

        return this.MD5(buffer.toString());
    }

    private String MD5(String input) {
        String result = "";
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] strTemp = input.getBytes("utf-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
