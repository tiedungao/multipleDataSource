package com.shallbuy.transfer.entity;

import java.math.BigDecimal;

/**
 * @version v2.0
 * Description
 * @auther gaotiedun
 * Created Date 2020/1/10 0010 10:25
 * Updated Date      by
 */

public class MemberEntity {

    private int id;
    private int level;
    private int upgradeType;
    private int createTime;
    private BigDecimal credit1;
    private BigDecimal totalCredit1;
    private BigDecimal credit2;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(int upgradeType) {
        this.upgradeType = upgradeType;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getCredit1() {
        return credit1;
    }

    public void setCredit1(BigDecimal credit1) {
        this.credit1 = credit1;
    }

    public BigDecimal getTotalCredit1() {
        return totalCredit1;
    }

    public void setTotalCredit1(BigDecimal totalCredit1) {
        this.totalCredit1 = totalCredit1;
    }

    public BigDecimal getCredit2() {
        return credit2;
    }

    public void setCredit2(BigDecimal credit2) {
        this.credit2 = credit2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
