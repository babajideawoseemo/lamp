package com.lamp.applicant.service;

import java.util.List;

import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.Response;

public interface ApplicantService {

	public void addApplicant(Applicant applicant);
	
	public List<Applicant> getApplicant();
	
	public Applicant getApplicantById(int applicantId);
	
	public void updateApplicant(Applicant applicant);
	
	public void deleteApplicant(int applicantId);
	
	public String encodePassword(Applicant applicant);
	
	public String encryptPassword(String password);

	public String getApplicantByEmail(Applicant applicant);
	
	public void sendMail(String from, int id);
	
	public void updatePassword(int applicantId, Applicant theApplicant);
	
	public void addResponse(Response response,Applicant applicant);
}
