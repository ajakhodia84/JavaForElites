package com.practice.practice.dynamicProgramming;

import java.util.ArrayList;

public class MaxProfit {

	/*
	 * The cost of a stock on each day is given in an array, find the max profit
	 * that you can make by buying and selling in those days. For example, if
	 * the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit
	 * can earned by buying on day 0, selling on day 3. Again buy on day 4 and
	 * sell on day 6. If the given array of prices is sorted in decreasing
	 * order, then profit cannot be earned at all.
	 */

	/*
	 * If array is sorted in ascending order then buy on day 1 and sell on day
	 * arrayLength to get max profit If array is sorted in descending order then
	 * profit will be zero and no trade can happen
	 * 
	 * 
	 */

	// Solution with 1 transaction allowed-using for loop
	// { 100, 50, 180, 260, 350, 40,200, 540, 530, 520, 510, 515 };
	public int stockBuySell1(int[] prices) {

		int minBuyPrice = prices[0];
		int maxProfit = 0;
		int buyDay = 1;
		int sellDay = 1;

		for (int i = 1; i < prices.length; i++) {

			if (minBuyPrice > prices[i]) {
				minBuyPrice = prices[i];
				buyDay = i + 1;
			}
			if ((prices[i] - minBuyPrice) > maxProfit) {
				sellDay = i + 1;
			}
			maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);

		}

		System.out
				.println("Buy day for One Transaction is: " + buyDay + ". Sell Day for one transaction is: " + sellDay);

