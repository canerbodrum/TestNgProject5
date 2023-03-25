package ProjeTestNG5;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static Utlity.BaseDriver.driver;


public class LeftNav extends BaseDriverParameter{

    public LeftNav() {
        PageFactory.initElements(BaseDriverParameter.driver,this);
    }



    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

    @FindBy(css = "[type='email']")
    public WebElement email;
    @FindBy(css = "[name='Password']")
    public WebElement pass;
    @FindBy(css = "[type='submit']")
    public WebElement login;
    @FindBy(xpath = "(//*[@class='nav-item has-treeview'])[1]")
    public WebElement catalog;

    @FindBy(xpath = "//a[@href='/Admin/Product/List']")
    public WebElement catalogverify;
    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[3]")
    public WebElement sales;

    @FindBy(xpath = "//a[@href='/Admin/Order/List']")
    public WebElement salesverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[4]")
    public WebElement customers;
    @FindBy(xpath = "//a[@href='/Admin/Customer/List']")
    public WebElement customersverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[5]")
    public WebElement promotions;

    @FindBy(xpath = "//a[@href='/Admin/Discount/List']")
    public WebElement promotionsverify;

    @FindBy(xpath = "//a[@href='/Admin/Topic/List']")
    public WebElement contentverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[6]")
    public WebElement content;

    @FindBy(xpath = "//a[@href='/Admin/EmailAccount/List']")
    public WebElement configrationverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[7]")
    public WebElement configration;


    @FindBy(xpath = "//a[@href='/Admin/Common/SystemInfo']")
    public WebElement systemverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[8]")
    public WebElement system;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[9]")
    public WebElement reports;

    @FindBy(xpath = "//a[@href='/Admin/Report/SalesSummary']")
    public WebElement reportsverify;

    @FindBy(xpath = "(//*[@data-widget='treeview']/li)[10]")
    public WebElement help;

    @FindBy(xpath = "//*[text()=' Documentation']")
    public WebElement helpverify;

}
