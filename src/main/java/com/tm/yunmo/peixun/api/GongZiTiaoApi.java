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
        String sfz_code = request.getParameter("sfz_code");
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoService.queryGongZiTiaoListBySfz(sfz_code);
        return gongZiTiaoList;
    }



    //http://localhost:9999/queryGongZiTiaoListBySfz?sfz_code=341225199509098888&name=java%E8%AF%BE%E7%A8%8B
    @RequestMapping("/queryGongZiTiaoByName")
    public GongZiTiao queryGongZiTiaoByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String sfz_code = request.getParameter("sfz_code");
        GongZiTiao gongZiTiao = gongZiTiaoService.queryGongZiTiaoByName(name, sfz_code);
        return gongZiTiao;
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
    public ResultModel insertGongZiTiao(@RequestBody GongZiTiao gongZiTiao) {
        ResultModel resultModel = new ResultModel();

        int result = gongZiTiaoService.insertGongZiTiao(gongZiTiao);
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
    public ResultModel updateGongZiTiao(@RequestBody GongZiTiao gongZiTiao) {
        ResultModel resultModel = new ResultModel();
        int result = gongZiTiaoService.updateGongZiTiao(gongZiTiao);
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
    public ResultModel deleteGongZiTiao(@RequestBody  GongZiTiao gongZiTiao) {
        ResultModel resultModel = new ResultModel();
        int result = gongZiTiaoService.deleteGongZiTiao(gongZiTiao);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
