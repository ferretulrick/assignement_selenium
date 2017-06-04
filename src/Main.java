import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest()
    {
        System.setProperty("webdriver.chrome.driver", "c:/lib/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

        ActionBot actionBot = new ActionBot(driver,wait);



        try {
            driver.get("https://outlook.live.com/");


            actionBot.click(By.className("buttonLargeBlue"));

            PageLogin pageLogin = new PageLogin(driver,wait,actionBot);

            //pageLogin.enterWrongEmail();
            PageHome pageHome = pageLogin.login("selenium.testing@outlook.com","azerty1234");
            String emailText = textRandom();
            pageHome.writeNewEmail("selenium.testing@outlook.com","test selenium",emailText);

            pageHome.selectLastEmail();
            assertEquals(emailText,pageHome.getLastEmailText());


        } catch(Exception e) {
            fail(e.getMessage());
        }
        finally {
            driver.close();
        }

    }


    public String textRandom(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(1000, random).toString(32);
    }



}