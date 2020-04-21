import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTimeTestSuite {

	DateTime dateTime;
	
	@Test
	private void getSystemTimeTestSuite() {
		dateTime = new DateTime();
		Assert.assertEquals(System.currentTimeMillis(), dateTime.getTime());
	}

	@Test
	private void getClockForwardTime() {
		int setClockForwardInDays = 5;
		long advance = ((setClockForwardInDays * 24L + 0) * 60L) * 60000L;
		dateTime = new DateTime(setClockForwardInDays);
		Assert.assertEquals(System.currentTimeMillis() + advance, dateTime.getTime());
	}

	@Test
	private void setManualTime() {
		dateTime = new DateTime(12, 12, 2020);
	}

	@Test
	private void getManualTimeTestSuite() {
		dateTime = new DateTime(12, 12, 2020);
		Assert.assertEquals(System.currentTimeMillis(), dateTime.getTime());
	}

	@Test
	private void getNameOfDaysTestCase() {
		dateTime = new DateTime(12, 12, 2020);
		Assert.assertEquals("Saturday", dateTime.getNameOfDay());
	}

	// Set Current Date
	@Test
	private void getCurrentTimeTestCase() {
		Assert.assertEquals("2020-02-22", dateTime.getCurrentTime());
	}

	@Test
	private void differenceDaysTestCuite() {
		DateTime startDate = new DateTime(12, 12, 2019);
		DateTime endDate = new DateTime(17, 12, 2019);
		Assert.assertEquals(5, dateTime.diffDays(endDate, startDate));
	}


}
