package api.model;

import java.time.LocalDate;
import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity(name = "`User`")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergen")
	@SequenceGenerator(name = "usergen", sequenceName = "user_id_seq", initialValue = 5, allocationSize = 1)
	private Integer id; 
	
	@Column(name = "FIRSTNAME", nullable = false)
	@Size(min = 1, max = 20, message = "First name must  be longer than 1 character and less than 20 characters")
	private String firstName;
	
	@Column(name = "LASTNAME", nullable = false)
	@Size(min = 1, max = 20, message = "Last name must  be longer tan 1 character and less than 20 characters")
	private String lastName;
	
	@Column(name="DOB", nullable = false)
	@Size(min = 1, max = 10, message = "DOB must not be blank")
	private Date dob;
	
	@Column(name = "EMAIL", nullable = false)
	@Size(min = 6, max = 30)
	@Email
	private String email;
	
	@Column(name = "PHONE_NO", nullable = true)
	@Size(max = 12) 
	private int phoneNo;
	
	@Enumerated(EnumType.STRING)	
	@Column(name = "COUNTRY", nullable = false)
	@Size(min = 6, max = 30)
	private Country country;
	
	@Column(name="PASSWORD", nullable = false)
	@Size(min = 8, max = 30)
	@Value("${some.key:u}")
	private String password;
	
	@Column(name = "REGISTRATION_DATE", nullable = false)
	@GeneratedValue
	private LocalDate registrationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="SUBSCRIPTION", nullable = false)
	@Size(max = 8)
	private Subscription subscription;
	
//	@Column(name="PAYMENT", nullable = true)
//	@OneToMany(mappedBy = "transaction_id")
//	private List<Payment> paymentList;;
	
//	@Enumerated(EnumType.ORDINAL)
//	@Column (name = "STATUS")
//	@Nullable
//	@GeneratedValue)
//	private Status status;
	
	@Column (name = "RESET_TOKEN", nullable = true)
	private String passwordResetToken;
	

	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, Date dob, String email, int phoneNo, 
			Country country, Subscription subscription) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
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
