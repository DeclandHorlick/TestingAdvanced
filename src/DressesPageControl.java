import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DressesPageControl
{
    @FindBy(css = "#selectProductSort")
    private WebElement ClickSortBy;


    Select select = new Select(ClickSortBy);



    public void sortByLowestPrice()
    {
        ClickSortBy.click();
        select.selectByValue("Price: Lowest first");
    }
    public void sortByName()
    {
        ClickSortBy.click();
        select.selectByValue("Product Name: A to Z");
    }
}
