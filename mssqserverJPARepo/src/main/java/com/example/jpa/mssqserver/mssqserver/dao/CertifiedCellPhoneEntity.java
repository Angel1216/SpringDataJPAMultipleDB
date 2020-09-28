package com.example.jpa.mssqserver.mssqserver.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
//import javax.persistence.StoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;


@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "CertifiedCellPhoneValidation",
        procedureName = "dbo.sp_Certified_CellPhone_Validation",
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="customer_numer", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="Adding", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="cellphone", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="carrier", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="certification_type", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="rejected_count", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="blocked", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="attemps", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="certification_way", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="DB_Status_Code", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="DB_Status_Code_Description", type=String.class)
    })
})
public class CertifiedCellPhoneEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CertifiedCellPhoneEntity() {};
	
	@Id
	@Column(name = "customer_numer")
	private String customerNumber;
	
	@Column(name = "Adding")
	private String adding;
	
	@Column(name = "cellphone")
	private String cellPhone;
	
	@Column(name = "carrier")
	private String carrier;
	
	@Column(name = "certification_type")
	private String certificationType;
	
	@Column(name = "rejected_count")
	private String rejectedCount;
	
	@Column(name = "blocked")
	private String blocked;
	
	@Column(name = "attemps")
	private String attemps;
	
	@Column(name = "certification_way")
	private String certificationWay;
	
	@Column(name = "DB_Status_Code")
	private String dbStatusCode;
	
	@Column(name = "DB_Status_Code_Description")
	private String dbStatusCodeDescription;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getAdding() {
		return adding;
	}

	public void setAdding(String adding) {
		this.adding = adding;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCertificationType() {
		return certificationType;
	}

	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}

	public String getRejectedCount() {
		return rejectedCount;
	}

	public void setRejectedCount(String rejectedCount) {
		this.rejectedCount = rejectedCount;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public String getAttemps() {
		return attemps;
	}

	public void setAttemps(String attemps) {
		this.attemps = attemps;
	}

	public String getCertificationWay() {
		return certificationWay;
	}

	public void setCertificationWay(String certificationWay) {
		this.certificationWay = certificationWay;
	}

	public String getDbStatusCode() {
		return dbStatusCode;
	}

	public void setDbStatusCode(String dbStatusCode) {
		this.dbStatusCode = dbStatusCode;
	}

	public String getDbStatusCodeDescription() {
		return dbStatusCodeDescription;
	}

	public void setDbStatusCodeDescription(String dbStatusCodeDescription) {
		this.dbStatusCodeDescription = dbStatusCodeDescription;
	}

}
