package com.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentidgen")
	@SequenceGenerator(name = "paymentidgen", sequenceName = "payment_id_seq", initialValue = 100, allocationSize = 1)
	private long paymentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "AMOUNT", nullable = false)
	@Size(min = 1, max = 20)
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "CURRENCY")
	@NotBlank
	@Size(min = 2, max = 5)
	private Currency currency = Currency.GBP;

	@Column(name = "PAYMENT_DATE")
	private LocalDate paymentDate;

	public Payment() {
		super();
	}

	public Payment(long paymentId, double amount, Currency currency) {
		super();
		this.paymentId = paymentId;
		this.amount = BigDecimal.valueOf(amount);;
		this.currency = currency;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setTransactionId(long transactionId) {
		this.paymentId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = BigDecimal.valueOf(amount);
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}
