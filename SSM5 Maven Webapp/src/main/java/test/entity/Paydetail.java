package test.entity;

import java.math.BigDecimal;

public class Paydetail {
    private String id;

    private String runit;

    private String way;

    private String account;

    private BigDecimal anumber;

    private BigDecimal pnumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRunit() {
        return runit;
    }

    public void setRunit(String runit) {
        this.runit = runit == null ? null : runit.trim();
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way == null ? null : way.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public BigDecimal getAnumber() {
        return anumber;
    }

    public void setAnumber(BigDecimal anumber) {
        this.anumber = anumber;
    }

    public BigDecimal getPnumber() {
        return pnumber;
    }

    public void setPnumber(BigDecimal pnumber) {
        this.pnumber = pnumber;
    }
}