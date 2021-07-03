package Test;

import Test.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InterruptedIOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;
import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {

    WebDriverWait wait = new WebDriverWait(appiumDriver, 60);

    @Step("Allow butonuna basıldı")
    public void allowClick() {
        appiumDriver.findElement(By.id(ALLOW_BTN)).click();
    }

    @Step("Cookie kapatıldı")
    public void cookieAccept() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(COOKIE))).click();
    }

    @Step("Bilet Alma")
    public void bookAFlight() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BOOKING))).click();
        //appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
    }

    @Step("Tek Yön Seçme")
    public void oneWay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(ONE_WAY))).click();
    }

    @Step("Kalkıs havaalanı seçimi")
    public void depatureAirport() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(DEPARTURE))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode"))).click();
    }

    @Step("Arama kutusuna basma")
    public void choiceDepartureAirport() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(CHOICE_DEPARTURE))).click();
    }

    @Step("Arama kutusuna <key> yazıldı")
    public void departureWrite(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(DEPARTURE_SEARCH))).sendKeys(key);
    }

    @Step("SAW sacme")
    public void sawDeparture() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAW))).click();
    }

    @Step("Varıs havaalını secimi")
    public void arrivalPort() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(ARRIVAL))).click();
    }

    @Step("Varıs arama kutusuna basma")
    public void choiceArrivalPort() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(CHOICE_ARRIVAL))).click();
    }

    @Step("Varıs Arama Kutusuna <key> yazıldı")
    public void arrivalWrite(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(ARRIVAL_SEARCH))).sendKeys(key);
    }

    @Step("ESB secme")
    public void esbArrival() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ESB))).click();
    }

    @Step("Iki Gun sonra secme")
    public void datePick() throws InterruptedIOException {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Istanbul"));
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        day = day+2;
        String s = Integer.toString(day);
        System.out.println(s);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CALENDAR))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + s + "']"))).click();


    }
   @Step("Takvim kapatıldı")
   public void cal() throws InterruptedException {
       Thread.sleep(4000);
       wait.until(ExpectedConditions.elementToBeClickable(By.id(CLOSE_CALENDAR))).click();
    }

    @Step("Yetiskin sayısı arttırma")
    public void passengerCount(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COUNT_PERSON))).click();
    }
    @Step("Ucus ara butonuna basılır")
    public void searchFlight(){
       wait.until(ExpectedConditions.elementToBeClickable(By.id(FLIGHT_SEARCH))).click();
    }
    @Step("Listeyi Görüntüle")
    public void listOfFlight(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(LIST_FLIGHT)));
        Assert.assertEquals("SORT AND FILTER",appiumDriver.findElementById(LIST_FLIGHT).getText());
    }
    @Step("Lısteyi aç")
    public void flightList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FLIGHT_LIST))).click();
    }
    @Step("Ekonomik uçuşu seç")
    public void ecoFligt(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ECO_FLIGHT))).click();
    }
    @Step("Tamama bas")
    public void done() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(By.id(DONE_CLICK))).click();
    Thread.sleep(2000);
    }
}