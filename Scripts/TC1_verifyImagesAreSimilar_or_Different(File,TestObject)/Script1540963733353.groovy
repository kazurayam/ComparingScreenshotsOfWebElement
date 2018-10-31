import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * 1. open Google Search page,
 * 2. take screenshot of the logo graphics <canvas id="hpcanvas"> to save it into file,
 * 3. wait for one second ... graphics may change
 * 4. compare the file and the web page; verify 2 images are similar
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path datadir = projectdir.resolve('Data Files/images')
Path workdir = projectdir.resolve('tmp/TC1')
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject hpcanvas = findTestObject('Object Repository/Page_Google/canvas_hpcanvas')

WebUI.verifyElementPresent(hpcanvas, 10)

com.kazurayam.ksbackyard.ScreenshotDriver.alwaysSaveSnapshots_ = true

// check if the logo image in Google Serach is similar to a file as expected
WebUI.delay(1)
File file1 = datadir.resolve('halloween1.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	file1,
	hpcanvas,
	3.0,
	workdir.resolve('a'))

WebUI.delay(1)

File file2 = datadir.resolve('halloween2.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	file2,
	hpcanvas,
	3.0,
	workdir.resolve('b'))

WebUI.closeBrowser()



