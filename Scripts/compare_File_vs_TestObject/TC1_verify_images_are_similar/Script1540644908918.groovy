import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling

import java.nio.file.Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/**
 * TC1 verifies a profile photo in the target web page is similar enough to the expected image file 
 */

Path tmpDir = Paths.get(RunConfiguration.getProjectDir(), 'tmp')
Files.createDirectories(tmpDir)
File imageFile = tmpDir.resolve("kazurayam.png").toFile()

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

TestObject testObject = findTestObject('Object Repository/Page_Katalon Discussion/img_Commentator', ['index':6])

WebUI.verifyElementPresent(testObject, 10)

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	imageFile,
	testObject,
	5.0,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()






