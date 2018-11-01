Comparing Screenshots of WebElement
====

## What is this?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can download it from [Releases](https://github.com/kazurayam/ComparingScreenshotsOfWebElement/releases) page and try on your local PC.

This project was developed using Katalon Studio 5.8.4.

This project proposes a set of Custom Keywords which enable you to test arbitrary HTML elements visually by taking and comparing screenshots in various ways.

## Problem to solve

### What is built-in

Katalon Studio provides a limited number of built-in keywords for testing web pages visually.

1. [`WebUI.verifyImagePresent(TestObject expected)`](https://docs.katalon.com/katalon-studio/docs/webui-verify-image-present.html)
2. [`WebUI.takeScreenshot(File)`](https://docs.katalon.com/katalon-studio/docs/webui-take-screenshot.html)

### Shortages

I would enumerate shortages of the built-in keywords above.

1. `WebUI.takeScreenshot(File)` enables you to take screenshot of viewport of the target web page, but it does not allow you to take screenshot of a particular HTML element of your interest.
2. `WebUI.verifyImagePresent(TestObject expected)` requires you to prepare a image file as *expected image* before running test. But Katalon Studio does not provide any method for you to prepare the *expected image* out of the target web page. Katalon just assumes you can find the *expected image* file somewhere.
3. `WebUI.verifyImagePresent(TestObject expected)` tries to find the expected image *anywhere* one or more times in the target web page. You can not specify which HTML element to compare against the expected image.

## Solution proposed

[aShot](https://github.com/yandex-qatools/ashot), WebDriver Screenshot utility, enables you to take screenshot of particular HTML element. Also it provides images comparison. My Custom Keyword [`com.kazurayam.ksbackyard.ScreenshotDriver`](Keywords/com/kazurayam/ksbackyard/ScreenshotDriver.groovy) wraps aShot so that you can utilize aShot features in Katalon Studio easily.

## Custom Keywords

### ScreenshotDriver#saveElementImage

#### Description

Takes screenshot of a HTML element in the target web page and store into file

#### Parameters

| Param   | Param Type | Mandatory | Description |
| :----   | :--------- | :-------- | :---------- |
| element | TestObject | Required  | target HTML element to take screenshot of |
| file    | File       | Required  | File into which PNG image is saved into   |

#### Example

- [TC1_saveElementImage](Scripts/TC1_saveElementImage/Script1540974069159.groovy)

```
// save screenshot of Google Logo area
TestObject logoArea = findTestObject('Page_Google/div_logoArea')
File file1 = workdir.resolve('logoArea.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveElementImage'(
	logoArea,
	file1)
```

### ScreenshotDriver#verifyImagesAreSimilar(File, TestObject, ...)

#### Description

Compare actual screenshot of a HTML element in the target web page against the expected PNG file. Difference of 2 images are calculated. If the difference is less than or equal to the given criteria, then verifies images are similar.

#### Parameters

| Param    | Param Type | Mandatory | Description |
| :----    | :--------- | :-------- | :---------- |
| expected | File       | Required  | PNG File to compare HTML element against |
| actual   | TestObject | Required  | target HTML element in the target web page|
| criteriaPercent | Double | Required | e.g. 5.0 percent, if the difference of the actual image and the expected image is less than or equal to criteriaPercent, then PASS, otherwise FAILS |
| snapshotDir | File    | Optional  | default to *&lt;projectDir&gt;*/tmp directory. When FAILED, 3 PNG files will be saved into this directory. These are the snapshots of the expected image, the actual image, and the difference image. The snapshots will NOT be saved when PASSED as default. But you can toggle it ON by calling `ScreenshotDriver.setForceSnapshots(true)` |
| flowControl | [FailureHandling](https://docs.katalon.com/katalon-studio/docs/failure-handling.html) | Optional | default to CONTINUE_ON_FAILURE  |

#### Example

- [TC2_verifyImagesAreSimilar_or_Different(File,TestObject](Scripts/TC2_verifyImagesAreSimilar_or_Different(File,TestObject)/Script1540974076759.groovy)

```
TestObject logoArea = findTestObject('Object Repository/Page_Google/div_logoArea')
File file1 = datadir.resolve('google_logo.png').toFile()
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	file1,
	logoArea,
	3.0,
	workdir.resolve('a').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)
```

Or you can simplify the above code as follows:
```
...
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	file1,
	logoArea,
    3.0)
```

### ScreenshotDriver#verifyImagesAreDifferent(File, TestObject, ...)

#### Description

Compare actual screenshot of a HTML element in the target web page against the expected PNG file. Difference of 2 images are calculated. If the difference is greater than the given criteria, then verifies images are different.

#### Parameters

| Param    | Param Type | Mandatory | Description |
| :----    | :--------- | :-------- | :---------- |
| expected | File       | Required  | PNG File to compare HTML element against |
| actual   | TestObject | Required  | target HTML element in the target web page|
| criteriaPercent | Double | Required | e.g. 5.0 percent, if the difference of the actual image and the expected image is greater than criteriaPercent, then PASS, otherwise FAILS |
| snapshotDir | File    | Optional  | default to *&lt;projectDir&gt;*/tmp directory. When FAILED, 3 PNG files will be saved into this directory. These are the snapshots of the expected image, the actual image, and the difference image. The snapshots will NOT be saved when PASSED as default. But you can toggle it ON by calling `ScreenshotDriver.setForceSnapshots(true)` |
| flowControl | [FailureHandling](https://docs.katalon.com/katalon-studio/docs/failure-handling.html) | Optional | default to CONTINUE_ON_FAILURE  |

#### Example

- [TC2_verifyImagesAreSimilar_or_Different(File,TestObject](Scripts/TC2_verifyImagesAreSimilar_or_Different(File,TestObject)/Script1540974076759.groovy)

```
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	file1,
	logoArea,
	3.0,
	workdir.resolve('c').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)

```

Or you can simplify the above code as follows:
```
...
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	file1,
	logoArea,
    3.0)
```




## How to run the demo
