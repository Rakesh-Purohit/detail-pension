package com.digitalhonorsproject.pensionmanagement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.digitalhonorsproject.pensionmanagement.model.PMModel;
import com.digitalhonorsproject.pensionmanagement.repository.PMRepository;
import com.digitalhonorsproject.pensionmanagement.service.PMService;

@SpringBootTest
class PensionManagementApplicationTests {


	
	@Autowired
	private PMService pmservice;
	
	@MockBean  // @MockBean creates a Mock for the Repository, which can be used to call the actual Repository
	private PMRepository pensionrepo;   

	
	@Test
	void  findByAadharNumber()
	{
		PMModel obj= new PMModel();
		
	obj.setAadharNumber(9060421389253850L);
	obj.setBankName("General Financial Inc");
	
	Mockito.when(pensionrepo.findByAadharNumber(9060421389253850L)).thenReturn(obj);
	
	PMModel obj2=pmservice.findByAadharNumber(9060421389253850L);
	
	assertThat(obj.getBankName()).isEqualTo(obj2.getBankName());
	
	}
	

}


