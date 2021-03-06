package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.*;
import com.tm.yunmo.peixun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 */
@RestController
public class QingJiaDanApi {
    @Autowired
    private QingJiaDanService qingJiaDanService;

    @Autowired
    private BaoMingService baoMingService;

    @Autowired
    private BanjiPaikeItemService banjiPaikeItemService;

    @Autowired
    private KeChengService keChengService;

    @Autowired
    private  BanJiService banJiService;

    /*@RequestMapping("/queryQingJiaDanListByInstitution")
    public List<QingJiaDan> queryQingJiaDanListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<QingJiaDan> qingJiaDanList = qingJiaDanService.queryQingJiaDanListByInstitution(institution_code);
        return qingJiaDanList;
    }*/

    @RequestMapping("/queryQingJiaDanById")
    public QingJiaDan queryQingJiaDanById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        QingJiaDan qingJiaDan = qingJiaDanService.queryQingJiaDanById(id, institution_code);
        return qingJiaDan;
    }


    @RequestMapping("/insertQingJiaDan")
    public ResultModel insertQingJiaDan(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        Byte role = Byte.valueOf(request.getParameter("role"));
        Byte employeeType = Byte.valueOf(request.getParameter("employeeType"));
        Float qingJiaDays = Float.valueOf(request.getParameter("qingJiaDays"));
        String qingJiaRenName = request.getParameter("qingJiaRenName");
        String qingJiaRenSFZ = request.getParameter("qingJiaRenSFZ");
        String qingJiaLeiXing = request.getParameter("qingJiaLeiXing");
        String qingJiaStartDate = request.getParameter("qingJiaStartDate");
        String qingJiaEndDate = request.getParameter("qingJiaEndDate");
        String qingJiaFangShi = request.getParameter("qingJiaFangShi");
        String idList = request.getParameter("idList");
        String note = request.getParameter("note");

        int result = 0;
        boolean hasClasses = false;
        // 学员请假处理
        if(role == 0 ){
            List<String> ids = Arrays.asList(idList.split(","));
            List<BaoMing> baoMingList =  baoMingService.queryBaoMingListBySFZCode(institution_code,qingJiaRenSFZ);
            for(BaoMing baoMing : baoMingList){
                BanJi banJi = banJiService.queryBanJiByName(baoMing.getBanji_name(),institution_code);
                List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndClassName(institution_code,baoMing.getBanji_name(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0);
                for(BanjiPaikeItem banjiPaikeItem : banjiPaikeItemList){
                    if(qingJiaFangShi.equals("按班级") && !ids.contains(String.valueOf(banjiPaikeItem.getId()))){
                        result = 1;
                        continue;
                    }
                    if(qingJiaDanService.queryQingJiaDanListByDateTimeAndClassNameAndPersonName(institution_code,qingJiaRenSFZ,banjiPaikeItem.getStart(),banjiPaikeItem.getEnd(),baoMing.getBanji_name()).size() > 0){
                        result = 1;
                        continue;
                    }
                    hasClasses = true;
                    QingJiaDan qingJiaDan = new QingJiaDan();
                    qingJiaDan.setInstitution_code(institution_code);
                    qingJiaDan.setRole(role);
                    qingJiaDan.setEmployeeType(employeeType);
                    qingJiaDan.setQingjia_person_name(qingJiaRenName);
                    qingJiaDan.setQingjia_person_sfz(qingJiaRenSFZ);
                    qingJiaDan.setQingjia_start_time(banjiPaikeItem.getStart());
                    qingJiaDan.setQingjia_end_time(banjiPaikeItem.getEnd());
                    qingJiaDan.setQingjia_banji(baoMing.getBanji_name());
                    qingJiaDan.setQingjia_kecheng(banJi.getKecheng_name());
                    qingJiaDan.setQingjia_yuanyin(qingJiaLeiXing);
                    qingJiaDan.setQingjia_days(qingJiaDays);
                    qingJiaDan.setStatus((byte)0);
                    qingJiaDan.setNote(note);
                    result += qingJiaDanService.insertQingJiaDan(qingJiaDan);
                }

            }
        }else {
            if(employeeType == 0){
                // 代课老师
                List<String> ids = Arrays.asList(idList.split(","));
                List<BanJi> banjiList =  banJiService.queryBanJiListByInstitutionAndSFZCode(institution_code,qingJiaRenSFZ);
                for(BanJi banJi : banjiList){
                    List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndTeacherCode(institution_code,banJi.getTeacherSFZCode(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0);
                    for(BanjiPaikeItem banjiPaikeItem : banjiPaikeItemList){
                        if(qingJiaFangShi.equals("按班级") && !ids.contains(String.valueOf(banjiPaikeItem.getId()))){
                            //result = 1;
                            continue;
                        }
                        if(qingJiaDanService.queryQingJiaDanListByDateTimeAndClassNameAndPersonName(institution_code,qingJiaRenSFZ,banjiPaikeItem.getStart(),banjiPaikeItem.getEnd(),banJi.getBanji_name()).size() > 0){
                            //result = 1;
                            continue;
                        }
                        hasClasses = true;
                        QingJiaDan qingJiaDan = new QingJiaDan();
                        qingJiaDan.setInstitution_code(institution_code);
                        qingJiaDan.setRole(role);
                        qingJiaDan.setEmployeeType(employeeType);
                        qingJiaDan.setQingjia_person_name(qingJiaRenName);
                        qingJiaDan.setQingjia_person_sfz(qingJiaRenSFZ);
                        qingJiaDan.setQingjia_start_time(banjiPaikeItem.getStart());
                        qingJiaDan.setQingjia_end_time(banjiPaikeItem.getEnd());
                        qingJiaDan.setQingjia_banji(banJi.getBanji_name());
                        qingJiaDan.setQingjia_kecheng(banJi.getKecheng_name());
                        qingJiaDan.setQingjia_yuanyin(qingJiaLeiXing);
                        qingJiaDan.setQingjia_days(qingJiaDays);
                        qingJiaDan.setStatus((byte)0);
                        qingJiaDan.setNote(note);
                        result += qingJiaDanService.insertQingJiaDan(qingJiaDan);
                    }

                }
            }else {
                //教务老师和其他员工
                if(qingJiaDanService.queryQingJiaDanListByDateTimeAndClassNameAndPersonName(institution_code,qingJiaRenSFZ,StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),"").size() == 0) {
                    hasClasses = true;
                    QingJiaDan qingJiaDan = new QingJiaDan();
                    qingJiaDan.setInstitution_code(institution_code);
                    qingJiaDan.setRole(role);
                    qingJiaDan.setEmployeeType(employeeType);
                    qingJiaDan.setQingjia_person_name(qingJiaRenName);
                    qingJiaDan.setQingjia_person_sfz(qingJiaRenSFZ);
                    qingJiaDan.setQingjia_start_time(StrToDate(qingJiaStartDate));
                    qingJiaDan.setQingjia_end_time(StrToDate(qingJiaEndDate));
                    qingJiaDan.setQingjia_banji("");
                    qingJiaDan.setQingjia_kecheng("");
                    qingJiaDan.setQingjia_yuanyin(qingJiaLeiXing);
                    qingJiaDan.setQingjia_days(qingJiaDays);
                    qingJiaDan.setStatus((byte) 0);
                    qingJiaDan.setNote(note);
                    result += qingJiaDanService.insertQingJiaDan(qingJiaDan);
                }
            }
        }
        if (result > 0) {
            return resultModel;
        } else {
            if(!hasClasses){
                if(employeeType == 1){
                    resultModel.setErrorMsg("本时间段已经请过假了.无需重复申请.");
                }else {
                    resultModel.setErrorMsg("该时间段请假人没有班级需要上课,请确认请假时间.");
                }
            }
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/queryBanjiPaikeItemForQingJiaDan")
    public ResultModel queryBanjiPaikeItemForQingJiaDan(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String qingJiaRenSFZ = request.getParameter("qingJiaRenSFZ");
        String qingJiaStartDate = request.getParameter("qingJiaStartDate");
        String qingJiaEndDate = request.getParameter("qingJiaEndDate");

        List<BaoMing> baoMingList =  baoMingService.queryBaoMingListBySFZCode(institution_code,qingJiaRenSFZ);
        List<BanjiPaikeItem> banjiPaikeItemList = null;
        for(BaoMing baoMing : baoMingList){
            if(banjiPaikeItemList == null){
                banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndClassName(institution_code,baoMing.getBanji_name(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0);
            }
            else {
                banjiPaikeItemList.addAll(banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndClassName(institution_code,baoMing.getBanji_name(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0));
            }
        }
        resultModel.setData(banjiPaikeItemList);

        return  resultModel;
    }

    @RequestMapping("/queryBanjiPaikeItemForEmployeeQingJiaDan")
    public ResultModel queryBanjiPaikeItemForEmployeeQingJiaDan(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String qingJiaRenSFZ = request.getParameter("qingJiaRenSFZ");
        String qingJiaStartDate = request.getParameter("qingJiaStartDate");
        String qingJiaEndDate = request.getParameter("qingJiaEndDate");

        List<BanJi> banJiList =  banJiService.queryBanJiListByInstitutionAndSFZCode(institution_code,qingJiaRenSFZ);
        List<BanjiPaikeItem> banjiPaikeItemList = null;
        for(BanJi banJi : banJiList){
            if(banjiPaikeItemList == null){
                banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndTeacherCode(institution_code,banJi.getTeacherSFZCode(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0);
            }
            else {
                banjiPaikeItemList.addAll(banjiPaikeItemService.queryBanjiPaikeItemByStartAndEndAndTeacherCode(institution_code,banJi.getTeacherSFZCode(),StrToDate(qingJiaStartDate),StrToDate(qingJiaEndDate),0));
            }
        }
        resultModel.setData(banjiPaikeItemList);

        return  resultModel;
    }

    @RequestMapping("/updateQingJiaDanStatus")
    public ResultModel updateQingJiaDanStatus(@RequestBody QingJiaDan qingJiaDan, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        qingJiaDan.setInstitution_code(institution_code);
        int result = qingJiaDanService.updateQingJiaDanStatus(qingJiaDan);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteQingJiaDan")
    public ResultModel deleteQingJiaDan(@RequestBody QingJiaDan qingJiaDan, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        qingJiaDan.setInstitution_code(institution_code);
        int result = qingJiaDanService.deleteQingJiaDan(qingJiaDan);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * 字符串转换成日期
     * @param strDate
     * @return date
     */
    public static Date StrToDate(String strDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
