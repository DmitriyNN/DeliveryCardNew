package ru.netology.delivery.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class
DeliveryTest {
    private static Faker faker;

    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test

    void shouldSuccessfulPlanAndReplanMeeting() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");

        $("input[type=text]").setValue(faker.address().cityName());
        $("[data-test-id=name] input").setValue(faker.name().fullName());
        $("[data-test-id=phone] input").setValue(faker.phoneNumber().phoneNumber());
       $x("//*[text()='Я соглашаюсь с условиями обработки и использования моих персональных данных']").click();
        $x("//*[text()='Запланировать']").click();
        $x("//*[text()='Запланировать']").click();
        $x("//*[text()='Перепланировать']").click();
     $("[data-test-id=success-notification]").should(text("Успешно! Встреча успешно запланирована на "));
    }
}



