package com.ps.demoblaze.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DemoBlazeDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m){
        return switch (m.getName()) {
            case "validLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abc"}};
            case "invalidLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abcd"}, {"pepito.perez@gmail.com", "123"}};
            default -> null;
        };
    }
}
