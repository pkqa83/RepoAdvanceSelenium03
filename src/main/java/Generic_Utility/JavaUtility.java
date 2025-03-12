package Generic_Utility;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * Method used to generate and return a random number
	 * @param  boundary
	 * @return randomNo
	 * @throws Throwable
	 * @author Viraj
	 */

	
	public int getRandomNum(int boundary) {
		
		Random ran = new Random();
		int randomNo = ran.nextInt(boundary);
		return randomNo;
		
	}

}
