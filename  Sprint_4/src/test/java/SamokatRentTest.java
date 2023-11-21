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

        public SamokatRentTest (String name, String surname, String address, String numberOfStation, String phoneNumber) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.numberOfStation = numberOfStation;
            this.phoneNumber = phoneNumber;
        }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] fillTextFields() {
            return new Object[][]{
                    {"Петр", "Васильев", "Москва, ул Большевиков 35, кв 5", "5" , "79990003322" },
                    {"Еримейя", "Гогольмоголь", "Питер, Спасокукоцкого 99", "12" , "00009990099" },
            };
        }


        @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @Test
    public void SamokatOrderThrowUpperButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //создаем объект главной станицы
        MainSection objMainSection = new MainSection(driver);

        objMainSection.pressorderCookiesButton();
        objMainSection.pressorderButtonHeader();

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
        objAboutRentpage.chooseBlackColourOfSamokat();
        objAboutRentpage.addCommentForCourier("Дорогой курьер, купите по дороге чипсы, пожалуйста");

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


    @Test
    public void SamokatOrderThrowLowerButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //создаем объект главной станицы
        MainSection objMainSection = new MainSection(driver);

        objMainSection.pressorderCookiesButton();
        objMainSection.scrollAndClickLowerOrderButton();

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
        objAboutRentpage.chooseBlackColourOfSamokat();
        objAboutRentpage.addCommentForCourier("Дорогой курьер, купите по дороге чипсы, пожалуйста");

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

