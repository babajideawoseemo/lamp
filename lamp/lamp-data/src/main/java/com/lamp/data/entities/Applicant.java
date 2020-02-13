package com.lamp.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "applicant")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob")
	private String date_of_birth;
	
	@Column(name="verified")
	private boolean verified;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@JoinColumn(name="response_id")
	private Response response;
	
	@Enumerated(EnumType.STRING)
	private ApplicantStatus applicantStatus;

	
	public Applicant() {
		
	}

	public Applicant(String username, String firstName, String lastName, String email, String date_of_birth,
			boolean verified, long phone, String gender, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.verified = verified;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public boolean isVerified() {
		return verified;
	}



	public void setVerified(boolean verified) {
		this.verified = verified;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public ApplicantStatus getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(ApplicantStatus applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", date_of_birth=" + date_of_birth + ", verified=" + verified + ", phone="
				+ phone + ", gender=" + gender + ", password=" + password + ", response=" + response + "]";
	}













	
	
	
}
