package code_jam;
import java.util.Scanner;

public class OversizedPancakeFlipper
	{
		
		private int count, k;
		private String s;
		private char[] c;
		private static int t;
		private static OversizedPancakeFlipper opf[];

		public static void main(String[] args)
			{
				input();
				output();
				// TODO Auto-generated method stub
			}

		private static void input()
			{
				 Scanner sc;
				sc = new Scanner(System.in);
				t = sc.nextInt();
				opf = new OversizedPancakeFlipper[t];
				for (int i = 0; i < t; i++)
					{
						opf[i] = new OversizedPancakeFlipper();
						opf[i].s = sc.next();
						opf[i].k = sc.nextInt();
					}
				sc.close();
			}

		private static void output()
			{
				for (int i = 0; i < t; i++)
					{
						if (!opf[i].checkIfImpossible())
							System.out.printf("Case #%d: %d\n", (i + 1), opf[i].count);
						else
							System.out.printf("Case #%d: IMPOSSIBLE\n", (i + 1));

					}

			}

		private boolean checkIfImpossible()
			{
				calculateCount();
				
				for (char ch : c)
					{
						if (ch == '-')
							return true;
					}
				return false;
			}

		private void calculateCount()
			{
				c = s.toCharArray();
				for (int i = 0; i <= c.length - k; i++)
					{
						if (c[i] == '+')
							continue;
						else
							{
								count++;
								flip(i);
							}
					}
			}

		private void flip(int i)
			{
				for (int f = i; f < i + k; f++)
					{
						if (c[f] == '+')
							c[f] = '-';
						else
							c[f] = '+';
					}
			}
	}
