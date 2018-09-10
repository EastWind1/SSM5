package test.entity;

import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

public class Linterest {
    private Integer lId;

    private String lName;

    private Integer lMitime;

    private Integer lMatime;

    private String lTunit;

    private BigDecimal lRate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String lStime;

    private String lState;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public Integer getlMitime() {
        return lMitime;
    }

    public void setlMitime(Integer lMitime) {
        this.lMitime = lMitime;
    }

    public Integer getlMatime() {
        return lMatime;
    }

    public void setlMatime(Integer lMatime) {
        this.lMatime = lMatime;
    }

    public String getlTunit() {
        return lTunit;
    }

    public void setlTunit(String lTunit) {
        this.lTunit = lTunit == null ? null : lTunit.trim();
    }

    public BigDecimal getlRate() {
        return lRate;
    }

    public void setlRate(BigDecimal lRate) {
        this.lRate = lRate;
    }

    public String getlStime() {
        return lStime;
    }

    public void setlStime(String lStime) {
        this.lStime = lStime == null ? null : lStime.trim();
    }

    public String getlState() {
        return lState;
    }

    public void setlState(String lState) {
        this.lState = lState == null ? null : lState.trim();
    }
}