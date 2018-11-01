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
 * take screenshot of the logo graphics <canvas id="hpcanvas"> to save it into file
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path workdir = projectdir.resolve('tmp/TC1')
if (Files.exists(workdir)) {
	FileUtils.deleteDirectory(workdir.toFile())
}
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject btnK = findTestObject('Page_Google/input_btnK')

WebUI.verifyElementPresent(btnK, 5, FailureHandling.CONTINUE_ON_FAILURE)

// save screenshot of Google Logo area
TestObject logoArea = findTestObject('Page_Google/div_logoArea')
File file1 = workdir.resolve('logoArea.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage'(
	logoArea,
	file1)

WebUI.closeBrowser()
