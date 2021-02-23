package com.restaurant.qrcode;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(description="All details about the user")
@Entity
@Table(name="qrcode")
public class QRBean 
{
	@Id
	@Column(name = "uuid", nullable = false)
	private String id;
	
	
	@Size(min = 2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Birth date should be in the past")
	@Column(name = "qrcode_type", nullable = false)
	private String type;
	
	@Column(name = "urltoreturn", nullable = false)
	private String URL;
	
	public QRBean() {
	}
	
	public QRBean(String id, String type, String uRL) {
		super();
		this.id = id;
		this.type = type;
		URL = uRL;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
}
