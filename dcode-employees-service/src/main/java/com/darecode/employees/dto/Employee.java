package com.darecode.employees.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonAutoDetect
@Entity
public class Employee implements Serializable{

	@Id
	@ApiModelProperty(name ="Google ID of the user", example = "111071751345337203041")
	private String id;
	@ApiModelProperty(name = "The name of the person")
	private String name;
	@ApiModelProperty(name ="Surnme of the person")
	private String lastName;
	@ApiModelProperty(name = "Email of Darecode")
	private String email;

	public Employee(String name, String lastName, String email) {
		this.lastName=lastName;
		this.name=name;
		this.email=email;
	}
}
