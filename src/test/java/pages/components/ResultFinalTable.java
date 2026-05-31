package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultFinalTable {

    private final SelenideElement resultTable = $("#resultModal");

    public void modalResult(String key, String value) {
        resultTable.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}