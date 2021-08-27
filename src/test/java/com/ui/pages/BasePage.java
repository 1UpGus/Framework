package com.ui.pages;

import com.ui.stepdefinitions.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;


public class BasePage {

    public static WebDriver driver;
    //Set timeOutDefault for WebDriverWait
    private static final int timeOutDefault = 30;
    //Set implicit wait for driver
    private static final int implicitWaitDefault = 15;
    //Initialise WebDriverWait variable
    private static WebDriverWait wait;
    //boolean to state whether the default implicit wait is set
    private static boolean isImplicitWaitSet = false;
    private static Logger log = LogManager.getLogger(BasePage.class);


    public BasePage() {
        driver = Hooks.driver;
    }

    public static void waitForDriver() {
        applyDefaultImplicitWait();
        waitForPageToLoad();
    }

    public static void waitForElementToBeVisible(WebElement element) {
        waitForElementToBeVisible(element, true);
    }


    public static void scrollToElement(By by, boolean elementShouldBeTop) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(" + elementShouldBeTop + ");", driver.findElement(by));
    }

    public static void scrollToElement(WebElement element, boolean elementShouldBeTop) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(" + elementShouldBeTop + ");", element);
    }

    public static void scrollToElement(final WebDriver driver, final WebElement Element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public static void waitForElementToBeVisible(By element) {
        wait = new WebDriverWait(driver, 40);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        setWebDriverWait();
    }

    public static void waitForElementToBeVisibleAndClickable(WebElement Element) {
        waitForElementToBeVisible(Element);
        waitForElementToBeClickable(Element);
    }

    public static void inputText(WebElement element, String textToInput) throws Exception {
        log.info("Sending text to element => " + element );
        waitForElementToBeVisibleAndClickable(element);
        if (textToInput.isEmpty()) {
            log.info("Planned text to input was blank, using backspace to delete current content");
            while (!element.getAttribute("value").isEmpty()) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            log.info("Clearing and inputting '" + textToInput + "' to input");
            element.clear();
            log.info("Entering text => '" + textToInput + "'");
            element.sendKeys(textToInput);
        }
    }

    public static void waitForElementToBeVisible(WebElement element, boolean ignoreStaleElement) {
        setWebDriverWait();
        if (ignoreStaleElement) {
            wait.ignoring(StaleElementReferenceException.class);
        }
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitAndMoveWithRetry(WebElement element) {
        waitAndMoveWithRetry(element, false);
    }

    public static void waitAndMoveWithRetry(WebElement element, boolean elementByIsSafeToFindBy) {
        try {
            waitAndMove(element, false);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            log.debug("Element has become stale, retrying...");
            if (elementByIsSafeToFindBy) element = driver.findElement(extractByFromWebElement(element));
            else driver.navigate().refresh();
            waitAndMove(element);
        } catch (TimeoutException e) {
            e.printStackTrace();
            log.debug("Timeout Exception occurred, retrying...");
            waitForPageToLoad();
            waitAndMove(element);
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
            log.debug("Element is not visible, retrying...");
            waitForPageToLoad();
            waitAndMove(element);
        }
    }

    private static void waitAndMove(WebElement element) {
        waitAndMove(element, true);
    }

    public static void moveToWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    private static void waitAndMove(WebElement element, boolean ignoreStaleElement) {
        waitForElementToBeVisible(element, ignoreStaleElement);
        moveToWebElement(element);
    }


    public static void setWebDriverWait() {
        BasePage.wait = new WebDriverWait(driver, timeOutDefault);
    }


    private static WebElement getVisibleElement(By by, WebElement root) {
        int count = 0;
        WebElement uniqueElement = null;
        List<WebElement> elements = root.findElements(by);
        if (elements.size() == 1)
            return elements.get(0).isDisplayed() ? elements.get(0) : null;

        for (WebElement element : elements) {
            try {
                if (element.isDisplayed()) {
                    count += 1;
                    if (uniqueElement == null) uniqueElement = element;
                }
            } catch (Exception e) {
                log.debug("Received error when checking whether element was displayed");
                e.printStackTrace();
            }
        }

        if (count == 0) {
            log.debug("Did not get any elements from list when expected to return 1 visible element");
            return null;
        } else if (count > 1) {
            throw new RuntimeException("Got multiple displayed elements");
        }
        log.debug("Received '" + elements.size() + "' elements to check and returned one visible element");
        return uniqueElement;

    }

    public static WebElement getVisibleElement(By by) {
        return getVisibleElement(by, false);
    }

    private static WebElement getVisibleElement(By by, boolean allowMultiple) {
        removeImplicitWait();
        int count = 0;
        WebElement uniqueElement = null;
        List<WebElement> elements = driver.findElements(by);
        log.info("Found => " + elements.size() + " <= elements with by => " + by + " <= Going to see which ones are visible");
        if (elements.size() == 1)
            try {
                return elements.get(0).isDisplayed() ? elements.get(0) : null;
            } catch (StaleElementReferenceException e) {
                log.info("Received Stale Element after finding 1 visible element with by => " + by + " <= Sending back null");
                return null;
            }

        for (WebElement element : elements) {
            try {
                if (element.isDisplayed()) {
                    count += 1;
                    if (uniqueElement == null) uniqueElement = element;
                }
            } catch (Exception e) {
                log.debug("Received error when checking whether element was displayed");
                e.printStackTrace();
            }
        }

        applyDefaultImplicitWait();

        if (count == 0) {
            log.debug("Did not get any elements from list when expected to return 1 visible element");
            return null;
        } else if (count > 1 && !allowMultiple) {
            throw new RuntimeException("Got multiple displayed elements. I saw => " + elements.size() + " <= of which visible => " + count);
        }
        log.debug("Received '" + elements.size() + "' elements to check and returned one visible element");
        return uniqueElement;

    }


    public static WebElement waitForVisibleElement(By by) throws Exception {
        return waitForVisibleElement(by, false);
    }

    public static WebElement waitForVisibleElement(By by, boolean allowMultiple) throws Exception {

        int retries = 0;
        int msBetweenRetries = 300;
        WebElement visibleElement = getVisibleElement(by, allowMultiple);

        removeImplicitWait();
        while (visibleElement == null && retries <= 60) {
            retries++;
            Thread.sleep(msBetweenRetries);
            try {
                visibleElement = getVisibleElement(by, allowMultiple);
            } catch (StaleElementReferenceException ignored) {
            }
        }
        applyDefaultImplicitWait();
        if (visibleElement == null) {
            log.debug("Did not get any elements from list when expected to return 1 visible element");
            throw new Exception("No elements became visible. " +
                    "Tried for " + (retries * msBetweenRetries) / 1000 + "seconds.");
        } else {
            return visibleElement;
        }
    }

    /**
     * Remove the implicit wait if the method is specifically designed so that an element may or may not exist
     * but is not critical to the goal of the method/test
     */
    public static void removeImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        log.info("Removed Implicit wait. Implicit wait is now set to 0");
        isImplicitWaitSet = false;
    }

    /**
     * @param element pass in type WebElement to extract By from String
     * @return By of type used to find element to begin
     * Should not be passed chained elements, or elements found via findElements
     */
    public static By extractByFromWebElement(WebElement element) {
        log.info("Attempting to retrieve By from WebElement: " + element.toString());
        String byType;
        String byString;

        if (element.toString().contains("Proxy element")) {
            log.info("WebElement has Page-Element Proxy-type By");
            byType = StringUtils.substringBetween(element.toString(), "By.", ":");
        } else {
            log.info("Found generic By");
            byType = StringUtils.substringBetween(element.toString(), "-> ", ":");
        }
        byString = StringUtils.substringAfter(element.toString(), byType + ": ");
        byString = byString.substring(0, byString.length() - 1);

        log.info("Found By of type \"" + byType + "\" with content: \"" + byString + "\"");

        switch (byType) {
            case "xpath":
                return By.xpath(byString);
            case "css selector":
            case "cssSelector":
                return By.cssSelector(byString);
            case "id":
                return By.id(byString);
            case "class name":
            case "className":
                return By.className(byString);
            case "link text":
            case "linkText":
                return By.linkText(byString);
            case "partial link text":
            case "partialLinkText":
                return By.partialLinkText(byString);
            case "name":
                return By.name(byString);
            case "tag name":
            case "tagName":
                return By.tagName(byString);
            default:
                log.warn("Could not find corresponding By for \"" + byType + "\"");
                throw new IllegalArgumentException(byType + " is not an implemented By type.");
        }
    }

    private static void waitAndClick(WebElement element) throws Exception {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            log.info(element + " has become stale...");
            waitForVisibleElement(extractByFromWebElement(element)).click();
            log.info("Successfully re-clicked " + element + " following refresh");
        } catch (NoSuchElementException e) {
            waitForPageToLoad();
            waitForElementToBeClickable(element);
            element.click();
        }
    }

    public static Boolean waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        log.info("Waiting for JS/Jquery to load.....");

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return false;
                }
            }
        };
        try {
            if (wait.until(jQueryLoad)) {
                log.info("Page has finished loading, continuing");
                return true;
            } else {
                log.warn("Did not see jquery returning as active... continuing without error");
                return false;
            }
        } catch (TimeoutException e) {
            log.warn("Received timeout exception waiting for JQuery to load... continuing without error");
            return false;
        }
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOutDefault))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Apply the default Implicit wait to the driver in seconds,
     * this should only be called within the BasePage constructor or if a method is overridden/removed the implicit wait
     */
    public static void applyDefaultImplicitWait() {
        if (isImplicitWaitSet) {
            log.debug("Implicit wait already set, not updating");
            return;
        }
        driver.manage().timeouts().implicitlyWait(implicitWaitDefault, TimeUnit.SECONDS);
        log.info("Applied default implicit wait. Implicit wait is set to " + implicitWaitDefault + " seconds.");
        isImplicitWaitSet = true;
    }


    /**
     * Retry if the element has encountered a stale element exception or Timeout Exception,
     * attempt a moveToElement and retry when it is not visible,
     * otherwise an exception is thrown
     * <p>
     * Override default WebDriverWait to be 15 seconds
     */
    public static void waitAndClickWithRetry(WebElement element) throws Exception {
        waitAndClickWithRetry(element, false);
    }

    public static void waitAndClickWithRetry(WebElement element, boolean elementByIsSafeForFindBy) throws Exception {
        wait = new WebDriverWait(driver, 15);
        applyDefaultImplicitWait();
        try {
            waitAndClick(element);
            try {
                removeImplicitWait();
                log.debug("Clicked on element => '" + element + "'");
                applyDefaultImplicitWait();
            } catch (WebDriverException e) {
                applyDefaultImplicitWait();
                log.debug("Clicked on element within iFrame - continuing without error");
            }
        } catch (TimeoutException e) {
            log.info("Timeout Exception occurred, retrying...");
            waitForPageToLoad();
            log.info("Temporarily increasing WebDriver wait to 40 seconds");
            wait = new WebDriverWait(driver, 40);
            waitAndClick(element);
            log.info("Successfully re-clicked element");
            setWebDriverWait();
        } catch (ElementNotVisibleException e) {
            log.info("Element is not visible, attempting move an click...");
            waitForPageToLoad();
            waitForElementToBeVisible(element);
            waitAndMoveWithRetry(element, elementByIsSafeForFindBy);
            waitAndClick(element);
            log.info("Successfully moved to element and clicked");
        } catch (ElementNotInteractableException e) {
            log.info("Element Click Intercepted occurred." +
                    "Ensure that \"" + element + "\" is visible and has been moved to in order to avoid this exception." +
                    "Attempting move to element and retrying click");
            waitForPageToLoad();
            element = elementByIsSafeForFindBy ? driver.findElement(extractByFromWebElement(element)) : element;
            scrollToElement(driver, element);
            try {
                waitAndClick(element);
            } catch (ElementClickInterceptedException e1) {
                log.warn("Element click was intercepted, scrolling element to bottom and retrying");
                scrollToElement(element, false);
                waitAndClick(element);
            }
            log.info("Successfully re-clicked element");
        }
        setWebDriverWait();
        waitForDriver();
    }

//    public static void waitForElementsToHaveText(By by, WebElement root) {
//        log.info("Going to wait for every element in list of elements to have text");
//        wait.ignoring(StaleElementReferenceException.class);
//        wait.until(driver ->{
//                List<WebElement> elements = root.findElements(by);
//                for (WebElement element : elements) {
//                    log.info("Going to check =>"+element+"<= has text=>"+element.getText());
//                    if(element.getText().isEmpty()) return false;
//                }
//                log.info("all elements have text returning ....");
//                return true;
//            } );
//    }


    public static void waitForElementsToHaveText(By by, WebElement root) {
        log.info("Going to wait for every element in list of elements to have text");
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = root.findElements(by);
                for (WebElement element : elements) {
                    log.info("Going to check =>"+element+"<= has text=>"+element.getText());
                    if(element.getText().isEmpty()) return false;
                }
                log.info("all elements have text returning ....");
                return true;
            } });
    }

}
