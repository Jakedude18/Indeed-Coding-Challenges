import java.util.*;
import java.io.*;
import java.math.*;

public class Knapsack
{
    // Matrix used for calculations
    public static int[][] mM;
    // Weights
    public static int[] mW;
    // Values
    public static int[] mV;
    // Max weight
    public static int mMax;
    
    // Stores the answer after it is solved
    public static int mAnswer;
    // A list of which items were used in the final answer
    public static boolean[] mUsed;
    
    
    // Reset arrays with a certain length
    public static void reset(int n)
    {
        mW = new int[n];
        mV = new int[n];
        mUsed = new boolean[n];
        mM = new int[n][mMax + 1];
        mAnswer = 0;
    }
    
    // Solve the calculation matrix, the answer will be stored in lower-right
    public static void solve()
    {
        for (int i = 0; i < mW.length; ++i)
        {
            for (int w = 0; w <= mMax; ++w)
            {
                int prev_i = i == 0 ? 0 : i - 1;
                
                // Check if weight of current item will fit into target weight
                if (mW[i] <= w)
                {
                    // The value of the current cell will be the max of
                    // the choice between choosing to use the current item
                    // or not using the current item
                    
                    // If we choose to use the current item, the value of the knapsack
                    // will be the value of the current item plus the max value
                    // of the previous items with however much weight will be left
                    // after choosing this item
                    // (i.e. If we choose an item with a value of 3 and weight of 50,
                    // and the current space in the knapsack is 5,
                    // the value of the knapsack will 50 plus the max value
                    // of the previous items in a knapsack of 2)
                    
                    mM[i][w] = Math.max(mM[prev_i][w], mM[prev_i][w - mW[i]] + mV[i]);
                }
                
                else
                {
                    // If item doesn't fit, don't use it and inherit max from previous items
                    // If we are on item 1, we can't inherit the max, so set the value to 0
                    mM[i][w] = mM[prev_i][w];
                }
            }
        }
        
        mAnswer = mM[mW.length - 1][mMax];
        
        // Do an analysis to record which items were used
        int val = mAnswer;
        int i = mW.length - 1;
        int w = mMax;
        
        while (i >= 0 && val != 0)
        {
            int prev_i = i == 0 ? 0 : i - 1;
            
            // Check to see if previous value is different
            if (mM[prev_i][w] != val)
            {
                // If it is different, then item i was used
                mUsed[i] = true;
                
                // Update values
                val = mM[prev_i][w - mW[i]];
                w = w - mW[i];
                i = prev_i;
            }
            else
            {
                // Just go back 1 item
                i--;
            }
        }
        
        // If item number is negative, then the very first item was used
        if (i < 0)
            mUsed[0] = true;
    }
    
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("file.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x)
        {
            
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
