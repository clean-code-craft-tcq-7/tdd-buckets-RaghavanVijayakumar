package Range;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RangeCalculatorTest {
	
	int arrinput1[]= {4,5,6,9,10,11};

	@Test
	public void testGetRangeWiseReadings() {
		
		int[] testIntegers = {4, 5};
		
		StringBuilder output = new StringBuilder("Range, Readings\n4-5, 2");
		
		assert (RangeCalculator.getRangeWiseOutputReadings(testIntegers).toString().equals(output.toString()));
		
		int[] testIntegers1 = {3, 3, 5, 4, 10, 11, 12};
		
		StringBuilder output1 = new StringBuilder("Range, Readings\n3-5, 4\n10-12, 3");
		
		assert(RangeCalculator.getRangeWiseOutputReadings(testIntegers1).toString().equals(output1.toString()));
	}
	
	@Test
	public void testGetRangeWiseReadingsAnalogInput() {
		
		int[] testIntegers = {1024, 1500, 2048};
		
		StringBuilder output = new StringBuilder("Range, Readings\n3-5, 3");
		
		assert(RangeCalculator.getAnalogInputReadings(testIntegers).toString().equals(output.toString()));
		
		int[] testIntegers1 = {1024, 1500, 2048, 4094, 3700, 3300};
		
		StringBuilder output1 = new StringBuilder("Range, Readings\n3-5, 3\n8-10, 3");
		
		System.out.println(RangeCalculator.getAnalogInputReadings(testIntegers1));
		
		assert(RangeCalculator.getAnalogInputReadings(testIntegers1).toString().equals(output1.toString()));

	}
	
	@Test
	public void testAnalogToDigitalConversion() {
		
		assert(RangeCalculator.convertIntoDigital(1024) == 3);
		assert(RangeCalculator.convertIntoDigital(2048) == 5);
		assert(RangeCalculator.convertIntoDigital(100) == 0);
		assert(RangeCalculator.convertIntoDigital(1146) == 3);
		assert(RangeCalculator.convertIntoDigital(4094) == 10);
		assert(RangeCalculator.convertIntoDigital(4095) == -1);
		
	}
	
	@Test
	public void testGetCountWithRange() {
		assert(RangeCalculator.getCountOnRange(new int[] {1,3,4,5,4,3,2,1}, "1-5") == 8);
		assert(RangeCalculator.getCountOnRange(new int[] {4,5,3,4,5,4,3,10}, "3-5") == 7);
		assert(RangeCalculator.getCountOnRange(new int[] {3,4,5,4,3,1,2}, "3-5") == 5);
		assert(RangeCalculator.getCountOnRange(new int[] {3,4,5,4,3,1,5,8}, "4-6") == 4);
	}
	
	@Test
	public void testGetRangesWithReadings() {
		List<String> ranges = new ArrayList<>();
		RangeCalculator.buildRanges(new int[] {3,4,5,4,3,6,7,8}, ranges);
		assert(ranges.get(0).equals("3-8"));
		List<String> ranges1 = new ArrayList<>();
		RangeCalculator.buildRanges(new int[] {1,2,3,4,5,10,11,12}, ranges1);
		assert(ranges1.get(0).equals("1-5"));
		assert(ranges1.get(1).equals("10-12"));
	}
	

}
