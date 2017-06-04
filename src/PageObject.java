import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


/**
 * Created by ulrick on 04/06/2017.
 */
public class PageObject {

    WebDriver driver;
    Wait<WebDriver> wait;
    ActionBot actionBot;

    public PageObject(WebDriver driver, Wait<WebDriver> wait, ActionBot actionBot) {
        this.driver = driver;
        this.wait=wait;
        this.actionBot=actionBot;

        System.out.println("page title: "+driver.getTitle());
        /*
        if (!"Login".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
        */
    }
}
