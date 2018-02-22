package utility;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UntrustedCertificate {
	private static DesiredCapabilities cap;
	
	public static DesiredCapabilities getBrowserSSLProfile(String browser) {
		new DesiredCapabilities();
		if(browser.toLowerCase().equals("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		}else if(browser.toLowerCase().equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		}else if(browser.toLowerCase().equals("ie")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		}else if(browser.toLowerCase().equals("safari")) {
			cap = DesiredCapabilities.safari();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		}
		return cap;
	}
}
