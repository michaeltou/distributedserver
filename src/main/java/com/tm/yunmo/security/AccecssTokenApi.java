package com.tm.yunmo.security;

import com.tm.yunmo.common.DateUtil;
import com.tm.yunmo.common.UUIDUtil;
import com.tm.yunmo.security.db.AccessToken;
import com.tm.yunmo.security.db.AppKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by daoying on 2017/5/17.
 */

@RestController
public class AccecssTokenApi {

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/getAccessToken")
    public String getAccessToken(HttpServletRequest request){

        //authorize the user with appid and secret
        String appId = request.getParameter("appId");
        String accessKey = request.getParameter("accessKey");

        AppKey appKey = securityService.queryAppKey(appId,accessKey);
        if (appKey == null){
            return "not valid user!";
        }

        AccessToken accessToken =  securityService.queryValidAccessToken(appId,accessKey);

        //不存在token的情况下
        if (accessToken == null ){
            accessToken =  generateNewAccessToken(appId,accessKey);
            securityService.insertValidAccessToken(accessToken);
            return accessToken.getToken();
            //tocken 时间expire失效的情况下，失效token，并重新插入新的token
        }else if (DateUtil.daysBetween2Date(DateUtil.dateToString(accessToken.getCreateTime()),DateUtil.dateToString(new Date()))> SecurityConstants.TOKEN_EXPIRE_DAYS
                || DateUtil.daysBetween2Date(DateUtil.dateToString(accessToken.getCreateTime()),DateUtil.dateToString(new Date())) < -SecurityConstants.TOKEN_EXPIRE_DAYS){

            boolean updateResult = securityService.invalidAccessToken(accessToken);
            accessToken =  generateNewAccessToken(appId,accessKey);
            securityService.insertValidAccessToken(accessToken);
            return accessToken.getToken();
        }else {//token 不失效的情况下，直接返回
            return accessToken.getToken();
        }


    }

    private AccessToken generateNewAccessToken(String appId, String accessKey){

        AccessToken accessToken = new AccessToken();
        accessToken.setAppId(appId);
        accessToken.setAccessKey(accessKey);
        accessToken.setToken(UUIDUtil.generateUUID());
        accessToken.setCreateTime(new Date());
        accessToken.setStatus("1");

        return accessToken;
    }

}
