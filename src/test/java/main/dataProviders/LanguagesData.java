package main.dataProviders;

import org.testng.annotations.DataProvider;

public class LanguagesData {
    @DataProvider(name="languages")
    public static Object[][] getLanguagesData(){
        return new Object[][]{
                {"default","Site Map"},
                {"french","Plan du Site"},
                {"german","Sitemap"}
        };
    }
}
