package com.lamp.applicant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.Response;
import com.lamp.data.entities.dao.ApplicantDao;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	MailSender mailSender;
	
	@Autowired
	SimpleMailMessage mailMessage;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private ApplicantDao applicantDaoImpl;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void addApplicant(Applicant applicant) {
		
		applicantDaoImpl.addApplicant(applicant);
		
	}
	
	public List<Applicant> getApplicant() {
		
		List<Applicant> theApplicants = applicantDaoImpl.getApplicant();
		
		return theApplicants;
		
	}
	
	public Applicant getApplicantById(int applicantId) {
		
		return applicantDaoImpl.getApplicantById(applicantId);
		
	}
	
	
	public void updateApplicant(Applicant theApplicant) {
		applicantDaoImpl.updateApplicant(theApplicant);
	}
	
	public void deleteApplicant(int theApplicant) {
		applicantDaoImpl.deleteApplicant(theApplicant);
	}
	
	public void addResponse(Response response,Applicant applicant) {
		
		applicantDaoImpl.addResponse(response, applicant);
	}
	
	
	
	public String encryptPassword(String password) {
		return this.encoder.encode(password);
	}
	
	public void sendMail(String from,int id) {
				
		String subject = "Confirm Registration";
				
		mailMessage.setFrom("learningex123@gmail.com");
		mailMessage.setTo(from);
		mailMessage.setSubject(subject);
		mailMessage.setText("Confirm registration by clicking on the link below" + " " + "http://localhost:8081/password");
		mailSender.send(mailMessage);

	}
	
	public String encodePassword(Applicant applicant) {
		return applicantDaoImpl.encodePassword(applicant);
	}
	
	public String getApplicantByEmail(Applicant applicant) {
		
		return applicantDaoImpl.getApplicantByEmail(applicant);
		
	}
	
	public void updatePassword(int applicantId, Applicant theApplicant) {
		
		String encoded = this.encryptPassword(theApplicant.getPassword());
		
		Applicant updatedApplicant = applicantDaoImpl.getApplicantById(applicantId);
		
		updatedApplicant.setPassword(encoded);
		
		applicantDaoImpl.updatePassword(updatedApplicant.getId(), updatedApplicant);
		
	}
}
