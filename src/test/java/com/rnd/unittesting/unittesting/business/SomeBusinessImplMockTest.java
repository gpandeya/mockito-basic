package com.rnd.unittesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import com.rnd.unittesting.unittesting.data.DataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	DataService mockDataService;
	
	/*It is not needed since Mockito will inject automatically due to annotations.*/
	/*@Before
	public void before() {
		business.setDataService(mockDataService);
	}
	*/
	
	@Test
	public void calculateSum_basic() {
		
		when(mockDataService.fetchAllData()).thenReturn(new int [] {1,2,3});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_empty() {
		when(mockDataService.fetchAllData()).thenReturn(new int [] {});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_oneValue() {
		when(mockDataService.fetchAllData()).thenReturn(new int [] {5});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_allZeroValue() {

		when(mockDataService.fetchAllData()).thenReturn(new int [] {0,0,0,0});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	

}
