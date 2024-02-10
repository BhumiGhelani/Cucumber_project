package Action_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class Action {
    public WebDriver driver = null;

    //This is a constructor to assign the local Webdriver value from test Webdriver value
    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public boolean check_element_present(By by)
    {

        boolean flag = false;
        try
        {
            if (driver.findElement(by).isDisplayed())
            {
                flag=true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    // This method is a reusable method to click on a WebElement
    public boolean click_implicit_wait(By by)
    {

        boolean flag = false;
        try
        {
            if (driver.findElement(by).isDisplayed())
            {
                driver.findElement(by).click();
                flag=true;
            }
        }


        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean send_keys(By by,String txt)
    {

        boolean flag = false;
        try
        {
            if (driver.findElement(by).isDisplayed())
            {
                driver.findElement(by).sendKeys(txt);
                flag=true;
            }
        }


        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    // this method is used to read Properties file
    public String read_properties_file(String key)
    {

        String flag = null;
        try
        {
            Properties prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/Global.properties"));
            flag =  prop.getProperty(key);
        }


        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
}
