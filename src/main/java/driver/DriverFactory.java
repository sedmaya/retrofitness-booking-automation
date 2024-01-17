package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (getBrowserType()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //firefoxOptions.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        String browserTypeRemote = System.getProperty("browserType");

        try {
            if (browserTypeRemote == null || browserTypeRemote.isEmpty()) {
                Properties property = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                property.load(file);
                browserType = property.getProperty("browser").toLowerCase(Locale.ROOT).trim();
            } else {
                browserType = browserTypeRemote;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
