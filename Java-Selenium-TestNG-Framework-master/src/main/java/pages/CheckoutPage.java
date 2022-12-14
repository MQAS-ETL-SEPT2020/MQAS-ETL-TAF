package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	// <<<<<<<<<<<<<<<<<<<<Billing Address Field>>>>>>>>>>>>>>>>>>>>

	By CheckoutPage = By.xpath("//h1[text()='Checkout']");
	By BillingAddressField = By.xpath("//h2[text()='Billing address']");
	By BillingAddress = By.id("billing-address-select");
	By NewAddress = By.xpath("//option[text()='New Address']");
	By FirstName = By.id("BillingNewAddress_FirstName");
	By LastName = By.id("BillingNewAddress_LastName");
	By Email = By.id("BillingNewAddress_Email");
	By Company = By.id("BillingNewAddress_Company");
	By CountryIdInBilling = By.id("BillingNewAddress_CountryId");
	By CountryNameInBilling = By.xpath("//option[text()='India']");
	By City = By.id("BillingNewAddress_City");
	By Address1InBilling = By.id("BillingNewAddress_Address1");
	By ZipPostalCodeInBilling = By.id("BillingNewAddress_ZipPostalCode");
	By PhoneNumberInBilling = By.id("BillingNewAddress_PhoneNumber");
	By ContinueInBilling = By.xpath("//input[@onclick='Billing.save()']");

	// <<<<<<<<<<<<<<<<<<<<<<<<Shipping Address Field>>>>>>>>>>>>>>>>>>>>>>>>

	By ShippingAddressField = By.xpath("(//div[@class='step-title'])[2]");
	By ShippingAddress = By.id("shipping-address-select");
	By NewShippingAddress = By.xpath("(//option[text()='New Address'])[2]");
	By CountryIdInShipping = By.id("ShippingNewAddress_CountryId");
	By CountryNameInShipping = By.xpath("(//option[text()='India'])[2]");
	By CityInShipping = By.id("ShippingNewAddress_City");
	By Address1InShipping = By.id("ShippingNewAddress_Address1");
	By ZipPostalCodeInShipping = By.id("ShippingNewAddress_ZipPostalCode");
	By PhoneNumberInShipping = By.xpath("//input[@name='ShippingNewAddress.PhoneNumber']");
	By ContinueInShipping = By.xpath("(//input[@title='Continue'])[2]");

	// <<shipping Method>>

	By shippingMethod = By.xpath("(//div[@class='step-title'])[3]");
	By ground = By.xpath("//label[@for='shippingoption_0']");
	By shippingMethodContinue = By.xpath("//input[@onclick='ShippingMethod.save()']");

	// <<<<<<<<<<<<<<<<<<<<<<<<<<Payment Method Field>>>>>>>>>>>>>>>>>>>>>>>>>>

	By PaymentMethodField = By.xpath("//h2[text()='Payment method']");
	By CashOnDelivery = By.xpath("//label[text()='Cash On Delivery (COD) (7.00)']");
	By CheckMoneyOrder = By.xpath("//label[text()='Check / Money Order (5.00)']");
	By CreditCard = By.xpath("//label[text()='Credit Card']");
	By PurchaseOrder = By.xpath("//label[text()='Purchase Order']");
	By PoNumber=By.xpath("//input[@name='PurchaseOrderNumber']");
	By ContinueButtonInPonumber=By.xpath("(//input[@value='Continue'])[5]");
	By BackButtonInPaymentMethod = By.xpath("(//a[text()='Back'])[1]");
	By BackButtonInPoNumber=By.xpath("(//a[text()='Back'])[4]");

	By ContinueInPaymentMethod = By.xpath("//input[@class='button-1 payment-method-next-step-button']");

	// <<<<<<<<<<<<<<<<<<<<<<<<<<Payment Information Field>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    By Cod_Text=By.xpath("//p[text()='You will pay by COD']");
	By PaymentInformationField = By.xpath("//h2[text()='Payment information']");
	By BackButtonInPaymentInformation = By.xpath("(//a[text()='Back'])[2]");
	By ContinueInPaymentInformation = By.xpath("//input[@class='button-1 payment-info-next-step-button']");

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Confirm Order>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
    By Paymentmethod_text=By.xpath("//strong[text()='Payment Method']");
    By BillingAddress_Text=By.xpath("//strong[text()='Billing Address']");
	By ConfirmOrderField = By.xpath("//h2[text()='Confirm order']");
	By BackButtonInConfirmationOrder = By.xpath("(//a[text()='Back'])[3]");
	By ConfirmInConfirmationOrder = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Thank You
	// page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	By ThankYouPage = By.xpath("//h1[text()='Thank you']");
	By ConfirmationMessage = By.xpath("//strong[text()='Your order has been successfully processed!']");
	By OrderNumber = By.xpath("//ul[@class='details']/li[1]");
	By ContinueInThankYouPage = By.xpath("//input[@class='button-2 order-completed-continue-button']");
	By ApplicationHomePage = By.xpath("//img[@alt='Tricentis Demo Web Shop']");

	WebDriver driver;
	WebDriverWait wait;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public boolean isCheckOutPageSuccesful() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPage)).isDisplayed();
	}

	public boolean isBillingAddressDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(BillingAddressField)).isDisplayed();
	}

	public boolean isContinueButtonDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueInBilling)).isDisplayed();
	}

	public void BillingDropdown() {
		driver.findElement(BillingAddress).click();
		WebElement billingAddress = driver.findElement(BillingAddress);
		Select newaddress = new Select(billingAddress);
		newaddress.selectByVisibleText("New Address");
		driver.findElement(NewAddress).click();
	}

	public boolean SelectNewAddressInBilling() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(NewAddress)).isSelected();
	}

	public void EnterFirstNameInBilling(String Firstname) {
		driver.findElement(FirstName).clear();
		driver.findElement(FirstName).sendKeys(Firstname);
	}

	public void EnterLastNameInBilling(String Lastname) {
		driver.findElement(LastName).clear();
		driver.findElement(LastName).sendKeys(Lastname);
	}

	public void EnterEmailIdInBilling(String Emailid) {
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys(Emailid);
	}

	public void EnterCompanyNameInBilling(String Companyname) {
		driver.findElement(Company).clear();
		driver.findElement(Company).sendKeys(Companyname);
	}

	public void CountryDropdownInBilling() {
		driver.findElement(CountryIdInBilling).click();
		WebElement countryId = driver.findElement(CountryIdInBilling);
		Select country = new Select(countryId);
		country.selectByVisibleText("India");
	}

	public boolean SelectCountryInBilling() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(CountryNameInBilling)).isSelected();
	}

	public void EnterCityNameInBilling(String Cityname) {
		driver.findElement(City).clear();
		driver.findElement(City).sendKeys(Cityname);
	}

	public void EnterAddress1InBilling(String Address) {
		driver.findElement(Address1InBilling).clear();
		driver.findElement(Address1InBilling).sendKeys(Address);
	}

	public void EnterZipCodeInBilling(String ZipCode) {
		driver.findElement(ZipPostalCodeInBilling).clear();
		driver.findElement(ZipPostalCodeInBilling).sendKeys(ZipCode);
	}

	public void EnterMobileNumberInBilling(String Mobilenumber) {
		driver.findElement(PhoneNumberInBilling).clear();
		driver.findElement(PhoneNumberInBilling).sendKeys(Mobilenumber);
	}

	public void ClickOnContinueInBillingAddress() {
		driver.findElement(ContinueInBilling).click();

	}

