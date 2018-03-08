package com.electronic.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRole;
	private String RoleName;
	
	public Role(){}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public Role(String roleName) {
		super();
		RoleName = roleName;
	}
	
	

}
