package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;


public class FileupLoadUtility {
	
	public void fileUpload_sendkeys(WebElement element,String filepath) {
		
		element.sendKeys(filepath);
		
	}

	public void filUpload_roboClass(WebElement element, String filepath) throws AWTException {
		
		element.click();
		StringSelection selection = new StringSelection(filepath);
		
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robo = new Robot();
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.delay(500);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
