import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignInControl
{
    ReadMySpreadSheet mySheet = new ReadMySpreadSheet(System.getProperty("user.dir") + "/src/Example_Spreadsheet.xlsx");
    List<String> row = mySheet.readRow(1, "Input Data");
    String myUser;

    @FindBy(css = "#email")
    private WebElement emailBox;

    @FindBy(css = "#passwd")
    private WebElement userNameBox;

    @FindBy(css = "#SubmitLogin")
    private WebElement submitLogin;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    private WebElement loginCheck;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement selectLogOut;

    public void enterEmail()
    {
        emailBox.sendKeys(row.get(2));
    }
    public void enterPassword()
    {
        userNameBox.sendKeys(row.get(3));
    }
    public void selectSignIn()
    {
        submitLogin.click();
    }
    public String checkLoggedIn()
    {

        myUser = loginCheck.getText();
        return loginCheck.getText();
    }
    public void signOut()
    {
        selectLogOut.click();
    }

}
