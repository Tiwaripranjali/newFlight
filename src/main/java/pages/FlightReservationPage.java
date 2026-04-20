package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightReservationPage {
    private WebDriver driver;

    public FlightReservationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTripType() {
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
    }

    public void selectPassengers(String count) {
        new Select(driver.findElement(By.name("passCount"))).selectByVisibleText(count);
    }

    public void selectDeparture(String city, String month, String day) {
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(city);
        new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText(day);
    }

    public void selectArrival(String city, String month, String day) {
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(city);
        new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("toDay"))).selectByVisibleText(day);
    }

    public void selectClass() {
        driver.findElement(By.xpath("//input[@value='Business']")).click();
    }

    public void selectAirline(String airline) {
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText(airline);
    }

    public void clickContinue() {
        driver.findElement(By.name("findFlights")).click();
    }
}
