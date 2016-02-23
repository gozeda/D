package auto;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HelloWorld {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		Chrome();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testOne() throws Exception {

		driver.findElement(By.id("kw")).sendKeys("google");
		driver.findElement(By.id("su")).click();
		
		String txtExpected = "����";
		String txtActual = driver.findElement(By.xpath("//h3/a[@class='OP_LOG_LINK c-text c-text-public c-text-mult c-gap-icon-left']")).getText();
		System.out.println(txtActual);
		
		Assert.assertEquals(txtExpected, txtActual);
	}

	public void Chrome() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");

		System.out.println("��������Chrome�����...");
		System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("����Chrome�������ɣ�");

		driver.manage().window().maximize();

		driver.get("https://www.baidu.com");
		System.out.println("����ָ��ҳ����ɣ�");
	}
	
}
