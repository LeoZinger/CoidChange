import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 * Leetcode 518. Coin Change 2
 * Created by leo.zinger on 5/11/17.
 */
public class CoinChange2 {
    //ArrayList<Integer> _coins;
    //int _totalcoins;

    //constructor

    /*
    int getCoins(int amt) {
        return getCoinNumber(amt, _coins);
    }
    */

    int getCoins (int amt, int [] coins) {
        int coinNumber = 0;
        int remainderAmt = 0;
        //= amt;

        if(amt<=0) {
            return 0;
        }

            Arrays.sort(coins);

        for (int i = coins.length-1; i >= 0; i--){
            while (amt - coins[i] >= 0){
                amt = amt - coins[i];
                coinNumber++;
                System.out.println("added 1 coin(" + coins[i] + "), total=" + coinNumber + " reminder amt=" + amt);
             }
            //remainderAmt = amt + coinArray[i];
            //ArrayList<Integer> _coins = new ArrayList<Integer>(coins(0, i-1));
            int [] remainder_coins = Arrays.copyOfRange(coins, 0, i);
            return coinNumber + getCoins(amt, remainder_coins);
        }

        return -1;
    }

    public static void main (String [] args) {
        int [] coins = {1, 2, 5};
        int billAmt = 83;
        CoinChange2 coinChange2 = new CoinChange2();
        //coinChange2.getCoinNumber(billAmt);

        System.out.println("number of coins{" + Arrays.toString(coins) + "}=" + coinChange2.getCoins(billAmt, coins));

    }
}
