package classcode;

class Vehicle {
	String dateOfMaking;
	int modelNo;
	String engineType;

	protected Vehicle(String dateOfMaking, int modelNo, String engineType) {
		super();
		this.dateOfMaking = dateOfMaking;
		this.modelNo = modelNo;
		this.engineType = engineType;
	}

	public void display() {
		System.out.println("\nVehicle Class Diplay Function :");
		System.out.println("Date of Making : " + dateOfMaking);
		System.out.println("Model No. : " + modelNo);
		System.out.println("Engine Type : " + engineType);
	}
}

//Vehicle Subclass
class Car extends Vehicle {

	String carModelName;

	protected Car(String dateOfMaking, int modelNo, String engineType, String carModelName) {
		super(dateOfMaking, modelNo, engineType);
		this.carModelName = carModelName;
	}

	public void displayCar() {
		System.out.println("\nCar Class Diplay Function :");
		System.out.println("Car Model Name : " + carModelName);
		System.out.println("Date of Making : " + dateOfMaking);
		System.out.println("Model No. : " + modelNo);
		System.out.println("Engine Type : " + engineType);
	}

}

class ELectricCar extends Car {

	double fuel;

	protected ELectricCar(String dateOfMaking, int modelNo, String engineType, String carModelName, double fuel) {
		super(dateOfMaking, modelNo, engineType, carModelName);
		this.fuel = fuel;
	}

}

//Car Subclass
class RacerCar extends Car {

	String carSpeed;

	protected RacerCar(String dateOfMaking, int modelNo, String engineType, String carModelName, String carSpeed) {
		super(dateOfMaking, modelNo, engineType, carModelName);
		this.carSpeed = carSpeed;
	}

}

class Bike extends Vehicle {

	String bikeModelName;

	protected Bike(String dateOfMaking, int modelNo, String engineType, String bikeModelName) {
		super(dateOfMaking, modelNo, engineType);
		this.bikeModelName = bikeModelName;
	}

	public void displayBike() {
		System.out.println("\nBike Class Diplay Function :");
		System.out.println("Bike Model Name : " + bikeModelName);
		System.out.println("Date of Making : " + dateOfMaking);
		System.out.println("Model No. : " + modelNo);
		System.out.println("Engine Type : " + engineType);
	}

}

//Bike Subclass
class MountainBike extends Bike {

	String heavyTires;

	protected MountainBike(String dateOfMaking, int modelNo, String engineType, String bikeModelName,
			String heavyTires) {
		super(dateOfMaking, modelNo, engineType, bikeModelName);
		this.heavyTires = heavyTires;
	}
}

class RacerBike extends Bike {
	int speed;

	protected RacerBike(String dateOfMaking, int modelNo, String engineType, String bikeModelName, int speed) {
		super(dateOfMaking, modelNo, engineType, bikeModelName);
		this.speed = speed;
	}

}

public class MultiLevelInheritance {

	public static void main(String[] args) {
		ELectricCar electricCar = new ELectricCar("2019-11-15", 178, "DTS", "Honda", 77);
		electricCar.display();
		electricCar.displayCar();

		RacerBike racerBike = new RacerBike("2017-01-18", 12345, "V6", "SuperSpeedBike", 200);
		racerBike.display();
		racerBike.displayBike();
	}

}
