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

		String txtExpected = "百度一下";
		String txtActual = driver.findElement(By.xpath("//input[@id='su']")).getAttribute("value");
		Thread.sleep(2000);
		Assert.assertEquals(txtExpected, txtActual);
	}

	public void Chrome() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");

		System.out.println("正在启动Chrome浏览器...");
		System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("启动Chrome浏览器完成！");

		driver.manage().window().maximize();

		driver.get("https://www.baidu.com");
		System.out.println("加载指定页面完成！");
	}
	
}
