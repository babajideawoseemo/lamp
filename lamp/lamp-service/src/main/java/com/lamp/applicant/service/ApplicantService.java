package com.lamp.applicant.service;

import java.util.List;

import com.lamp.data.entities.Applicant;

public interface ApplicantService {

	public void addApplicant(Applicant applicant);
	
	public List<Applicant> getApplicant();
	
	public Applicant getApplicantById(int applicantId);
	
	public void updateApplicant(Applicant applicant);
	
	public void deleteApplicant(int applicantId);
}
