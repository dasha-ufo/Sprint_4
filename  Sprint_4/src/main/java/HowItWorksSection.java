import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowItWorksSection {
    private WebDriver driver;
    public HowItWorksSection(WebDriver driver){
        this.driver = driver;
    }

    private By orderButtonMiddle = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By header = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and (contains(text(),'Как это'))]");
    private By listOfStepsAndButton = By.className("Home_RoadMap__2tal_");
}
