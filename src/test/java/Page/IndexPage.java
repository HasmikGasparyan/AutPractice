package Page;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;

public class IndexPage {
    WebDriver driver;
    BasePage basePage;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }
    public void signIn() throws InterruptedException {
        basePage = new BasePage(driver);
        basePage.delay(2);

        basePage.clickOnElement("css", "[class='login']");
    }

    public void createAccount(String rEmail)throws InterruptedException{
        basePage = new BasePage(driver);
        basePage.delay(2);
        basePage.insertInto("css", "[id='email_create']", rEmail);
        basePage.clickOnElement("css", "[id='SubmitCreate']");

    }
}