/**
 * 
 */
package com.lamp.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Omotolani
 *
 */

@Entity
@Table(name = "response")
public class Response {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "response_id")
	private int id;
	
	
	@Column(name = "dob")
	private String dateofbirth;
	
	@Column(name = "state_of_origin") 
	private String stateOfOrigin;
	
	
	@Column(name = "state_of_residence") 
	private String stateOfResidence;
	
	
	@Column(name = "program") 
	private boolean ableToCommitToProgram;
	
	@Column(name = "relocate") 
	private boolean relocate;
	
	@Column(name = "marital_status") 
	private String maritalStatus;
	
	@Column(name = "secondary_school") 
	private String secondarySchool;
	
	@Column(name = "university") 
	private String university;
	
	@Column(name = "course") 
	private String course;
	
	@Column(name = "grad_year") 
	private String graduationYear;
	
	@Column(name = "grade") 
	private String grade;
	
	@Column(name = "nysc") 
	private String nysc;
	
	@Column(name = "job") 
	private String job;
	
	@Column(name = "prog_lang") 
	private String programmingLang;
	
	@Column(name = "fam_database") 
	private String databasetype;
	
	@Column(name = "operating_system") 
	private String operatingSystem;
	
	



	public Response() {
	
	}


	public Response(String dateofbirth, String stateOfOrigin, String stateOfResidence, boolean ableToCommitToProgram,
			boolean relocate, String maritalStatus, String secondarySchool, String university, String course,
			String graduationYear, String grade, String nysc, String job, String programmingLang, String databasetype,
			String operatingSystem) {
		super();
		this.dateofbirth = dateofbirth;
		this.stateOfOrigin = stateOfOrigin;
		this.stateOfResidence = stateOfResidence;
		this.ableToCommitToProgram = ableToCommitToProgram;
		this.relocate = relocate;
		this.maritalStatus = maritalStatus;
		this.secondarySchool = secondarySchool;
		this.university = university;
		this.course = course;
		this.graduationYear = graduationYear;
		this.grade = grade;
		this.nysc = nysc;
		this.job = job;
		this.programmingLang = programmingLang;
		this.databasetype = databasetype;
		this.operatingSystem = operatingSystem;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getStateOfOrigin() {
		return stateOfOrigin;
	}


	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}


	public String getStateOfResidence() {
		return stateOfResidence;
	}


	public void setStateOfResidence(String stateOfResidence) {
		this.stateOfResidence = stateOfResidence;
	}


	public boolean isAbleToCommitToProgram() {
		return ableToCommitToProgram;
	}


	public void setAbleToCommitToProgram(boolean ableToCommitToProgram) {
		this.ableToCommitToProgram = ableToCommitToProgram;
	}


	public boolean isRelocate() {
		return relocate;
	}


	public void setRelocate(boolean relocate) {
		this.relocate = relocate;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getSecondarySchool() {
		return secondarySchool;
	}


	public void setSecondarySchool(String secondarySchool) {
		this.secondarySchool = secondarySchool;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getGraduationYear() {
		return graduationYear;
	}


	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getNysc() {
		return nysc;
	}


	public void setNysc(String nysc) {
		this.nysc = nysc;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getProgrammingLang() {
		return programmingLang;
	}


	public void setProgrammingLang(String programmingLang) {
		this.programmingLang = programmingLang;
	}


	public String getDatabasetype() {
		return databasetype;
	}


	public void setDatabasetype(String databasetype) {
		this.databasetype = databasetype;
	}


	public String getOperatingSystem() {
		return operatingSystem;
	}


	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}




	@Override
	public String toString() {
		return "Response [id=" + id + ", dateofbirth=" + dateofbirth + ", stateOfOrigin=" + stateOfOrigin
				+ ", stateOfResidence=" + stateOfResidence + ", ableToCommitToProgram=" + ableToCommitToProgram
				+ ", relocate=" + relocate + ", maritalStatus=" + maritalStatus + ", secondarySchool=" + secondarySchool
				+ ", university=" + university + ", course=" + course + ", graduationYear=" + graduationYear
				+ ", grade=" + grade + ", nysc=" + nysc + ", job=" + job + ", programmingLang=" + programmingLang
				+ ", databasetype=" + databasetype + ", operatingSystem=" + operatingSystem 
				+ "]";
	}
	
	
	
	
	
	

}
