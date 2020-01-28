package com.example.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Deatils of Contact")
public class Contact {

	@ApiModelProperty(notes="ID is VZID ")
	private String id;
	@ApiModelProperty(notes="First Name")
	private String name;
	@ApiModelProperty(notes="Mobile only")
	private String phone;
	
	Contact(){}
	Contact(String id,String name,String phone){
		id=this.id;name=this.name;phone=this.phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
