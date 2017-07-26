package com.tm.yunmo.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */

@Controller
public class FileUploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //访问路径为：http://127.0.0.1:8080/singleFileUpload
    @RequestMapping("/singleFileUpload")
    public String singleFileUpload(){
        return"/file/singleFileUpload";
    }


    //访问路径为：http://127.0.0.1:8080/file
    @RequestMapping("/batchFileUpload")
    public String batchFileUpload(){
        return"/file/batchFileUpload";
    }


    //访问路径为：http://127.0.0.1:8080/file
    @RequestMapping("/singleFileUploadWithNoRefresh")
    public String singleFileUploadWithNoRefresh(){
        return"/file/singleFileUploadWithNoRefresh";
    }


    //文件上传相关代码
    @RequestMapping("/single/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {

        boolean saveResult = saveFile(file);
        if (!saveResult){
            return "上传失败";
        }else {
            return "文件上传成功";
        }
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleBatchFileUpload(HttpServletRequest request) {
        System.out.println(" handleBatchFileUpload here ");
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            boolean saveResult = saveFile(file);
            if (!saveResult){
                return "上传失败";
            }

        }
        return "upload successful";
    }


    //文件上传相关代码
    @RequestMapping("/single/uploadWithNoRefresh")
    public String uploadWithNoRefresh(@RequestParam("file") MultipartFile file, ModelMap model) {


        model.addAttribute("result","success");

        model.addAttribute("imagePath","/image/test/2.jpg");
        boolean saveResult = saveFile(file);
        if (!saveResult){
            return"/file/singleFileUploadWithNoRefresh";
        }else {
            return"/file/singleFileUploadWithNoRefresh";
        }

    }





    /***
     * 保存文件 功能ok
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file) {
        // 文件保存路径
        String filePath = "E://test//";
        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                System.out.println("上传的文件是："+ filePath + fileName);
                // 转存文件
                file.transferTo(dest);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("上传文件失败"+ filePath + fileName);
            }
        }
        return false;
    }

    @RequestMapping("/myfilesUpload")
    public String filesUpload(@RequestParam("files") MultipartFile[] files) {
        //判断file数组不能为空并且长度大于0
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //保存文件
                saveFile(file);
            }
        }
        // 重定向
        return "redirect:/list.html";
    }







}
