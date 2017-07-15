package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ClassRecordMain;
import com.tm.yunmo.peixun.service.ClassRecordDetailService;
import com.tm.yunmo.peixun.service.ClassRecordMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录主表 rest接口
 */
@RestController
public class ClassRecordApi {

    @Autowired
    private ClassRecordMainService classRecordMainService;


    @Autowired
    ClassRecordDetailService classRecordDetailService;






}
