package com.tm.yunmo.file;

import com.tm.yunmo.common.JsonUtil;
import com.tm.yunmo.common.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * jquery.form.js 文件上传处理类
 * Created by daoying on 2017/6/9.
 */

@RestController
public class JqueryFormFileController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    //文件上传相关代码
    @RequestMapping("/file/jqueryformuploadfile")
    public ResultModel upload(@RequestParam("file") MultipartFile file, FileUser user) {

        ResultModel resultModel = new ResultModel();
        Image image = new Image();
        resultModel.setData(image);


        logger.info("user对象是:"+JsonUtil.getString(user));

        if (file.isEmpty()) {
            resultModel.setSuccess(false);
            resultModel.setErrorMsg("文件为空");
            return resultModel;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        image.setImageName(fileName);
        image.setImageURL("http://localhost:9999/images/certification/userid.jpg");

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        resultModel.setSuccess(false);
        resultModel.setErrorMsg("上传失败");
        return  resultModel;
    }
}
