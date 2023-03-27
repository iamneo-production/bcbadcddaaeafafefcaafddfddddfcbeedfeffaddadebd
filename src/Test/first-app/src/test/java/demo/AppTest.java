package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLinkCount() {
        // Navigate to Flipkart homepage
        driver.get("https://www.flipkart.com/");

        // Find the count of links on the page
        int linkCount = driver.findElements(By.tagName("a")).size();
        Assert.assertTrue(linkCount > 0, "There are no links on the page.");
        System.out.println("Number of links on the page: " + linkCount);
    }

    @Test
    public void testLinkTextAndUrl() {
        // Navigate to Flipkart homepage
        driver.get("https://www.flipkart.com/");

        // Print link text and URLs of all the links on the page
        for (WebElement link : driver.findElements(By.tagName("a"))) {
            String linkText = link.getText();
            String linkUrl = link.getAttribute("href");
            System.out.println(linkText + " - " + linkUrl);
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
