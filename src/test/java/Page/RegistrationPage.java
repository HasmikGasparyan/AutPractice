package Page;

import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    BasePage basePage;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void personalInfo(String name, String lastName, String address, String company, String phone) {
        basePage = new BasePage(driver);
        basePage.clickOnElement("css","[id='id_gender1']");
        basePage.insertInto("css", "[id='customer_firstname']", name);
        basePage.insertInto("css", "[id='customer_lastname']", lastName);
        basePage.insertInto("css", "[data-validate='isPasswd']", "myPassword");
        basePage.selectElement("css","[id='days']", "1");
        basePage.selectElement("css","[id='months']", "4");
        basePage.selectElement("css","[id='years']", "1989");
        basePage.clickOnElement("css","[name='newsletter']");
        basePage.insertInto("css", "[id='company']", company);
        basePage.insertInto("css", "[id='address1']", address);
        basePage.insertInto("css", "[id='city']", "randomCity");
        basePage.selectElement("css", "[id='id_state']", "4");
        basePage.insertInto("css", "[id='postcode']", "90002");
        basePage.selectElement("css", "[id='id_country']", "21");
        basePage.insertInto("css", "[id='other']", "additionalInfo");
        basePage.insertInto("css", "[id='phone']", phone);
        basePage.insertInto("css", "[id='phone_mobile']", phone);
        basePage.insertInto("css", "[id='alias']", "randomAddress");
        basePage.clickOnElement("css", "[id='submitAccount']");
    }
}