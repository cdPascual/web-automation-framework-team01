package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.*;
import utility.Utility;

public class Account extends CommonAPI {
    Logger LOG = LogManager.getLogger(Account.class.getName());

    @Test
    public void invalidEmailAddress() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnLoginButton();
        Thread.sleep(3);

        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("crazycray@dhsj");
        loginPage.typePassword("password123");

        loginPage.clickOnConnectButton();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
        LOG.info("error message validation success");

    }
    @Test
    public void createNewAccount() throws InterruptedException {
        Base base = new Base(getDriver());
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());

        base.clickOnCreateAnAccount();
        String createAnAccountPage = getCurrentTitle();
        Assert.assertEquals(getCurrentTitle(),"Create New Customer Account");
        LOG.info("successfully landed on Create An Account Page");

        String firstName = createAccountPage.fakeFirstName();
        createAccountPage.inputFirstName(firstName);
        LOG.info("successfully entered a first name");

        String lastName = createAccountPage.fakeLastName();
        createAccountPage.inputLastName(lastName);
        LOG.info("successfully entered a last name");

        String email = createAccountPage.fakeEmailAddress();
        createAccountPage.inputEmailAddress(email);
        LOG.info("successfully entered an email");

        String password = createAccountPage.fakePassword();
        createAccountPage.inputPassword(password);
        LOG.info("successfully entered a password");

        createAccountPage.inputConfirmPassword(password);
        LOG.info("successfully entered password confirmation");

        createAccountPage.clickCreateAccountButton();
        LOG.info("successfully clicked create account");

        String myAccountPageTitle = getCurrentTitle();
        Assert.assertEquals(myAccountPageTitle,"My Account");
        LOG.info("successfully Created An Account");
    }

    @Test
    public void addItemsToWishList() throws InterruptedException {
        Base base = new Base(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        WatchesPage watchesPage = new WatchesPage(getDriver());
        BagsPage bagsPage = new BagsPage(getDriver());
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        MyWishListPage wishListPage = new MyWishListPage(getDriver());

        base.clickOnCreateAnAccount();
        String createAnAccountPage = getCurrentTitle();
        Assert.assertEquals(getCurrentTitle(),"Create New Customer Account");
        LOG.info("successfully landed on Create An Account Page");

        String firstName = createAccountPage.fakeFirstName();
        createAccountPage.inputFirstName(firstName);
        LOG.info("successfully entered a first name");

        String lastName = createAccountPage.fakeLastName();
        createAccountPage.inputLastName(lastName);
        LOG.info("successfully entered a last name");

        String email = createAccountPage.fakeEmailAddress();
        createAccountPage.inputEmailAddress(email);
        LOG.info("successfully entered an email");

        String password = createAccountPage.fakePassword();
        createAccountPage.inputPassword(password);
        LOG.info("successfully entered a password");

        createAccountPage.inputConfirmPassword(password);
        LOG.info("successfully entered password confirmation");

        createAccountPage.clickCreateAccountButton();
        LOG.info("successfully clicked create account");

        base.clickOnWatches(getDriver());
        watchesPage.addClamberWatchToWishList(getDriver());

        base.clickOnBags(getDriver());
        bagsPage.addMessengerBagToWishList(getDriver());

        base.clickOnCustomerMenu();
        LOG.info("click on main menu successful");

        base.clickOnMyWishList();
        String wishListPageTitle= getCurrentTitle();
        Assert.assertEquals(wishListPageTitle,"My Wish List");
        LOG.info("click on my wish list successful");

        String totalItems = wishListPage.getTotalItemsWishList();
        Assert.assertEquals(totalItems, "2 Item(s)");

    }

    @Test
    public void addAllWishListItemsToCart() throws InterruptedException {
        Base base = new Base(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        WatchesPage watchesPage = new WatchesPage(getDriver());
        BagsPage bagsPage = new BagsPage(getDriver());
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        MyWishListPage wishListPage = new MyWishListPage(getDriver());

        base.clickOnCreateAnAccount();
        String createAnAccountPage = getCurrentTitle();
        Assert.assertEquals(getCurrentTitle(),"Create New Customer Account");
        LOG.info("successfully landed on Create An Account Page");

        String firstName = createAccountPage.fakeFirstName();
        createAccountPage.inputFirstName(firstName);
        LOG.info("successfully entered a first name");

        String lastName = createAccountPage.fakeLastName();
        createAccountPage.inputLastName(lastName);
        LOG.info("successfully entered a last name");

        String email = createAccountPage.fakeEmailAddress();
        createAccountPage.inputEmailAddress(email);
        LOG.info("successfully entered an email");

        String password = createAccountPage.fakePassword();
        createAccountPage.inputPassword(password);
        LOG.info("successfully entered a password");

        createAccountPage.inputConfirmPassword(password);
        LOG.info("successfully entered password confirmation");

        createAccountPage.clickCreateAccountButton();
        LOG.info("successfully clicked create account");

        base.clickOnWatches(getDriver());
        watchesPage.addClamberWatchToWishList(getDriver());

        base.clickOnBags(getDriver());
        bagsPage.addMessengerBagToWishList(getDriver());

        wishListPage.clickAddAllItemsToCart();
        String emptyMessage = wishListPage.getEmptyMessage();
        Assert.assertEquals(emptyMessage,"You have no items in your wish list.");

        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 2);
        LOG.info("Add 2 items to cart success. "+totalItemsInCart+" item/items in the cart.");
        LOG.info(totalItemsInCart+" item/items in the cart.");

    }

//    @Test
//    public void validCredentials() throws InterruptedException {
//        HomePage homePage = new HomePage(getDriver());
//        WhatsNewPage whatsNewPage= new WhatsNewPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        String email = Utility.getProperties().getProperty("magentoLuma.username");
//        String password = Utility.getProperties().getProperty("magentoLuma.password");
//        //String password = ConnectDB.getTableColumnData("select * from credentials","password").get(0);
//
//

//        homePage.clickOnLoginButton();
//
//        String title = getCurrentTitle();
//        Assert.assertEquals(title, "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
//        LOG.info("login title page validation success");
//
//        loginPage.typeEmailAddress(email);
//        loginPage.typePassword(password);
//
//        loginPage.clickOnConnectButton();
//
//        String error = loginPage.getErrorMessage();
//        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
//        LOG.info("error message validation success");

//    }

}
