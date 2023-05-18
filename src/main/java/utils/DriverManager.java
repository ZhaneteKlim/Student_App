package utils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static utils.ConfigHelper.getConfig;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static String testName;

    // Singleton pattern
    public static WebDriver getInstance() {
        if (driverThreadLocal.get() == null) {
            if (getConfig().getBoolean("student.app.run.locally")) {
                //     ChromeOptions options = new ChromeOptions();
                //     options.addArguments("--remote-allow-origins=*");
                //     driverThreadLocal.set(new ChromeDriver(options));
                driverThreadLocal.set(configureLocal());
            } else {
                driverThreadLocal.set(configureRemote());
            }
        }
        return driverThreadLocal.get();
    }

    public static void closeDriver() {
        driverThreadLocal.get().close();
        driverThreadLocal.remove();
    }

    private static RemoteWebDriver configureRemote() {
        URL url = null;
        try {
            //  url = new URL("https://oauth-nikita-839ac:91b032f7-1489-40cf-b55c-3bc4a3376d1c@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            url = new URL("https://oauth-janete.klim-f7afd:11561b45-a8a8-42df-9adf-44f7a7cfd540@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            //поменять ссылку на свой аккаунт!!!
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new RemoteWebDriver(url, configureOptions());
    }

    private static WebDriver configureLocal() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    public static MutableCapabilities configureCapabilities() {
        // private static MutableCapabilities configureCapabilities() {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        //sauceOptions.setCapability("username", "oauth-nikita-839ac");
        sauceOptions.setCapability("username", "oauth-janete.klim-f7afd");
        //sauceOptions.setCapability("access_key", "91b032f7-1489-40cf-b55c-3bc4a3376d1c");
        sauceOptions.setCapability("access_key", "11561b45-a8a8-42df-9adf-44f7a7cfd540");
        sauceOptions.setCapability("name", testName);
        sauceOptions.setCapability("browserVersion", "latest");
        return sauceOptions;
    }

    private static Capabilities configureOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", configureCapabilities());
        return options;
    }

    public static void markRemoteTest(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        ((JavascriptExecutor) getInstance()).executeScript("sauce:job-result=" + status);
    }
    //private static RemoteWebDriver configureRemote() {
    //  EdgeOptions browserOptions = new EdgeOptions();
    //  browserOptions.setPlatformName("Windows 11");
    //  browserOptions.setBrowserVersion("");
    //  Map<String, Object> sauceOptions = new HashMap<>();
    //   sauceOptions.put("build", "selenium-build-HJAUT");
    //   sauceOptions.put("name", "<your test name>");
    //   browserOptions.setCapability("sauce:options", sauceOptions);
    //   URL url = null;
    //   try {
    //      url = new URL("https://oauth-janete.klim-f7afd:11561b45-a8a8-42df-9adf-44f7a7cfd540@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    //  } catch (MalformedURLException e) {
    //      throw new RuntimeException(e);
    //  }
    //  return new RemoteWebDriver(url, browserOptions);
    // }

    // private static WebDriver configureLocal() {
    //     ChromeOptions options = new ChromeOptions();
    //     options.addArguments("--remote-allow-origins=*");
    //    return new ChromeDriver(options);
    //  }

}
