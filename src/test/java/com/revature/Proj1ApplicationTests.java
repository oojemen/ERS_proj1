package com.revature;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.*;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.Mock.stubbing;
//import java.lang.List;
import java.util.ArrayList;
import java.util.List;

//import java.util.*;

//import org.mockito.stubbing.OngoingStubbing;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class Proj1ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock //Mocked UserDAO, which is a dependency of UserService
	UserDAO userDAO;

	@InjectMocks	// Injecting the mocked dependency into CourseService
	private UserService userService;


	@Mock
	ReimbursementDAO reimbursementDAO;

	@InjectMocks
	private ReimbursementService reimbursementService;

	public void testGetAllUser() {

		/*
		OngoingStubbing<List<User>> listOngoingStubbing;


		listOngoingStubbing = when(userDAO.findAll()).thenReturn(new List<User>);

		//   arrange (set up my employee dao, set up the expected results) act (inserting an employee) assert (making sure that the inserted employee was actually added)

		List<User> results = userService.getAllUser();

		//  Assertions Assert;
		assertTrue(results != null);

		 */
		// Create a list of mocked users
		List<User> expectedUsers = new ArrayList<>();
		//expectedUsers.add(new User("John"));
			expectedUsers.get(0);

		//expectedUsers.add(new User("Jane"));
		expectedUsers.get(1);

		// Mock the behavior of the userDAO.findAll() method
		when(userDAO.findAll()).thenReturn(expectedUsers);

		// Call the method under test
		List<User> results = userService.getAllUser();

		// Assertions
		assertNotNull(results);
		assertEquals(expectedUsers.size(), results.size());
		assertEquals(expectedUsers.get(0).getFirstName(), results.get(0).getLastName());
		assertEquals(expectedUsers.get(1).getFirstName(), results.get(1).getLastName());



	}





}
