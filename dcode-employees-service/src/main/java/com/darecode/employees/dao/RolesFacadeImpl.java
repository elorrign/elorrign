package com.darecode.employees.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.darecode.employees.api.exceptions.JpaException;
import com.darecode.employees.dto.Roles;
@Component
public class RolesFacadeImpl implements RolesFacade{

	private RolesRepository dao;
	
	@Override
	public List<Roles> listAll() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw new JpaException(e.getLocalizedMessage());
		}
	}

	@Override
	public Roles readRole(Integer id) {
		try {
			return dao.getOne(id);
		} catch (Exception e) {
			throw new JpaException(e.getLocalizedMessage());
		}
	}

}
