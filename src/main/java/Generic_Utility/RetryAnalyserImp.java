package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer{

	int count = 0;
	int retryLimit = 3;

	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count < 3) {
			count++;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	

}
