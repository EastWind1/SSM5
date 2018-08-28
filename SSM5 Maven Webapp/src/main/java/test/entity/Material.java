package test.entity;

import java.math.BigDecimal;

public class Material {
    private String wlnm;

    private String wlbh;

    private String wlmc;

    private BigDecimal zsl;

    private String zdw;

    private BigDecimal zdj;

    public String getWlnm() {
        return wlnm;
    }

    public void setWlnm(String wlnm) {
        this.wlnm = wlnm == null ? null : wlnm.trim();
    }

    public String getWlbh() {
        return wlbh;
    }

    public void setWlbh(String wlbh) {
        this.wlbh = wlbh == null ? null : wlbh.trim();
    }

    public String getWlmc() {
        return wlmc;
    }

    public void setWlmc(String wlmc) {
        this.wlmc = wlmc == null ? null : wlmc.trim();
    }

    public BigDecimal getZsl() {
        return zsl;
    }

    public void setZsl(BigDecimal zsl) {
        this.zsl = zsl;
    }

    public String getZdw() {
        return zdw;
    }

    public void setZdw(String zdw) {
        this.zdw = zdw == null ? null : zdw.trim();
    }

    public BigDecimal getZdj() {
        return zdj;
    }

    public void setZdj(BigDecimal zdj) {
        this.zdj = zdj;
    }
}