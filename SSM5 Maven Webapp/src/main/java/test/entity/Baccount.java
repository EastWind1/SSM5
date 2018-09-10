package test.entity;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Baccount {
    private String id;

    private String name;

    private String number;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String odate;

	private String type;

    private String currency;

    private String bank;

    private String agroup;

    private String unit;

    private String applicant;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String adate;

    private String reason;

    private String audit;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String audate;
    
    private List<Caccount> caccounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getGroup() {
        return agroup;
    }

    public void setGroup(String agroup) {
        this.agroup = agroup == null ? null : agroup.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit == null ? null : audit.trim();
    }

    public String getAudate() {
        return audate;
    }

    public void setAudate(String audate) {
        this.audate = audate;
    }

	public List<Caccount> getCaccounts() {
		return caccounts;
	}

	public void setCaccounts(List<Caccount> caccounts) {
		this.caccounts = caccounts;
	}
}