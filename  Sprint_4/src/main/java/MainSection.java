import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainSection {
    private WebDriver driver;
    public MainSection(WebDriver driver){
        this.driver = driver;
    }

    private By orderButtonHeader = By.xpath(".//div[2]/button[text() = 'Заказать']");
    private By orderButtonLower = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    private By orderStatus = By.className("Header_Link__1TAG7");
    private By logo = By.className("Header_Logo__23yGT");
    private By samokatImage = By.xpath(".//div/img[@alt = 'Scooter blueprint']");
    private By headerTitle = By.className("Home_Header__iJKdX");
    private By hiddenInfoBlock = By.className("Home_Table__2kPxP");
    private By hiddenSubtitle = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and (contains(text(),'барабанить'))]");
    private By cookiesButton = By.id("rcc-confirm-button");

    public void pressorderCookiesButton() {
        driver.findElement(cookiesButton).click();
    }
    public void pressorderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void scrollAndClickLowerOrderButton() {
        WebElement element = driver.findElement(orderButtonLower);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonLower).click();
    }
}
