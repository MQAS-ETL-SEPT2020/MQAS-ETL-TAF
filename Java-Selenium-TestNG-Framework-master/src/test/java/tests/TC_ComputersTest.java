package tests;

import org.testng.annotations.Test;

import pages.BasePage;
import pages.CompareButtonPage;
import pages.ComputerPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC_ComputersTest extends BasePage {
	@Test
	public void ClickOnComputer() {
		HomePage home = new HomePage(driver);
		home.clickComputers();

		ComputerPage computer = new ComputerPage(driver);
		computer.ClickOnDesktop();

		DesktopPage desktop = new DesktopPage(driver);
		desktop.Desktop();

		CompareButtonPage comparebutton = new CompareButtonPage(driver);
		comparebutton.click();

		ProductsPage product = new ProductsPage(driver);
		product.remove();
	}
}