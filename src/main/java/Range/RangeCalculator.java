package Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeCalculator {

	public static void buildRanges(int[] values, List<String> ranges) {

		Arrays.sort(values);
		int rangeStart = values[0];
		int lastValue = values[0];
		for (int i = 1; i < values.length; i++) {
			int value = values[i];

			if (value != lastValue + 1 && value != lastValue) {
				// Range ended, wrap it up
				ranges.add(rangeStart + "-" + lastValue);
				rangeStart = value;
			}

			lastValue = value;
		}

		ranges.add(rangeStart + "-" + lastValue);
	}

	public static StringBuilder getAnalogInputReadings(int[] analogReadings) {

		int[] digitalReadings = new int[analogReadings.length];
		for (int i = 0; i < analogReadings.length; i++) {
			digitalReadings[i] = convertIntoDigital((double) analogReadings[i]);
		}
		return getRangeWiseOutputReadings(digitalReadings);
	}

	public static int convertIntoDigital(double analogData) {
		int digitalRate = 0;

		if (analogData > 4094) {
			return -1;
		}
		digitalRate = (int) Math.round(analogData * 10 / 4094);
		return digitalRate;
	}

	public static int getCountOnRange(int[] readings, String range) {

		String[] ranges = range.split("-");

		int lower = Integer.parseInt(ranges[0]);
		int upper = Integer.parseInt(ranges[1]);

		int count = 0;

		for (int number : readings) {
			if (number >= lower && number <= upper) {
				count++;
			}
		}

		return count;
	}

	public static StringBuilder getRangeWiseOutputReadings(int[] readings) {

		Arrays.sort(readings);

		List<String> ranges = new ArrayList<>();

		StringBuilder output = new StringBuilder("Range, Readings");

		buildRanges(readings, ranges);

		for (String range : ranges) {
			output.append("\n" + range + ", " + Integer.toString(getCountOnRange(readings, range)));
		}
		System.out.println("output" + output);
		return output;
	}

}
