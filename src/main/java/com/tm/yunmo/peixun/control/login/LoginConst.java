package com.tm.yunmo.peixun.control.login;

/**
 * Created by daoying on 2017/7/4.
 */
public class LoginConst {
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    /**
     * 系统默认密码
     */
    public final static String DEFAULT_PASSWORD = "123456";

    /**
     * 角色 管理员
     */
    public final static String ROLE_ADMIN = "ADMIN";

    /**
     * 角色 学生
     */
    public final static String ROLE_STUDENT = "STUDENT";
    /**
     * 角色 教师
     */
    public final static String ROLE_TEACHER= "TEACHER";

    /**
     * 角色 教务
     */
    public final static String ROLE_JIAOWU = "JIAOWU";

    /**
     * 角色 父母
     */
    public final static String ROLE_PARENT = "PARENT";

    public static String getRoleName(String role){
        String rolename=null;
        if (LoginConst.ROLE_ADMIN.equals(role)){
            rolename="管理员";
        }else if(LoginConst.ROLE_STUDENT.equals(role)  ){
            rolename="学生";
        }else if(LoginConst.ROLE_TEACHER.equals(role)  ){
            rolename="教师";
        }else if(LoginConst.ROLE_JIAOWU.equals(role)  ){
            rolename="教务";
        }else if(LoginConst.ROLE_PARENT.equals(role)  ){
            rolename="家长";
        }
        return rolename;
    }
}
