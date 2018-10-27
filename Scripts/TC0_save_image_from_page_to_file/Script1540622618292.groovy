import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/**
 * 
 */

Path tmpDir = Paths.get(RunConfiguration.getProjectDir(), 'tmp')
Files.createDirectories(tmpDir)
File imageFile = tmpDir.resolve("kazurayam.png").toFile()

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

TestObject testObject =	findTestObject('Object Repository/Page_Katalon Discussion/img_Originator')
 
WebUI.verifyElementPresent(testObject, 10)


CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage'(testObject, imageFile)

WebUI.delay(3)

WebUI.closeBrowser()