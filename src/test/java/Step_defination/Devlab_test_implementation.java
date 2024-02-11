package Step_defination;

import Action_pkg.Action;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.an.E;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Page_object_model.*;

import java.time.Duration;

public class Devlab_test_implementation {

    Login log_obj;
    char_registration chartink;
    Action act;
    public WebDriver driver = null;
    public String url = null;

    // copy from skeleton

    @Before
    public void windowOpen(){
        driver = new ChromeDriver();
        act = new Action(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.get("https://devlabsalliance.com/");

        if(act.read_properties_file("applicationname").equals("formsmart"))
        {
            url = act.read_properties_file("formurl");
        }
        if(act.read_properties_file("applicationname").equals("devlabs"))
        {
            url = act.read_properties_file("url");
        }
        if(act.read_properties_file("applicationname").equals("chartink"))
        {
            url = act.read_properties_file("charurl");
        }
        driver.get(url);
        log_obj = new Login();
        chartink = new char_registration();

    }
    @Given("user launch devlab application")
    public void user_launch_devlab_application() {
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://devlabsalliance.com/");
        log_obj = new Login();
        act = new Action(driver);  */
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user validate the homepage title")
    public void user_validate_the_homepage_title() {
        // Write code here that turns the phrase above into concrete actions
    String strtitle = driver.getTitle();
        System.out.println(strtitle);
        Assert.assertEquals(driver.getTitle(),"Devlabs Alliance offers consulting and workshops on AI, RPA, DevOps, Big Data, Block Chain, Automation.");
    }
    @Then("user validate devlab logo")
    public void user_validate_devlab_logo() {
        // Write code here that turns the phrase above into concrete actions
   Assert.assertTrue(act.check_element_present(log_obj.logo()));
        System.out.println("We found the logo");
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions

        act.click_implicit_wait(log_obj.login_button());
    }
    @Then("login pop up screen displays")
    public void login_pop_up_screen_displays() {
        // Write code here that turns the phrase above into concrete actions
        if(act.check_element_present(log_obj.email_txt()));
        System.out.println("Email ID text is present");
        if (act.check_element_present(log_obj.email_input()));
        System.out.println("Email ID input box is present");

        if(act.check_element_present(log_obj.pass_txt()));
        System.out.println("Password text is present");

        if (act.check_element_present(log_obj.pass_input()));
        System.out.println("Password input box is present");
    }
    @When("user gives input as username and password")
    public void user_gives_input_as_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        String email = (act.read_properties_file("email"));
        String Pass = (act.read_properties_file("password"));

        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys(Pass);
    }
    @Then("user close the login pop up")
    public void user_close_the_login_pop_up() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().refresh();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("(//img[@alt='DevLabs Alliance Logo'])[1]")).click();
    }
    @After
    public void closeApp(){
        driver.quit();
    }
    @Then("user close the application")
    public void user_close_the_application() {
        // Write code here that turns the phrase above into concrete actions
//driver.quit();
    }

    // Form smart formfilling scenario

    @Given("user launch formsmart application")
    public void user_launch_formsmart_application() {
        // Write code here that turns the phrase above into concrete actions
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));*/
       // driver.get(act.read_properties_file("formurl"));
    }
    @Then("user scroll till the form section")
    public void user_scroll_till_the_form_section() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().frame(0);
        WebElement talk = driver.findElement(By.xpath("//input[@placeholder='Your first name']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", talk);
        Thread.sleep(5000);
    }
    @When("user give input as first name,last name, email and inquiry")
    public void user_give_input_as_first_name_last_name_email_and_inquiry() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@placeholder='Your first name']")).sendKeys("Bhumi");
        driver.findElement(By.xpath("//input[@placeholder='Your last name']")).sendKeys("Ghelani");
        driver.findElement(By.xpath("//input[@placeholder='Your email address']")).sendKeys("bhumi@gmail.com");
        driver.findElement(By.xpath("//textarea[@placeholder='Your comment']")).sendKeys("This is sample inquiry");
    Thread.sleep(3000);
    driver.switchTo().defaultContent();
    }

    @Given("user is in form home page")
    public void user_is_in_form_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("You have reached the home page");
    }
    @Then("user fills the form with {string},{string},{string},{string}")
    public void user_fills_the_form_with(String fname, String lname, String email, String inquiry) throws  Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@placeholder='Your first name']")).sendKeys(fname);
        driver.findElement(By.xpath("//input[@placeholder='Your last name']")).sendKeys(lname);
        driver.findElement(By.xpath("//input[@placeholder='Your email address']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@placeholder='Your comment']")).sendKeys(inquiry);
        Thread.sleep(3000);
    }


    // Chartink registration form filling

    @Then("user validate the homepage logo")
    public void user_validate_the_homepage_logo() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(act.check_element_present(chartink.char_logo()));
        System.out.println("We found the logo");
    }
    @When("user click on get started button")
    public void user_click_on_get_started_button() {
        // Write code here that turns the phrase above into concrete actions
   // act.send_keys(chartink.email(),)
    }
    @Then("user registration for page appears")
    public void user_registration_for_page_appears() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user enter details")
    public void user_enter_details() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user close the registration app")
    public void user_close_the_registration_app() {
        // Write code here that turns the phrase above into concrete actions

    }
}
