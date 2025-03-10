package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

public void openLoginRegistrationForm(){
//    WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//    //xPath--> //a[text()='LOGIN']
//    loginTab.click();
    click(By.cssSelector("a[href='/login']"));

}

    public void fillLoginRegistrationForm(String email, String password) {

//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"),email);


//        WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"),password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[last()]"), user.getPassword());
    }


    public void sumitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
      return   isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
       return wait.until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),
                        "No Contacts here!"));
    }
    //++++++++++++++++++++++++++++++++++++++++++Contact++++++++++++++++++++++++++++++++++++
    public void login( User user){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        sumitLogin();
    }

    public void openContactForm() {
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContact(Contact contact) {
        type(By.cssSelector("[placeholder = 'Name']"),contact.getName());
        type(By.cssSelector("[placeholder = 'Last Name']"),contact.getLastName());
        type(By.cssSelector("[placeholder = 'Phone']"),contact.getPhone());
        type(By.cssSelector("[placeholder = 'email']"),contact.getEmail());
        type(By.cssSelector("[placeholder = 'Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder = 'description']"),contact.getDescription());

    }

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2>button"));
    }
}
