package com.izenbridge.tdd.parking.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingChargeCalculatorServiceTest {

	private static final int MILLIS_IN_MINUTE = 60000; 
	private static final int MILLIS_IN_HOUR = 3600000; 

	private ParkingChargeCalculatorService parkingChargeCalculatorService;
	private Date outTime;

	@Before
	public void setupForEachTest() {
		parkingChargeCalculatorService = new ParkingChargeCalculatorService();
		outTime = new Date();
	}
	
	@Test
	public void testCalculateParkingCharge_1Hour() {
		Date inTime = new Date(outTime.getTime() - MILLIS_IN_HOUR);
		Assert.assertEquals(20, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_1Hour1Minute() {
		Date inTime = new Date(outTime.getTime() - MILLIS_IN_HOUR - MILLIS_IN_MINUTE);
		Assert.assertEquals(30, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_2Hours() {
		Date inTime = new Date(outTime.getTime() - 2 * MILLIS_IN_HOUR);
		Assert.assertEquals(30, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_2Hour1Min() {
		Date inTime = new Date(outTime.getTime() - 2 * MILLIS_IN_HOUR - MILLIS_IN_MINUTE);
		Assert.assertEquals(40, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_3Hours() {
		Date inTime = new Date(outTime.getTime() - 3 * MILLIS_IN_HOUR);
		Assert.assertEquals(40, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_4Hours() {
		Date inTime = new Date(outTime.getTime() - 4 * MILLIS_IN_HOUR);
		Assert.assertEquals(50, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_5Hours() {
		Date inTime = new Date(outTime.getTime() - 5 * MILLIS_IN_HOUR);
		Assert.assertEquals(60, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_10Hours() {
		Date inTime = new Date(outTime.getTime() - 10 * MILLIS_IN_HOUR);
		Assert.assertEquals(110, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_15Hours() {
		Date inTime = new Date(outTime.getTime() - 15 * MILLIS_IN_HOUR);
		Assert.assertEquals(160, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_20Hours() {
		Date inTime = new Date(outTime.getTime() - 20 * MILLIS_IN_HOUR);
		Assert.assertEquals(210, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test
	public void testCalculateParkingCharge_24Hours() {
		Date inTime = new Date(outTime.getTime() - 24 * MILLIS_IN_HOUR);
		Assert.assertEquals(250, parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime));
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsWhenInTimeAfterOutTime() {
		Date inTime = new Date(outTime.getTime() + MILLIS_IN_MINUTE);
		parkingChargeCalculatorService.calculateParkingCharge(inTime, outTime);
	}

}
