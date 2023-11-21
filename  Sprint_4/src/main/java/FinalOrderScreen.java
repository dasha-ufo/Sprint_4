import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalOrderScreen {
    private WebDriver driver;
    public FinalOrderScreen(WebDriver driver){
        this.driver = driver;
    }
    private By textThatOrderCreated = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    private By seeStatusButton = By.xpath(".//button[text() = 'Посмотреть статус']");

    //метод для ожидания загрузки заголовка об успехе
    public void waitForLoadOrderData() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(textThatOrderCreated), "Заказ оформлен")
        );
}}
