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
		
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);//coping to system clipboard
		Robot robo = new Robot();//inbuilt class to perform keyboard and mouse actions
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_CONTROL);//press control key
		robo.keyPress(KeyEvent.VK_V);//for pressing v-pasting
		robo.delay(500);
		robo.keyRelease(KeyEvent.VK_CONTROL);//for releasing the enter key
		robo.keyRelease(KeyEvent.VK_V);// for releasing the v(pasting) key
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_ENTER);//press enter key
		robo.keyRelease(KeyEvent.VK_ENTER);//release enter key
		
	}
}
