package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 3, 1, 5);
		List<String> stringList = Arrays.asList("Sridhar", "Nallasamy", "Sridhar");

		/**
		 * To get count of values.
		 */
		Map<Integer, Long> numCount = numList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		numCount.forEach((num, count) -> System.out.println(num + " - " + count));
		Map<String, Long> stringCount = stringList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		stringCount.forEach((str, count) -> System.out.println(str + " - " + count));
	}

}
