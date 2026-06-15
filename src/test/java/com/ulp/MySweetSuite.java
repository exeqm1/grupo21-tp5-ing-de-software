package com.ulp;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ 
    CalculadoraTest.class, 
    DivisionTest.class, 
    CalculadoraParametrizadaTest.class 
})
public class MySweetSuite {
}
