package recheck_test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import de.retest.recheck.*;
import de.retest.recheck.persistence.*;

public class recheck_test {

    public ChromeDriver driver;
    public Recheck re;

    @Before
    public void setUp() {
        re = new RecheckImpl();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1280,720");
        driver = new ChromeDriver(options);
    }

    @Test
    public void google() throws Exception {
        re.startTest();

        driver.get("http://google.com");
        re.check(driver, "open");

        re.capTest();
    }

    @After
    public void tearDown() {
        driver.quit();
        re.cap();
    }
}