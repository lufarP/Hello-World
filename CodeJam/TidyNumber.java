package code_jam;

import java.util.Scanner;

public class TidyNumber
	{
		private String s;
		private String tidy;
		static int t;
		private static TidyNumber tn[];

		public static void main(String[] args)
			{

				input();
				output();
			}

		private static void input()
			{

				Scanner in = new Scanner(System.in);
				t = in.nextInt();
				tn = new TidyNumber[t];
				for (int i = 0; i < t; i++)
					{
						tn[i] = new TidyNumber();
						tn[i].s = in.next();
					}

				in.close();
			}

		private static void output()
			{
				for (int i = 0; i < t; i++)
					{
						tn[i].calculateTidy();
						System.out.printf("Case #%d: %s\n", (i + 1), tn[i].getTidy());
					}

			}

		private void calculateTidy()
			{
				char tidyTemp[] = s.toCharArray();

				for (int i = tidyTemp.length - 1; i > 0; i--)
					{
						if ((int) tidyTemp[i] < (int) tidyTemp[i - 1])
							{
								for (int j = i; j < tidyTemp.length; j++)
									tidyTemp[j] = '9';
								tidyTemp[i - 1]--;
							}

					}
				tidy = new String(tidyTemp);
			}

		private String getTidy()
			{
				if (tidy.charAt(0) == '0' && tidy.length() != 1)
					tidy = tidy.substring(1);
				return tidy;
			}
	}
