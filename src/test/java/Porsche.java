

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Porsche {
 // task 1
   WebDriver porsche;
   @Before
   public void before() {
	   WebDriverManager.chromedriver().setup();
	   porsche = new ChromeDriver();
	   porsche.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   porsche.manage().window().maximize();	  
	
	   porsche.get("https://www.porsche.com/usa/modelstart");
   }
	@Test
	public void test() throws InterruptedException {
	//task 2	
		porsche.findElement(By.xpath("//img[@alt='Porsche - 718']")).click();
		
		//task 3
	    String price= porsche.findElement(By.xpath("//div[contains(text(),'From $ 56,900.00*')]")).getText();
	    price = price.substring(7, 13);
	    System.out.println(price);
	
    //task 4    
       porsche.get("https://cc.porsche.com/icc_pcna/ccCall.do?rt=1558205758&screen=1440x900&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");	 
	 
    //task 5
    WebElement total=porsche.findElement(By.xpath("//*[@id='s_iccCca']/div[1]/div[4]/div[1]/span"));
	total.click();
	
	//task 6 
	String basePrice= porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$56,900']")).getText();
    String  bP=basePrice.substring(1);
    System.out.println(bP);
    Assert.assertEquals(price, bP);
      
    // task 7
	String eq=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$0']")).getText(); 
	eq=eq.substring(1);

	String zero="0";
	Assert.assertEquals(zero, eq);
	
	//task 8
    String delivery=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$1,250']")).getText();     
    delivery=delivery.substring(1).replace(",","");
    int dP=Integer.parseInt(delivery);
    System.out.println(dP);
	  
	 String baseprice=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$56,900']")).getText();
		baseprice=baseprice.substring(1).replace(",","");
		int baseP=Integer.parseInt(baseprice);
		
		int totalExpected=dP+baseP;
		System.out.println(totalExpected);
		
		String totalP=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$58,150']")).getText();
		totalP=totalP.substring(1).replace(",", "");
		int totalPrice=Integer.parseInt(totalP);
		System.out.println(totalPrice);
		
		Assert.assertEquals(totalExpected, totalPrice);
  	
		// task 9
		WebElement miamiBlue=porsche.findElement(By.xpath("//span[@style='background-color: rgb(0, 120, 138);']"));
		miamiBlue.click();
 	
		//task 10	
		String eqPrice=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$2,580']")).getText();
     	eqPrice=eqPrice.substring(1,6);
     	System.out.println(eqPrice);
  
		WebElement mBlue=porsche.findElement(By.xpath("//span[@style='background-color: rgb(0, 120, 138);']"));
		mBlue.click();
		String equipPrice=porsche.findElement(By.xpath("//div[@class='tt_row']//div[.='$2,580']")).getText();
        equipPrice=equipPrice.substring(1,6);
        System.out.println(equipPrice);
        
        Assert.assertEquals(eqPrice, equipPrice);
         
        //task 11    
        String eqMBlue=porsche.findElement(By.xpath("//div[@class='tt_row']//div[.='$2,580']")).getText();
        equipPrice=equipPrice.substring(0).replace(",", "");
        int ep=Integer.parseInt(equipPrice);
        System.out.println(ep);
        
        int expectedPrice=ep+dP+baseP;
        System.out.println(expectedPrice);
    
        String totalMiamiBluePrice=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$60,730']")).getText();
        totalMiamiBluePrice=totalMiamiBluePrice.substring(1).replace(",", "");
        int tMbP=Integer.parseInt(totalMiamiBluePrice);
        System.out.println(tMbP);
        
        Assert.assertEquals(expectedPrice, tMbP);
             
        //task 12
        WebElement wheel=porsche.findElement(By.id("s_exterieur_x_MXRD"));
        wheel.click();
   
        String carrera=porsche.findElement(By.xpath("//div[@id='s_exterieur_x_IRA']//div[.='$3,750']")).getText();
        carrera=carrera.substring(1).replace(",", "");
        int carWheel=Integer.parseInt(carrera);
        System.out.println(carWheel);
  
              
        //task 13
        String eprice=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$6,330']")).getText();
        eprice=eprice.substring(1).replace(",", "");
        int e=Integer.parseInt(eprice);
        System.out.println(e);
      
       int wheelPrice=ep+carWheel;
       System.out.println(wheelPrice);
       
 
       
       //task 14
       String totalPrice1=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$64,480']")).getText();
       totalPrice1=totalPrice1.substring(1).replace(",", "");
       int tp=Integer.parseInt(totalPrice1);
       System.out.println(tp);
       
       int tp1=e+dP+baseP;
       System.out.println(tp1);
       Assert.assertEquals(tp, tp1);
 
       //task 15    
       WebElement seats=porsche.findElement(By.xpath("//div[@id='seatGroup_73']//div[@data-camera-command='set_SeatsMemory']"));
       seats.click();

       //task 16 
       String priseSests=porsche.findElement(By.xpath("//div[@class='box']//div[contains(text(),'$2,330')]")).getText();
       priseSests=priseSests.substring(1).replace(",", "");
       int seat=Integer.parseInt(priseSests);
        System.out.println(seat);
       
       int sum=ep+carWheel+seat;
       System.out.println(sum);
           
       //task 17     
       String p=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$8,660']")).getText();
       p=p.substring(1).replace(",", "");
       int equipment=Integer.parseInt(p);
       
       int sum2=equipment+dP+baseP;
       System.out.println(sum2);
       
       String tP=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$66,810']")).getText();
       tP=tP.substring(1).replace(",", "");
       int summ=Integer.parseInt(tP);
       //System.out.println(summ);
      
       Assert.assertEquals(sum2, summ);
    
       //task 18      
       JavascriptExecutor selector1 = (JavascriptExecutor)porsche;
       selector1.executeScript("scroll(0, 2600);");
       Thread.sleep(3000);
       
       //task 19   
       new WebDriverWait(porsche, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IIC_subHdl']"))).click();
       new WebDriverWait(porsche, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']"))).click();
      
       //task 20 
       String carbon=porsche.findElement(By.xpath("//div[@id='vs_table_IIC_x_PEKH']//div[contains(text(),'$1,540')]")).getText();
       carbon=carbon.substring(1).replace(",", "");
       int cBon=Integer.parseInt(carbon);
    
       int eqSe=ep+carWheel+seat+cBon;
       System.out.println(eqSe);
      
       String total1=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$10,200']")).getText();
       total1=total1.substring(1).replace(",", "");
       int t1=Integer.parseInt(total1);
      
       // task 21    
       int total2=baseP+dP+t1;
       System.out.println(total2);
        
       String total3=porsche.findElement(By.xpath("//section[@id='s_iccCca']//div[.='$68,350']")).getText();
       total3=total3.substring(1).replace(",", "");
       int t2=Integer.parseInt(total3);
       //System.out.println(t2);
      
       Assert.assertEquals(total2, t2);
    
       //task 22
   	   JavascriptExecutor performance = (JavascriptExecutor)porsche;
       performance.executeScript("scroll(0, 2300);");
       Thread.sleep(3000);
   	   new WebDriverWait(porsche, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IMG_subHdl']"))).click();;
   	   Thread.sleep(3000); 
   		   
   	   //task 23     
       WebElement per= porsche.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']")); 
      per.click();    
	   JavascriptExecutor selector2 = (JavascriptExecutor) porsche;
       selector2.executeScript("scroll(0, 2300)");
       Thread.sleep(2000);
       String dop=porsche.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']//div[@class='box']//div[@class='pBox']")).getText();
       dop=dop.substring(1).replace(",", "");
       int dope=Integer.parseInt(dop);
              
       //task 24
      JavascriptExecutor selector3 = (JavascriptExecutor)porsche;
      selector3.executeScript("scroll(0, 3100)");
      Thread.sleep(2000);
      WebElement brake=porsche.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450_x_c84_M450_x_shorttext']")); 
      brake.click();   
  
      String brakePrice=porsche.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450']//div[@class='box']//div[@class='pBox']")).getText();
      brakePrice=brakePrice.substring(1).replace(",", "");
      int br=Integer.parseInt(brakePrice);
      
      //task 25 
      int perf=ep+carWheel+seat+cBon+dope+br;
      System.out.println(perf);
      
      //Task 26.
     int everything=baseP+dP+perf;
     System.out.println(everything);
         
     String totalCarP=porsche.findElement(By.xpath("//section[@class='responsive-width-right']//div[contains(text(),'$78,970')]")).getText();
     totalCarP=totalCarP.substring(1).replace(",", "");
     int carTotalP=Integer.parseInt(totalCarP);
    // System.out.println(carTotalP);
    
     Assert.assertEquals(carTotalP,everything);
    
	}   
     @After
  	public void end() {
  	   
  		porsche.quit();
  	}

       
	}

