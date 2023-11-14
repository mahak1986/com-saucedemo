package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class SauceDemo {

    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Which browser to launch using if else
        // EqualsIgnoreCase ignores upper case or lower case
        if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else {
            System.out.println("Invalid browser name");
        }

        //Open Url
        driver.get((baseUrl));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Printing title of the page
        System.out.println("The Title of the page is: " + driver.getTitle());

        //Printing current Url
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        //Printing the page source
        System.out.println("The source page is: " + driver.getPageSource());

        //Enter the email to email field
        driver.findElement(By.id("user-name")).sendKeys("Mahak");
        Thread.sleep(2000);

        //Enter the password to password field
        driver.findElement(By.id("password")).sendKeys("Mahak123");
        Thread.sleep(2000);

        //Click on Login Button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Printing current URL
        System.out.println("The current Url is: " + driver.getCurrentUrl());

        //Navigate to baseUrl
        driver.navigate().to(baseUrl);
        Thread.sleep(2000);

        //Refresh the page
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Closing the browser
        driver.quit();
    }
}
