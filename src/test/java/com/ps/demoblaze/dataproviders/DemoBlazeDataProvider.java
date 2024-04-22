package com.ps.demoblaze.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DemoBlazeDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m){
        return switch (m.getName()) {
            case "ECLAT_965_validLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abc"}};
            case "ECLAT_966_invalidLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abcd"}, {"pepito.perez@gmail.com", "123"}};
            default -> null;
        };
    }
}
