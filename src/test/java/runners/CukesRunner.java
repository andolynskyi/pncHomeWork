package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/parallel-cucumber.json",
        },
        features = "src/test/resources/features/",
        glue = "step_definitions",
        tags = "@api",
        dryRun = false
        //dryRun, plugin, tags...
)

public class CukesRunner {

}
