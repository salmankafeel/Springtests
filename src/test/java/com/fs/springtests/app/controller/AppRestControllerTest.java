package com.fs.springtests.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fs.springtests.app.model.Employee;
import com.fs.springtests.app.service.AppService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AppRestControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AppService appService;
	
	
	
	@Test
	public void testGetAllEmployees() throws Exception{
		
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(new Employee(98L, "", "XXX", null, 2300.0));
		emps.add(new Employee(92L, "", "YYY", null, 76878.0));
		
		Mockito.when(appService.getEmployeeList()).thenReturn(emps);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result= mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "[{\"id\":98,\"empNumber\":\"\",\"name\":\"XXX\",\"address\":null,\"salary\":2300.0},{\"id\":92,\"empNumber\":\"\",\"name\":\"YYY\",\"address\":null,\"salary\":76878.0}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void testSaveEmployee() throws Exception {
		String input = "{\"empNumber\":\"\",\"name\":\"AAA\",\"address\":null,\"salary\":8300.0}";
		
	Employee	expected =new Employee(95L, "", "AAA", "", 8300.0);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/updateEmployee")
				.content(input)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		Mockito.when(appService.createOrUpdateEmployee(Mockito.any())).thenReturn(expected);
		MvcResult result= mockMvc.perform(requestBuilder).andReturn();
		
		assertNotNull(result.getResponse().getContentAsString());
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testRetrieveEmployee() throws Exception {
		String output = "{\"id\":91,\"empNumber\":\"\",\"name\":\"AAA\",\"address\":\"\",\"salary\":8300.0}";
		
	Employee	expected =new Employee(91L, "", "AAA", "", 8300.0);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/retrieveEmployee/91")
				.accept(MediaType.APPLICATION_JSON);
		
		Mockito.when(appService.getEmployeById(Mockito.anyString())).thenReturn(expected);
		
		MvcResult result= mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(output,result.getResponse().getContentAsString());
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deleteEmployee/91")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result= mockMvc.perform(requestBuilder).andReturn();
		
		Mockito.verify(appService, times(1)).deleteEmployee(Mockito.anyString());
		System.out.println(result.getResponse().getContentAsString());
	}
	
	
}
