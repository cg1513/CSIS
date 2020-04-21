import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VehicleTypeTestSuite {

	VehicleType vehicleType;
	@BeforeSuite
	private void setUp() {
		vehicleType = new VehicleType(5);
	}

	@Test
	private void getSeatsForVanTypeTestCase()
	{
		DateTime date = new DateTime(11, 10, 2019);
		vehicleType = new VehicleType(5, date);
		Assert.assertEquals(5.0, vehicleType.getSeats("van"));
	}

	@Test
	private void getSeatsForCarTypeTestCase() {
		DateTime date = new DateTime(11, 10, 2019);
		vehicleType = new VehicleType(5);
		Assert.assertEquals(5.0, vehicleType.getSeats("car"));
	}

	@Test
	private void getSeatsForWrongTypeTestCase() {
		DateTime date = new DateTime(11, 10, 2019);
		vehicleType = new VehicleType(5);
		Assert.assertEquals(0.0, vehicleType.getSeats("type"));
	}

	@Test
	private void setCarSeatsTestSuite() {
		vehicleType.setCarSeats(5);
	}

	@Test
	private void getCarSeatsTestSuite() {
		vehicleType = new VehicleType(5);
		Assert.assertEquals(5, vehicleType.getCarSeats());
	}

	@Test
	private void indexOfTestCase() {
		Assert.assertEquals(-1, vehicleType.indexOf("5"));
	}

	@Test
	private void setLastMaintaincesTestSuite() {
		DateTime date = new DateTime(12, 12, 2019);
		vehicleType.setLastMaintenance(date);
	}

	@Test
	private void getLastMaintenanceTestSuite() {
		Assert.assertEquals(null, vehicleType.getLastMaintenance());
	}

	@Test
	private void carCanBeRentedForMinimumDaysTestCase() {
		DateTime date = new DateTime(12, 12, 2019);
		Assert.assertEquals(2, vehicleType.canBeRentedForMinimumDays(date, "car"));
	}

	@Test
	private void vanCanBeRentedForMinimumDaysTestCase() {
		DateTime date = new DateTime(12, 12, 2019);
		Assert.assertEquals(1, vehicleType.canBeRentedForMinimumDays(date, "van"));
	}

	@Test
	private void carIsUnderMaintenanceTestCase() {
		DateTime date = new DateTime(12, 12, 2019);
		DateTime lastDate = new DateTime(10, 11, 2019);
		vehicleType = new VehicleType(5, lastDate);
		Assert.assertEquals(false, vehicleType.IsUnderMaintenance(date, "car", 5));
	}

	@Test
	private void vanIsUnderMaintenanceTestCase() {
		DateTime date = new DateTime(12, 12, 2019);
		DateTime lastDate = new DateTime(10, 11, 2019);
		vehicleType = new VehicleType(5, lastDate);
		Assert.assertEquals(true, vehicleType.IsUnderMaintenance(date, "van", 5));
	}

}
