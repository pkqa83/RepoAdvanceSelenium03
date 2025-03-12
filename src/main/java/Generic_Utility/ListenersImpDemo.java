package Generic_Utility;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Generic_Utility.ListenersImp.class)
public class ListenersImpDemo extends BaseClass {
	
	
	@Test
	public void demo() {		
		Assert.fail("i am failing after login on homepage");
	}

}
