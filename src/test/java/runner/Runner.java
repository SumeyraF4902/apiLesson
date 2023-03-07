package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin={
                "pretty",// stepleri konsolda görebilmek icin
        },
        //path of feature
        features ="src/test/resources/trelloApi.feature",

        //   path of step definitons
        glue="trelloAPI",
        tags="@trelloApi",
        dryRun = false
        //dryRun = true olursa (önce truue yaparsın run ettiginde altta senaryolar gelir onları kopyalayıp stepdefinitions clasına yapıstırabilirsin yani calısacagın clasa yapıstır) sonra false cevir

)


public class Runner {
}
