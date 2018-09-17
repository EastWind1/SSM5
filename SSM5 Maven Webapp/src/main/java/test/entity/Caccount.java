package test.entity;

import java.math.BigDecimal;

public class Caccount {
    private String cid;

    private String pid;

    private String cname;

    private String ccurrency;

    private BigDecimal cnumber;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCcurrency() {
        return ccurrency;
    }

    public void setCcurrency(String ccurrency) {
        this.ccurrency = ccurrency == null ? null : ccurrency.trim();
    }

    public BigDecimal getCnumber() {
        return cnumber;
    }

    public void setCnumber(BigDecimal cnumber) {
        this.cnumber = cnumber;
    }
}