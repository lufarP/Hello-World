package code_jam;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct
{
	private int n;
	private long sp,x[],y[];
	public int getN()
	{
		return n;
	}

	public void setN(int n) 
	{
		this.n = n;
	}
	
	private long getSp() 
	{
		sp=0;
		Arrays.sort(x);
		Arrays.sort(y);
		for(int num=0;num<n;num++)
		{
			sp+=x[num]*y[n-1-num];
		}
		return sp;
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		MinimumScalarProduct msp[] = new MinimumScalarProduct[t];
		
		for(int i=0;i<t;i++)
		{
			msp[i]=new MinimumScalarProduct();
			msp[i].setN(sc.nextInt());
			
			msp[i].x=new long[msp[i].n];
			for(int num =0;num<msp[i].n;num++)
			{
				msp[i].x[num]=sc.nextLong();
			}
			
			msp[i].y=new long[msp[i].n];
			for(int num =0;num<msp[i].n;num++)
			{
				msp[i].y[num]=sc.nextLong();
			}
			
		}
		
		for(int i=0;i<t;i++)
		{
			System.out.println("Case #"+(i+1)+": "+msp[i].getSp());
		}
		sc.close();
	}
}

