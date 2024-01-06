package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Main {
    public static void main(String[] args)  {

        //Method 1 without Downloading gecodriver
        //WebDriverManager.firefoxdriver().setup();

        //Methhod 2 with downloading gecodriver.
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriverFolder\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/82738/indw-vs-ausw-1st-t20i-australia-women-tour-of-india-2023-24");

        WebElement scoreCard = driver.findElement(By.id("innings_1"));
        WebElement finalScore = scoreCard.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[1]/span[2]"));
        System.out.println("Final Score of 1st Innings is "+finalScore.getText());

        //Now Printing Table

        List<WebElement> tableList = scoreCard.findElements(By.className("cb-scrd-itms"));

        for(WebElement rows:tableList){
            List<WebElement> rowsDataList = rows.findElements(By.className("cb-col"));
            System.out.println("------------------------------------------");
            for(WebElement rDataDiv : rowsDataList){
                System.out.print(rDataDiv.getText()+"  ||  ");
            }

            //Player Name
            System.out.println(rows.findElement(By.tagName("a")).getText());
        }

        System.out.println(tableList.size());

        driver.close();
    }
}