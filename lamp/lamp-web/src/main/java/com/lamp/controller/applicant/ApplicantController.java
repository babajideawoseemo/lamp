package com.lamp.controller.applicant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamp.applicant.service.ApplicantService;
import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.Response;

@RestController
public class ApplicantController {

	@Autowired
	private ApplicantService applicantServiceImpl;

	@CrossOrigin
	@PostMapping("/apply")
	public Applicant addApplicant(@RequestBody Applicant applicant) {
			
		applicantServiceImpl.sendMail(applicant.getEmail(),applicant.getId());
		applicantServiceImpl.addApplicant(applicant);;
		
		return applicant;
	}
	
	@CrossOrigin
	@GetMapping("/getApplicant")
	public List<Applicant> getApplicants() {
		return applicantServiceImpl.getApplicant();
	}
	
	@CrossOrigin
	@GetMapping("/getApplicant/{id}")
	public Applicant getApplicantById(@PathVariable int id) {
		
		return applicantServiceImpl.getApplicantById(id);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteApplicant/{applicantId}")
	public void deleteApplicant(@PathVariable int applicantId) {
		
		applicantServiceImpl.deleteApplicant(applicantId);
	}
	
	@CrossOrigin
	@PutMapping("/updateApplicant/{applicantId}")
	public Applicant updateApplicant(@PathVariable int applicantId, @RequestBody Applicant applicant) {
		
		applicant = applicantServiceImpl.getApplicantById(applicantId);
		
		applicantServiceImpl.updateApplicant(applicant);
		
		return applicant;
	}
	
	@CrossOrigin
	@PutMapping("/addResponse/{applicantId}")
	public Response addResponse(@PathVariable int applicantId, @RequestBody Response response) {
		
		Applicant applicant = applicantServiceImpl.getApplicantById(applicantId);
		
		applicantServiceImpl.addResponse(response,applicant);
		
		return response;
	}
	
	@CrossOrigin
	@PutMapping("/createPassword/{applicantId}")
	public Applicant updatePassword(@PathVariable int applicantId, @RequestBody Applicant theApplicant) {
		
		applicantServiceImpl.updatePassword(applicantId, theApplicant);
		
		return theApplicant;
		
	}
	
	
}
