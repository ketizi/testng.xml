
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ForExample {
    public WebDriver driver ; // კლასის დონეზე იქნება გლობალური ცვლადი (public უბრალოს ყველგან რომ დაინახოს მაგიტომ)
    SoftAssert softAssertion; // ეს იმიტომ ,რომ შემდეგ გამოვიყენოთ after ტესტში
    @BeforeMethod // უშუალოდ შეგვიძლია გამოვიყენოთ რაღაც ტესტის წინ
    public void beforeTestConfig(){ // ჩვენი გარემო დასეთაფებული გვაქვს, ესეიგი ყოველი ტესტის გაშვების დროს ვებდრაივერი გაიხსნება და გადავა გუგლის საიტზე
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @Test
    public void firsForExample() throws InterruptedException {
        By googleSearch = By.name("q");
        driver.findElement(googleSearch).sendKeys("linkedin");
        driver.findElement(googleSearch).sendKeys(Keys.ENTER);
 // ზოგადად assertion რაღაც მოსალოდნელ შედეგს ადარებს რეალურ შედეგს


        String expectedResult = "Lankdin"; // მოსალოდნელ შედეგს ვინახავთ სტრინგ ტიპის ცვლადში
        String actualResult = driver.findElement(googleSearch).getText();

  //      Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(6000);

    }
    @Test (groups = "Both")
    public void secondExample() throws InterruptedException {
        By googleSearch = By.name("q");
        driver.findElement(googleSearch).sendKeys("Keti Zirakashvili");
        driver.findElement(googleSearch).sendKeys(Keys.ENTER);
        Thread.sleep(5000);


    }
// before/after ტესტი ეშვება მხოლოდ ერთხელ
// before/after მეთოდი ეშვება ყოველი ტესტის წინ, before method გამოიყენება მხოლოდ დრაივერებთან სამუშაოდ
// before method გვთავაზობს იზოლაციას, ჯერ დრაივერი შექმენი, შემდეგ ტესტი დაწერე და after მეთოდით დახურე ბრაუზერი.
    @AfterMethod
    public void afterTestConfig(){

        driver.quit();

    }
// !!! თუ გვაქვს ხუთი ტესტი და ხუთივეში მჭირდება რაღაც ერთიდაიგივე გამაქვს before method-ში.
//შემდეგ ვწერ ტესტებს და ამ ხუთივეს თუ აქვს საერთო, რაც ტესტებს აერთიანებს, რაც უნდა მოხდეს ტესტის დასრულების შემდეგ
// გამაქვს aftermethod-ში.

}
// საბოლოოდ softassertion არის ტიპი, რომელიც მკაცრად არ ეუბნება ბრძანებას შესამოწმებლად, უბრალოდ verify ტიპია და თუ არ დაემთხვა დაიკიდებს და გააფასდებს.
