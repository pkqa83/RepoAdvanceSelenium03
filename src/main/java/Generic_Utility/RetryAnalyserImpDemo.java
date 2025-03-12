package Generic_Utility;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.RetryAnalyserImp;

public class RetryAnalyserImpDemo {

	@Test(retryAnalyzer = RetryAnalyserImp.class)
	public void demo() {
		System.out.println("executing test");
		Assert.fail();
	}
	
}