//<<<<<<<<<Shipping Address>>>>>>>>>>>>>>>>>

	public boolean ShippingAddressDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ShippingAddressField)).isDisplayed();
	}

	public boolean isContinueButtonDisplayedInShipping() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueInShipping)).isDisplayed();
	}

	public void shippingDropdown() {
		driver.findElement(ShippingAddress).click();
		WebElement shippingAddress = driver.findElement(ShippingAddress);
		Select newAddress = new Select(shippingAddress);
		newAddress.selectByVisibleText("New Address");
		// driver.findElement(NewAddress).click();
	}

	public void CountryDropDownInShippingAddress() {
		driver.findElement(CountryIdInShipping).click();
		WebElement country = driver.findElement(CountryIdInShipping);
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");
		driver.findElement(CountryNameInShipping).click();
	}

	public void EnterCityNameInShippingAddress(String Cityname) {
		driver.findElement(CityInShipping).clear();
		driver.findElement(CityInShipping).sendKeys(Cityname);
	}

	public void EnterAddress1InShippingAddress(String Address) {
		driver.findElement(Address1InShipping).clear();
		driver.findElement(Address1InShipping).sendKeys(Address);
	}

	public void EnterZipCodeInShippingAddress(String PortalCode) {
		driver.findElement(ZipPostalCodeInShipping).clear();
		driver.findElement(ZipPostalCodeInShipping).sendKeys(PortalCode);
	}

	public void EnterMobileNumberInShippingAddress(String MobileNumber) {
		driver.findElement(PhoneNumberInShipping).clear();
		driver.findElement(PhoneNumberInShipping).sendKeys(MobileNumber);
	}

	public void ClickOnContinueInShippingAddress() {
		driver.findElement(ContinueInShipping).click();

	}

	// <<shipping Method>>
	public void shippingMethod() {
		driver.findElement(shippingMethod);
	}

	public boolean selectShippingMethod() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethod)).isDisplayed();
	}

	public void ground() {
		driver.findElement(ground);
	}

	public boolean selectground() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ground)).isDisplayed();
	}

	public void shippingMethodContinue() {
		driver.findElement(shippingMethodContinue).click();
	}

	public boolean clickShippingMethodContinue() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodContinue)).isDisplayed();
	}

	// <<<<<<<<<<<<<<<<<<<<<<<Payment method>>>>>>>>>>>>>>>>>>>>>>>

	public boolean isPaymentMethodDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentMethodField)).isDisplayed();
	}
	
	 public boolean CashonDeliveryisDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(CashOnDelivery)).isDisplayed();
	    }
	 
	 public boolean CheckMoneyOrder_RadioButtonisDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(CheckMoneyOrder)).isDisplayed();
	    }
	    
	    public boolean Creditcard_RadioButtonisDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(CreditCard)).isDisplayed();
	    }
	    
	    public boolean PurchaseOrder_RadioButtonisDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(PurchaseOrder)).isDisplayed();
	    }
	    
	    

	public boolean isContinueButtonDisplayedInPaymentMethod() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueInPaymentMethod)).isDisplayed();
	}

	public boolean isBackButtonDisplayedInPaymentMethod() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(BackButtonInPaymentMethod)).isDisplayed();
	}

	public void ClickOnCashOnDelivery() {
		driver.findElement(CashOnDelivery).click();
	}

	public void ClickOnCheckMoneyOrder() {
		driver.findElement(CheckMoneyOrder).click();
	}

	public void ClickOnCreditCard() {
		driver.findElement(CreditCard).click();
	}

	public void ClickOnPurchaseOrder() {
		driver.findElement(PurchaseOrder).click();
	}

	public void ClickOnContinueInPaymentMethod() {
		driver.findElement(ContinueInPaymentMethod).click();
	}
	public void enterPoNumber(String Ponumber) {
		driver.findElement(PoNumber).clear();
		driver.findElement(PoNumber).sendKeys(Ponumber);
	}

	public void clilckOnContinueInPoNumber() {
		//return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueButtonInPonumber)).isDisplayed();
		driver.findElement(ContinueButtonInPonumber).click();;
	}

	public boolean isBackButtonDisplayedInPoNumber() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(BackButtonInPoNumber)).isDisplayed();
	}
	
	
	//>>>>>>Assertion Methods<<<<<<<<<<<<<<<<	    
	    
	    public boolean CodTextIsDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(Cod_Text)).isDisplayed();
	    }

	
	// <<<<<<<<<<<<<<<<<<<<<<<<Payment Information Field>>>>>>>>>>>>>>>>>>>>>>>>

	public boolean isPaymentInformationDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentInformationField)).isDisplayed();
	}

	public boolean isContinueButtonDisplayedInPaymentInformation() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueInPaymentInformation)).isDisplayed();
	}

	public boolean isBackButtonDisplayedInPaymentInformation() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(BackButtonInPaymentInformation)).isDisplayed();
	}

	public void ClickOnContinueInPaymentInformation() {
		driver.findElement(ContinueInPaymentInformation).click();
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Confirm Order>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public boolean isConfirmOrderDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmOrderField)).isDisplayed();
	}

	public boolean isConfirmButtonDisplayedInConfirmOrder() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmInConfirmationOrder)).isDisplayed();
	}

	public boolean isBackButtonDisplayedInConfirmOrder() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(BackButtonInConfirmationOrder)).isDisplayed();
	}

	public void ClickOnConfirmInConfirmOrder() {
		driver.findElement(ConfirmInConfirmationOrder).click();
	}
	
	 public boolean BillingAddress_isDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(BillingAddress_Text)).isDisplayed();
	    }
	    
	    public boolean Paymentmethodtext_isDisplayed() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(Paymentmethod_text)).isDisplayed();
	    }


	// <<<<<<<<<<<<<<<<<<<<<<<<<<Thank You Page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public boolean isThankYouPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ThankYouPage)).isDisplayed();
	}

	public boolean isOrderNumberDisplayedInThankYouPage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(OrderNumber)).isDisplayed();
	}

	public boolean isConfirmationMessageDisplayedInThankYouPage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationMessage)).isDisplayed();
	}

	public boolean isContinueButtonDisplayedInThankYouPage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueInThankYouPage)).isDisplayed();
	}

	public void ClickOnContinueInThankYouPage() {
		driver.findElement(ContinueInThankYouPage).click();
	}
	
	public boolean isHomePageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ApplicationHomePage)).isDisplayed();
	}
}

