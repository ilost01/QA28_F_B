package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        click(By.cssSelector("a[href='/login']"));

    }


    public void fillLoginRegistrationForm(String email, String password) {

        type(By.name("email"), email);
        type(By.name("password"), password);

    }
    public void submitLogin(){
        click(By.name("login"));
    }
}
