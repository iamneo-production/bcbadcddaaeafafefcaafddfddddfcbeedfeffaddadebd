package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        // Initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to Flipkart homepage
        driver.get("https://www.flipkart.com/");

        // Find the count of links on the page
        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println("Number of links on the page: " + linkCount);

        // Print link text and URLs of all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String linkText = link.getText();
            String linkUrl = link.getAttribute("href");
            System.out.println(linkText + " - " + linkUrl);
        }

        // Close the browser
        driver.quit();
    }
}
