package test.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SaleOrder {
    private String ddnm;

    private String ddbh;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String ywrq;

    private String khmc;

    private BigDecimal zje;

    private String khdh;
    
    private List<Delivery> jh;
    
    private List<Material> wl;
    
    public String getDdnm() {
        return ddnm;
    }

    public void setDdnm(String ddnm) {
        this.ddnm = ddnm == null ? null : ddnm.trim();
    }

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh == null ? null : ddbh.trim();
    }

    public String getYwrq() {
        return ywrq;
    }

    public void setYwrq(String ywrq) {
        this.ywrq = ywrq;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc == null ? null : khmc.trim();
    }

    public BigDecimal getZje() {
        return zje;
    }

    public void setZje(BigDecimal zje) {
        this.zje = zje;
    }

    public String getKhdh() {
        return khdh;
    }

    public void setKhdh(String khdh) {
        this.khdh = khdh == null ? null : khdh.trim();
    }

	public List<Delivery> getJh() {
		return jh;
	}

	public void setJh(List<Delivery> jh) {
		this.jh = jh;
	}

	public List<Material> getWl() {
		return wl;
	}

	public void setWl(List<Material> wl) {
		this.wl = wl;
	}
}