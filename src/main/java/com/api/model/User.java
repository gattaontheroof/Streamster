package com.api.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import jakarta.persistence.OneToMany;
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

	@Column(name = "FIRSTNAME")
	@NotBlank
	@Size(min = 1, max = 20, message = "First name must be at least 1 character and less than 20 characters")
	private String firstName;

	@Column(name = "LASTNAME")
	@NotBlank
	@Size(min = 1, max = 20, message = "Last name must be longer than 1 character and less than 20 characters")
	private String lastName;
	
	@Column(name = "USERNAME")
	@NotBlank
	@Size(min = 3, max = 20, message = "Username must be at least 3 characters and less than 20 characters")
	private String username;

	@Column(name = "DOB")
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Size(min = 8, max = 12, message = "DOB must not be blank")
	private Date dob;

	@Column(name = "EMAIL")
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
	private Country country = Country.UK;	//UK set up as default

	@Column(name = "PASSWORD")
	@NotBlank
	@Size(min = 8, max = 30)
	@Value("${some.key:u}")
	private String password;

	@Column(name = "REGISTRATION_DATE")
	private LocalDate registrationDate;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "USER_TYPE", nullable = false)
//	@NotBlank
//	@Size(max = 8)
//	private UserType userType;

	@Enumerated(EnumType.STRING)
	@Column(name = "SUBSCRIPTION")
	@NotBlank
	@Size(max = 8)
	private Subscription subscription = Subscription.BASIC; // Default value

	
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

	public User() {
		
	}
	
	
	public User(String firstName, String lastName, String username, Date dob, String email, String phoneNo, Country country,
			 Subscription subscription) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
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
	
	public String getUsername() {
		return lastName;
	}

	public void setgetUsername(String getUsername) {
		this.lastName = getUsername;
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
		return this.registrationDate = LocalDate.now();

	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}



}
