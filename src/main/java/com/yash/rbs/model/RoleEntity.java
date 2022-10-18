package com.yash.rbs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user_role_mapping")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = -855065752444279587L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 120, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String role;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	
	
	

}
