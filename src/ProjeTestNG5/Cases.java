package ProjeTestNG5;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;

public class Cases extends BaseDriverParameter {

//    Techno Study Testing Project 5
//            1. POM kullanınız.
//            2. Paralel testler koşturunuz (Chrome,Firefox).
//            3. Test Case’lerinizi xml file dan çalistiriniz.
//4. Url: https://admin-demo.nopcommerce.com/login?
    @Test(priority = 0)
    public void loginTest() {

        LeftNav ln=new LeftNav();
        driver.get("https://admin-demo.nopcommerce.com/login?");
        ln.email.clear();
        ln.email.sendKeys("admin@yourstore.com");
        ln.pass.clear();
        ln.pass.sendKeys("admin");
        ln.login.click();

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("admin"));
    }
    @Test(priority = 1)
    public void checkLeftNaw() {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        LeftNav ln=new LeftNav();
        //    Test Case 2: Check LeftNaw Menu
//➢ Dashboardun altındaki menülere tek tek tıklatın.
//            ➢ Menülerin açılıp açılmadığını doğrulayın.
//            ➢ Açılan menünün altındaki elemanların olduğunu doğrulayın.
       // js.executeScript("arguments[0].click();", ln.catalog);
        ln.catalog.click();
        Assert.assertTrue(ln.catalogverify.isDisplayed());
        Tools.Bekle(1);

        ln.sales.click();
        //js.executeScript("arguments[0].click();", ln.sales);
        Assert.assertTrue(ln.salesverify.isDisplayed());
        Tools.Bekle(1);

        ln.customers.click();
        //js.executeScript("arguments[0].click();", ln.customers);
        Assert.assertTrue(ln.customersverify.isDisplayed());
        Tools.Bekle(1);

        ln.promotions.click();
        Assert.assertTrue(ln.promotionsverify.isDisplayed());
        Tools.Bekle(1);
    ln.content.click();
        Assert.assertTrue(ln.contentverify.isDisplayed());
        Tools.Bekle(1);

        Actions aksiyonlar=new Actions(driver);
        aksiyonlar.scrollToElement(ln.configrationverify);
    ln.configration.click();

    Tools.Bekle(1);
        Assert.assertTrue(ln.configrationverify.isDisplayed());Tools.Bekle(1);

        aksiyonlar.scrollToElement(ln.system);
    ln.system.click();
        Assert.assertTrue(ln.systemverify.isDisplayed());Tools.Bekle(1);

        ln.reports.click();
        Tools.Bekle(1);
        Assert.assertTrue(ln.reportsverify.isDisplayed());

        ln.help.click();
        Tools.Bekle(1);
        Assert.assertTrue(ln.helpverify.isDisplayed());

    }
    //    Test Case 3: Create Customer
    //➢ Customers menusunun altındaki Customers’a tıklatınız.
//            ➢ Açılan sayfada Add new Butonuna tıklatınız.
//            ➢ Açılan formu doldurunuz ve save butonuna tıklatınız.
//➢ Başarılı bir şekilde Customer oluşturduğunuzu doğrulayınız.
    @Test(priority = 2,dataProvider = "create")

    public void createCustomer(String email,String firstname,String lastname) {
        LeftNav ln=new LeftNav();
        ln.customers.click();
        ln.customersverify.click();
        DialogContent dc=new DialogContent();
        dc.addbtn.click();
        dc.eMail.sendKeys(email);
        dc.password.sendKeys("ahmet");
        dc.firstname.sendKeys(firstname);
        dc.lastName.sendKeys(lastname);
        dc.male.click();
        dc.dateOfBirth.click();

        dc.company.sendKeys("GROUP14");
        dc.tax.click();

        dc.select.click();
        wait.until(ExpectedConditions.visibilityOf(dc.icerde));
        dc.icerde.click();

        Select select=new Select(dc.select2);
        select.selectByValue("2");

        dc.adminComment.sendKeys("NO COMMENT ANYMORE");
        dc.save.click();
        Assert.assertTrue(dc.verifyaddcustomer.isDisplayed());
    }

