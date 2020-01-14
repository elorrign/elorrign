package com.darecode.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darecode.employees.dto.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
