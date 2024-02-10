package Page_object_model;

import org.openqa.selenium.By;

public class Login {
    public By login_button()
    {

        return By.xpath("//button[@id='header_Button']");
    }

    public By logo()
    {

        return By.xpath("(//img[@alt='DevLabs Alliance Logo'])[1]");
    }

    public By email_txt(){
        return By.xpath("//span[text()='Email ID']");
    }

    public By email_input()
    {
        return By.xpath("//div/input[@name='email']");
    }
    public By pass_txt()
    {
        return By.xpath("//span[text()='Password']");
    }
    public By pass_input()
    {
        return By.xpath("//div/input[@name='password']");
    }

}
