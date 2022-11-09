package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement heading = $("h2.heading");
    private SelenideElement buttonBuyCard = $("[class=button__content]");
    private SelenideElement buttonBuyCredit = $$("[class=button__content]").get(1);

    public MainPage() {
        heading.shouldBe(visible);
    }

    public BuyByCard getPageByCard() {
        buttonBuyCard.click();
        return new BuyByCard();
    }

    public BuyOnCredit getPageOnCredit() {
        buttonBuyCredit.click();
        return new BuyOnCredit();
    }
}