		return maxProfit;

	}

	// Solution with n transacion aloowed - using for loop
	public int stockBuySell2(int[] prices) {
		int buyDate = 0;
		int sellDate = 0;
		int maxProfit = 0;

		ArrayList<Integer> buyDates = new ArrayList<Integer>();
		ArrayList<Integer> sellDates = new ArrayList<Integer>();

		if (prices[0] < prices[1]) {
			buyDates.add(1);
		}

		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) {
				sellDate++;
			} else {
				int profitForThisTrade = prices[sellDate] - prices[buyDate];
				if (profitForThisTrade > 0) {
					maxProfit += profitForThisTrade;

					buyDates.add(buyDate + 1);
					sellDates.add(sellDate + 1);

				}
				buyDate = i;
				sellDate = i;
			}
		}
		/*
		 * On Last day if the prices is not decreased then add the diff to max
		 * price
		 */
		if (prices[prices.length - 1] - prices[buyDate] > 0) {
			buyDates.add(buyDate + 1);
			sellDates.add(prices.length);
		}
		System.out.println(buyDates.toString());
		System.out.println(sellDates.toString());
		return maxProfit + (prices[prices.length - 1] - prices[buyDate]);
	}

	// Solution with n transacion aloowed and fee applyied on selling - using
	// for loop
	public int stockBuySell3(int[] prices) {
		int buyDate = 0;
		int sellDate = 0;
		int maxProfit = 0;
		int fee = 10;

		ArrayList<Integer> buyDates = new ArrayList<Integer>();
		ArrayList<Integer> sellDates = new ArrayList<Integer>();

		if (prices[0] < prices[1]) {
			buyDates.add(1);
		}

		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) {
				sellDate++;
			} else {
				int profitForThisTrade = prices[sellDate] - prices[buyDate];
				if (profitForThisTrade > 0) {
					maxProfit += profitForThisTrade;

					buyDates.add(buyDate + 1);
					sellDates.add(sellDate + 1);

				}
				buyDate = i;
				sellDate = i;
			}
		}
		// On Last day if the prices is not decreased then add the diff to max
		// price
		if (prices[prices.length - 1] - prices[buyDate] > 0) {
			buyDates.add(buyDate + 1);
			sellDates.add(prices.length);
		}
		System.out.println("Buy dates without fee" + buyDates.toString());
		System.out.println("Sell dates without fee" + sellDates.toString());

		maxProfit = maxProfit + (prices[prices.length - 1] - prices[buyDate]);
		System.out.println("Max profit without fee: " + maxProfit);

		/*
		 * Now reducing the fee amount for per transaction profit and also
		 * removing the profit of transaction and its date where per transaction
		 * profit is less than fee and its adding negative profit to max profit
		 */
		for (int j = 0; j < buyDates.size(); j++) {
			if (prices[sellDates.get(j) - 1] - prices[buyDates.get(j) - 1] - fee <= 0) {
				maxProfit = maxProfit - (prices[sellDates.get(j) - 1] - prices[buyDates.get(j) - 1]);
				buyDates.remove(j);
				sellDates.remove(j);
			} else {
				maxProfit = maxProfit - fee;
			}
		}

		System.out.println("Buy dates with fee" + buyDates.toString());
		System.out.println("Sell dates with fee" + sellDates.toString());

		return maxProfit;
	}

	/*
	 * Solution 4: Solution from PepCoding for unlimited transaction and fee
	 * included
	 */

	public int stockBuySell4(int[] prices) {

		int obsp = -prices[0];
		int ossp = 0;
		int fee = 10;

		for (int i = 0; i < prices.length; i++) {
			int nbsp = 0;
			int nssp = 0;
			if (ossp - prices[i] > obsp) {
				nbsp = ossp - prices[i];
			} else {
				nbsp = obsp;
			}

			if (obsp + prices[i] - fee > ossp) {
				nssp = obsp + prices[i] - fee;
			} else {
				nssp = ossp;
			}

			obsp = nbsp;
			ossp = nssp;
		}
		return ossp;

	}

	/*
	 * Solution 5: Solution from PepCoding for unlimited transaction and 1 day
	 * of cooldown
	 */
	public int stockBuySell5(int[] prices) {
		int obsp = -prices[0];
		int ossp = 0;
		int ocsp = 0;

		for (int i = 1; i < prices.length; i++) {
			int nbsp = 0;
			int nssp = 0;
			int ncsp = 0;

			if (ocsp - prices[i] > obsp) {
				nbsp = ocsp - prices[i];
			} else {
				nbsp = obsp;
			}

			if (obsp + prices[i] > ossp) {
				nssp = obsp + prices[i];
			} else {
				nssp = ossp;
			}

			if (ossp > ocsp) {
				ncsp = ossp;
			} else {
				ncsp = ocsp;
			}

			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}

		return ossp;
	}
	
	//Solution 6: Maximum 2 transaction allowed
	public int stockBuySell6(int[] prices){
		int mpist=0;
		int leastsf=prices[0];
		int[] dpmpisut = new int[prices.length];
		
		for(int i=1; i<prices.length; i++){
			if(prices[i]<leastsf){
				leastsf=prices[i];
			}
			
			mpist=prices[i]-leastsf;
			if(mpist>dpmpisut[i-1]){
				dpmpisut[i]=mpist;
			}else{
				dpmpisut[i]=dpmpisut[i-1];
			}
		}
		
		int mpibt=0;
		int maxat=prices[prices.length-1];
		int[] dpmpibut=new int[prices.length];
		
		for(int j=prices.length-2; j>=0; j--){
			if(prices[j]>maxat){
				maxat=prices[j];
			}
			
			mpibt=maxat-prices[j];
			if(mpibt>dpmpibut[j+1]){
				dpmpibut[j]=mpibt;
			}else{
				dpmpibut[j]=dpmpibut[j+1];
			}
		}
		
		
		int op=0;
		for(int k=0; k<prices.length;k++){
			if(dpmpisut[k]+dpmpibut[k]>op){
				op=dpmpisut[k]+dpmpibut[k];
			}
		}
		
		return op;
	}

	public static void main(String[] args) {
		int[] prices = { 100, 50, 180, 260, 350,340, 550, 510, 550 };
		MaxProfit maxProfit = new MaxProfit();
		System.out.println("Maximum profit for one transaction is: " + maxProfit.stockBuySell1(prices));
		System.out.println();
		System.out.println("Maximum profit for n transaction is: " + maxProfit.stockBuySell2(prices));
		System.out.println();
		System.out.println(
				"Maximum profit for n transaction and with fee on selling is: " + maxProfit.stockBuySell3(prices));
		System.out.println(
				"Maximum profit for n transaction and with fee on selling is: " + maxProfit.stockBuySell4(prices));
		System.out.println(
				"Maximum profit for n transaction and with Cooldown on selling is: " + maxProfit.stockBuySell5(prices));
		System.out.println(
				"Maximum profit for 2 transactions: " + maxProfit.stockBuySell6(prices));

	}

}
