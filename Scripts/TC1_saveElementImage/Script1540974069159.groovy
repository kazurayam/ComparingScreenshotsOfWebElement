import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * open Google Search page,
 * take screenshot of the logo graphics <canvas id="hpcanvas"> to save it into file
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path workdir = projectdir.resolve('tmp/TC1')
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject hpcanvas = findTestObject('Object Repository/Page_Google/canvas_hpcanvas')

WebUI.verifyElementPresent(hpcanvas, 10)

// save screenshot of <canvas id="hpcanvas">
WebUI.delay(1)
File file1 = workdir.resolve('hpcanvas1.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage'(
	hpcanvas,
	file1)

// one more time
WebUI.delay(1)
File file2 = workdir.resolve('hpcanvas2.png')
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage'(
	hpcanvas,
	file2)

WebUI.closeBrowser()

