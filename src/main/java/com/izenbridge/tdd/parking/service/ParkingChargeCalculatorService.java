package com.izenbridge.tdd.parking.service;

import java.util.Date;

public class ParkingChargeCalculatorService {

	private static final int parkingFirstHour = 20;
	private static final int parkingSubsequentHours = 10;

	public int calculateParkingCharge(Date inTime, Date outTime) {
		int parkingTimeInMinutes = (int) ((outTime.getTime() - inTime.getTime())/60000);
		int parkingTimeInHours = (int)Math.ceil(parkingTimeInMinutes/60.0);
		return parkingFirstHour + parkingSubsequentHours * (parkingTimeInHours-1); 
	}

}
