Comparing Screenshots of WebElement
====

## What is this?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can download it from [Releases](https://github.com/kazurayam/ComparingScreenshotsOfWebElement/releases) page and try on your local PC.

This project was developed using Katalon Studio 5.8.4.

This project proposes a set of Custom Keywords which enable you to test arbitrary HTML elements visually by taking and comparing screenshots in various ways.

## Problem to solve

### What is built-in

Katalon Studio provides only limited range of built-in keywords for testing web pages visually.

1. [`WebUI.verifyImagePresent(TestObject expected)`](https://docs.katalon.com/katalon-studio/docs/webui-verify-image-present.html)
2. [`WebUI.takeScreenshot(File)`](https://docs.katalon.com/katalon-studio/docs/webui-take-screenshot.html)

### Shortages

I can enumerate shortages about the current built-in features for visual testing.

1. I want to take screenshot of a paticular HTML element in a web page. I do not need whole page screenshot. But I can not select HTML element when using  `WebUI.takeScreenshot(File)`; it takes screenshot of viewport.
2. `WebUI.verifyImagePresent(TestObject expected)` requires you to prepare a image file as *expected image* before running test. But Katalon Studio does not provide any method for you to prepare the *expected image*. Katalon just assumes you can find the *expected image* file somewhere. Not helpful enough.
3. `WebUI.verifyImagePresent(TestObject expected)` provides no runtime diagnostics. Therefore it is difficult to find why it PASSED when you expected it to FAIL, or why it FAILED when you expected it to PASS.
4. `WebUI.verifyImagePresent(TestObject expected)` tries to find the expected image *anywhere* in the target page regardless where. You can not specify which HTML element to compare against the expected image.

## Solution proposed

## Custom Keywords

## How to run the demo
