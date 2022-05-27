package hall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Refactored fan pull code to implement the State Pattern
 * Author: Joshua Hall (10787004)
 * Last Modified: 4/7/2022
 */
public class App 
{
    public static void main(String[] args) {
        final int MAX_CNT = 8;  //number of cycles for test

        //instantiate fan class
        FanPullChain chain = new FanPullChain();
        for (int testCnt = 1; testCnt <= MAX_CNT; testCnt++)

        {
            System.out.print("Press ENTER");
            getLine();
            chain.pull();
        }

    }

    // output status on fan states
    static void getLine() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
