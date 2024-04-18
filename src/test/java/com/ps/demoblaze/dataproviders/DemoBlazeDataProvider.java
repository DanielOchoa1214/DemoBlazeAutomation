package com.ps.demoblaze.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DemoBlazeDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m){
        switch (m.getName()){
            case "validLoginTest":
                return new Object[][] {{"pepito.perez@gmail.com", "abc"}};
        }
        return null;
    }
}
