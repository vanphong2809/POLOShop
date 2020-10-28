package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment", schema = "dbo")
public class PaymentEntity implements Serializable{
	private static final long serialVersionUID = 8422713919919296370L;
	@Id
	@GeneratedValue
	@Column(name = "PaymentId")
	private int paymentId;
	@Column(name = "PaymentMethodId")
	private PaymentMethodEntity paymentMethod;
	@Column(name = "CardType")
	private String cardType;
	@Column(name = "CardNumber")
	private int cardNumber;
	@Column(name="NameOnCard")
	private String nameOnCard;
	@Column(name = "PaymentDate")
	private Date paymentDate;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="OrderId")
	private OrderEntity order;
	@Column(name = "Status")
	private int status;
	public PaymentEntity() {
		super();
	}
	public PaymentEntity(int paymentId, PaymentMethodEntity paymentMethod, String cardType, int cardNumber,
			String nameOnCard, Date paymentDate, OrderEntity order, int status) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.paymentDate = paymentDate;
		this.order = order;
		this.status = status;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public PaymentMethodEntity getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethodEntity paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
