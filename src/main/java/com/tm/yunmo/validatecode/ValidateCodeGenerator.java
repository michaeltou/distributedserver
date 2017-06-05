package com.tm.yunmo.validatecode;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tm.yunmo.common.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by daoying on 2017/6/1.
 */

@RestController
public class ValidateCodeGenerator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping("/getValidateCode")
    public void getValidateCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("validateCode", createText);
            logger.info("when produce , sessionId is:"+httpServletRequest.getSession().getId());
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @RequestMapping("/getRegisterValidateCode")
    public void getRegisterValidateCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("register_validateCode", createText);
            logger.info("when produce , sessionId is:"+httpServletRequest.getSession().getId());
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }



    @RequestMapping("/verifyRegisterValidateCode")
    public ResultModel   verifyRegisterValidateCode(String validateCode, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
      ResultModel resultModel = new ResultModel();
      String sessionValidateCode = (String) httpServletRequest.getSession().getAttribute("register_validateCode");
        logger.info("when verify , sessionId is:"+httpServletRequest.getSession().getId());
        //错误的验证码
        if (!sessionValidateCode.equals(validateCode)) {
            resultModel.setSuccess(false);
        } else {//正确的验证码
            resultModel.setSuccess(true);
        }

        return resultModel;
    }



    @RequestMapping("/getLoginValidateCode")
    public void getLoginValidateCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("login_validateCode", createText);
            logger.info("when produce , sessionId is:"+httpServletRequest.getSession().getId());
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }



    @RequestMapping("/verifyLoginValidateCode")
    public ResultModel   verifyLoginValidateCode(String validateCode, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ResultModel resultModel = new ResultModel();
        String sessionValidateCode = (String) httpServletRequest.getSession().getAttribute("login_validateCode");
        logger.info("when verify , sessionId is:"+httpServletRequest.getSession().getId());
        //错误的验证码
        if (!sessionValidateCode.equals(validateCode)) {
            resultModel.setSuccess(false);
        } else {//正确的验证码
            resultModel.setSuccess(true);
        }

        return resultModel;
    }

    @RequestMapping("/testResponse")
    public void test(HttpServletResponse httpServletResponse){
        try {
            httpServletResponse.getWriter().println("helloworld");
            httpServletResponse.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
