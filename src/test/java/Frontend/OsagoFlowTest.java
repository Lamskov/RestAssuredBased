package Frontend;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class OsagoFlowTest {

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://test-osago.ab.insapp.ru";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true; // для SPA быстрее
        // Если используете WebDriverManager:
        // io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
    }

    @AfterEach
    void tearDown() {
        // Закрываем браузер после каждого теста (опционально)
        Selenide.closeWebDriver();
    }

    @Test
    public void testOsagoFlow() {

        open("/");

        // 1. Ввод номера авто

        $("[test-id=licensePlateControlName]")
                .shouldBe(visible)
                .setValue("У395МН03");

        // 2. Нажимаем кнопку "рассчитать"

        $("[test-id=calculateBtnLicenseComponent]")
                .shouldBe(enabled)
                .click();

        // 3. Страница авто

//        $("[test-id=brandIdControlName]").setValue("Toyota").selectOption("Toyota");

        $("[test-id=brandIdControlName]").setValue("Toy");
        // 2. Ждем появления выпадающего списка (может быть задержка)
        $(".dropdown-menu").shouldBe(visible);
        $$(".dropdown-item").findBy(text("Toyota")).click();

        $("[test-id=modelIdControlName]").setValue("Cam");
        // 2. Ждем появления выпадающего списка (может быть задержка)
        $(".dropdown-menu").shouldBe(visible);
        $$(".dropdown-item").findBy(text("Camry")).click();

        $("[id=productionYear]").click();
        sleep(500); // Ждем открытия списка
        $(".dropdown-menu").shouldBe(visible);
        $$("a.dropdown-item").findBy(text("2011"))
                .shouldBe(visible)
                .click();

        $("[id=horsePower]").click();
        sleep(500);
        $(".dropdown-item").shouldBe(visible);
        $$("a.dropdown-item").findBy(text("156"))
                .shouldBe(visible)
                .click();


        $x("//input[@test-id='bodyNumberControlName']").setValue("NZE1419116311");
        $x("//input[@name='stsNumberControlName']").setValue("12 31 231321");
        $x("//input[@test-id='stsDateControlName']").setValue("01.01.2012");
        $x("//button[@test-id='continueBtnCarDataComponent']")
                .shouldBe(enabled)
                .click();



/*
        $("[test-id=productionYearControlName]").shouldBe(visible).setValue("2008");;


// Заполняем марку и модель авто (если есть соответствующие поля)
        $("[test-id=brandIdControlName]").setValue("Toyota");
        $("[test-id=modelIdControlName]").setValue("Camry");

// Номер кузова
        $("[test-id=bodyNumberControlName]").setValue("NZE1419116396");

// Диагностическая карта
        $("[test-id=hasDiagnosticCardControlName]").setSelected(true); // или setValue(true)
        $("test-id=stsNumberControlName").setValue("12 31 231321")

// После заполнения всех полей нажимаем кнопку "Далее"
        $("[test-id=nextBtnCarData]").click();
*/

    }



}
