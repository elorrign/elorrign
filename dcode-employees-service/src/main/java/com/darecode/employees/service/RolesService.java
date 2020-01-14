package com.darecode.employees.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.darecode.employees.dao.RolesFacade;
import com.darecode.employees.dto.Roles;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RolesService {

	private RolesFacade facade;
	
	@Cacheable(cacheNames = "roles")
	public List<Roles> listAll(){
		return facade.listAll();
	}
	
	@Cacheable(cacheNames = "roles")
	public Roles getOne(final Integer id){
		return facade.readRole(id);
	}
	
}
