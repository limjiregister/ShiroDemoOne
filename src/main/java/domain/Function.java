package domain;

import javax.persistence.*;


@Entity
@Table(name = "SHIRO_FUNCIONT")
public class Function {


	private Integer id;
	private String nameZh;
	private String reqUrl;
	private String remark;

	@Column(name = "FUN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	@Column(name = "FUN_REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Function() {
	}

	public Function(Integer id, String nameZh, String reqUrl, String remark) {
		this.id = id;
		this.nameZh = nameZh;
		this.reqUrl = reqUrl;
		this.remark = remark;
	}
}
