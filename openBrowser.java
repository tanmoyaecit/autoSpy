/**
 * 
 */
package AutoHeal;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author info2890
 *
 */
public class openBrowser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
    	    public X509Certificate[] getAcceptedIssuers(){return null;}
    	    public void checkClientTrusted(X509Certificate[] certs, String authType){}
    	    public void checkServerTrusted(X509Certificate[] certs, String authType){}
    	}};

    	// Install the all-trusting trust manager
    	try {
    	    SSLContext sc = SSLContext.getInstance("TLS");
    	    sc.init(null, trustAllCerts, new SecureRandom());
    	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    	} catch (Exception e) {
    	    ;
    	}
    	System.setProperty("webdriver.chrome.driver", "\\\\C:\\AutoSpy\\chromedriver_win32\\chromedriver.exe");
   	 	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://phptravels.org/clientarea.php");
        String command="";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you choice");
        while(!command.equals("end"))
        {
        	System.out.print("Please enter end to continue nahole onno key: "); 
            command = input.nextLine();
            System.out.println();
            String pgaeSource=driver.getPageSource();
            xpathCapture.xpath(pgaeSource);
        }
        input.close();
        driver.close();
	}

}
