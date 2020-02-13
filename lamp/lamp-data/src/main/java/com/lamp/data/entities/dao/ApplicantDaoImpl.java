package com.lamp.data.entities.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.Response;

@Repository
public class ApplicantDaoImpl implements ApplicantDao {

	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(ApplicantDaoImpl.class.getName());
	
	@Transactional
	public void addApplicant(Applicant applicant) {
	
	Session currentSession = sessionFactory.getCurrentSession();
	
	logger.info("Saving applicant to the database " + applicant.toString());
	currentSession.save(applicant);
	
	}
	
	@Transactional
	public List<Applicant> getApplicant() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		logger.info("Querying list of applicants from the database");
		Query<Applicant> theQuery = currentSession.createQuery("from Applicant", Applicant.class);
		
		List<Applicant> applicantList = theQuery.getResultList();
		
		return applicantList;
	}
	
	@Transactional
	public Applicant getApplicantById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Applicant theApplicant = currentSession.get(Applicant.class, id);
		
		return theApplicant;
		
	}
	
	@Transactional
	public void updateApplicant(Applicant theApplicant) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(theApplicant);
		
	}
	
	@Transactional
	public void deleteApplicant(int applicantId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Applicant where id=:applicantId");
		
		theQuery.setParameter("applicantId", applicantId);
	}
	
	@Transactional 
	public void addResponse(Response response,Applicant applicant) {
	
	Session currentSession = sessionFactory.getCurrentSession();
	
	applicant.setResponse(response);
	
	
	logger.info("Saving response to the database " + response.toString());

	
	logger.info("Saving applicant to the database " + applicant.toString());
	currentSession.save(response);
	
	updateApplicant(applicant);

	}
	
	public String encodePassword(Applicant applicant) {
		
		applicant.setPassword(encoder.encode(applicant.getPassword()));
		return applicant.getPassword();
	}

	public String getApplicantByEmail(Applicant applicant) {
		
		applicant.setEmail(applicant.getEmail());
		return applicant.getEmail();
		
	}
	
	@Transactional
	public void updatePassword(int applicantId, Applicant theApplicant) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(theApplicant);
		
	}

}
