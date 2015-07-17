package com.izenbridge.tdd.parking.data;

public class ParkingRatesDAO {

	private static final int parkingFirstHour = 20;
	private static final int parkingSubsequentHours = 10;

	public int getParkingChargeFirstHour() {
		return parkingFirstHour;
	}

	public int getParkingChargeSubsequentHours() {
		return parkingSubsequentHours;
	}

}
