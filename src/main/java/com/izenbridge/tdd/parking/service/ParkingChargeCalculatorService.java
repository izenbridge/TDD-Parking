package com.izenbridge.tdd.parking.service;

import java.util.Date;

public class ParkingChargeCalculatorService {

	public int calculateParkingCharge(Date inTime, Date outTime) {
		int parkingTimeInMinutes = (int) ((outTime.getTime() - inTime.getTime())/60000);
		if (parkingTimeInMinutes <= 60) {
			return 20;
		}

		return 10000;	// By default, return a ridiculously high parking charge 
	}

}
