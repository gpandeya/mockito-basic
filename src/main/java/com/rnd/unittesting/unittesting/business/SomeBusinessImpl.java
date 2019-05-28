package com.rnd.unittesting.unittesting.business;

import com.rnd.unittesting.unittesting.data.DataService;

public class SomeBusinessImpl {

	private DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int [] data) {
		int sum=0;
		for(int value : data) {
			sum +=value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		
		int [] data = dataService.fetchAllData();
		int sum=0;
		for(int value : data) {
			sum +=value;
		}
		return sum;
	}
}
