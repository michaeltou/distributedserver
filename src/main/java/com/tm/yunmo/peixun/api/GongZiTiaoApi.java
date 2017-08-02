package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.GongZiTiao;
import com.tm.yunmo.peixun.service.GongZiTiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by moxu on 2017/7/4.
 * 工资条rest接口
 */
@RestController
public class GongZiTiaoApi {

    @Autowired
    private GongZiTiaoService gongZiTiaoService;

    //http://localhost:9999/queryGongZiTiaoListBySfz?sfz_code=341225199509098888
    @RequestMapping("/queryGongZiTiaoListBySfz")
    public List<GongZiTiao> queryGongZiTiaoListBySfz(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String sfz_code = request.getParameter("sfz_code");
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoService.queryGongZiTiaoListBySfz(institution_code,sfz_code);
        return gongZiTiaoList;
    }

    /**
     * POST http://localhost:9999/insertGongZiTiao HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 339


     {
     "id":"2",
     //姓名
     "name":"张三",
     //'身份证'
     "sfzCode":"341225199509098888",
     //'实发工资'
     "shi_fa_gz":"5000",
     //'加班工资'
     "jia_ban_gz":"400",
     //'岗位工资'
     "gang_wei_gz":"4000",
     //'绩效工资'
     "ji_xiao_gz":"200",
     //'课时费'
     "ke_shi_fei":"800",
     //'介绍费'
     "jie_shao_fei":"400",
     //'绩效奖金'
     "jiXiao_jiangJin":"300",
     //'加班费'
     "jia_ban_fei":"30",
     //'全勤奖'
     "quan_qing_jiang":"30",
     //'补课费'
     "bu_ke_fei":"30",
     //'请假扣款'
     "qing_jia_kou_kuan":"50",
     //'退费扣款'
     "tui_fei_kou_kuan":"50",
     //'通信补贴'
     "tong_xun_bu_tie":"50",
     //'交通补贴'
     "jiao_tong_bu_tie":"50",
     //'餐补'
     "can_bu":"15",
     //'养老扣款'
     "yang_lao_kk":"50",
     //'医疗扣款'
     "yi_liao_kk":"50",
     //'失业扣款'
     "shi_ye_kk":"50",
     //'工伤扣款'
     "gong_shang_kk":"50",
     //'生育扣款'
     "sheng_yu_kk":"50",
     //'公积金扣款'
     "gong_ji_jing_kk":"50",
     //'个人所得税扣款\n'
     "tax_kk":"50",
     //'工龄工资'
     "gong_ling_gz":"50",
     //'其它奖金'
     "other_bonus":"50",
     //'其它扣款'
     "other_kk":"50",
     //'应发总工资'
     "ying_fa_zong_gz":"50"
     }

     * @param gongZiTiao
     * @return
     */
    @RequestMapping("/insertGongZiTiao")
    public ResultModel insertGongZiTiao(@RequestBody GongZiTiao gongZiTiao,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        int result = 0;
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        gongZiTiao.setInstitution_code(institution_code);
        List<String> nameList = Arrays.asList(gongZiTiao.getName().split(","));
        List<String> sfzCodeList = Arrays.asList(gongZiTiao.getSfz_code().split(","));
        for(int i = 0;i< nameList.size();i++){
            gongZiTiao.setName(nameList.get(i));
            gongZiTiao.setSfz_code(sfzCodeList.get(i));
            result = gongZiTiaoService.insertGongZiTiao(gongZiTiao);
        }
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }

