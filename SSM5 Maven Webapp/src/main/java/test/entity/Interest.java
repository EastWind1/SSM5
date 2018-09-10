package test.entity;

import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

public class Interest {
    private Integer iId;

    private String iName;

    private String iWay;

    private BigDecimal iRate;

    private String iTunit;

    private Integer iStime;

    private Integer iLbtime;

    private Integer iLttime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String iBtime;

    private String iState;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public String getiWay() {
        return iWay;
    }

    public void setiWay(String iWay) {
        this.iWay = iWay == null ? null : iWay.trim();
    }

    public BigDecimal getiRate() {
        return iRate;
    }

    public void setiRate(BigDecimal iRate) {
        this.iRate = iRate;
    }

    public String getiTunit() {
        return iTunit;
    }

    public void setiTunit(String iTunit) {
        this.iTunit = iTunit == null ? null : iTunit.trim();
    }

    public Integer getiStime() {
        return iStime;
    }

    public void setiStime(Integer iStime) {
        this.iStime = iStime;
    }

    public Integer getiLbtime() {
        return iLbtime;
    }

    public void setiLbtime(Integer iLbtime) {
        this.iLbtime = iLbtime;
    }

    public Integer getiLttime() {
        return iLttime;
    }

    public void setiLttime(Integer iLttime) {
        this.iLttime = iLttime;
    }

    public String getiBtime() {
        return iBtime;
    }

    public void setiBtime(String iBtime) {
        this.iBtime = iBtime;
    }

    public String getiState() {
        return iState;
    }

    public void setiState(String iState) {
        this.iState = iState == null ? null : iState.trim();;
    }
}