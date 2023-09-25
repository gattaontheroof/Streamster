package com.api.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "`User`")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usergen")
	@SequenceGenerator(name = "usergen", sequenceName = "user_id_seq", initialValue = 5, allocationSize = 1)
	private int id;

	@Column(name = "FIRSTNAME", nullable = false)
	@NotBlank
	@Size(min = 1, max = 20, message = "First name must  be inter than 1 character and less than 20 characters")
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	@NotBlank
	@Size(min = 1, max = 20, message = "Last name must  be lonher than 1 character and less than 20 characters")
	private String lastName;

	@Column(name = "DOB", nullable = false)
	@NotBlank
	@DateTimeFormat
	@Size(min = 8, max = 12, message = "DOB must not be blank")
	private Date dob;

	@Column(name = "EMAIL", nullable = false)
	@NotBlank
	@Size(min = 6, max = 30)
	@Email
	private String email;

	@Column(name = "PHONE_NO", nullable = true)
	@Size(max = 12)
	private String phoneNo;

	@Enumerated(EnumType.STRING)
	@NotBlank
	@Column(name = "COUNTRY", nullable = false)
	@Size(min = 6, max = 30)
	private Country country;

	@Column(name = "PASSWORD", nullable = false)
	@NotBlank
	@Size(min = 8, max = 30)
	@Value("${some.key:u}")
	private String password;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	@NotBlank
	@GeneratedValue
	private LocalDate registrationDate;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "USER_TYPE", nullable = false)
//	@NotBlank
//	@Size(max = 8)
//	private UserType userType;

	@Enumerated(EnumType.STRING)
	@Column(name = "SUBSCRIPTION", nullable = false)
	@NotBlank
	@Size(max = 8)
	private Subscription subscription;

//	@Column(name = "PAYMENT", nullable = true)
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "USER_PAYMENT", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "PAYMENT_ID"))
//	private List<Payment> payments = new ArrayList<>();
	
	
	@Column(name = "PAYMENT", nullable = true)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Payment> payments = new ArrayList<>();
	

//	@Enumerated(EnumType.ORDINAL)
//	@Column (name = "STATUS")
//	@Nullable
//	@GeneratedValue
//	private Status status;

	@Column(name = "RESET_TOKEN", nullable = true)
	private String passwordResetToken;


	public User(int id, String firstName, String lastName, Date dob, String email, String phoneNo, Country country,
			 Subscription subscription) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.country = country;
		this.subscription = subscription;

	}
	
//testing constructor
	public User(int id, String firstName, String lastName, String email) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPassword() {
		return password;

	}

	public String getPasswordResetToken() {
		return passwordResetToken;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;

	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}
