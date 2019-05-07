package com.fs.springtests.app;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fs.springtests.app.dao.AppDao;
import com.fs.springtests.app.model.Employee;
import com.fs.springtests.app.service.AppService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AppServiceTest {

	 @Mock
	 private AppDao appDao;

	 @InjectMocks
	 private AppService appService;
	
	@Test
	public void testGetMaxSalary() {
		
		List<Employee> emps=new ArrayList<Employee>();
		
		emps.add(new Employee(908L, "EMP01", "XXX", "", 9878.0));
		emps.add(new Employee(808L, "EMP02", "YYY", "", 09886.0));
		emps.add(new Employee(708L, "EMP03", "ZZZ", "", 10988787.0));
		
		Mockito.when(appDao.getEmployeeList()).thenReturn(emps);
		
		assertEquals(new Double(10988787.0), appService.getMaxSalary());
	}
	
}
