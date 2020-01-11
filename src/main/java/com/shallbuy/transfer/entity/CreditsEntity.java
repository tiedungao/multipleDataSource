package com.shallbuy.transfer.entity;


import com.shallbuy.transfer.util.FrameDateUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author gaotiedun
 * Created Date 2019/04/17 10:48
 * Updated Date      by
 * @version v2.0
 * Description  积分账户实体类
 */
public class CreditsEntity implements Serializable {

    private static final long serialVersionUID = -360618653086830578L;

    private int id;                         //积分账户ID
    private int memberId;                     //角色ID
    private int status;                     //积分账户状态
    private BigDecimal nowCredits;          //当前账户积分余额
    private BigDecimal totalCredits;        //总积分收益
    private BigDecimal todayIncrease;       //今日新增积分（只增不减）
    private BigDecimal todayDecrease;       //今日消费积分（只减不增）
    private String createTime;              //创建时间
    private String updateTime;              //更新时间
    private int version;                    //乐观锁
    private String remark;                  //备注说明
    private int accountType;                //账户类型
    private int investmentId;               //投资项目ID
    private int level;                      //等级 与积分转微币比例关联
    private String transferDate;            //最后一次积分转微币日期

    public CreditsEntity() {

    }

    public CreditsEntity(MemberEntity memberEntity){
        this.memberId = memberEntity.getId();
        this.accountType = 1;
        this.investmentId = 0;
        this.level = memberEntity.getLevel()*10;
        this.version = 0;
        if (memberEntity.getStatus() == 1) {
            this.status = 1;
        }else if (memberEntity.getStatus() == 2) {
            this.status = -1;
        }
        this.createTime = FrameDateUtils.timeStampToString(memberEntity.getCreateTime());
        this.updateTime = FrameDateUtils.currentFormatDate();
        this.nowCredits = memberEntity.getTotalCredit1();          //当前账户积分余额
        this.totalCredits = memberEntity.getCredit1();             //总积分收益
        this.todayIncrease = BigDecimal.valueOf(0.0000);       //今日新增积分（只增不减）
        this.todayDecrease = BigDecimal.valueOf(0.0000);       //今日消费积分（只减不增）
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getNowCredits() {
        return nowCredits;
    }

    public void setNowCredits(BigDecimal nowCredits) {
        this.nowCredits = nowCredits;
    }

    public BigDecimal getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(BigDecimal totalCredits) {
        this.totalCredits = totalCredits;
    }


    public BigDecimal getTodayIncrease() {
        return todayIncrease;
    }

    public void setTodayIncrease(BigDecimal todayIncrease) {
        this.todayIncrease = todayIncrease;
    }

    public BigDecimal getTodayDecrease() {
        return todayDecrease;
    }

    public void setTodayDecrease(BigDecimal todayDecrease) {
        this.todayDecrease = todayDecrease;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }
}
