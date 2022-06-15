package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReausableMethods {


    @Test
    public void test01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH = Driver.getDriver().getWindowHandle();

        //● Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH = "";

        for (String each : windowHandleSeti
             ) {
            if (!each.equals(ikinciSayfaWH)){
                ikinciSayfaWH = each;
            }
        }

        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());




    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window2");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();


        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }








}