// }

//<<Default Checkout page>>

//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class CheckoutPage {
//
// By firstNameField = By.name("firstName");
// By lastNameField = By.name("lastName");
// By phoneField = By.name("phoneNumber");
// By addressField = By.name("address1");
// By cityField = By.name("city");
// By stateProvinceDropdown = By.cssSelector("._296s._47p_");
// By zipcodeField = By.name("postalCode");
// By emailField = By.name("email");
// By emailOptInCheckbox = By.name("optInAsGuest");
// By continueToPaymentButton = By.name("submit");
// By errorContainer = By.xpath("//div[@class=' _64f3'][contains(text(), 'Please specify a valid email')]");
//
// WebDriver driver;
// WebDriverWait wait;
//
// public CheckoutPage(WebDriver driver) {
// this.driver = driver;
// wait = new WebDriverWait(driver, 5);
// }
//
// public void enterFirstName(String firstName) {
// driver.findElement(firstNameField).clear();
// driver.findElement(firstNameField).sendKeys(firstName);
// }
//
// public void enterLastName(String lastName) {
// driver.findElement(lastNameField).clear();
// driver.findElement(lastNameField).sendKeys(lastName);
// }
//
// public void enterPhoneNumber(String phone) {
// driver.findElement(phoneField).clear();
// driver.findElement(phoneField).sendKeys(phone);
// }
//
// public void enterAddress(String address) {
// driver.findElement(addressField).clear();
// driver.findElement(addressField).sendKeys(address);
// }
//
// public void enterCity(String city) {
// driver.findElement(cityField).clear();
// driver.findElement(cityField).sendKeys(city);
// }
//
// public void selectState(String state) {
// new Select(driver.findElement(stateProvinceDropdown)).selectByValue(state);
// }
//
// public void enterZipcode(String zipcode) {
// driver.findElement(zipcodeField).clear();
// driver.findElement(zipcodeField).sendKeys(zipcode);
// }
//
// public void enterEmail(String email) {
// driver.findElement(emailField).clear();
// driver.findElement(emailField).sendKeys(email);
// }
//
// public void refresh() {
// driver.navigate().refresh();
// }
//
// public boolean isErrorContainerDisplayed() {
// return wait.until(ExpectedConditions.visibilityOfElementLocated(errorContainer)).isDisplayed();
// }
//
// public boolean isContinueButtonEnabled() {
// return wait.until(ExpectedConditions.elementToBeClickable(continueToPaymentButton)).isDisplayed();
// }
//
//}
