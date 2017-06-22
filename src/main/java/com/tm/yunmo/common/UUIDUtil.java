package com.tm.yunmo.common;

import java.util.UUID;

/**
 * Created by daoying on 2017/5/17.
 */
public class UUIDUtil {
    public static String generateUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println("generating new uuid:"+uuid);
        return uuid.toString();
    }

}
