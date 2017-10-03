import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Volcano
	{
		int x, y;
		int weight;

		Volcano(int x, int y, int weight)
			{
				this.x = x;
				this.y = y;
				this.weight = weight;
			}

		void volcanoBurst(int arr[][])
			{
				int spreadWeight = weight;
				arr[x][y] += spreadWeight--;
				int lx, hx, ly, hy;
				lx = x - 1;
				hx = x + 1;
				ly = y - 1;
				hy = y + 1;
				while (spreadWeight > 0)
					{
						// spreadLeft
						for (int i = ly; i <= hy; i++)
							{
								if ((i >= 0) && (i < arr.length) && lx >= 0)
									arr[lx][i] += spreadWeight;
							}
						// spreadRight
						for (int i = ly; i <= hy; i++)
							{
								if ((i >= 0) && (i < arr.length) && hx < arr[0].length)
									arr[hx][i] += spreadWeight;
							}
						// spreadTop
						for (int i = lx + 1; i < hx; i++)
							{
								if ((i >= 0) && (i < arr[0].length) && ly >= 0)
									arr[i][ly] += spreadWeight;
							}
						// spreadBottom
						for (int i = lx + 1; i < hx; i++)
							{
								if ((i >= 0) && (i < arr[0].length) && hy < arr.length)
									arr[i][hy] += spreadWeight;
							}
						lx--;
						ly--;
						hx++;
						hy++;
						spreadWeight--;
					}
			}

	}

public class EruptingVolcanoes
	{
		public static int maximumAffectedArea(int arr[][])
			{
				int max = 0;
				for (int i = 0; i < arr.length; i++)
					{
						for (int j = 0; j < arr.length; j++)
							{
								if (max < arr[i][j])
									max = arr[i][j];
							}
					}
				return max;
			}

		public static void main(String[] args)
			{
				Scanner in = new Scanner(System.in);
				int n = in.nextInt();
				int m = in.nextInt();
				int arr[][] = new int[n][n];

				for (int i = 0; i < arr.length; i++)
					{
						for (int j = 0; j < arr.length; j++)
							{
								arr[i][j] = 0;
							}
					}
				Volcano v[] = new Volcano[m];
				for (int a0 = 0; a0 < m; a0++)
					{
						int x = in.nextInt();
						int y = in.nextInt();
						int w = in.nextInt();
						v[a0] = new Volcano(x, y, w);
						v[a0].volcanoBurst(arr);
					}
				System.out.println(maximumAffectedArea(arr));
				in.close();
			}
	}
