package com.lamp.data.entities.dao;

import java.util.List;

import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.Response;

public interface ApplicantDao {

	public void addApplicant(Applicant applicant);
	
	public List<Applicant> getApplicant();
	
	public Applicant getApplicantById(int id);
	
	public void updateApplicant(Applicant theApplicant);
	
	public void deleteApplicant(int theApplicant);
	
	public String encodePassword(Applicant applicant);
	
	public void addResponse(Response response,Applicant applicant);
	
	public String getApplicantByEmail(Applicant applicant);
	
	public void updatePassword(int applicantId, Applicant theApplicant);
	
}
