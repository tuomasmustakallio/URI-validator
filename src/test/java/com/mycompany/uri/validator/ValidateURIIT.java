/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.uri.validator;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tuomas
 */
public class ValidateURIIT {
    
    public ValidateURIIT() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testValidator() {
        List<String> testValuesPass = new ArrayList<String>();
        testValuesPass.add("visma-identity://login?source=severa");
        testValuesPass.add("visma-identity://confirm?source=netvisor&paymentnumber=102226");
        testValuesPass.add("visma-identity://sign?source=vismasign&documentid=47ed9186-2ba0-4e8b-b9e2-7123575fdd5b");
        List<String> testValuesFail = new ArrayList<String>();
        testValuesFail.add("visma-anonymity://login?source=severa");
        testValuesFail.add("visma-identity://resign?source=severa");
        testValuesFail.add("visma-identity://confirm?badparam");
        testValuesFail.add("not a uri");
        testValuesFail.add("");
        ValidateURI testValidator = new ValidateURI();
        for(String t : testValuesPass){
            boolean ttest = testValidator.validate(t);
            assertEquals(true, ttest);
        }
        for(String f : testValuesFail){
            boolean ftest = testValidator.validate(f);
            assertEquals(false, ftest);
        }
        
    }
    
}
