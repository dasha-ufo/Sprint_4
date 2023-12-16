import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class AboutRentPage {
    private WebDriver driver;
    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }
    private By dataPicker = By.xpath(".//input[contains (@placeholder,'Когда привезти')]");
    private By timeOfRent = By.xpath(".//div[contains (text(),'Срок аренды')]");
    private By checkboxes = By.className("Order_Checkboxes__3lWSI");
    private By checkboxInputBlack = By.xpath(".//input[@id='black']");
    private By checkboxInputGrey = By.xpath(".//input[@id='grey']");
    private By commentField = By.xpath(".//input[contains (@placeholder,'Комментарий')]");
    private By confirmOrderLowButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private By goBackButton = By.cssSelector(".Button_Inverted__3IF-i");
    private By sixDaysOfRent = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'шестеро суток']");
    private By secondDecemberDate = By.xpath(".//div[@aria-label = 'Choose суббота, 2-е декабря 2023 г.']");


    //установить дату аренды
    public void fillDateRent() {
        driver.findElement(dataPicker).click();
        driver.findElement(secondDecemberDate).click();
    }

    //установить срок аренды
    public void fillTimeOfRent() {
        driver.findElement(timeOfRent).click();
        driver.findElement(sixDaysOfRent).click();
    }

    //установить цвет самоката
    public void chooseBlackColourOfSamokat() {
        driver.findElement(checkboxInputBlack).click();
    }
    //выбрать цвет самоката по параметру
    public void chooseColourOfSamokat(String colour) {
        if (Objects.equals(colour, "Black")) {
            driver.findElement(checkboxInputBlack).click();
        } if ((Objects.equals(colour, "Grey"))) {
            driver.findElement(checkboxInputGrey).click();
        }
    }

    //оставляем комментарий для курьера
    public void addCommentForCourier (String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickConfirmOrder() {
        driver.findElement(confirmOrderLowButton).click();
    }



}
