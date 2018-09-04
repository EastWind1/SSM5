package test.entity;

import java.util.List;

public class Bank {
    private Integer bId;

    private String bName;
    
    private List<Interest> interest; 

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

	public List<Interest> getInterest() {
		return interest;
	}

	public void setInterests(List<Interest> interest) {
		this.interest = interest;
	}
}