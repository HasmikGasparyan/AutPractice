package Test;

import Base.SeleniumBase;
import Page.IndexPage;
import Page.BasePage;
import Page.MainAddressPage;
import Page.RegistrationPage;
import Utils.Helpers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationPracticeTest extends SeleniumBase {
    MainAddressPage mainAddressPage;
    Helpers helpers = new Helpers();
    BasePage basePage;
    IndexPage indexPage;
    RegistrationPage registrationPage;

    String rEmail;
    String name;
    String lastName;
    String address;
    String company;
    String phone;

    @BeforeClass
    public void setupDriver() {
        InitDriver();
    }

    @Test(priority = 1)
    public void checkTitleTest(){
        basePage = new BasePage(driver);
        mainAddressPage = new MainAddressPage(driver);

        mainAddressPage.getAddress();
        basePage.checkPageTitle("My Store");

    }
    @Test(priority = 2)
    public void CreateAccountEmailTest() throws InterruptedException {
        basePage = new BasePage(driver);
        indexPage = new IndexPage(driver);

        rEmail = helpers.randomEmail(7);
        indexPage.signIn();

        basePage.checkPageTitle("Login - My Store");
        indexPage.createAccount(rEmail);
    }
    @Test(priority = 3)
    public void RegistrationInfoTest() throws InterruptedException{
        registrationPage = new RegistrationPage(driver);
        basePage = new BasePage(driver);
        helpers = new Helpers();

        name = helpers.randomFirstName();
        lastName = helpers.randomLastName();
        company = helpers.randomCompany(3);
        address = helpers.randomAddress();
        phone = helpers.randomPhoneNumber(9);
        registrationPage.personalInfo(name,lastName,address,company, phone);
        basePage.delay(5);
        basePage.checkPageTitle("My account - My Store");



    }
   @AfterClass
   public void quitDriver(){
      driver.quit();
    }
}