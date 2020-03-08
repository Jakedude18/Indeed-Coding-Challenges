import java.util.*;
import java.io.*;
import java.math.*;

class MazeNode implements Comparable<MazeNode>
{
    public int r, c;
    public int mCost;
    public int mPrevR, mPrevC;

    public MazeNode(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.mCost = -1;
    }

    public int compareTo(MazeNode b)
    {
        return mCost - b.mCost;
    }
}

public class BFSMaze
{
    public static char[][] mMap;
    public static MazeNode[][] mNodes;
    public static PriorityQueue<MazeNode> mQueue;
    public static ArrayList<MazeNode> mDsts;

    private static int[] mOrthR = new int[] { -1, 1, 0, 0 };
    private static int[] mOrthC = new int[] { 0, 0, -1, 1 };

    ///////////////////////////////////////////////////////////////////////////

    // Returns true if the point is in the bounds of the maze
    public static boolean inBounds(int r, int c)
    {
        return
                r >= 0 && r < mMap.length &&
                c >= 0 && c < mMap[0].length;
    }

    // Parse a new maze from the scanner
    public static void parseMaze(Scanner scan, int w, int h)
    {
        // Reset all static variables
        mMap = new char[h][w];
        mNodes = new MazeNode[h][w];
        mQueue = new PriorityQueue<>();
        mDsts = new ArrayList<>();

        for (int r = 0; r < h; ++r)
        {
            String line = scan.nextLine();

            for (int c = 0; c < w; ++c)
            {
                // Setup current cell
                mMap[r][c] = line.charAt(c);
                mNodes[r][c] = new MazeNode(r, c);
            }
        }
    }

    // Reset the node map to its initial state
    public static void reset()
    {
        for (int r = 0; r < mMap.length; ++r)
        {
            for (int c = 0; c < mMap[0].length; ++c)
            {
                // Reset node
                mNodes[r][c] = new MazeNode(r, c);
            }
        }
    }

    // Find the first start symbol in the maze
    public static int[] findStart(char symbol)
    {
        int[] s = new int[2];

        // Just search through the maze
        for (int r = 0; r < mMap.length; ++r)
        {
            for (int c = 0; c < mMap[0].length; ++c)
            {
                if (mMap[r][c] == symbol)
                {
                    s[0] = r;
                    s[1] = c;
                    break;
                }
            }
        }

        return s;
    }

    // Attempt to add a cell to the queue
    public static void addToQueue(int r, int c, int pr, int pc)
    {
        MazeNode node = mNodes[r][c];

        // Quit early if the target node is not valid
        if (!inBounds(r, c) || !isValid(r, c)) return;

        // Calculate the new cost
        int cost = mNodes[pr][pc].mCost + getCost(mNodes[r][c]);

        // If the cost of the target node is negative, or if the current cost is less,
        // then add this to the queue
        if (mNodes[r][c].mCost < 0 || cost < mNodes[r][c].mCost)
        {
            node.mPrevR = pr;
            node.mPrevC = pc;
            node.mCost = cost;

            // Add to queue
            mQueue.add(node);
        }
    }

    // Find all paths from the starting cell to all destination cells
    public static void findPaths(int sr, int sc)
    {
        // Add the first node
        mQueue.add(mNodes[sr][sc]);
        mNodes[sr][sc].mCost = 0;

        while (!mQueue.isEmpty())
        {
            MazeNode node = mQueue.poll();

            // Check if this node is a destination
            if (isGoal(node.r, node.c))
                // Add to the list of destinations
                mDsts.add(node);

            // Attempt to add cells in orthogonal directions
            for (int i = 0; i < 4; ++i)
                addToQueue(node.r + mOrthR[i], node.c + mOrthC[i], node.r, node.c);
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    public static boolean isValid(int r, int c)
    {
        // Change this
        // To determine if a given position is a valid space
        return false;
    }

    public static boolean isGoal(int r, int c)
    {
        // Change this
        // To determine if a given position is a goal (or destination) cell
        return false;
    }

    public static int getCost(MazeNode n)
    {
        // Change this
        // To determine the cost of travelling though a given cell
        // (i.e. travelling to an adjacent cell costs 1, but travelling through wall costs 5)
        return 1;
    }

    ///////////////////////////////////////////////////////////////////////////

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
