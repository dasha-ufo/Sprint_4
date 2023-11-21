import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationOrderPage {

    private WebDriver driver;
    public ConfirmationOrderPage(WebDriver driver){
        this.driver = driver;
    }

    private By modalWindow = By.className("Order_Modal__YZ-d3");
    private By modalHeader = By.className("Order_ModalHeader__3FDaJ");
    private By buttonYes = By.xpath(".//button[text() = 'Да']");
    private By buttonNo = By.xpath(".//button[text() = 'No']");

    public void pressYesButton() {
        driver.findElement(buttonYes).click();
    }

}
