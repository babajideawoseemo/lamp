package com.lamp.applicant.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.lamp.data.entities.Applicant;

@ContextConfiguration("classpath:/lamp-service-context.xml")
@RunWith(SpringRunner.class)
public class ApplicantServiceImplTest {

	
	@Mock
	private ApplicantService applicantService;
	
	@Before
	public void setUp() throws Exception {
		applicantService = mock(ApplicantService.class);
	}
	
	@Test
	public void applicantExistsTest() {
		assertNotNull(ApplicantService.class);
	}

	@Test
	public void addApplicantTest() {
		Applicant applicant = new Applicant("Austin","Mbum","Kemi","Fiyinola@yahoo.com","1998-12-13",false,8036061425L,"Male","badero5men");
	
		doNothing().when(applicantService).addApplicant(isA(Applicant.class));
		applicantService.addApplicant(applicant);
	
		verify(applicantService, times(1)).addApplicant(applicant);
	}
	
	@Test
	public void getApplicantTest() {
		
		Applicant applicant = new Applicant("Adilete","Ewele","Kolapeju","jinadu@yahoo.com","1985-7-15",true,7036061425L,"Male","jinadumen1123");
		Applicant applicant2 = new Applicant("Igbin","Babajide","Olufunmi","badmus@outlook.com","1994-08-3",false,8136571415L,"Male","badeotff5");
		Applicant applicant3 = new Applicant("Bridget","Bunmi","Kayode","tutinola@gmail.com","2019-1-12",true,8036972365L,"Male","merryment32");

		List<Applicant> theApplicant = new ArrayList<Applicant>();
		theApplicant.add(applicant);
		theApplicant.add(applicant2);
		theApplicant.add(applicant3);
		
		when(applicantService.getApplicant()).thenReturn(new ArrayList<Applicant>());
		applicantService.getApplicant();
		verify(applicantService, times(1)).getApplicant();
		
	}
}
