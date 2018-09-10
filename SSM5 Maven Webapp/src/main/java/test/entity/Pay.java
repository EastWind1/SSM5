package test.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Pay {
    private String id;

    private String unit;

    private String depart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String etime;

    private String eway;

    private String currency;

    private BigDecimal number;

    private String note;

    private String applicant;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String atime;

    private String state;
    
    private List<Paydetail> paydetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime == null ? null : etime.trim();
    }

    public String getEway() {
        return eway;
    }

    public void setEway(String eway) {
        this.eway = eway == null ? null : eway.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime  == null ? null : atime.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public List<Paydetail> getPaydetails() {
		return paydetails;
	}

	public void setPaydetails(List<Paydetail> paydetails) {
		this.paydetails = paydetails;
	}
}