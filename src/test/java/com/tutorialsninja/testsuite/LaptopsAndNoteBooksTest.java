package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNoteBooks;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNoteBooksTest extends BaseTest {


    LaptopsAndNoteBooks laptopsAndNoteBooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        laptopsAndNoteBooks = new LaptopsAndNoteBooks();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        laptopsAndNoteBooks.verifyProductsPriceDisplayHighToLowSuccessfully();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNoteBooks.verifyProductsPriceDisplayHighToLowSuccessfully();
        laptopsAndNoteBooks.clickOnMacBook();
        Thread.sleep(5000);
        assertAssert("MacBook not selected", laptopsAndNoteBooks.exptectedTextMessage("MacBook"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[text()='MacBook']")));
        laptopsAndNoteBooks.clickOnAddToCart();
        assertAssert("Product has not been added to Cart", laptopsAndNoteBooks.exptectedTextMessage("Success: You have added MacBook to your shopping cart!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54));
        laptopsAndNoteBooks.clickOnShoppingCart();
        assertAssert("Not on Shopping cart", laptopsAndNoteBooks.exptectedTextMessage("Shopping Cart"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13));
        assertAssert("MacBook is not on cart", laptopsAndNoteBooks.exptectedTextMessage("MacBook"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));
        laptopsAndNoteBooks.sendTextToElement();
        laptopsAndNoteBooks.clickOnUpdate();
        assertAssert("Cart not modified", laptopsAndNoteBooks.exptectedTextMessage("Success: You have modified your shopping cart!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 46));
        laptopsAndNoteBooks.currencyConverter();
        assertAssert("Total is not Matching", laptopsAndNoteBooks.exptectedTextMessage("£737.45"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));
        laptopsAndNoteBooks.clickOnCheckoutButton();
        assertAssert("Not on Checkout", laptopsAndNoteBooks.exptectedTextMessage("Checkout"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[contains(text(),'Checkout')]")));
        Thread.sleep(2000);
        assertAssert("New customer text is not display", laptopsAndNoteBooks.exptectedTextMessage("New Customer"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h2[text()='New Customer']")));
        laptopsAndNoteBooks.clickOnRadioButton();
        laptopsAndNoteBooks.clickOnContinueButton();
        laptopsAndNoteBooks.addingMandatoryFields("Enter First Name", "Raghav", By.id("input-payment-firstname"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Last Name", "Raja", By.id("input-payment-lastname"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Email", "RaghavRaja@gmail.com", By.id("input-payment-email"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Telephone", "02089056066", By.id("input-payment-telephone"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Address1", "95 Harrow Road", By.id("input-payment-address-1"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter City", "London", By.id("input-payment-city"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Postcode", "HA8 9ZZ", By.id("input-payment-postcode"));
        laptopsAndNoteBooks.selectCountry();
        laptopsAndNoteBooks.selectState();
        laptopsAndNoteBooks.clickOnContinueButtonPayment();
        laptopsAndNoteBooks.addComment();
        laptopsAndNoteBooks.checkBoxClick();
        laptopsAndNoteBooks.clickOnLastContinueButton();
        assertAssert("Not checking payment method", laptopsAndNoteBooks.exptectedTextMessage("Warning: Payment method required!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).substring(0, 33));

    }
}
