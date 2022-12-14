package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.CheckoutPage;
import pages.GiftcardPage;
import pages.HomePage;
import pages.LoginPage1;
import pages.VirtualGiftcard_ProductPage;

public class TC07_GiftcardPageTest extends BasePage {
	@Test(priority = 0)
	public void Giftcards() throws InterruptedException {
		LoginPage1 page = new LoginPage1(driver);
		Reporter.log("Demowebshop Application is Lauched",true);
		Assert.assertTrue(page.verifyclickOnLogin(),"Demowebshop Application is not lauched");
		page.clickOnLogin();
		Reporter.log("Clicking on login link",true);
		Assert.assertTrue(page.verifyclickOnLogin(),"Not clicking on Login Link");
		page.typeEmail("achyutkembhavi4@gmail.com");
		Reporter.log("Entering the data into the Emailtextfeild",true);
		page.typePassword("131099");
		Reporter.log("Entering the data into the PasswordTextfeild",true);
		page.Loginbutton();
		Reporter.log("Clicking on login Button",true);

		
		// Clicking on Gift cards Menu
		GiftcardPage giftpage = new GiftcardPage(driver);
		HomePage homepage=new HomePage(driver) ;// Clicking on Giftcards_Menu
		homepage.clickGiftCards();
		Reporter.log("Clicking on Giftcards Menu", true);
		Assert.assertTrue(giftpage.Giftcards_Text(), "Not clicking on Giftcards Menu");
		Reporter.log("Verifying the Postion option present in Sortby Dropdown", true);// Asserting postion option
		Assert.assertTrue(giftpage.DefaultPostion_option(), "Postion option is not present in Sortby Dropdown");
		Reporter.log("Verifying the 8 option present in Display per page Dropdown", true);// Asserting 8 option
		Assert.assertTrue(giftpage.Default8_option(), "8 option is not present in Display per page Dropdown");
		Reporter.log("Verifying the Grid option present in Viewas Dropdown", true);
		Assert.assertTrue(giftpage.DefaultGrid_option(), "Grid option is not present in Viewas Dropdown");

		
		// Clicking on $25 virtual Gift card Product
		giftpage.ClickVitualGiftcardProduct();
		Reporter.log("Clicking on $25 vitual Giftcard", true);
		VirtualGiftcard_ProductPage productpage = new VirtualGiftcard_ProductPage(driver);
		productpage.Number();
		Reporter.log("Verifying Price as 5", true);
		Assert.assertTrue(productpage.Number(), "Price is not displayed as per ");
		productpage.Qty_textfeild();
		Reporter.log("Verifying the qty textfeild as 1", true);
		Assert.assertTrue(productpage.Qty_textfeild(), "Qty as 1 in textfeild is not displayed");
		productpage.Addtocart_text();
		Reporter.log("Verifying the Add to cart Button is displayed", true);
		Assert.assertTrue(productpage.Addtocart_text(), "Add to cart button is displayed");
		productpage.textfeild("Bhartha", "bharatakumar@gmail.com", "his got the whole world in his hands");
		Reporter.log("Entering the data in all the texfeilds");
		productpage.Addtocart_Button();
		Reporter.log("Clicking on Addtocart button");
		Assert.assertTrue(productpage.Message_addedtocart(), "Not clicking on Addtocart");

	
		// After Adding the product to cart and then Clicking on Shopping Cart
		productpage.ShoppingCart();
		Reporter.log("Clicking on Shopping cart", true);
		Assert.assertTrue(productpage.virtualgiftcard_inShoppingcart(), "not clicking on shopping cart");
		productpage.Twentyfive_Price();// Verifying Price as 25.00		Reporter.log("Verifying the 25.00 price is displayed", true);
		Assert.assertTrue(productpage.Twentyfive_Price(), "25.00 price is not displayed");
		productpage.Iagree_Checkbox();// Verifying I agree checkbox is displayed
		Reporter.log("Verifying the I agree checkbox is displayed", true);
		Assert.assertTrue(productpage.Iagree_Checkbox(), "I agree checkbox is not displayed");
		productpage.ClickIagree_Checkbox();// Clicking on I Agree Checkbox
		Reporter.log("Clicking on I Agree Checkbox", true);
		productpage.Checkout_Button();// Verifying the Checkout Button is displayed
		Reporter.log("Verifying the Checkout Button is displayed", true);
		Assert.assertTrue(productpage.Checkout_Button(), "Checkout Button is not displayed");

		
		// clicking on Checkout Button
		productpage.ClickCheckout_Button();
		Reporter.log("Clicking on Checkout Button", true);
		Reporter.log("After Clicking Checkout Button Verifying Billing address is Displayed", true);
		CheckoutPage checkpage = new CheckoutPage(driver);
		Assert.assertTrue(checkpage.isBillingAddressDisplayed(), "Billing Address is not displayed");
		Reporter.log("Verifying Continue Button is Displayed", true);
		Assert.assertTrue(checkpage.isContinueButtonDisplayed(), "Continue Button is not Displayed");
		Thread.sleep(5000);

		
		// Clicking on Continue in Billing Address
		checkpage.ClickOnContinueInBillingAddress();
		Reporter.log("Clicking on Continue Button", true);
		Reporter.log("Verifying Cash on Delivery RadioButton is displayed",true);
		Assert.assertTrue(checkpage.CashonDeliveryisDisplayed(), "Cash on Delivery RadioButton is not displayed");
		Reporter.log("Verifying the Check/Money Order RadioButton is Displayed ",true);
		Assert.assertTrue(checkpage.CheckMoneyOrder_RadioButtonisDisplayed(),"Check/Money Order RadioButton is Displayed");
		Reporter.log("Verifying the Credit card  RadioButton is Displayed ",true);
		Assert.assertTrue(checkpage.Creditcard_RadioButtonisDisplayed(),"Credit card  RadioButton is not Displayed");
		Reporter.log("Verifying the Purchase Order  RadioButton is Displayed ",true);
		Assert.assertTrue(checkpage.PurchaseOrder_RadioButtonisDisplayed(),"Purchase Order  RadioButton is not Displayed");
		Reporter.log("Verifying the Backbutton is Displayed",true);
		Assert.assertTrue(checkpage.isBackButtonDisplayedInPaymentMethod(), "Backbutton is not Displayed");

		// clicking on Continue Button in Payment method
		checkpage.ClickOnContinueInPaymentMethod();
		Reporter.log("Clicking on Continue button in payment method ",true);
		Reporter.log("Verifying the Cash on delivery text is Displayed",true);
		Assert.assertTrue(checkpage.CodTextIsDisplayed(), "cash on Delivery text message is not displayed");

		
		// Clicking on Continue Button in Payment Information
		checkpage.ClickOnContinueInPaymentInformation();
		Reporter.log("Clicking on Continue Button in Payment Information",true);
		Reporter.log("Verifying the Billing Address is Displayed ",true);
		Assert.assertTrue(checkpage.BillingAddress_isDisplayed(), "Billing Address is not Displayed");
		Reporter.log("verifying the Payment method is Displayed",true);
		Assert.assertTrue(checkpage.Paymentmethodtext_isDisplayed(), "Payment method is not Displayed");

		
		// Clicking on Confirm Button in Confirm Order
		checkpage.ClickOnConfirmInConfirmOrder();
		Reporter.log("Clicking on Confirm button",true);
		Reporter.log("Verifying the Thank you message is displayed",true);
		Assert.assertTrue(checkpage.isThankYouPageDisplayed(),"Thank you text is not displayed");
		Reporter.log("Verifying the Particular order number is displayed ",true);
		Assert.assertTrue(checkpage.isOrderNumberDisplayedInThankYouPage(),"Order number is Displayed");
		checkpage.ClickOnContinueInThankYouPage();
		Reporter.log("Clicking on the Continue button in thank you page",true);
		Reporter.log("After Clicking Continue button in Thank you page Verifying Home page is not Displayed");
		Assert.assertTrue(checkpage.isHomePageDisplayed(),"Home page is not Displayed");
		
		
		
		

	}
}
