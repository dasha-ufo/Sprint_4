import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private WebDriver driver;
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    private By titleOrderPage = By.className("Order_Header__BZXOb");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[contains (@placeholder,'* Адрес')]");
    private By metroStationField = By.xpath(".//input[contains (@placeholder,'метро')]");
    private By phoneNumberField = By.xpath(".//input[contains (@placeholder,'Телефон')]");
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By listOfStations = By.xpath(".//div[@class = 'select-search__select']");
    private By listOfStationsDynamic = By.xpath(".//ul/li[%s]");

    public void fillTextFields(String name, String surname, String address, String phone ) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    public void clickMetroField () {
        driver.findElement(metroStationField).click();
    }

    public void goNextButton () {
        driver.findElement(nextButton).click();
    }

    public void chooseDynamicMetroStation(String numberOfStation){
        By dynamicXpath = By.xpath(String.format(".//ul/li[%s]", numberOfStation));
        driver.findElement(dynamicXpath).click();
    }

}
