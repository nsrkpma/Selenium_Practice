package Kane.Selenium_java;
import javax.net.ssl.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.List;



public class BrokenLinks {



    static String url = "http://www.rahulshettyacademy.com/AutomationPractice";

    static WebDriver driver;



    @Test(enabled = true)

    public void validateBrokenLinks() throws MalformedURLException, IOException {



        // Disable SSL certificate validation

        disableSslVerification();



        driver = new ChromeDriver();

        driver.get(url);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> links = driver.findElements(By.tagName("a"));



        SoftAssert sf = new SoftAssert();

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            System.out.println(url);



            if (url == null || url.isEmpty()) {

                System.out.println("URL is either not configured or it is empty");

                continue;

            }



            try {

                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

                conn.setRequestMethod("HEAD");

                conn.connect();

                int responseCode = conn.getResponseCode();

                System.out.println(responseCode);

                sf.assertTrue(responseCode < 400, "The link with Text " + link.getText() + " is broken with code: " + responseCode);

            } catch (Exception e) {

                System.out.println("Exception while checking URL: " + e.getMessage());

                sf.fail("Failed for URL: " + url);

            }

        }

        sf.assertAll();

    }



    // Method to disable SSL verification

    private static void disableSslVerification() {

        try {

            TrustManager[] trustAllCerts = new TrustManager[]{

                new X509TrustManager() {

                    public X509Certificate[] getAcceptedIssuers() {

                        return null;

                    }



                    public void checkClientTrusted(X509Certificate[] certs, String authType) {

                    }



                    public void checkServerTrusted(X509Certificate[] certs, String authType) {

                    }

                }

            };



            SSLContext sc = SSLContext.getInstance("TLS");

            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {

                    return true;

                }

            });

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
