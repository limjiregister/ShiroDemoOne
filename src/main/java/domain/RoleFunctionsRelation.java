package domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/13.
 */
@Entity
@Table(name = "SHIRO_ROLE_FUNCTION_RELATION")
public class RoleFunctionsRelation {

	private Integer id;
	private Integer parentNodeId;
	private Role role;
	private Function function;


	@Column(name = "SHIRO_RELATION_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	@JoinColumn(name = "ROLE_ID",referencedColumnName = "ROLE_ID",unique = true)
	@OneToOne
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToOne
	@JoinColumn(name = "FUNCTION_ID", referencedColumnName = "FUN_ID", unique = true)
	public Function getFunction() {

		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
