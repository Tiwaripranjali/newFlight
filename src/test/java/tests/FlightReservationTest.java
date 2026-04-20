package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightReservationPage;

public class FlightReservationTest extends BaseTest {

    @Test
    public void testFlightReservation() throws InterruptedException {
        FlightReservationPage flightPage = new FlightReservationPage(driver);

        System.out.println("Step 1: Selecting trip type...");
        flightPage.selectTripType();
        Thread.sleep(2000);

        System.out.println("Step 2: Selecting 2 passengers...");
        flightPage.selectPassengers("2");
        Thread.sleep(2000);

        System.out.println("Step 3: Selecting departure from Paris on April 15...");
        flightPage.selectDeparture("Paris", "April", "15");
        Thread.sleep(2000);

        System.out.println("Step 4: Selecting arrival in London on May 20...");
        flightPage.selectArrival("London", "May", "20");
        Thread.sleep(2000);

        System.out.println("Step 5: Selecting Business Class...");
        flightPage.selectClass();
        Thread.sleep(2000);

        System.out.println("Step 6: Selecting Unified Airlines...");
        flightPage.selectAirline("Unified Airlines");
        Thread.sleep(2000);

        System.out.println("Step 7: Clicking Continue...");
        flightPage.clickContinue();
        Thread.sleep(2000);
        
        System.out.println("Step 8: Verifying results page...");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("reservation2.php"), "URL did not change to reservation2.php");

        Assert.assertTrue(driver.getTitle().contains("Flight"), "Page title does not contain 'Flight'");

        Assert.assertTrue(driver.findElement(By.name("reserveFlights")).isDisplayed(),
                          "Search results form not displayed");

        Thread.sleep(2000);

        System.out.println("Step 9: Test completed successfully!");
    }
}

