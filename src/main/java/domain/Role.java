package domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/13.
 */
@Entity
@Table(name = "SHIRO_ROLE")
public class Role {

	private Integer id;
	private String nameZh;
	private String remark;


	@Column(name = "ROLE_ID")
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

	@Column(name = "ROLE_REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Role() {
	}

	public Role(Integer id, String nameZh, String remark) {
		this.id = id;
		this.nameZh = nameZh;
		this.remark = remark;
	}
}
