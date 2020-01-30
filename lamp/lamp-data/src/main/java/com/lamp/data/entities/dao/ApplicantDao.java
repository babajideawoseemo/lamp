package com.lamp.data.entities.dao;

import java.util.List;

import com.lamp.data.entities.Applicant;

public interface ApplicantDao {

	public void addApplicant(Applicant applicant);
	
	public List<Applicant> getApplicant();
	
	public Applicant getApplicantById(int id);
	
	public void updateApplicant(Applicant theApplicant);
	
	public void deleteApplicant(int theApplicant);
	
}
