package my.home.cucumberpractice.pages.zooadoptionform;

import com.codeborne.selenide.Condition;
import my.home.cucumberpractice.pages.BasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ZooAdoptionFormPage extends BasePage {

    private String personName = "input[ng-model='person.name']";
    private String displayedPersonName = "h2[ng-bind='person.name']";
    private String continueButton = "button#continue_button";
    private String animalSelect = "select[ng-model='animal']";
    private String confirmationText = "div[ng-controller='HelloController'] p";
    private String backToHomeButton = "button#back_button";

    public ZooAdoptionFormPage openPage() {
        open("/jswebapp");

        return this;
    }

    public ZooAdoptionFormPage waitForPageLoading() {
        $(byText("WELCOME TO THE ZOO ADOPTION CENTER")).shouldBe(Condition.visible);

        return this;
    }

    public ZooAdoptionFormPage enterName(String name) {
        $(personName).shouldBe(Condition.enabled).append(name);

        return this;
    }

    public String getDisplayedPersonsName() {
        return  $(displayedPersonName).shouldBe(Condition.visible).getText();
    }

    public ZooAdoptionFormPage clickContinue() {
        $(continueButton).shouldBe(Condition.enabled).click();

        return this;
    }

    public ZooAdoptionFormPage selectAnimal(String animal) {
        $(animalSelect).shouldBe(Condition.enabled).selectOption(animal);

        return this;
    }

    public ZooAdoptionFormPage animalSelectShouldNotExist() {
        $(animalSelect).shouldNotBe(Condition.exist);

        return this;
    }

    public String getConfirmationText() {
        return $(confirmationText).shouldBe(Condition.visible).getText();
    }

    public ZooAdoptionFormPage clickBackToHome() {
        $(backToHomeButton).shouldBe(Condition.enabled).click();

        return this;
    }
}
