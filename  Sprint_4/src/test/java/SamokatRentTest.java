import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class SamokatRentTest  {
        private final String name;
        private final String surname;
        private final String address;
        private final String phoneNumber;
        public final String numberOfStation;
        public final String comment;
        public final String colour;
        public final String buttonLocation;


    public SamokatRentTest (String buttonLocation, String name, String surname, String address, String numberOfStation, String phoneNumber, String comment, String colour) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.numberOfStation = numberOfStation;
            this.phoneNumber = phoneNumber;
            this.comment = comment;
            this.colour = colour;
            this.buttonLocation = buttonLocation;
        }



        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] fillTextFields() {
            return new Object[][]{
                    {"Upper", "Петр", "Васильев", "Москва, ул Большевиков 35, кв 5", "5" , "79990003322", "Очень ждем вас!", "Black" },
                    {"Lower", "Еримейя", "Гогольмоголь", "Питер, Спасокукоцкого 99", "12" , "00009990099", "Дорогой курьер, захватите чипсов, пожалуйста", "Grey" },
            };
        }

    private WebDriver driver;

        @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }



    @Test
    public void samokatOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //создаем объект главной станицы
        MainSection objMainSection = new MainSection(driver);

        objMainSection.pressorderCookiesButton();
        objMainSection.pressDynamicButton(buttonLocation);

        //создаем объект класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);

        //заполняем текстовые поля
        objOrderPage.fillTextFields( name, surname , address, phoneNumber );

        //выбираем станцию метро
        objOrderPage.clickMetroField();
        objOrderPage.chooseDynamicMetroStation(numberOfStation);

        //нажимаем далее
        objOrderPage.goNextButton();

        //создаем объект страницы об аренде
        AboutRentPage objAboutRentpage = new AboutRentPage(driver);

        //заполняем поля
        objAboutRentpage.fillDateRent();
        objAboutRentpage.fillTimeOfRent();
        objAboutRentpage.chooseColourOfSamokat(colour);
        objAboutRentpage.addCommentForCourier(comment);

        //нажимаем заказать
        objAboutRentpage.clickConfirmOrder();

        //создаем объект страницы подтверждения заказа
        ConfirmationOrderPage objConfirmationOrderPage = new ConfirmationOrderPage(driver);

        //нажимаем да в модальном окне
        objConfirmationOrderPage.pressYesButton();

        //проверяем что всплывающее окно отображается
        FinalOrderScreen objFinalOrderScreen = new FinalOrderScreen(driver);
        objFinalOrderScreen.waitForLoadOrderData();

    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}

