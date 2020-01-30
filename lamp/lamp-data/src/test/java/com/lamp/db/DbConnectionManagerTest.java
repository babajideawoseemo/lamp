package com.lamp.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@ContextConfiguration("classpath:/lamp-data-context.xml")
@RunWith(SpringRunner.class)
public class DbConnectionManagerTest {

	
	private Logger logger = Logger.getLogger(DbConnectionManagerTest.class);
	
	@Autowired
	private ComboPooledDataSource dataSource; 
	
	
	@Test
	public void dataSourceInitializedTest() {
		
		assertNotNull(dataSource);
	}
	
	@Test
	public void dbConnectionManagerExistTest() {
		
		String user = "lampuser";
		String password = "lampdatabase1";
		String jdbcUrl = "jdbc:mysql://localhost:3306/lampdb?useSSL=false&serverTimezone=UTC";
	
		try {
			
			
			logger.info("Getting connection to the database");
			
			Connection mycon = DriverManager.getConnection(jdbcUrl, user, password);
			
			logger.info("Connection to the database successful" + jdbcUrl);
			
			assertNotNull(mycon);
			
		}
		catch(SQLException e) {
			
			logger.warn("Error connecting to the database");
		}
		
		
	}

	

}
