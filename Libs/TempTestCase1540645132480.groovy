import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('/var/folders/2j/_1868sm54yddf8_9xf0k3qrw0000gn/T/Katalon/Test Cases/compare_TestObject_vs_TestObject/TC5_verify_images_are_similar/20181027_215852/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/compare_TestObject_vs_TestObject/TC5_verify_images_are_similar', new TestCaseBinding('Test Cases/compare_TestObject_vs_TestObject/TC5_verify_images_are_similar',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
