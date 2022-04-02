package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pages.BasketPage;
import pages.HeaderPage;
import pages.WorkAreaPage;

public class StepsMainPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private WorkAreaPage workArea = Selenide.page(new WorkAreaPage());



    public void checkThatButtonStatusOrderIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getStatusOrder());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonStatusOrderIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getStatusOrder());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getRegistration());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonRegistrationIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getRegistration());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonComparisonIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getComparison());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonComparisonIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getComparison());
        Assert.assertFalse(actualCondition);
    }

    public void checkThatButtonFavoritesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getFavorites());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonFavoritesIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getFavorites());
        Assert.assertFalse(actualCondition);

    }

    public void checkThatButtonAddToCartIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getAddToCart());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonAddToCartIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertFalse(actualCondition);
    }

    public void clickOnButtonAddToCartProductDay() {
        workArea.addToCartProductDayDisplayed();

    }

    public void checkThatBlockWithProductDayIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.blockWithProductDay());
        Assert.assertTrue(actualCondition);

    }

    public void checkNumberOnTheCartDisplayed() {
        header.getNumberOnTheCart("1");
    }

    public void checkThatButtonAddToCartProductDayIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertTrue(actualCondition);
    }

    public void clickOnButtonBasket() {
        header.getAddToCart().shouldBe(Condition.visible);
        header.click(header.getAddToCart());

    }
    //if (header.checkForEnabled(header.getAddToCart())) {

    public void checkThatTitleMostViewedIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.getTitleMostViewed());
        Assert.assertTrue(actualCondition);
    }

    public void scrollToBlockMostViewed() {
        workArea.scrollToFirstBlockMostViewed();
        if (workArea.getBlockMostViewedWithText().isDisplayed()) {
            workArea.getBlockMostViewedWithText().shouldBe(Condition.visible);
        } else {
            workArea.getBlockMostViewed2().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible);
        }
    }

    public void clickTwoItems() {
        workArea.addMultipleProducts();
        workArea.clickFewProducts(1);
        header.getNumberOnTheCart("1");
        workArea.clickFewProducts(2);
        header.getNumberOnTheCart("2");

    }

    public void shouldBeVisibleForTitleMostViewed() {
        workArea.titleMostViewedVisible();
    }

    public void checkThatInputLineIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getInputLine());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatValueEnterCorrect() {
        header.enterValue("apple");
        Assert.assertEquals(header.getEnterValue(), "apple");
    }

    public void clickOnButtonSearch() {
        header.click(header.getButtonSearch());
    }

    public void clickOnButtonRegistration() {
        header.click(header.getRegistration());
    }

    public void checkThatFormRegistrationIsDisplayed() {
        header.getFormRegistration().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(header.getFormRegistration());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatTitleLoginOrRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getTitleLoginOrRegistration());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatPhoneInputFieldIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getPhoneInputField());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatButtonContinueIsNotEnabled() {
        boolean actualCondition = header.checkForDisabled();
        Assert.assertFalse(actualCondition);
    }

    public void checkThatLinkLegalEntitiesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getLinkLegalEntities());
        Assert.assertTrue(actualCondition);
    }

    public void clickOnButtonComparisonInHeader(){
        header.click(header.getComparison());
    }

    public void clickOnButtonFavoritesInHeader(){
        header.click(header.getFavorites());
    }

    public void clickOnLocationButton(){
        header.click(header.getLocationButton());
    }

    public void checkThatWindowSelectCityIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getWindowSelectCity());
        Assert.assertTrue(actualCondition);
    }

    public void selectDesiredCity(String city){
        header.findCity("Краснодар");
        header.closeForModalWindow();
    }


    public void displayButtonToCheckPageLoading(){
        workArea.buttonDisplayForDownloadVerification();
    }

    public void checkDisplayedLocator(String text){
        Assert.assertTrue(header.displayedLocator("Краснодар"));
    }

}






