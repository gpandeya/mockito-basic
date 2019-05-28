package com.rnd.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rnd.unittesting.unittesting.data.DataService;

class DataServiceStub implements DataService{
	@Override
	public int[] fetchAllData() {
		return new int [] {1,2,3};
	}	
}

class DataServiceEmptyStub implements DataService{
	@Override
	public int[] fetchAllData() {
		return new int [] {};
	}	
}

class DataServiceOneValueStub implements DataService{
	@Override
	public int[] fetchAllData() {
		return new int [] {5};
	}	
}

class DataServiceAllZeroStub implements DataService{
	@Override
	public int[] fetchAllData() {
		return new int [] {0,0,0,0};
	}	
}

public class SomeBusinessImplStubTest {
	
	@Test
	public void calculateSum_basic() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_empty() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new DataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_oneValue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new DataServiceOneValueStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_allZeroValue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new DataServiceAllZeroStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	

}
