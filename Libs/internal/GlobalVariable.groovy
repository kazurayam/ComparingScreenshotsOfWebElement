package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object MATERIAL_REPOSITORY
     
    /**
     * <p></p>
     */
    public static Object CURRENT_TESTCASE_NAME
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['MATERIAL_REPOSITORY' : null, 'CURRENT_TESTCASE_NAME' : ''])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        MATERIAL_REPOSITORY = selectedVariables['MATERIAL_REPOSITORY']
        CURRENT_TESTCASE_NAME = selectedVariables['CURRENT_TESTCASE_NAME']
        
    }
}
