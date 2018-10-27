
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import org.openqa.selenium.WebDriver

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject

import java.io.File

import java.lang.Integer

import java.awt.image.BufferedImage

import java.lang.Double

import com.kms.katalon.core.model.FailureHandling

import java.lang.String

import java.lang.Boolean

import java.lang.Number


def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeElementImage"(
    	WebDriver webDriver	
     , 	WebElement webElement	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeElementImage(
        	webDriver
         , 	webElement)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeElementImage"(
    	TestObject testObject	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeElementImage(
        	testObject)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage"(
    	WebDriver webDriver	
     , 	WebElement webElement	
     , 	File file	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveElementImage(
        	webDriver
         , 	webElement
         , 	file)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage"(
    	TestObject testObject	
     , 	File file	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveElementImage(
        	testObject
         , 	file)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePageImage"(
    	WebDriver webDriver	
     , 	Integer timeout	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePageImage(
        	webDriver
         , 	timeout)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePageImage"(
    	Integer timeout	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePageImage(
        	timeout)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage"(
    	WebDriver webDriver	
     , 	File file	
     , 	Integer timeout	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveEntirePageImage(
        	webDriver
         , 	file
         , 	timeout)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage"(
    	File file	
     , 	Integer timeout	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveEntirePageImage(
        	file
         , 	timeout)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePage"(
    	WebDriver webDriver	
     , 	File file	
     , 	Integer timeout	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePage(
        	webDriver
         , 	file
         , 	timeout)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImages"(
    	BufferedImage expectedImage	
     , 	BufferedImage actualImage	
     , 	Double criteriaPercent	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImages(
        	expectedImage
         , 	actualImage
         , 	criteriaPercent)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.compareImages"(
    	BufferedImage expectedImage	
     , 	BufferedImage actualImage	
     , 	Double criteriaPercent	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).compareImages(
        	expectedImage
         , 	actualImage
         , 	criteriaPercent)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.compareImages"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).compareImages(
        	expected
         , 	actual
         , 	criteriaPercent)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePageImage"(
    	WebDriver webDriver	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePageImage(
        	webDriver)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePageImage"() {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePageImage()
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage"(
    	WebDriver webDriver	
     , 	File file	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveEntirePageImage(
        	webDriver
         , 	file)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage"(
    	File file	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).saveEntirePageImage(
        	file)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePage"(
    	WebDriver webDriver	
     , 	File file	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).takeEntirePage(
        	webDriver
         , 	file)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent)
}

def static "com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	) {
    (new com.kazurayam.ksbackyard.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual)
}

def static "com.kazurayam.ksbackyard.Assert.assertTrue"(
    	String message	
     , 	Boolean condition	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.Assert()).assertTrue(
        	message
         , 	condition
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.Assert.assertFalse"(
    	String message	
     , 	Boolean condition	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.Assert()).assertFalse(
        	message
         , 	condition
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.Assert.assertEquals"(
    	String message	
     , 	String expected	
     , 	String actual	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.Assert.assertEquals"(
    	String message	
     , 	Number expected	
     , 	Number actual	
     , 	FailureHandling flowControl	) {
    (new com.kazurayam.ksbackyard.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual
         , 	flowControl)
}

def static "com.kazurayam.ksbackyard.Assert.assertTrue"(
    	String message	
     , 	Boolean condition	) {
    (new com.kazurayam.ksbackyard.Assert()).assertTrue(
        	message
         , 	condition)
}

def static "com.kazurayam.ksbackyard.Assert.assertFalse"(
    	String message	
     , 	Boolean condition	) {
    (new com.kazurayam.ksbackyard.Assert()).assertFalse(
        	message
         , 	condition)
}

def static "com.kazurayam.ksbackyard.Assert.assertEquals"(
    	String message	
     , 	String expected	
     , 	String actual	) {
    (new com.kazurayam.ksbackyard.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual)
}

def static "com.kazurayam.ksbackyard.Assert.assertEquals"(
    	String message	
     , 	Number expected	
     , 	Number actual	) {
    (new com.kazurayam.ksbackyard.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual)
}

def static "com.kazurayam.ksbackyard.TestObjectSupport.jsonifyActiveProperties"(
    	TestObject testObject	) {
    (new com.kazurayam.ksbackyard.TestObjectSupport()).jsonifyActiveProperties(
        	testObject)
}
