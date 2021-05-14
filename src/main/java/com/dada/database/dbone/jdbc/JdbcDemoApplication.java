package com.dada.database.dbone.jdbc;

import org.slf4j.LoggerFactory;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			logger.info("All users-> {}",dao.findAll());
			logger.info("User id 10001-> {}",dao.findById(10001));
			logger.info("User name Gillispe-> {}",dao.findByName("Gillispe"));
			logger.info("Deleting 10002. No. of rows deleted {}", dao.DeleteById(10002));
			logger.info("Deleting 10001 and Name \"Mec haz\". No. of rows deleted {}", dao.DeleteByIdAndName(10001, "Mec haz"));
			logger.info("nserting 10004-> {}", dao.insert(new JDBCPerson(10004, "Tara", "Berlin", new Date())));
			logger.info("All users-> {}",dao.findAll());

	}

}
