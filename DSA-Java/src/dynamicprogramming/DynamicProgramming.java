package dynamicprogramming;

import java.util.*;

public class DynamicProgramming {
	/**
	 * Coin Change.
	 * 
	 * @param amount: 3
	 * @param coins:  {8, 3, 1, 2}
	 * 
	 * 
	 * @return 3: {1, 1, 1}, {1, 2} and {3}.
	 * 
	 */
	static int coinChange(int amount, int[] coins) {

		int[] combinations = new int[amount + 1];
		combinations[0] = 1;

		for (int coin : coins) {
			for (int amt = 0; amt < combinations.length; amt++) {
				if (amt >= coin) {
					combinations[amt] += combinations[amt - coin];
				}
			}
		}

		return combinations[amount];
	}

	/**
	 * Chocolate Equal Distribution at minimal steps.
	 * 
	 * @param current distribution [2, 2, 3, 7]
	 * 
	 * @return minimum steps: 2
	 * 
	 *         1, 2 and 5 can be distributes at a time except 1.
	 * 
	 *         Add 1 to all but not 3rd -> [3, 3, 3, 8] Add 5 to all but not 4th ->
	 *         [8, 8, 8, 8]
	 * 
	 */
	static int equals(int[] arr) {

		int[] pos = new int[5];

		int min = Arrays.stream(arr).min().getAsInt();

		for (int i = 0; i < pos.length; i++) {
			for (int a : arr) {
				int diff = a - min;
				pos[i] += diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
			}
			min--;
		}
		return Arrays.stream(pos).min().getAsInt();
	}

	public static void main(String[] args) {
		System.out.println("Coin Change: " + coinChange(3, new int[] { 8, 3, 1, 2 }));
		System.out.println("Equals: " + equals(new int[] { 2, 2, 3, 7 }));
	}

}