    @RequestMapping("/copyPreMonthGongZiTiao")
    public ResultModel copyPreMonthGongZiTiao(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        int result = 0;
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        /*String names = request.getParameter("names");*/
        String sfzCodes = request.getParameter("sfzCodes");
        String month = request.getParameter("month");
        List<String> sfzCodeList = Arrays.asList(sfzCodes.split(","));

        String preMonth = CalPreMonth(month);
        String filter = "";
        for (String str :sfzCodeList ){
            if (filter.equals("")){
                filter += "("+"'"+str +"'";
            }else {
                filter += ","+"'"+str +"'";
            }
        }
        filter += ")";

        List<GongZiTiao> gongZiTiaoList = gongZiTiaoService.queryGongZiTiaoListByInstitutionAndMonthAndSfz(institution_code,preMonth,filter);
        for(GongZiTiao gongZiTiao : gongZiTiaoList){
            gongZiTiao.setMonth(month);
            result = gongZiTiaoService.insertGongZiTiao(gongZiTiao);
        }
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateGongZiTiao HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 343


     {

     "id":"2",
     //姓名
     "name":"张三",
     //'身份证'
     "sfzCode":"341225199509098888",
     //'实发工资'
     "shi_fa_gz":"5000",
     //'加班工资'
     "jia_ban_gz":"400",
     //'岗位工资'
     "gang_wei_gz":"4000",
     //'绩效工资'
     "ji_xiao_gz":"200",
     //'课时费'
     "ke_shi_fei":"800",
     //'介绍费'
     "jie_shao_fei":"400",
     //'绩效奖金'
     "jiXiao_jiangJin":"300",
     //'加班费'
     "jia_ban_fei":"30",
     //'全勤奖'
     "quan_qing_jiang":"30",
     //'补课费'
     "bu_ke_fei":"30",
     //'请假扣款'
     "qing_jia_kou_kuan":"50",
     //'退费扣款'
     "tui_fei_kou_kuan":"50",
     //'通信补贴'
     "tong_xun_bu_tie":"50",
     //'交通补贴'
     "jiao_tong_bu_tie":"50",
     //'餐补'
     "can_bu":"15",
     //'养老扣款'
     "yang_lao_kk":"50",
     //'医疗扣款'
     "yi_liao_kk":"50",
     //'失业扣款'
     "shi_ye_kk":"50",
     //'工伤扣款'
     "gong_shang_kk":"50",
     //'生育扣款'
     "sheng_yu_kk":"50",
     //'公积金扣款'
     "gong_ji_jing_kk":"50",
     //'个人所得税扣款\n'
     "tax_kk":"50",
     //'工龄工资'
     "gong_ling_gz":"50",
     //'其它奖金'
     "other_bonus":"50",
     //'其它扣款'
     "other_kk":"50",
     //'应发总工资'
     "ying_fa_zong_gz":"50"
     }

     * @param gongZiTiao
     * @return
     */
    @RequestMapping("/updateGongZiTiao")
    public ResultModel updateGongZiTiao(@RequestBody GongZiTiao gongZiTiao,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        gongZiTiao.setInstitution_code(institution_code);
        int result = gongZiTiaoService.updateGongZiTiao(gongZiTiao);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/updateGongZiTiaoStatus")
    public ResultModel updateGongZiTiaoStatus(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String ids = request.getParameter("ids");
        String names = request.getParameter("names");
        String sfzCodes = request.getParameter("sfzCodes");
        String status = request.getParameter("status");

        List<String> idList = Arrays.asList(ids.split(","));
        List<String> nameList = Arrays.asList(names.split(","));
        List<String> sfcCodeList = Arrays.asList(sfzCodes.split(","));

        int result = 0;
        for(int i = 0 ;i< idList.size();i++){
            GongZiTiao gongZiTiao = new GongZiTiao();
            gongZiTiao.setInstitution_code(institution_code);
            gongZiTiao.setId(Integer.valueOf(idList.get(i)));
            gongZiTiao.setName(nameList.get(i));
            gongZiTiao.setSfz_code(sfcCodeList.get(i));
            gongZiTiao.setStatus(Byte.valueOf(status));
            result = gongZiTiaoService.updateGongZiTiaoStatus(gongZiTiao);
        }
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteGongZiTiao HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 343


     {
     "id":"2",
     //姓名
     "name":"张三",
     //'身份证'
     "sfzCode":"341225199509098888",
     //'实发工资'
     "shi_fa_gz":"5000",
     //'加班工资'
     "jia_ban_gz":"400",
     //'岗位工资'
     "gang_wei_gz":"4000",
     //'绩效工资'
     "ji_xiao_gz":"200",
     //'课时费'
     "ke_shi_fei":"800",
     //'介绍费'
     "jie_shao_fei":"400",
     //'绩效奖金'
     "jiXiao_jiangJin":"300",
     //'加班费'
     "jia_ban_fei":"30",
     //'全勤奖'
     "quan_qing_jiang":"30",
     //'补课费'
     "bu_ke_fei":"30",
     //'请假扣款'
     "qing_jia_kou_kuan":"50",
     //'退费扣款'
     "tui_fei_kou_kuan":"50",
     //'通信补贴'
     "tong_xun_bu_tie":"50",
     //'交通补贴'
     "jiao_tong_bu_tie":"50",
     //'餐补'
     "can_bu":"15",
     //'养老扣款'
     "yang_lao_kk":"50",
     //'医疗扣款'
     "yi_liao_kk":"50",
     //'失业扣款'
     "shi_ye_kk":"50",
     //'工伤扣款'
     "gong_shang_kk":"50",
     //'生育扣款'
     "sheng_yu_kk":"50",
     //'公积金扣款'
     "gong_ji_jing_kk":"50",
     //'个人所得税扣款\n'
     "tax_kk":"50",
     //'工龄工资'
     "gong_ling_gz":"50",
     //'其它奖金'
     "other_bonus":"50",
     //'其它扣款'
     "other_kk":"50",
     //'应发总工资'
     "ying_fa_zong_gz":"50"
     }

     * @param gongZiTiao
     * @return
     */
    @RequestMapping("/deleteGongZiTiao")
    public ResultModel deleteGongZiTiao(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();

        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String ids = request.getParameter("ids");
        String names = request.getParameter("names");
        String sfzCodes = request.getParameter("sfzCodes");

        List<String> idList = Arrays.asList(ids.split(","));
        List<String> nameList = Arrays.asList(names.split(","));
        List<String> sfcCodeList = Arrays.asList(sfzCodes.split(","));

        int result = 0;
        for(int i = 0 ;i< idList.size();i++){
            GongZiTiao gongZiTiao = new GongZiTiao();
            gongZiTiao.setInstitution_code(institution_code);
            gongZiTiao.setId(Integer.valueOf(idList.get(i)));
            gongZiTiao.setName(nameList.get(i));
            gongZiTiao.setSfz_code(sfcCodeList.get(i));
            result = gongZiTiaoService.deleteGongZiTiao(gongZiTiao);
        }
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteGongZiTiaoByMonth")
    public ResultModel deleteGongZiTiaoByMonth(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String month = request.getParameter("month");
        ResultModel resultModel = new ResultModel();
        int result = gongZiTiaoService.deleteGongZiTiaoByMonth(institution_code,month);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * 日期转换成字符串
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public String CalPreMonth(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String strMonth = "";
        try {
            Date d = format.parse(str);
            Calendar cld = Calendar.getInstance();
            cld.setTime(d);
            cld.add(Calendar.MONTH, -1);
            Date d2 = cld.getTime();
            strMonth = format.format(d2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strMonth;
    }



}
