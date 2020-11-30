package com.sondage.user;

import com.fasterxml.jackson.core.ObjectCodec;
import com.sondage.DAO.DAO;
import com.sondage.jdbc.ConnectionPostgreSQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication
public class SondageApplication {

	public static void main(String[] args) {
		try {
			ConnectionPostgreSQL.getInstance().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SpringApplication.run(SondageApplication.class, args);
	}

}
