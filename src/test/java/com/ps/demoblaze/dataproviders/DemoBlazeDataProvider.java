package com.ps.demoblaze.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Random;

public class DemoBlazeDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m){
        Random rand = new Random();
        String randomUsername = "user" + rand.nextInt(1000) + "@gmail.com";
        String randomPassword = "pass" + rand.nextInt(1000);
        return switch (m.getName()) {
            case "ECLAT_965_validLoginTest", "ECLAT_802_SignUpValidation" -> new Object[][]{{"pepito.perez@gmail.com", "abc"}};
            case "ECLAT_805_correctSignUp" -> new Object[][]{{randomUsername, "123"}};
            case "ECLAT_966_invalidLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abcd"}, {"pepito.perez@gmail.com", "123"}};
            default -> null;
        };
    }
}
