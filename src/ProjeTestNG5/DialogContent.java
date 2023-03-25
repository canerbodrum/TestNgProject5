package ProjeTestNG5;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class DialogContent extends BaseDriverParameter{
    public DialogContent() {
        PageFactory.initElements(BaseDriverParameter.driver,this);
    }
    @FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
    public WebElement addbtn;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='FirstName']")
    public WebElement firstname;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@id='Gender_Male']")
    public WebElement male;

    @FindBy(xpath = "//*[@id='customer-info']/div[2]/div[6]/div[2]/span[1]/span/span")
    public WebElement dateOfBirth;
    @FindBy(xpath = "//*[@id='Company']")
    public WebElement company;
    @FindBy(xpath = "//*[@id='IsTaxExempt']")
    public WebElement tax;
    @FindBy(xpath = "//*[@id='customer-info']/div[2]/div[9]/div[2]/div/div[1]/div/div/input")
    public WebElement select;

    @FindBy(xpath = "//*[@id='VendorId']")
    public WebElement select2;

    @FindBy(xpath = "//*[@id='AdminComment']")
    public WebElement adminComment;

    @FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
    public WebElement save;

    @FindBy(xpath = "//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[2]")
    public WebElement icerde;

    @FindBy(xpath = "//*[@id=VendorId]/option[2]")
    public WebElement icerde2;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement verifyaddcustomer;

    @FindBy(xpath = "//*[@id='SearchEmail']")
    public WebElement searchEmail;

    @FindBy(xpath = "//*[@id='SearchFirstName']")
    public WebElement searchfirstName;

    @FindBy(xpath = "//*[@id='SearchLastName']")
    public WebElement searchLastName;
    //*[@id="SearchEmail"]

    @FindBy(xpath = "//div[text()='Search']")
    public WebElement searchBtn;

    @FindBy(xpath = "(//*[@class='odd'])[1]")
    public WebElement customerCheck;

    //*[@id="search-customers"]
    @FindBy(xpath = "//*[@id='search-customers']")
    public WebElement searchara;

    @FindBy(xpath = "//*[@id='customers-grid']/tbody/tr/td[7]/a")
    public WebElement editButton;
    //*[@id="customers-grid"]/tbody/tr/td[7]/a

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/text()")
    public WebElement editCheck;

    @FindBy(xpath = "//*[@id='customer-delete']")
    public WebElement deleteBtn;

    @FindBy(css = "button[type='submit'][class='btn btn-danger float-right']")
    public WebElement confirmDelete;

    @FindBy(css = "//*[@id='search-box']/span/pre")
    public WebElement search;

    @FindBy(css = "//*[@id='user-selection']/h5/strong")
    public WebElement cikansonuc;

    @FindBy(css = "//*[@id='search-box']/span/input")
    public WebElement cikansonuc2;

}
