package code_jam;

import java.util.Scanner;

public class CountingSheep 
{
	private int n;
	private byte count;
	private boolean digits[]=new boolean[10];
	
	public void check()
	{
		if(n==0)
		{
			System.out.println("INSOMNIA");
		}
		else
		{
			int i,temp;
			i=1;temp=n;
			do
			{
				n=i*temp;
				i++;
				//System.out.println(n);
			}while(count()==false);
			System.out.println(n);
		}
		
	}
	

	private boolean count()
	{
		int temp=n;
		while(temp>0&count<10)
		{
			if(digits[temp%10]==false)
			{
				count++;
				digits[temp%10]=true;
			}
			temp/=10;
		}
		if(count==10)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		CountingSheep cs[]=new CountingSheep[t];
		// TODO Auto-generated method stub
		for(int i=0;i<t;i++)
		{
			cs[i]=new CountingSheep();
			cs[i].n=in.nextInt();
			
		}
		
	for(int i=0;i<t;i++)
		{
			System.out.print("Case #"+(i+1)+": ");
			cs[i].check();
		}
		in.close();

	}

}
