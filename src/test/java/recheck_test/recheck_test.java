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
        System.setProperty( RecheckProperties.REHUB_REPORT_UPLOAD_ENABLED_PROPERTY_KEY, "true" );
        re = new RecheckImpl();
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