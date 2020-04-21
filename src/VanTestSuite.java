import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VanTestSuite {

	Van van;

	@BeforeSuite
	private void setUp() {
		van = new Van("V_123", 2010, "2006", "2006", 0, new VehicleType(13));
	}

	@Test
	public void getLateFeeTestCase() {
		DateTime start = new DateTime(11, 10, 2019);
		DateTime end = new DateTime(17, 12, 2019);
		Assert.assertEquals(6532.5, van.getLateFee(end, start));
	}

	@Test
	private void wrongDateGetLateFeeTestCase() {
		DateTime end = new DateTime(11, 10, 2019);
		DateTime start = new DateTime(17, 12, 2019);
		Assert.assertEquals(0.0, van.getLateFee(end, start));
	}

	@Test
	private void returnVehicleCarTestCase() {
		this.van.Vehicle_id = "C_123";
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, van.returnVehicle(date));
	}

	@Test
	private void returnVehicleVanTestCase() {
		this.van.Vehicle_id = "V_123";
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, van.returnVehicle(date));
	}

	@Test
	private void positiveVehicleMaintainceTestCase() {
		van.vehicleStatus = 2;
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(true, van.completeMaintenance(date));
	}

	@Test
	private void negativeVehicleMaintainceTestCase() {
		van.vehicleStatus = 1;
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, van.completeMaintenance(date));
	}

	@Test
	private void noVehicleMaintainceTestCase() {
		van.vehicleStatus = 0;
		DateTime date = new DateTime(11, 10, 2019);
		Assert.assertEquals(false, van.completeMaintenance(date));
	}

	@Test
	private void getCarDetailsTestCase() {
		System.out.print(van.getDetails());
		Assert.assertEquals("Vehicle ID:	C_123\r\n" + " Year:	 2010\r\n" + " Make:	2006\r\n"
				+ " Model:	2006\r\n" + " Number of Seats:	13\r\n" + " Status:	Available", van.getDetails());
	}

}
