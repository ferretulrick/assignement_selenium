import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Created by ulrick on 04/06/2017.
 */
public class PageHome extends PageObject{

    By newEmailButtonLocator = By.xpath("//*[@id=\"_ariaId_24\"]");
    By emailAdressLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/div/span/div[1]/form/input");
    By emailObjectLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[6]/div[2]/input");
    By emailTextLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div[1]/div[3]/div");
    By emailSendButtonLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[3]/div[2]/div[1]/button[1]");

    //By menuEmailSendedLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[1]/div[2]/div/div[5]/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/");
    //By menuInboxLocator = By.xpath("//*[@id=\"_ariaId_34.subfolders\"]/div[4]");
    By inboxLastEmailLocator = By.xpath("//*[@id=\"primaryContainer\"]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[2]/div/div/div/div[5]/div[3]/div[1]/div[3]/div[1]/div/div/div[2]/div[2]/div[2]");

    By lastEmailTextLocator = By.xpath("//*[@id=\"x_divtagdefaultwrapper\"]");

    public PageHome(WebDriver driver,Wait<WebDriver> wait,ActionBot actionBot) {
        super(driver,wait,actionBot);
    }

    public void writeNewEmail(String email,String object,String text){
        actionBot.click(newEmailButtonLocator);
        actionBot.type(emailAdressLocator,email);
        actionBot.type(emailObjectLocator,object);
        actionBot.type(emailTextLocator,text);
        actionBot.click(emailSendButtonLocator);
    }

    public void selectLastEmail(){
        //actionBot.click(menuEmailSendedLocator);
        //actionBot.click(menuInboxLocator);
        actionBot.click(inboxLastEmailLocator);
    }

    public String getLastEmailText(){
        return actionBot.getText(lastEmailTextLocator);
    }



}
