package code_jam;
import java.util.Scanner;

public class BathroomStalls
	{
		private static BathroomStalls bs[];
		private static int t;
		private int y;
		private int z;
		private int n, k;
		private boolean status[];

		private class ValuesForEachPerson
			{
				private int left[], right[], min[], max[];
				private boolean minMaximal[];

				public ValuesForEachPerson()
					{
						left = new int[n];
						right = new int[n];
						min = new int[n];
						max = new int[n];
						minMaximal = new boolean[n];
						// TODO Auto-generated constructor stub
					}

				private void calculateLeftRight()
					{
						for (int i = 0; i < n; i++)
							{
								if (status[i])
									continue;
								else
									{
										for (int j = i - 1; j >= 0 && !status[j]; j--)
											{
												left[i]++;
											}
										for (int j = i + 1; j < n && !status[j]; j++)
											{
												right[i]++;
											}

									}
							}
						// showLeftRight();

					}

				private void calculateMinMax()
					{
						for (int i = 0; i < n; i++)
							{
								if (status[i])
									continue;
								else
									{
										if (left[i] < right[i])
											{
												max[i] = right[i];
												min[i] = left[i];
											} else
											{
												max[i] = left[i];
												min[i] = right[i];
											}
									}
							}
						// showMinMax();

					}

				private void calculateMinMaximal()
					{
						int maxm = 0;
						for (int i = 0; i < n; i++)
							{
								if (status[i])
									continue;
								else
									{
										if (min[i] > maxm)
											{
												maxm = min[i];
											}

									}
							}
						for (int i = 0; i < n; i++)
							{
								if (status[i])
									minMaximal[i] = false;// that stall is not
								// valid
								else
									{
										if (min[i] == maxm)
											minMaximal[i] = true;// stall valid
										else
											minMaximal[i] = false;
									}
							}
						// showMinMaximalSet();
					}

				private void calculateMinMaximalMax()
					{
						int maxm = 0;
						for (int i = 0; i < n; i++)
							{
								if (!minMaximal[i])
									continue;
								else
									{
										if (max[i] > maxm)
											{
												maxm = max[i];
											}
									}
							}
						for (int i = 0; i < n; i++)
							{
								if (!minMaximal[i])
									continue;
								else
									{
										if (maxm == max[i])
											minMaximal[i] = true;
										else
											minMaximal[i] = false;
									}
							}
						// showMinMaximalMaxSet();

					}

				public void stallCapture()
					{
						for (int i = 0; i < n; i++)
							{
								if (minMaximal[i])
									{
										status[i] = true;
										y = max[i];
										z = min[i];
										// System.out.println("capture seat
										// "+i);
										break;

									}
							}
						// TODO Auto-generated method stub
					}

			}

		ValuesForEachPerson vfek[];

		public void setN(int n)
			{
				this.n = n;
			}

		public void setK(int k)
			{
				this.k = k;
			}

		private void findYZ()
			{
				if (n == k)
					{
						y = 0;
						z = 0;
					} else
					{
						status=new boolean[n];
						vfek = new ValuesForEachPerson[k];

						for (int i = 0; i < k; i++)
							{
								vfek[i] = new ValuesForEachPerson();
								vfek[i].calculateLeftRight();
								vfek[i].calculateMinMax();
								vfek[i].calculateMinMaximal();
								vfek[i].calculateMinMaximalMax();
								vfek[i].stallCapture();
							}
					}

			}

		private static void output()
			{
				for (int i = 0; i < t; i++)
					{
						bs[i].findYZ();
						System.out.printf("Case #%d: %d %d\n", (i + 1), bs[i].y, bs[i].z);
					}
				// TODO Auto-generated method stub

			}

		private static void input()
			{
				Scanner sc;
				sc = new Scanner(System.in);
				t = sc.nextInt();
				bs = new BathroomStalls[t];

				for (int i = 0; i < t; i++)
					{
						bs[i] = new BathroomStalls();
						bs[i].setN(sc.nextInt());
						bs[i].setK(sc.nextInt());
					}
				sc.close();
			}

		public static void main(String args[])
			{
				input();
				output();
			}

	}
