import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VehicleTestSuite {

	Vehicle vehicle;

	@BeforeSuite
	private void setUp() {
		vehicle = new Vehicle("C_123", 2010, "2006", "2006", 0, new VehicleType(13));
	}

	@Test
	public void getVehicleID() {
		DateTime start = new DateTime(11, 10, 2019);
		DateTime end = new DateTime(17, 12, 2019);
		Assert.assertEquals("C_123", vehicle.getVehicleId());
	}

	@Test
	private void rentTestSuite() {
		DateTime start = new DateTime(17, 12, 2019);
		Assert.assertEquals(false, vehicle.rent("c_111", start, 10));
	}

	@Test
	private void performMaintainceTestSuite() {
		Assert.assertEquals(true, vehicle.performMaintenance());
	}

	@Test
	private void getCarDetailsTestCase() {
		Assert.assertEquals("Vehicle ID:	C_123\r\n" + " Year:	 2010\r\n" + " Make:	2006\r\n"
				+ " Model:	2006\r\n" + " Number of Seats:	13\r\n" + " Status:	Available", vehicle.getDetails());
	}

}
