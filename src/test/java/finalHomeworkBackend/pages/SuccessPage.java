package finalHomeworkBackend.pages;

import org.openqa.selenium.By;

public class SuccessPage {

    BaseBackendFunction baseBackendFunction;

    private final By SUCCESS_MESSAGE = By.xpath("//div[contains(@class, 'finalTxt')]");

    public String getSuccessText(){
        String successText = baseBackendFunction.getElement(SUCCESS_MESSAGE).getText();
        return successText;
    }
}
