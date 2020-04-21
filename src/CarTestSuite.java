import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CarTestSuite {

	Car car;

	@BeforeSuite
	private void setUp() {
		car = new Car("C_123", 2010, "2006", "2006", 0, new VehicleType(13));
	}

	@Test
	public void getLateFeeTestCase() {
		DateTime start = new DateTime(11,10,2019);
		DateTime end = new DateTime(17, 12, 2019);
		Assert.assertEquals(6532.5, car.getLateFee(end, start));
	}

	@Test
	private void wrongDateGetLateFeeTestCase() {
		DateTime end = new DateTime(11, 10, 2019);
		DateTime start = new DateTime(17, 12, 2019);
		Assert.assertEquals(0.0, car.getLateFee(end, start));
	}

	@Test
	private void returnVehicleCarTestCase() {
		this.car.Vehicle_id = "C_123";
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, car.returnVehicle(date));
	}

	@Test
	private void returnVehicleVanTestCase() {
		this.car.Vehicle_id = "V_123";
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, car.returnVehicle(date));
	}

	@Test
	private void positiveVehicleMaintainceTestCase() {
		car.vehicleStatus = 2;
		Assert.assertEquals(true, car.completeMaintenance());
	}

	@Test
	private void negativeVehicleMaintainceTestCase() {
		car.vehicleStatus = 1;
		Assert.assertEquals(false, car.completeMaintenance());
	}


	@Test
	private void noVehicleMaintainceTestCase() {
		car.vehicleStatus = 0;
		Assert.assertEquals(false, car.completeMaintenance());
	}

	@Test
	private void getCarDetailsTestCase() {
		System.out.print(car.getDetails());
		Assert.assertEquals("Vehicle ID:	C_123\r\n" + " Year:	 2010\r\n" + " Make:	2006\r\n"
				+ " Model:	2006\r\n" + " Number of Seats:	13\r\n" + " Status:	Available", car.getDetails());
	}
	
}
