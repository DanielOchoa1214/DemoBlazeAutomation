package com.ps.demoblaze.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DemoBlazeDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m){
        return switch (m.getName()) {
            case "ECLAT_965_validLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abc"}};
            case "ECLAT_966_invalidLoginTest" -> new Object[][]{{"pepito.perez@gmail.com", "abcd", "Wrong password."},
                                                                {"pepito.perez@gmail.com", "123", "Wrong password."},
                                                                {"invalid.email@gmail.com", "123", "User does not exist."}};
            case "ECLAT_419_NavigToPhonesCategory" -> new Object[][]{{"Phones", "Iphone 6 32gb"}};
            case "ECLAT_420_NavigToLaptopsCategory" -> new Object[][]{{"Laptops", "MacBook air"}};
            case "ECLAT_421_NavigToMonitorsCategory" -> new Object[][]{{"Monitors", "Apple monitor 24"}};
            case "ECLAT_904_CompletionCheckoutProcess" -> new Object[][]{{"Pepito Perez", "Colombia", "Bogotá", "1234 5678 9012 3456","December"," 1999"}};
            default -> null;
        };
    }
}
