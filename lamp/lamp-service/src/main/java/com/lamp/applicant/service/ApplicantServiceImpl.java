package com.lamp.applicant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.dao.ApplicantDao;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	
	@Autowired
	private ApplicantDao applicantDaoImpl;
	
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
	
}
