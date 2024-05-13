package Utilities;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
import java.util.Locale;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // her bir thread'e özel static
    public static ThreadLocal<String> browserName = new ThreadLocal<>(); // her bir thread'e özel browser name


    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (browserName.get() == null) {   // switch null ise default'a gönderemez ondan dolayı böyle
            browserName.set("chrome");
        }

        if (threadDriver.get() == null) {
            switch (browserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                default:
                    if (isRunningOnJenkins()) {
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");

                        threadDriver.set(new ChromeDriver(options));
                    }

            }


            threadDriver.get().manage().window().setPosition(new Point(-1000, 0));

            threadDriver.get().manage().window().maximize();

            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        }


        return threadDriver.get();
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver kapat
        if (threadDriver.get() != null) { //bu hatta driver var ise
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);//bu hattaki driver NULL oldu
        }
    }

}
