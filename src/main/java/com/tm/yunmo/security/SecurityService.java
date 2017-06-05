package com.tm.yunmo.security;

import com.tm.yunmo.security.db.AccessToken;
import com.tm.yunmo.security.db.AccessTokenDAO;
import com.tm.yunmo.security.db.AppKey;
import com.tm.yunmo.security.db.AppKeyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by daoying on 2017/5/17.
 */
@Component
public class SecurityService {

    @Autowired
    private AppKeyDAO appKeyDAO;

    @Autowired
    private AccessTokenDAO accessTokenDAO;


    /**
     * 查询appkey
     *
     * @param appId
     * @param accessKey
     * @return
     */
    public AppKey queryAppKey(String appId, String accessKey) {
        if (appId == null || appId.isEmpty()) {
            return null;
        }
        if (accessKey == null || accessKey.isEmpty()) {
            return null;
        }
        AppKey appKey = appKeyDAO.queryAppKey(appId, accessKey);
        return appKey;
    }


    /**
     * 查询有效的accessToken
     *
     * @param appId
     * @param accessKey
     * @return
     */
    public AccessToken queryValidAccessToken(String appId, String accessKey) {
        if (appId == null || appId.isEmpty()) {
            return null;
        }
        if (accessKey == null || accessKey.isEmpty()) {
            return null;
        }
        AccessToken accessToken = accessTokenDAO.queryValidAccessToken(appId, accessKey);
        return accessToken;
    }


    public boolean insertValidAccessToken(AccessToken accessToken) {
        if (accessToken == null) {
            return false;
        }
        int result = accessTokenDAO.insertValidAccessToken(accessToken);
        if (result == 0) {
            return false;
        }
        return true;
    }


    public boolean invalidAccessToken(AccessToken accessToken) {
        if (accessToken == null) {
            return false;
        }
        int result = accessTokenDAO.invalidAccessToken(accessToken);
        if (result == 0) {
            return false;
        }
        return true;
    }


    /**
     * 判断当前的token是否有效.
     * @param token
     * @return
     */
    public boolean isValidToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        AccessToken accessToken = accessTokenDAO.queryValidAccessTokenByToken(token);
        if (accessToken == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据token查询有效的token。
     * @param token
     * @return
     */
    public AccessToken queryValidAccessTokenByToken(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        AccessToken accessToken = accessTokenDAO.queryValidAccessTokenByToken(token);
        return accessToken;
    }




}
