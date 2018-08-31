package test.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class Delivery {
    private String jhnm;

    private String jhbh;

    private String shr;

    private String shdz;

    private String wlzz;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String jhjhrq;

    public String getJhnm() {
        return jhnm;
    }

    public void setJhnm(String jhnm) {
        this.jhnm = jhnm == null ? null : jhnm.trim();
    }

    public String getJhbh() {
        return jhbh;
    }

    public void setJhbh(String jhbh) {
        this.jhbh = jhbh == null ? null : jhbh.trim();
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr == null ? null : shr.trim();
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz == null ? null : shdz.trim();
    }

    public String getWlzz() {
        return wlzz;
    }

    public void setWlzz(String wlzz) {
        this.wlzz = wlzz == null ? null : wlzz.trim();
    }

    public String getJhjhrq() {
        return jhjhrq;
    }

    public void setJhjhrq(String jhjhrq) {
        this.jhjhrq = jhjhrq;
    }
}