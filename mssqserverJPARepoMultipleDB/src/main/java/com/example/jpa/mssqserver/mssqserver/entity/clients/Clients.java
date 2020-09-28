package com.example.jpa.mssqserver.mssqserver.entity.clients;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTS")
public class Clients implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CLIENT_ID")
	private Integer client_id;
	
	@Column(name = "CLIENT_NAME")
	private String client_name;
	
	@Column(name = "ACCESS_DATE_TIME")
	private String access_date_time;
	
	@Column(name = "FIRST_TIME")
	private String first_time;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "SECOND_LAST_NAME")
	private String second_last_name;
	
	@Column(name = "KEEP_SESSION_COUNTER")
	private int keep_session_counter;
	
	@Column(name = "HARDWARE_ID")
	private String hardware_id;
	
	@Column(name = "STATUS_BM")
	private int status_bm;
	
	@Column(name = "CREATE_DT")
	private String create_dt;
	
	@Column(name = "DEVICE_ID")
	private String device_id;
	
	@Column(name = "MODIFICATION_DT")
	private String modification_dt;
	
	@Column(name = "LAST_LOGIN_DT")
	private String last_login_id;
	
	@Column(name = "CERTIFIED_CELLPHONE")
	private String certified_cellphone;
	
	@Column(name = "CODI_ID")
	private String codi_id;
	
}