//Test Case 4: Edit Customer
//➢ Customers’a tıklatınız.
//            ➢ Acilan sayfada search kısmına yukarıda oluşturduğunuz Customer’in email,firstname
//    ve lastName’leri giriniz.
//            ➢ Search butonuna tıklatınız.
//➢ Oluşturmuş olduğunuz kaydın geldiğini doğrulayınız.
//➢ Edit butonuna tıklatınız.
//➢ Herhangi bir bilgiyi değiştirip save butonuna tıklatınız.
//➢ Başarılı bir şekilde update olduğunu doğrulayınız.
    @Test(priority = 3,dataProvider = "edit")
    public void editCustomer(String email,String firstname,String lastname,String degistirilen){
        DialogContent dc=new DialogContent();
        LeftNav ln=new LeftNav();
        ln.customers.click();
        ln.customersverify.click();

        dc.searchEmail.sendKeys(email);
        dc.searchfirstName.sendKeys(firstname);
        dc.searchLastName.sendKeys(lastname);

        Tools.Bekle(2);
        Assert.assertTrue(dc.customerCheck.isDisplayed());
        dc.searchara.click();
        dc.editButton.click();

        dc.eMail.clear();
        dc.eMail.sendKeys(degistirilen);
        dc.save.click();
        Assert.assertTrue(dc.verifyaddcustomer.isDisplayed());
    }
    @Test(priority = 4,dataProvider = "delete")
    public void deleteCUstomer(String degistirilen,String firstname,String lastname){
        LeftNav ln=new LeftNav();
        DialogContent dc=new DialogContent();
        ln.customers.click();
        ln.customersverify.click();


        Tools.Bekle(1);
        dc.searchEmail.sendKeys(degistirilen);
        dc.searchfirstName.sendKeys(firstname);
        dc.searchLastName.sendKeys(lastname);
        Tools.Bekle(1);
        dc.searchara.click();
        dc.editButton.click();
        dc.deleteBtn.click();
        dc.confirmDelete.click();

        Assert.assertTrue(dc.verifyaddcustomer.isDisplayed());
    }
    //    Test Case 6: Search Test
//➢ Search kısmına “Shipments” textini gönderiniz.
//            ➢ Arama sonucuna tıklayınız.
//➢ Shipments’e gittiğini doğrulayınız
    @Test(priority = 5)
    public void SearchTest() throws AWTException {
        Robot rbt=new Robot();
        Tools.Bekle(1);
        for (int i = 0; i < 7; i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
        }
        rbt.keyPress(KeyEvent.VK_SHIFT);
        rbt.keyPress(KeyEvent.VK_S);
        rbt.keyRelease(KeyEvent.VK_S);
        rbt.keyPress(KeyEvent.VK_H);
        rbt.keyRelease(KeyEvent.VK_H);
        rbt.keyPress(KeyEvent.VK_I);
        rbt.keyRelease(KeyEvent.VK_I);
        rbt.keyPress(KeyEvent.VK_P);
        rbt.keyRelease(KeyEvent.VK_P);
        rbt.keyPress(KeyEvent.VK_M);
        rbt.keyRelease(KeyEvent.VK_M);
        rbt.keyPress(KeyEvent.VK_E);
        rbt.keyRelease(KeyEvent.VK_E);
        rbt.keyPress(KeyEvent.VK_N);
        rbt.keyRelease(KeyEvent.VK_N);
        rbt.keyPress(KeyEvent.VK_T);
        rbt.keyRelease(KeyEvent.VK_T);
        rbt.keyPress(KeyEvent.VK_S);
        rbt.keyRelease(KeyEvent.VK_S);
        rbt.keyRelease(KeyEvent.VK_SHIFT);
        Tools.Bekle(1);
        rbt.keyPress(KeyEvent.VK_DOWN);
        rbt.keyRelease(KeyEvent.VK_DOWN);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        DialogContent dc=new DialogContent();

        Actions actions=new Actions(driver);
        actions.doubleClick(dc.cikansonuc2);



        //aksiyonlar.moveToElement(dc.cikansonuc).click().build().perform();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("shipmentlist"));



    }
    @DataProvider
    public Object[][] create() {
        Object[][] create = {
                {"Ahmetcaner959594@gmail.com","ahmet","caner"}
        };

        return create;

    }

    @DataProvider
    public Object[][] edit() {
        Object[][] edit = {
                {"ahmetcaner959594@gmail.com","ahmet","caner","berkayguu35n35@hotmail.com"}
        };

        return edit;

    }

    @DataProvider
    public Object[][] delete() {
        Object[][] delete = {
                {"berkayguu35n35@hotmail.com","ahmet","caner"}
        };

        return delete;

    }
}
