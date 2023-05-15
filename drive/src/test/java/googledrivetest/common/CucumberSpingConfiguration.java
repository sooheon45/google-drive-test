package googledrivetest.common;

import googledrivetest.DriveApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DriveApplication.class })
public class CucumberSpingConfiguration {}
