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
| criteriaPercent | Double | Required | e.g. 5.0 percent |
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
| criteriaPercent | Double | Required | e.g. 5.0 percent |
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


### ScreenshotDriver#verifyImagesAreSimilar(TestObject, TestObject, ...)

#### Description

Compare the screenshot of a HTML element in the target web page as actual one against the screenshot of another HTML element in the same page as expected one. Difference of 2 images are calculated. If the difference is less than or equal to the given criteria, then verifies images are similar.

#### Parameters

| Param    | Param Type | Mandatory | Description |
| :----    | :--------- | :-------- | :---------- |
| expected | TestObject | Required  | HTML element in the target web page|
| actual   | TestObject | Required  | HTML element in the target web page|
| criteriaPercent | Double | Required | e.g. 5.0 percent |
| snapshotDir | File    | Optional  | default to *&lt;projectDir&gt;*/tmp directory. When FAILED, 3 PNG files will be saved into this directory. These are the snapshots of the expected image, the actual image, and the difference image. The snapshots will NOT be saved when PASSED as default. But you can toggle it ON by calling `ScreenshotDriver.setForceSnapshots(true)` |
| flowControl | [FailureHandling](https://docs.katalon.com/katalon-studio/docs/failure-handling.html) | Optional | default to CONTINUE_ON_FAILURE  |

#### Example

- [TC3_verifyImagesAreSimilar_or_Different(TestObject,TestObject](Scripts/TC3_verifyImagesAreSimilar_or_Different(TestObject,TestObject)/Script1540974083248.groovy)

```
TestObject logoArea = findTestObject('Object Repository/Page_Google/div_logoArea')

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	logoArea,
	logoArea,
	3.0,
	workdir.resolve('a').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)
```

Or you can simplify the above code as follows:
```
...
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	logoArea,
	logoArea,
	3.0)
```


### ScreenshotDriver#verifyImagesAreDifferent(TestObject, TestObject, ...)

#### Description

Compare the screenshot of a HTML element in the target web page as actual one against the screenshot of another HTML element in the same page as expected one. Difference of 2 images are calculated. If the difference is greater than the given criteria, then verifies images are different.

#### Parameters

| Param    | Param Type | Mandatory | Description |
| :----    | :--------- | :-------- | :---------- |
| expected | TestObject | Required  | HTML element in the target web page|
| actual   | TestObject | Required  | HTML element in the target web page|
| criteriaPercent | Double | Required | e.g. 5.0 percent |
| snapshotDir | File    | Optional  | default to *&lt;projectDir&gt;*/tmp directory. When FAILED, 3 PNG files will be saved into this directory. These are the snapshots of the expected image, the actual image, and the difference image. The snapshots will NOT be saved when PASSED as default. But you can toggle it ON by calling `ScreenshotDriver.setForceSnapshots(true)` |
| flowControl | [FailureHandling](https://docs.katalon.com/katalon-studio/docs/failure-handling.html) | Optional | default to CONTINUE_ON_FAILURE  |

#### Example

- [TC3_verifyImagesAreSimilar_or_Different(TestObject,TestObject](Scripts/TC3_verifyImagesAreSimilar_or_Different(TestObject,TestObject)/Script1540974083248.groovy)

```
TestObject btnK = findTestObject('Object Repository/Page_Google/input_btnK')

TestObject logoArea = findTestObject('Object Repository/Page_Google/div_logoArea')

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	logoArea,
	btnK,
	3.0,
	workdir.resolve('a').toFile(),
	FailureHandling.CONTINUE_ON_FAILURE)
```

Or you can simplify the above code as follows:
```
...
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar'(
	logoArea,
	btnK,
	3.0)
```



## How to run the demo

1. download the zip file of this project from [Realses](https://github.com/kazurayam/ComparingScreenshotsOfWebElement/releases) page
2. unzip it
3. open the project with your Katalon studio

and then

### 4. TC1_saveElementImage

Open `Test Cases/TC1_saveElementImage` and run it. When finished, you will find the screenshot of &lt;div id="lga"&gt; element, which contains the Google Logo graphics, is saved in the  *&lt;projectDir&gt;*/`tmp/TC1` directory.

![logoArea](docs/images/tmp/TC1/logoArea.png)

### 5. TC2_verifyImagesAreSimilar_or_Different(File,TestObject)

Open `Test Cases/TC2_verifyImagesAreSimilar_or_different(File,TestObject)` and run it. This test case will fail. The log was as follows:

```
11-01-2018 04:42:58 PM - [FAILED] - Test Cases/TC2_verifyImagesAreSimilar_or_Different(File,TestObject)
    FAILED because (of) (Stack trace: com.kms.katalon.core.exception.StepFailedException:
		images are expected to be similar but are different, difference=99.35%,
		snapshots were saved in C:\Users\qcq0264\katalon-workspace\ComparingScreenshotsOfWebElement\tmp\TC2\b
	at com.kms.katalon.core.util.KeywordUtil.markFailed(KeywordUtil.java:15)
	at com.kms.katalon.core.util.KeywordUtil$markFailed.call(Unknown Source)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:125)
	at com.kazurayam.ksbackyard.Assert.stepFailed(Assert.groovy:68)
	at com.kazurayam.ksbackyard.Assert.assertTrue(Assert.groovy:27)
	at com.kazurayam.ksbackyard.Assert$assertTrue.call(Unknown Source)
	at com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreSimilar(ScreenshotDriver.groovy:316)
	...
```

You can find the reason why it failed by looking at the snapshots. See the following snapshots.

The expected image is tmp/TC2/b/verifyImagesAreSimilar(File,TestObject).expected.png
![expected](docs/images/tmp/TC2/b/verifyImagesAreSimilar%28File,TestObject%29.expected.png)

The actual image is tmp/TC2/b/verifyImagesAreSimilar(File,TestObject).actual.png
![actual](docs/images/tmp/TC2/b/verifyImagesAreSimilar%28File,TestObject%29.actual.png)

The difference image is
tmp/TC2/b/verifyImagesAreSimilar(File,TestObject).diff(99.35).png
![diff](docs/images/tmp/TC2/b/verifyImagesAreSimilar%28File,TestObject%29.diff%2899.35%29.png)

The expected image and actual image is NOT similar, therefore the test case TC2 fails.


## How to make those Custom Keywords operational in your Katalon projectDir

1. import the jar file of aShot into your Katalon Studio Project. You can download the jar at [Maven Repository](https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot/1.5.4). Or you can reuse the jar [bundled in this project](https://github.com/kazurayam/ComparingScreenshotsOfWebElement/tree/master/Drivers). See Katalon Docs [External Library](https://docs.katalon.com/katalon-studio/docs/external-libraries.html) for operation.
2. Using Katalon Studio GUI, create 2 Groovy class files in the Keywords folder, and copy&paste the source code from this project:
    - [Keywords/com/kazurayam/ksbackyard/Assert](Keywords/com/kazurayam/ksbackyard/Assert.groovy)
    - [Keywords/com/kazurayam/ksbackyard/ScreenshotDriver](Keywords/com/kazurayam/ksbackyard/ScreenshotDriver.groovy)
3. Now you can create your test case. See the following sample codes.
    - [Test Cases/TC1_saveElementImage](Scripts/TC1_saveElementImage/Script1540974069159.groovy)
    - [Test Cases/TC2_verifyImagesAreSimilar_or_Different(File,TestObject)](Scripts\TC2_verifyImagesAreSimilar_or_Different%28File,TestObject%29)
