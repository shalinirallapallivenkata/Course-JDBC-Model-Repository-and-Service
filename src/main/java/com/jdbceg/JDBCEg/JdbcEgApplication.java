package com.jdbceg.JDBCEg;

import com.jdbceg.JDBCEg.model.Student;
import com.jdbceg.JDBCEg.repository.StudentRepository;
import com.jdbceg.JDBCEg.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
// H2 provides db connection using hikari data source one time connection (DBMS)
public class JdbcEgApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbcEgApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setId(4); // mentioned id as 4 here and tried adding 4 in data.sql
		student.setName("studentOne");
		student.setMarks(80);

		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(student);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		List<Student> studentsList = studentService.getAllStudents();
		System.out.println(studentsList);

	}



// Error: when using jdbc driver in pom.xml
	// this is wrapper class
//	Action:
//
//	Consider the following:
//	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
//	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
// to set normal jdbc we need to configure we gotta mention url, username password and the driver. for extra configuration xml configuration. create bean for datasource.
// Servelets container or web container request and response from client to server.
//	Spring will work behind the scene with servlet. To run servlet we need container tomcat.
// web application in java. Run this on java we need to create a package with .war runs on tomcat
// package creation and put that on tomcat


}
