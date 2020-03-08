import java.util.*;
import java.io.*;
import java.math.*;

class Region implements Comparable<Region>
{
    int mValue;
    int mNum;
    int mMinr, mMaxr;
    int mMinc, mMaxc;

    public Region(int v)
    {
        mValue = v;
        mNum = 0;
        mMinr = 25;
        mMinc = 25;
        mMaxr = 0;
        mMaxc = 0;
    }

    public void add(int r, int c)
    {
        ++r;
        ++c;
        if (r < mMinr)
            mMinr = r;
        else if (r > mMaxr)
            mMaxr = r;

        if (c < mMinc)
            mMinc = c;
        else if (c > mMaxc)
            mMaxc = c;

        ++mNum;
    }

    public int compareTo(Region b)
    {
        int dist_a = mMinr + mMinc;
        int dist_b = b.mMinr + b.mMinc;

        if (dist_a == dist_b)
            return mMinr - b.mMinr;
        return dist_a - dist_b;
    }
}

public class Topography
{
    public static int[] ortr = { 0, 0, -1, 1 };
    public static int[] ortc = { -1, 1, 0, 0 };

    public static boolean inBounds(int r, int c, int w, int h)
    {
        return
                r >= 0 && r < h &&
                c >= 0 && c < w;
    }

    public static void flood(int[][] m, int r, int c,int v, int new_v, Region region)
    {
        if (!inBounds(r, c, m.length, m[0].length)) return;
        if (m[r][c] != v) return;

        region.add(r, c);
        m[r][c] = new_v;

        for (int i = 0; i < 4; ++i)
        {
            flood(m, r + ortr[i], c + ortc[i], v, new_v, region);
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("topography.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x)
        {
            int w = scan.nextInt();
            int h = scan.nextInt();
            int[][] m = new int[h][w];

            int min = 25, max = 0;

            for (int r = 0; r < h; ++r)
            {
                String line = scan.nextLine();

                for (int c = 0; c < w; ++c)
                {
                    int v = line.charAt(c) - '0';
                    m[r][c] = v;

                    if (v < min)
                        min = v;
                    if (v > max)
                        max = v;
                }
            }

            ArrayList<Region> regions = new ArrayList<>();

            for (int r = 0; r < h; ++r)
            {
                String line = scan.nextLine();

                for (int c = 0; c < w; ++c)
                {
                    if (m[r][c] == min) {
                        Region region = new Region(min);
                        flood(m, r, c, min, -1, region);
                        regions.add(region);
                    }
                    else if (m[r][c] == max)
                    {
                        Region region = new Region(max);
                        flood(m, r, c, max, 10, region);
                        regions.add(region);
                    }
                }
            }

            Collections.sort(regions);

            for (int i=0;i<regions.size();++i)
            {
                Region region = regions.get(i);
                System.out.println(region.mNum + " coordinate(s) with elevation " + region.mValue + " from (" + region.mMinr + ", " + region.mMinc + ") to (" + region.mMinr + ", " + region.mMinc + ")" );
            }

            if (x != times - 1)
                System.out.println();
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
