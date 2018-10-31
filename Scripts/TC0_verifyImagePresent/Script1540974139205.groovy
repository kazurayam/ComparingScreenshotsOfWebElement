import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * open Google Search page,
 * check if the fixture graphic is found in the page
 */
Path projectdir = Paths.get(RunConfiguration.getProjectDir())
Path workdir = projectdir.resolve('tmp/TC0')
Files.createDirectories(workdir)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.google.com')

TestObject hpcanvas = findTestObject('Object Repository/Page_Google/canvas_hpcanvas')

WebUI.verifyElementPresent(hpcanvas, 10)

WebUI.delay(1)

TestObject halloween1 = findTestObject('Object Repository/Fixture_halloween/halloween1')
WebUI.verifyImagePresent(halloween1)

TestObject halloween2 = findTestObject('Object Repository/Fixture_halloween/halloween2')
WebUI.verifyImagePresent(halloween2)

TestObject halloween3 = findTestObject('Object Repository/Fixture_halloween/halloween3')
WebUI.verifyImagePresent(halloween3)

WebUI.closeBrowser()