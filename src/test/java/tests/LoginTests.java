package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SignOut present --->logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }


    @Test
    public void loginSuccess() {
      app.getHelperUser().openLoginRegistrationForm();
      app.getHelperUser().fillLoginRegistrationForm("ilost1@gmail.com","898756542321Qq#");
      app.getHelperUser().sumitLogin();
      //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue()
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("ilost1@gmail.com","898756542321Qq#");
        app.getHelperUser().sumitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com","Mmar123456$");
        app.getHelperUser().sumitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123");
        app.getHelperUser().sumitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maaa@gmail.com","Maa123456$");
        app.getHelperUser().sumitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

}
