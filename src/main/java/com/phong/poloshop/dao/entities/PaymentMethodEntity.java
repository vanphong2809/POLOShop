package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PAYMENT_METHOD", schema = "dbo")
public class PaymentMethodEntity implements Serializable{

	private static final long serialVersionUID = 2944719671024264186L;
	@Id
	@GeneratedValue
	@Column(name="PaymentMethodId")
	private int paymentMethodId;
	@Column(name="PaymentMethodName")
	private String paymentMethodName;
	@Column(name="Description")
	private String description;
	@Column(name="Status")
	private boolean status;
	public PaymentMethodEntity() {
		super();
	}
	public PaymentMethodEntity(int paymentMethodId, String paymentMethodName, String description, boolean status) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.paymentMethodName = paymentMethodName;
		this.description = description;
		this.status = status;
	}
	public int getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
