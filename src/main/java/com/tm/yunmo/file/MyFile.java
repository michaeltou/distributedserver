package com.tm.yunmo.file;

import com.google.gson.Gson;
import com.tm.yunmo.common.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daoying on 2017/5/31.
 */

/**
 * 构建结构如下：
 * https://github.com/blueimp/jQuery-File-Upload/wiki/Setup#using-jquery-file-upload-ui-version-with-a-custom-server-side-upload-handler
 */
public class MyFile {

    public static void main(String[] args) {
        MyFile file =new MyFile();
        file.setName("michael");
        file.setSize(2322);

        Gson json = new Gson();

       // System.out.println(   JsonUtil.getString(file));

        List<MyFile> myFileList = new ArrayList<MyFile>();
        myFileList.add(file);

        Map<String,List<MyFile>>  myResult = new HashMap<String,List<MyFile>>();
        myResult.put("files",myFileList);

        System.out.println(   JsonUtil.getString(myResult));

    }

    private String name;
    private long size;
    private String url;
    private String thumbnailUrl;
    private String deleteUrl;
    private String deleteType;
    private String error;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
