package com.izenbridge.tdd.parking.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ParkingChargeCalculatorServiceTest {

	@Test
	public void testCalculateParkingCharge_1Hour() {
		//arrange
		Date outTime = new Date();
		Date inTime = new Date(outTime.getTime() - 3600000);
		ParkingChargeCalculatorService parkingChargeCalculatorService = new ParkingChargeCalculatorService();
		
		// act
		int charge = parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime);
		
		// assert
		Assert.assertEquals(20, charge);
	}
}
