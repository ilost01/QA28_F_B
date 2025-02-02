package manager;

import org.openqa.selenium.WebDriver;

public class ApplicationManager {

    WebDriver wd;

    public void init() {
      //  wd = WebDriver();
        wd.navigate().to("https://telranedu.web.app/");

    }

    public void stop() {

        wd.quit();
    }
}
