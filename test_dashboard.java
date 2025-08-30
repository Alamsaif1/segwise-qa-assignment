package assesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_dashboard {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://ua.segwise.ai/qa_assignment");

            
            WebDriverWait wait = new WebDriverWait(driver, 20);

            
            WebElement loginWithEmailBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button//span[contains(text(),'Log in with email')]")
                )
            );
            loginWithEmailBtn.click();

            
            WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[autocomplete='email']")
                )
            );
            new Actions(driver).moveToElement(emailField).click().sendKeys("qa@segwise.ai").perform();

            
            WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[type='password']")
                )
            );
            new Actions(driver).moveToElement(passwordField).click().sendKeys("segwise_test").perform();

            
            WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
            );
            loginBtn.click();

           
            wait.until(ExpectedConditions.urlContains("qa_assignment/home"));

            
            WebElement costChart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Cost Per Install')]")
                )
            );

            if (costChart.isDisplayed()) {
                System.out.println("✅ Dashboard chart 'Cost Per Install' is visible!");
            } else {
                System.out.println("Chart not found!");
            }

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            driver.quit();
        }
    }
}
