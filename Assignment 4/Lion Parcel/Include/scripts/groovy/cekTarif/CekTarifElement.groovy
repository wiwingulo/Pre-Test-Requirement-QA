package cekTarif
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

import com.kms.katalon.core.mobile.keyword.internal.AndroidUIAutomator
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.By;

class CekTarifElement {

	def getResourceIdText(String resourceId, String text) {
		return findTestObject('Object Repository/Resource ID and Text', [('resource-id'):'com.lionparcel.services.consumer:id/'+resourceId, ('text'):text])
	}

	def getResourceId(String resourceId) {
		return findTestObject('Object Repository/Resource ID', [('resource-id'):'com.lionparcel.services.consumer:id/'+resourceId])
	}

	def getText(String text) {
		return findTestObject('Object Repository/Text', [('text'):text])
	}
	
	def getContentDesc(String contentDesc) {
		return findTestObject('Object Repository/Content-desc', [('content-desc'):contentDesc])
	}

	@Given("User open Lion Parcel app (.*)")
	def openAppLionParcel(String path) {
		Mobile.startExistingApplication(path, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()
}

	@When("User click 'Cek Tarif' menu")
	def clickCekTarif() {
		Mobile.tap(getResourceIdText('txtTitle', "Cek Tarif"), 0)
		String toolbarTitle = Mobile.getText(getResourceIdText('txtToolbarTitle', 'Cek Tarif'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyMatch(toolbarTitle, "Cek Tarif", false, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()
	}

	@And("User fill Asal (.*) and Tujuan (.*)")
	def fillAsalandTujuan(String asal, String tujuan) {
		Mobile.tap(getResourceId('tlOriginAddress'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.setText(getResourceId("edtRouteSearch"), asal, 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(getResourceId('llOriginRoute'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()
		Mobile.tap(getResourceId('edtDestinationAddress'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.setText(getResourceId("edtRouteSearch"), tujuan, 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()
	}

	@And("User click 'Cek Tarif' button")
	def clickCekTarifButton() {
		Mobile.tap(getResourceId('llDestinationRoute'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(getResourceId('btnCheckTariff'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()

	}

	@Then("User verify total rate (.*)")
	def checkTotalRate(String totalRate) {
		Mobile.scrollToText("Total Biaya :", FailureHandling.STOP_ON_FAILURE)
		String getTotalTarif = Mobile.getText(getResourceId('txtTotalTariffEstimation'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyMatch(getTotalTarif, totalRate, false, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot()
		KeywordUtil.logInfo("Total rate matches the test data")
	}
	
	@Then("User verify error message (.*)")
	def verifyErrMsg(String expectedErrorMessage) {
		String actualErrorMessage = Mobile.getText(getResourceId('txtErrorMessage'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyMatch(actualErrorMessage, expectedErrorMessage, false, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("Error message matches the test data")
		Mobile.takeScreenshot()
	}
	
	@When("User click back button")
	def clickBackButton() {
		Mobile.tap(getContentDesc("Navigate up"), 0)
		Mobile.startExistingApplication("com.lionparcel.services.consumer", FailureHandling.STOP_ON_FAILURE)
	}
	
}