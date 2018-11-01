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
 * 1. open Google Search page,
 * 2. take screenshot of the logo graphics <canvas id="hpcanvas"> to save it into file,
 * 3. wait for one second ... graphics may change
 * 4. compare the file and the web page; verify 2 images are similar
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path datadir = projectdir.resolve('Data Files/images')
Path workdir = projectdir.resolve('tmp/TC2')
if (Files.exists(workdir)) {
	FileUtils.deleteDirectory(workdir.toFile())
}
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject btnK = findTestObject('Object Repository/Page_Google/input_btnK')
TestObject logoArea = findTestObject('Object Repository/Page_Google/div_logoArea')

WebUI.verifyElementPresent(btnK, 10)

com.kazurayam.ksbackyard.ScreenshotDriver.alwaysSaveSnapshots_ = true

File file1 = datadir.resolve('google_logo.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	file1,
	logoArea,
	3.0,
	workdir.resolve('a'),
	FailureHandling.CONTINUE_ON_FAILURE)


File file2 = datadir.resolve('halloween2.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	file2,
	logoArea,
	3.0,
	workdir.resolve('b'),
	FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	file1,
	logoArea,
	3.0,
	workdir.resolve('c'),
	FailureHandling.CONTINUE_ON_FAILURE)


CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	file2,
	logoArea,
	3.0,
	workdir.resolve('d'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()



