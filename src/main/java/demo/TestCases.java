package demo;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
           System.out.println("Start Test case: testCase01");
        // Navigate to Google Calendar ( https://calendar.google.com/ ).
           driver.get(" https://calendar.google.com/");
           String url = driver.getCurrentUrl();
        // Verify that the current URL contains "calendar."
           System.out.println("URL: " + url);
           System.out.println("End Test case: testCase01");
    }

        public void testCase02() throws InterruptedException {
          System.out.println("Start Test case: testCase02");
       
        // Switch to the month view.
          driver.findElement(By.xpath("//div[@class='XyKLOd']")).click();
          WebElement month = driver
                .findElement(By.xpath("//ul[@class='VfPpkd-StrnGf-rymPhb DMZ54e']//span[text()='Month']"));
             month.click();
             String actual = "Month";
             String expected = month.getText();
                 if (expected.equals(actual)) {
                  System.out.println("Test case passed");
              } else {
                 System.out.println("Test case failed");
                      }
             // Click on the Create to add a task.
              driver.findElement(By.xpath("//div[@class='dwlvNd Hrn1mc']//div[text()='Create']")).click();
              Thread.sleep(3000);
               // Navigate to the Tasks tab and click on it.
               driver.findElement(By.xpath("//div[contains(@class,'JPdR6b QFf4q qjTEB')]//div[contains(text(),'Task')]"))
                .click();
              Thread.sleep(3000);
              // Enter a title for the task Title: Crio INTV Task Automation
            WebElement title = driver.findElement(By.xpath("//div[@class='DgKtsd']//input[@class='VfPpkd-fmcmS-wGMbrd ']"));
            title.sendKeys("Crio INTV Task Automation");
            // Select a Start date for the task
            driver.findElement(By.xpath("//div[@class='Dna1ee']//span[@data-key='startDate']")).click();
              Thread.sleep(3000);
          // Select a date from the calendar
              driver.findElement(By.xpath("//div[@class='Dna1ee']//div[@class='ei1jbe']//div[text()='24']")).click();
             Thread.sleep(3000);
             // Select a time from the calendar
              driver.findElement(By.xpath("//div[@class='Dna1ee']//div[@class='Ufn6O']")).click();
              driver.findElement(By.xpath("//div[@class='Dna1ee']//div[@class='w8UdJc']//div[text()='12:15pm']")).click();
              // Description: Crio INTV Calendar Task Automation
              WebElement description = driver
                .findElement(By.xpath("//div[@class='Dna1ee']//textarea[@class='VfPpkd-fmcmS-wGMbrd TaTzUd']"));
              description.sendKeys("Crio INTV Calendar Task Automation");
              driver.findElement(By.xpath(
                "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']"))
                .click();

            System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//h2[text()='3 events, Sunday, March 24']//parent::div")).click();

        Thread.sleep(4000);
        // Click on the task to edit it. 
        WebElement task = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        task.click();
        // des.clear();
        Thread.sleep(2000);
        // Edit the task click on edit
        WebElement edit = driver.findElement(
                By.xpath("(//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe'])[1]"));
        edit.click();
        Thread.sleep(2000);
        // find description and clear it
        WebElement description = driver.findElement(By.xpath("//textarea[@class='VfPpkd-fmcmS-wGMbrd vRGQ0d']"));
        description.clear();
        //set new description 
        description.sendKeys(
                "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(2000);
        // Click on Save button              
        WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
        save.click();
       // click on cross button using find element
        driver.findElement(By.xpath("//span[@class='VfPpkd-kBDsod']")).click();
        // click on date 
        driver.findElement(By.xpath("//h2[text()='3 events, Sunday, March 24']//parent::div")).click();
        // click on task 
        Thread.sleep(2000);
        WebElement task1 = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        task1.click();
        // check for updated description.
        Thread.sleep(2000);
        WebElement updatedescription = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
        String des = updatedescription.getText();
        System.out.println(des);

        System.out.println("End Test case: testCase03");
        //// div[@class='Task deleted']
    }

    public void testCase04() throws InterruptedException {
        
        System.out.println("Start Test case: testCase04");

        driver.navigate().refresh();
        Thread.sleep(3000);
        // Click on the task 
        driver.findElement(By.xpath("//h2[text()='3 events, Sunday, March 24']//parent::div//div[text()='2 more']")).click();
        Thread.sleep(3000);
        // click on task.
        WebElement task = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        task.click();
        Thread.sleep(3000);
        // click on title by using find element
        WebElement title = driver
                .findElement(By.xpath("//span[@class='kma42e']//span[text()='Crio INTV Task Automation']"));
        System.out.println("Title: " + title.getText());
        // click on delete button
        WebElement delete = driver.findElement(
                By.xpath("(//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe'])[2]"));
        delete.click();
        // verify task is deleted.
        WebElement TaskDeleted = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        System.out.println("Task Deleted: " + TaskDeleted.getText());

        System.out.println("End Test case: testCase04");

    }


}