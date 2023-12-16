import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaqSection {
    private WebDriver driver;
    public FaqSection(WebDriver driver){
        this.driver = driver;}
    private By headerFaq = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and contains (text(), 'Вопросы')]");
    private By faqFullList = By.className("accordion");
    private By faqCollapsedLine = By.xpath(".//div[@id='accordion__heading-%s']");
    private By faqExpandLine = By.xpath(".//div[@id='accordion__panel-%s']");

    public void scrollToFaq(){
    WebElement element = driver.findElement(faqFullList);
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    public void clickOnFaqLine(String number){
        By dynamicXpath = By.xpath(String.format(".//div[@id='accordion__heading-%s']", number));
        driver.findElement(dynamicXpath).click();
    }

    public String getTextOnExpandedFaq(String expandedLineNumber){
        By dynamicXpath = By.xpath(String.format(".//div[@id='accordion__panel-%s']", expandedLineNumber));
        return driver.findElement(dynamicXpath).getText();
    }
}
