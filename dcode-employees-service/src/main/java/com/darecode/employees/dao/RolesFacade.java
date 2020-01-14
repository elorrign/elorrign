package com.darecode.employees.dao;

import java.util.List;

import com.darecode.employees.dto.Roles;

public interface RolesFacade {

	public List<Roles> listAll();
	
	public Roles readRole(Integer id);
	
}
