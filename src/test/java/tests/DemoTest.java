package tests;

import environment.ConfProperties;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    @Before
    public void startBrowser() {
        EnvironmentManager.initWebDriver();;
        RunEnvironment.getWebDriver().get(ConfProperties.getProperty("testpage"));
        PageFactory.initElements(RunEnvironment.getWebDriver(), this);
    }

    @FindBy(name = "name")
    private WebElement inputField;

    @FindBy(className = "custom-form__button")
    private WebElement inputButton;

    @FindBy(css = "#start-screen > p")
    private WebElement textField;

    @Test
    public void demo() {
        inputField.sendKeys(ConfProperties.getProperty("name"));
        inputButton.click();
        assertEquals("Привет, Вася!",textField.getText());
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
