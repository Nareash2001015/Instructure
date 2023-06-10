package com.example.instructure;

import com.example.instructure.dao.*;
import com.example.instructure.utility.OperationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstructureApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	@Autowired
	private InstructorDao instructorDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private CourseDao courseDao;

	public static void main(String[] args) {
		SpringApplication.run(InstructureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		OperationUtility.usersOperations(userDao);
		OperationUtility.roleOperations(roleDao);
		OperationUtility.instructorOperations(instructorDao, roleDao, userDao);
		OperationUtility.studentOperation(studentDao, roleDao, userDao);
		OperationUtility.courseOperations(courseDao, instructorDao, studentDao);
	}
}
