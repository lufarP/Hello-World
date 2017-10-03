package code_jam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FashionShow
	{
		private static FashionShow[] fs;
		private static int t;
		private static Scanner sc;
		private static File file;
		private static FileWriter writer;
		private int n, m;
		private char[][] addModels;

		private int points;
		private char[][] grid;

		public static void main(String[] args) throws IOException
			{
				input();
				// TODO Auto-generated method stub
				output();

			}

		private static void output() throws IOException
			{
				file=new File("C:\\Users\\PRAFUL KUMAR\\Desktop\\output.txt");
				
				file.createNewFile();
				writer=new FileWriter(file);
				
				
				for (int i = 0; i < t; i++)
					{
						fs[i].rearrange();
						writer.write("Case #" + (i + 1) + ": " + fs[i].getStylePoints() + " "
								+ fs[i].countAddModels() + "\n");
						//System.out.print("Case #" + (i + 1) + ": " + fs[i].getStylePoints() + " "
						//		+ fs[i].countAddModels() + "\n");
						fs[i].outputModels();
					}
				// TODO Auto-generated method stub
				writer.flush();
				writer.close();
				System.out.println("output.txt file saved at "+file.getAbsolutePath());
			}

		private void outputModels() throws IOException
			{
				int i, j;
				for (i = 0; i < n; i++)
					for (j = 0; j < n; j++)
						{
							if (addModels[i][j] != '.')
								{
									writer.write(addModels[i][j] + " " + (i + 1) + " " + (j + 1) + "\n");
									//System.out.print(addModels[i][j] + " " + (i + 1) + " " + (j + 1) + "\n");
								}
						}
				// TODO Auto-generated method stub

			}

		private int countAddModels()
			{
				int noM = 0;
				int i, j;
				// TODO Auto-generated method stub
				for (i = 0; i < n; i++)
					{
						for (j = 0; j < n; j++)
							{
								if (addModels[i][j] != '.')
									noM++;
							}
					}
				return noM;
			}

		private void rearrange()
			{
				String result;
				int i, j;
				addModels = new char[n][n];
				for (i = 0; i < n; i++)
					{
						for (j = 0; j < n; j++)
							{
								addModels[i][j] = '.';
							}
					}
				for (int k = 1; k < 3; k++)
					{
						for (i = 0; i < n; i++)

							{
								for (j = 0; j < n; j++)
									{

										result = check(i, j);
										if (k == 1)
											setO(result, i, j);
										else
											setPlusX(result, i, j);

									}
							}
					}
			}

		private void setPlusX(String result, int i, int j)
			{
				if (grid[i][j] == '.')
					{
						if (result.charAt(0) != '2' && (result.charAt(1) == '2' || result.charAt(2) == '2'))
							{
								grid[i][j] = '+';
								addModels[i][j] = '+';
							} else if (result.charAt(1) != '2' && result.charAt(2) != '2')
							{
								grid[i][j] = 'x';
								addModels[i][j] = 'x';
							}

					}

			}

		// TODO Auto-generated method stub

		private void setO(String result, int i, int j)
			{
				// TODO Auto-generated method stub
				if (grid[i][j] != 'o')
					{
						if (result.charAt(0) != '2' && result.charAt(1) != '2' && result.charAt(2) != '2')
							{
								grid[i][j] = 'o';
								addModels[i][j] = 'o';
							}
					}

			}

		private String check(int i, int j)
			{
				String result = "" + checkDiagonal(i, j) + checkVertical(i, j) + checkHorizontal(i, j);
				return result;
			}

		private int checkDiagonal(int i, int j)
			{
				int state = 0;
				// TODO Auto-generated method stub
				int row, column;
				for (row = 0; row < n; row++)
					{
						for (column = 0; column < n; column++)
							{
								if ((row == i && column == j) || (grid[row][column] == '.'))
									continue;
								if (row + column == i + j || row - column == i - j)
									{
										if (grid[row][column] != 'x')
											return 2;
										else
											state = 1;
									}
							}

					}
				return state;
			}

		private int checkVertical(int i, int j)
			{
				int state = 0;
				// TODO Auto-generated method stub
				for (int row = 0; row < n; row++)
					{
						if (row == i || grid[row][j] == '.')
							continue;
						else if (grid[row][j] != '+')
							return 2;
						else
							state = 1;
					}

				return state;
			}

		private int checkHorizontal(int i, int j)
			{
				int state = 0;
				for (int column = 0; column < n; column++)
					{
						if (column == j || grid[i][column] == '.')
							continue;
						else if (grid[i][column] != '+')
							return 2;
						else
							state = 1;
					}
				return state;

			}

		private int getStylePoints()
			{
				int i, j;

				for (i = 0; i < n; i++)
					{
						for (j = 0; j < n; j++)
							{
								if (grid[i][j] == 'o')
									points += 2;
								if (grid[i][j] == '+' || grid[i][j] == 'x')
									points += 1;
							}
					}
				return points;
			}

		private static void input()
			{
				sc = new Scanner(System.in);
				t = sc.nextInt();
				fs = new FashionShow[t];
				for (int i = 0; i < t; i++)
					{
						fs[i] = new FashionShow();
						fs[i].n = sc.nextInt();
						fs[i].m = sc.nextInt();
						fs[i].inputModels();
					}
				// TODO Auto-generated method stub
				sc.close();
			}

		private void inputModels()
			{
				char model;
				int r, c;
				int i, j;
				grid = new char[n][n];
				for (i = 0; i < n; i++)
					{
						for (j = 0; j < n; j++)
							grid[i][j] = '.';
					}
				for (i = 0; i < m; i++)
					{
						model = (sc.next()).charAt(0);
						r = sc.nextInt();
						c = sc.nextInt();
						grid[r - 1][c - 1] = model;
					}
				// TODO Auto-generated method stub
			}

		@SuppressWarnings("unused")
		private void printGrid()
			{
				int i, j;
				for (i = 0; i < n; i++)
					{
						for (j = 0; j < n; j++)
							System.out.print(grid[i][j]);
						System.out.println();
					}

			}

	}
