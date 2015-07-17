package com.izenbridge.tdd.parking.service;

import java.util.Date;

import com.izenbridge.tdd.parking.data.ParkingRatesDAO;

public class ParkingChargeCalculatorService {

	ParkingRatesDAO parkingRatesDAO;
	
	public void setParkingRatesDAO(ParkingRatesDAO parkingRatesDAO) {
		this.parkingRatesDAO = parkingRatesDAO;
	}

	public int calculateParkingCharge(Date inTime, Date outTime) {
		if (inTime.after(outTime)) {
			throw new IllegalArgumentException("Incorrect dates: Out-Time must be after In-Time.");
		}
		int parkingTimeInMinutes = (int) ((outTime.getTime() - inTime.getTime())/60000);
		int parkingTimeInHours = (int)Math.ceil(parkingTimeInMinutes/60.0);
		return parkingRatesDAO.getParkingChargeFirstHour() 
				+ parkingRatesDAO.getParkingChargeSubsequentHours() * (parkingTimeInHours-1); 
	}

}
