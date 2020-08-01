package desafio;

import java.util.Arrays;

public class TestOne {

	public static void main(String[] args) {

		int[] missingNumbers = getMissingNumbers();
		
		for(int i = 0; i < missingNumbers.length; i++ ) {
			System.out.println(missingNumbers[i]);
		}

	}

	private static int[] getMissingNumbers() {
		int count = 0, min = 1, max = 50;
		final int[] arr = { 32, 47, 41, 7, 47, 9, 36, 32, 20, 15, 11, 9, 6, 37, 9, 39, 45, 29, 29, 19, 28, 21, 50, 19, 43 };
		int[] saveNumbers = new int[max];

		for (int j = min; j <= max; j++) {
			boolean notExists = false;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == j) {
					break;
				}
				if (i == (arr.length-1))
					notExists = true;
			}
			
			if (notExists) {
				System.out.println("position: " + count + " / number: " + j);
				saveNumbers[count] = j;
				count++;
				notExists = false;
			}
		}
		
		saveNumbers = Arrays.copyOf(saveNumbers , count);

		return saveNumbers;
	}
}
