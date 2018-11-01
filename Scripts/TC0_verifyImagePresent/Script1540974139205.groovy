import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * open Google Search page,
 * check if the fixture graphic is found in the page
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path workdir = projectdir.resolve('tmp/TC0')
if (Files.exists(workdir)) {
	FileUtils.deleteDirectory(workdir.toFile())
}
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject btnK = findTestObject('Page_Google/input_btnK')
TestObject hpcanvas = findTestObject('Object Repository/Page_Google/canvas_hpcanvas')

WebUI.verifyElementPresent(btnK, 10)

WebUI.delay(1)

TestObject logoArea = findTestObject('Fixture/google_logo')
WebUI.verifyImagePresent(logoArea,
	FailureHandling.CONTINUE_ON_FAILURE)

TestObject halloween1 = findTestObject('Fixture/halloween1')
WebUI.verifyImagePresent(halloween1,
	FailureHandling.CONTINUE_ON_FAILURE)

TestObject halloween2 = findTestObject('Fixture/halloween2')
WebUI.verifyImagePresent(halloween2,
	FailureHandling.CONTINUE_ON_FAILURE)

TestObject halloween3 = findTestObject('Fixture/halloween3')
WebUI.verifyImagePresent(halloween3,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()