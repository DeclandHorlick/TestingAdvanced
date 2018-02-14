import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageControl {


    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement ClickSignIn;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement ClickWomens;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement ClickSignOut;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
    private WebElement SelectShirt;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement SelectDresses;

    public void selectSignIn()
    {
        ClickSignIn.click();
    }
    public void selectWomens()
    {
        ClickWomens.click();
    }
    public void selectSignOut()
    {
        ClickSignOut.click();
    }
    public void selectShirt()
    {
        SelectShirt.click();
    }
    public void selectDresses()
    {
        SelectDresses.click();
    }




}
