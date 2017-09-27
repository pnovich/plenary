package ua.com.sngtrans.plenary.cucumber.stepdefs;

import ua.com.sngtrans.plenary.PlenaryErpApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = PlenaryErpApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
