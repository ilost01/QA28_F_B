package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("ilost1@gmail.com").withPassword("898756542321Qq#"));

        }
    }
    @Test
    public  void addContactSuccess(){
        int i = new Random().nextInt(1000)+1000;
        User user = new User().withEmail("don" + i +"@gmail.com")
                .withPassword("Don123456$");
        Contact contact= Contact.builder()
                .name("John1")
                .lastName("Doe")
                .address("123 Main Street, NY, USA")
                .email("john.doe"+i+"@example.com")
                .phone("123231"+i)
               // .description("Contact for QA testing")
                .build();
        app.getHelperUser().openContactForm();
        app.getHelperUser().fillContact(contact);
        app.getHelperUser().saveContact();
    }
    @Test
    public  void addContactSuccessRequired(){
        int i = new Random().nextInt(1000)+1000;
        User user = new User().withEmail("don" + i +"@gmail.com")
                .withPassword("Don123456$");
        Contact contact= Contact.builder()
                .name("John2")
                .lastName("Doe2")
                .address("123 Main Street, NY, USA")
                .email("john.doe"+i+"@example.com")
                .phone("123456"+i)
                .description("Contact for QA testing")
                .build();
        app.getHelperUser().openContactForm();
        app.getHelperUser().fillContact(contact);
        app.getHelperUser().saveContact();

    }

}
