package api.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "`User`")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergen")
	@SequenceGenerator(name = "usergen", sequenceName = "user_id_seq", initialValue = 5, allocationSize = 1)
	private int id; 
	
	@Column(name = "FIRSTNAME")
	@NotBlank(message = "Enter a first name")
	@Size(min = 1, max = 20, message = "First name must  be longer than 1 character and less than 20 characters")
	private String firstName;
	
	@Column(name = "LASTNAME")
	@NotBlank(message = "Enter a last name")
	@Size(min = 1, max = 20, message = "Last name must  be longer tan 1 character and less than 20 characters")
	private String lastName;
	
	@Column(name="DOB")
	@NotBlank(message = "DOB must not be null or blank")
	@Size(min = 1, max = 10, message = "DOB must not be blank")
	private Date dob;
	
	@Column(name = "EMAIL")
	@NotBlank(message = "Enter a valid email address")
	@Size(min = 6, max = 30)
	@Email
	private String email;
	
	@Column(name = "PHONE_NO")
	@Nullable 
	@Size(max = 12) 
	private int phone_no;
	
	@Enumerated(EnumType.STRING)	
	@Column(name = "COUNTRY")
	@NotBlank(message = "Please select a country from a list")
	@Size(min = 6, max = 30)
	private Country country;
	
	@Column(name="PASSWORD")
	@NotBlank(message = "Password must have at least 8 characters")
	@Size(min = 8, max = 30)
	@Value("${some.key:u}")
	private String password;
	
	@Column(name = "REGISTRATION_DATE")
	@NotBlank(message = "Registration date must not be null or blank")
	@GeneratedValue
	private LocalDate registration_date;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="SUBSCRIPTION")
	@NotBlank(message = "Please select a subscription from  the list")
	@Size(max = 8)
	private Subscription subscription;
	
//	@Column(name="RENEWAL_DATE")
//	@Nullable
//	@GeneratedValue
//	private Date renewal_date;
	
//	@Enumerated(EnumType.ORDINAL)
//	@Column (name = "STATUS")
//	@Nullable
//	@GeneratedValue)
//	private Status status;
	
	@Column (name = "RESET_TOKEN")
	@Nullable
	@Size(max = 60) 
	private String password_reset_token;
	

	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, Date dob, String email, int phone_no, 
			Country country, Subscription subscription) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phone_no = phone_no;
		this.country = country;
		this.subscription = subscription;
		
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

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
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

	public String getPassword_reset_token() {
		return password_reset_token;
	}


	public LocalDate getRegistration_date() {
		return registration_date;

	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	

}
