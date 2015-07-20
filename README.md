TDD Exercise - Parking charge calculator
========================================

The purpose of this project is to build a simple application in Core Java using Test-Driven Development.
Though a real-world application may contain Front-end Layer, Service Layer and a Data Access Layer, this exercise aims to build the service layer only.

==> Business Requirements
The Hourly parking rates are:
* Parking charge for first hour – Rs 20
* Parking charge for subsequent hours – Rs 10 per hour

==> Application version tags (master branch)
v1 - First failing test
v2 - First test passed
v3 - Added all tests - from 1 min to 24 hours
v4 - Added error handling - In-Time after Out-Time
v5 - Refactored service class to get rates from Data access layer
v6 - [PENDING] Make the unit tests independent of DAO changes (using Mocks)


==> Development Environment Setup 
* Install Eclipse or an IDE of your choice
* Install JDK 6 and above
* Install Git
* Install GitHub plugin for Eclipse (or another IDE)
* Download junit-4.12.jar and hamcrest-core-1.3.jar

==> Setting up the project (on Eclipse)
* Add 'Git Repositories' view thru... Windows >> Show View >> Git Repositories
* 'Clone a Git Respository' using GitHub location https://github.com/izenbridge/TDD-Parking.git
* Import Project
	- Right click Git Repository and select 'Import Projects', and follow prompts
* (optional) Switch to a specific tag, say 'v1' if you wish to do the exercise from start:
	- Right click the project... Team >> Switch to >> Other >> Tags >> 'v1'
* Update build path to include junit-4.12.jar and hamcrest-core-1.3.jar
	- Alternatively, you may convert this into a maven project and add maven dependencies for junit and hamcrest jars

==> Code the application functionality, Step by Step
1. The first test
	- Test that the parking charge calculation for first hour is correct
2. Add code to Pass the test
	- Simplest possible code that works
	- Real calculations, no hard coding of return value
	- Focus on the current test only, no code for future tests
3. Add more test cases, and code to pass them:
	a. 	Parking Charge for 1 minute – Rs 20
	b.	Parking Charge for less than 1 minute – Rs 0
	c.	Parking Charge for 1 hour 1 minute – Rs 30
	d.	Parking Charge for 2 hours – Rs 30
	e.	Parking Charge for 2 hours 1 minute – Rs 40
	f.	Parking Charge for 3 hours – Rs 40
	g. Parking Charge for 4 hours – Rs 50
	h.	Parking Charge for 5 hours – Rs 60
	i.	Parking Charge for 10 hours – Rs 110
	j.	Parking Charge for 15 hours – Rs 160
	k.	Parking Charge for 20 hours – Rs 210
	l.	Parking Charge for 24 hours – Rs 250
4. Add test (and code) to ensure proper error handling:
	- Parking In time is after Our time
5. Extract the Data Access layer from service layer:
	a. 	Replace hard-coded parking rates with constant variables
	b.	Replace constant variables with internal method calls
	c.	Move parking rate methods (along with constants) to a new Data Access class, say ParkingRatesDAO:
		- Add “TODO” comments to retrieve parking rates from database
		- Update Service class to get rates from DAO class
6.	Make the unit tests independent of DAO changes:
	a.	Double the parking rates in DAO class 
		- Most tests would FAIL now!
	b.	Update tests to mock DAO class behavior
		- May use previous rates to ensure tests pass without changing individual tests
