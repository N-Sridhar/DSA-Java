package dynamicprogramming;

public class DynamicProgramming {
	/**
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

	public static void main(String[] args) {
		System.out.println("Coin Change: " + coinChange(3, new int[] { 8, 3, 1, 2 }));
	}

}
