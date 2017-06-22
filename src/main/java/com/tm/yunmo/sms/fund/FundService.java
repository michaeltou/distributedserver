package com.tm.yunmo.sms.fund;

import com.tm.yunmo.common.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by daoying on 2017/5/19.
 */

@Component
public class FundService {

    @Autowired
    private FundDetailDAO fundDetailDAO;


    @Autowired
    private FundLeftDAO fundLeftDAO;


    public List<FundLeft> queryFundLeftList(String userName) {
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        List<FundLeft> fundLeftList = fundLeftDAO.queryFundLeftList(userName);
        return fundLeftList;
    }


    /**
     * 从fundLeft找出需要扣款的某一条记录.
     * @param userName
     * @return
     */
    public FundLeft findTheChargeOneFromFundLeft(String userName) {
        List<FundLeft> fundLeftList = queryFundLeftList(userName);
        if (fundLeftList == null || fundLeftList.isEmpty()) {
            return null;
        }
        if (fundLeftList.size() == 1) {
            return fundLeftList.get(0);
        }

        Date minDate = null;
        int minId = 0;
        //获取最小的endDate,和主键id
        for (int i = 0; i < fundLeftList.size(); i++) {
            FundLeft fundLeft = fundLeftList.get(i);
            if (fundLeft == null) {
                return null;
            }
            if (i == 0) {
                minDate = fundLeft.getEndDate();
                minId = fundLeft.getId();
            }

            int compareResult = DateUtil.compare_date(fundLeft.getEndDate(), minDate);
            if (compareResult == -1) {
                minDate = fundLeft.getEndDate();
                minId = fundLeft.getId();
            }
        }
        if (minId == 0) {
            return null;
        }

        for (int i = 0; i < fundLeftList.size(); i++) {
            FundLeft fundLeft = fundLeftList.get(i);
            if (minId == fundLeft.getId()) {
                return fundLeft;
            }
        }

        return null;
    }


    public boolean insertFundLeft(FundLeft fundLeft) {
        if (fundLeft == null) {
            return false;
        }
        final int result = fundLeftDAO.insertFundLeft(fundLeft);
        if (result == 0) {
            return false;
        }
        return true;

    }

    public boolean decreaseFundLeft(FundLeft fundLeft) {

        if (fundLeft == null) {
            return false;
        }
        final int result = fundLeftDAO.decreaseFundLeft(fundLeft);
        if (result == 0) {
            return false;
        }
        return true;

    }

    public boolean decreaseFundLeftByStepNo(FundLeft fundLeft, int stepNo) {

        if (fundLeft == null) {
            return false;
        }
        final int result = fundLeftDAO.decreaseFundLeftByStepNo(fundLeft.getUserName(), new Date(), fundLeft.getVersion(), stepNo);
        if (result == 0) {
            return false;
        }
        return true;

    }


    public boolean invalidFundLeftById(FundLeft fundLeft) {
        final int result = fundLeftDAO.invalidFundLeftById(fundLeft);
        if (result == 0) {
            return false;
        }
        return true;

    }


    public List<FundDetail> queryFundDetail(String userName) {
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        List<FundDetail> fundDetailList = fundDetailDAO.queryFundDetail(userName);
        return fundDetailList;

    }

    public boolean insertFundDetail(FundDetail fundDetail) {
        if (fundDetail == null) {
            return false;
        }
        final int result = fundDetailDAO.insertFundDetail(fundDetail);
        if (result == 0) {
            return false;
        }
        return true;
    }

}
