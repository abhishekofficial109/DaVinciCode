package com.abhishek.algorithms.davincicode.arrays.problems;

import java.util.ArrayList;

class Interval {
    int buy;
    int sell;
}

public class StockBuyAndSell {
    public static void main(String args[]){
        int[] A = {100,180,260,310,40,535,695};
        int n=A.length;
        stockBuySell(A,n);
    }
    static void stockBuySell(int price[], int n) {
        ArrayList<Interval> sol = new ArrayList<Interval>();
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (price[i] < price[i - 1]||i+1==n) {
                Interval stock = new Interval();
                stock.buy = start;
                stock.sell = (i+1==n)?i:i - 1;
                start = i;
                sol.add(stock);
            }
        }
        int count = sol.size();
        if (count == 0)
            System.out.println("No Profit");
        else {
            for (Interval interval : sol) {
                System.out.print("(" + interval.buy + " " + interval.sell + ") ");
            }
        }
    }
}
