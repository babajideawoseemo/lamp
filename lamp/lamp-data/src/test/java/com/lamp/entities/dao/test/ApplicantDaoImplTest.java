package com.lamp.entities.dao.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.lamp.data.entities.Applicant;
import com.lamp.data.entities.dao.ApplicantDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@ContextConfiguration(locations = "classpath:/lamp-data-context.xml")
@RunWith(SpringRunner.class)
public class ApplicantDaoImplTest {

	private Logger logger = Logger.getLogger(ApplicantDaoImplTest.class.getName());

	@Autowired
	private ApplicantDao applicantDaoImpl;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws Exception {
		
		String username = "lampuser";
		
		String password = "lampdatabase1";
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		String DBUrl = "jdbc:mysql://localhost:3306/lampdb?useSSL=false&serverTimezone=UTC";
		
		Connection conn = null;
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		try {
			
		
			DbUtils.loadDriver(jdbcDriver);
			
			conn = DriverManager.getConnection(DBUrl, username, password);
			
			queryRunner.update("drop database lampdb");
			
			queryRunner.update("create database lampdb");
			
	//		queryRunner.update("drop table employee");
			queryRunner.update("use lampdb");
			
			queryRunner.update("create table `applicant`(\r\n" + 
					"	\r\n" + 
					"	`id` int(30) not null auto_increment,\r\n" + 
					"    `user_name` varchar(30) default null,\r\n" + 
					"	`first_name` varchar(45) default null,\r\n" + 
					"	`last_name` varchar(45) default null,\r\n" + 
					"    `phone` bigint(200) default null,\r\n" + 
					"	`email` varchar(45) default null,\r\n" + 
					"    `dob` varchar(30) default null,\r\n" + 
					"    `verified` boolean,\r\n" + 
					"    `gender` varchar(15) default null,\r\n" + 
					"    `password` varchar(40) default null, \r\n" + 
					"	\r\n" + 
					"	 primary key(`id`)\r\n" + 
					"	\r\n" + 
					")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;");
			
		}
		catch(Exception e) {
			logger.throwing(ApplicantDaoImplTest.class.getName(), "setUp() method",e.getCause());
			e.printStackTrace();
		}
		finally {
			
			DbUtils.close(conn);
		};
		}
	
	@Test
	public void dbManagerClassesInitializedTest() {
		
		assertNotNull(applicantDaoImpl);
		assertNotNull(dataSource);
		
	}
	
	@Test
	public void addApplicantToDatabaseTest() {
		
		try {
			logger.info("Creating new Applicant object");
			
			Applicant theApplicant = new Applicant("Ademola","Ibukun","Ajagun","akinloluolaposi@gmail.com","1996-12-07",true,7069160721L,"Male","akeens4real");
		
			logger.info("Storing applicant to the database");
			
			applicantDaoImpl.addApplicant(theApplicant);
			
			logger.info("Successfully saving applicant to the database");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.warning("Error saving applicant to the database");
		}
		
	}
	
	@Test
	public void getApplicantByIdTest() {
		
		Applicant theApplicant1 = new Applicant("Ajegunle","Iyanuoluwa","Folakemi","Iyanufola@gmail.com","1993-02-03",true,8136061425L,"Female","Iyanu45good"); 
		Applicant theApplicant2 = new Applicant("Atinuke","Ifeoluwa","Riliwan","Iferilwan@outlook.com","1991-11-13",true,8136162826L,"Female","At9inuke23");
		Applicant theApplicant3 = new Applicant("Talabi","Eniokanmiyan","Jolayemi","jola18funmi@gmail.com","1999-12-4",true,8136061495L,"Male","Jolayemi12"); 


		applicantDaoImpl.addApplicant(theApplicant1);
		applicantDaoImpl.addApplicant(theApplicant2);
		applicantDaoImpl.addApplicant(theApplicant3);
		
		List<Applicant> theApplicants = applicantDaoImpl.getApplicant();
		
		assertNotNull(theApplicants.get(0));
		assertNotNull(theApplicants.get(1));
		assertNotNull(theApplicants.get(2));
		
		int applicantId = theApplicants.get(0).getId();
		
		Applicant tempApplicant = applicantDaoImpl.getApplicantById(applicantId);
		
//		String username = tempApplicant.getUsername();
//		String firstname = tempApplicant.getFirstName();
//		String lastname = tempApplicant.getLastName();
//		String email = tempApplicant.getEmail();
//		String dob = tempApplicant.getDate_of_birth();
//		boolean isVerified = tempApplicant.isVerified();
		
		logger.info("Applicant found from the database: ==>> " + tempApplicant);
				
		
		
	}

}
