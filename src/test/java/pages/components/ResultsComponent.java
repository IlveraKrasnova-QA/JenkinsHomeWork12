package pages.components;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsComponent {

    public void checkResults (String key, String value) {
        $("[class=table-responsive]").$(byText(key)).parent().shouldHave(text(value));

    }
}
