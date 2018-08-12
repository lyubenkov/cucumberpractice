package my.home.cucumberpractice.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.home.cucumberpractice.pages.zooadoptionform.ZooAdoptionFormPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ZooAdoptionFormSteps {

    private ZooAdoptionFormPage zooAdoptionFormPage = new ZooAdoptionFormPage();

    @Given("^an opened browser with Zoo Adoption Subscription Page$")
    public void anOpenedBrowserWithZooAdoptionSubscriptionPage() {
        zooAdoptionFormPage
                .openPage()
                .waitForPageLoading();
    }

    @When("^I click continue$")
    public void iClickContinue() {
        zooAdoptionFormPage.clickContinue();
    }

    @And("^select \"([^\"]*)\"$")
    public void select(String animal) {
        zooAdoptionFormPage.selectAnimal(animal);
    }

    @When("^I click back to home button$")
    public void iClickBackToHomeButton() {
        zooAdoptionFormPage.clickBackToHome();
    }

    @Then("^Welcome adoption page should open$")
    public void welcomeAdoptionPageShouldOpen() {
        zooAdoptionFormPage.waitForPageLoading();
    }

    @Then("^Animal selection page should not be opened$")
    public void animalSelectionPageShouldNotBeOpened() {
        zooAdoptionFormPage.animalSelectShouldNotExist();
    }

    @When("^I enter \"([^\"]*)\" into text field$")
    public void iEnterIntoTextField(String name) {
        zooAdoptionFormPage.enterName(name);
    }

    @Then("^\"([^\"]*)\" should be displayed below the text$")
    public void shouldBeDisplayedBelowTheText(String expectedName) {
        String displayedPersonsName = zooAdoptionFormPage.getDisplayedPersonsName();
        assertThat(displayedPersonsName)
                .as("Displayed person's name should be equal to expected")
                .isEqualTo(expectedName);
    }

    @Then("^The confirmation text should match$")
    public void theConfirmationTextShouldMatch(String expectedText) {
        String confirmationText = zooAdoptionFormPage.getConfirmationText();
        assertThat(confirmationText).isEqualTo(expectedText);
    }
}
