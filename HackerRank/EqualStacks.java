package hacker_rank;

import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("serial")
class CylinderStack extends Stack<Integer>
	{
		private int heightOfStack;
		private static int heightOfAllStack = 0;

		public int getHeightOfStack()
			{
				return heightOfStack;
			}

		@Override
		public Integer push(Integer item)
			{
				heightOfStack += item;
				return super.push(item);
			}

		@Override
		public synchronized Integer pop()
			{
				Integer removedCylinderOfHeight = super.pop();
				heightOfStack -= removedCylinderOfHeight;
				return removedCylinderOfHeight;

			}

		public static int getHeightOfAllStack()
			{
				return heightOfAllStack;
			}

		protected static void setHeightOfAllStack(int heightOfAllStack)
			{
				CylinderStack.heightOfAllStack = heightOfAllStack;
			}
	}

public class EqualStacks
	{

		public static void main(String[] args)
			{
				CylinderStack stack1, stack2, stack3;
				Scanner sc = new Scanner(System.in);
				int numberOfCylinder[] = new int[3];
				for (int i = 0; i < 3; i++)
					{
						numberOfCylinder[i] = sc.nextInt();
					}
				stack1 = new CylinderStack();
				pushIntoStack(stack1, numberOfCylinder[0], sc);

				stack2 = new CylinderStack();
				pushIntoStack(stack2, numberOfCylinder[1], sc);
				stack3 = new CylinderStack();
				pushIntoStack(stack3, numberOfCylinder[2], sc);
				while(heightIsDissimilar(stack1, stack2, stack3))
					{
						removeCilnderfromStack(stack1, stack2, stack3);
					}
				System.out.println(CylinderStack.getHeightOfAllStack());
			}

		private static void pushIntoStack(CylinderStack stack, int numberOfCylinder, Scanner sc)
			{
				if (numberOfCylinder == 0)
					{
						// do nothing in stack;
					} else if (stack.isEmpty())
					{
						stack.push(sc.nextInt());
						pushIntoStack(stack, numberOfCylinder - 1, sc);
					} else
					{
						int topOftheStack = stack.pop();
						pushIntoStack(stack, numberOfCylinder, sc);
						stack.push(topOftheStack);
					}

			}
		private static boolean heightIsDissimilar(CylinderStack s1,CylinderStack s2,CylinderStack s3)
		{

			int h1,h2,h3;
			h1=s1.getHeightOfStack();
			h2=s2.getHeightOfStack();
			h3=s3.getHeightOfStack();
			if(h1==h2 && h2==h3)
				{
					CylinderStack.setHeightOfAllStack(h1);
					return false;
				}
			else
				return true;
		}

	private static void removeCilnderfromStack(CylinderStack s1,CylinderStack s2,CylinderStack s3)
		{
			int h1,h2,h3;
			h1=s1.getHeightOfStack();
			h2=s2.getHeightOfStack();
			h3=s3.getHeightOfStack();
			 if(!(h1==h2 || h2==h3 || h3==h1))
				{ 
					if(h1>h2 && h1>h3)
						s1.pop();
					else if(h2>h1 && h2>h3)
						s2.pop();
					else 
						s3.pop();
				}
			else
				{
					if(h1==h2)
						{
							if(h1>h3)
								{
									s1.pop();
									s2.pop();
								}
							else
								s3.pop();
						}
					else if(h1==h3)
						{

							if(h1>h2)
								{
									s1.pop();
									s3.pop();
								}
							else
								s2.pop();
							
						}
					else
						{
							if(h3>h1)
								{
									s3.pop();
									s2.pop();
									
								}
							else
								s1.pop();
						}
				}


		}

	}
