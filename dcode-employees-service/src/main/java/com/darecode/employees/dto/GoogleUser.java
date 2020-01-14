package com.darecode.employees.dto;

import java.security.Principal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GoogleUser implements Principal{

	private String email;
	private boolean emailVerified;
	private String name;
	private String pictureUrl;
	private String locale;
	private String familyName;
	private String givenName;
	private String idGoogle;
	private String role;
	
	
	@Override
	public String getName() {
		return this.name;
	}

}
