import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {

    private WebDriver driver;
    public OrderStatusPage(WebDriver driver){
        this.driver = driver;
    }

    private By trackNumberField = By.xpath(".//div[@class = 'Track_Form__N4FE3']/div/input");
    private By cancelButton = By.xpath(".//div[@class = 'Track_OrderInfo__2fpDL']/button");
    private By trackOrderInfo = By.xpath(".//div[@class = 'Track_OrderRoadmap__3eUiE']");
    private By orderDetailsSection = By.xpath(".//div[1][@class = 'Track_OrderInfo__2fpDL']");

}
