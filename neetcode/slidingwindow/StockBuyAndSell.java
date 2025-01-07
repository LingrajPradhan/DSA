package datastructures.src.com.neetcode.slidingwindow;

public class StockBuyAndSell {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxProfitProfit(prices));

	}

	static int maxProfitProfit(int[] prices) {

		int maxProfit = 0;

		int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;

            else if (price > minPrice)
                maxProfit = Math.max(price - minPrice, maxProfit);
        }
		return maxProfit;
	}

}
