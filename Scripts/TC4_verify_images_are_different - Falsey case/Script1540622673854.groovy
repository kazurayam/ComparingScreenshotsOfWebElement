import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.model.FailureHandling

/**
 * TC4 verifies a profile photo in the target web page is different enough from the expected image file,
 * but infact they are similar, so the test case fails 
 */

Path tmpDir = Paths.get(RunConfiguration.getProjectDir(), 'tmp')
Files.createDirectories(tmpDir)
File imageFile = tmpDir.resolve("kazurayam.png").toFile()

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

TestObject testObject = findTestObject('Object Repository/Page_Katalon Discussion/img_Commentator', ['index':6])

WebUI.verifyElementPresent(testObject, 10)

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	imageFile,
	testObject,
	75.0,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()






