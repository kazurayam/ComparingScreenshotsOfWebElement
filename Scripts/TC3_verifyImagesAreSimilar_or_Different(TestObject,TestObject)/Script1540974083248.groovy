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
 * TC2
 *
 * 1. open Google Search page,
 * 2. take screenshot of the logo graphics <canvas id="hpcanvas"> to save it into file,
 * 3. wait for one second ... graphics may change
 * 4. compare the file and the web page; verify 2 images are similar
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path datadir = projectdir.resolve('Data Files/images')
Path workdir = projectdir.resolve('tmp/TC3')
if (Files.exists(workdir)) {
	FileUtils.deleteDirectory(workdir.toFile())
}
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject btnk     = findTestObject('Object Repository/Page_Google/input_btnK')

WebUI.verifyElementPresent(btnk, 10)

com.kazurayam.ksbackyard.ScreenshotDriver.setForceSnapshots(true)

TestObject logoArea = findTestObject('Object Repository/Page_Google/div_logoArea')

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	logoArea,
	logoArea,
	3.0,
	workdir.resolve('a').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)


CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	logoArea,
	btnk,
	3.0,
	workdir.resolve('b').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	logoArea,
	logoArea,
	3.0,
	workdir.resolve('c').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)


CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	logoArea,
	btnk,
	3.0,
	workdir.resolve('d').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()
