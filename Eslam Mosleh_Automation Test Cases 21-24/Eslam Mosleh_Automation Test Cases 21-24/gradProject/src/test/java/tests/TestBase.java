package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class TestBase {
    public static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	public ChromeOptions chromeOption() {
        Map<String, Object> prefs = new HashMap<>();
        
        prefs.put("download.default_directory", downloadPath);
        
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);
       
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return options;
    }
    
    @BeforeTest
    public void startDriver() {
        driver = new ChromeDriver(chromeOption());

        Duration duration = Duration.ofSeconds(15);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(duration);
        driver.navigate().to("https://automationexercise.com/");
    }

    @AfterTest
    public void endDriver() {
        driver.quit();
    }

}
