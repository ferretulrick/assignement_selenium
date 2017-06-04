import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Created by ulrick on 04/06/2017.
 */
public class PageLogin extends PageObject {


    By emailLocator = By.name("loginfmt");
    By passwordLocator = By.name("passwd");
    By buttonLocator = By.id("idSIButton9");


    public PageLogin(WebDriver driver, Wait<WebDriver> wait, ActionBot actionBot) {
        super(driver,wait,actionBot);
    }

    public PageLogin enterWrongEmail(){
        actionBot.type(emailLocator,"selenium1234.testing987654321@outlook.com");
        actionBot.click(buttonLocator);
        return this;
    }



    public PageHome login(String email,String password){
        actionBot.type(emailLocator,email);
        actionBot.click(buttonLocator);

        actionBot.type(passwordLocator,password);
        actionBot.click(buttonLocator);
        return new PageHome(driver,wait,actionBot);
    }











}
