package code_jam;

import java.util.Scanner;

public class AlienLanguage
{
	private  static String dic[];
	private String mes,mesWrd[];
	private static int l,d;
	private int match;
	private void setMesWrd()
	{
		mesWrd=new String[l];
		char ch;
		int i;i=0;
		boolean status=false;
		for(int x=0;x<mes.length();x++)
		{
            ch=mes.charAt(x);
            if(ch=='(')
            {
                status=true;
                mesWrd[i]="";
            }
            else if(ch==')')
            {
                status=false;
                i++;
            }
            else if(status)
            {
                mesWrd[i]+=Character.toString(ch);
            }
            else if(Character.isLetter(ch))
            {
                mesWrd[i]=Character.toString(ch);
                i++;
            }


			
		}
	}	
	
	private int matchPattern()
	{
		for(int i=0;i<d;i++)// i_th string of dictionary
		{
			for(int j=0;j<l;j++)//j_th character of that string
			{
				boolean status=false;
				char letter=dic[i].charAt(j);
				for(int k=0;k<mesWrd[j].length();k++)
				{
					if(letter==mesWrd[j].charAt(k))
					{
						status=true;//letter found
						break;
					}
				}
				//if (status)
				//	continue;//check the next letter
				if(!status)
				{
					match--;
					break;//since letter not found, this string cannot be invented, check the next i_th string
				}
			}
		}
		return match;
	}
	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);
		int n;
		l=obj.nextInt();d=obj.nextInt();n=obj.nextInt();
		obj.skip("[\r\n]+");
		AlienLanguage al[]=new AlienLanguage[n];
		for(int i=0;i<n;i++)
		{
			al[i]=new AlienLanguage();
			if(i==0)
			{
				dic =new String[d];
				for(int j=0;j<d;j++)
				{
					dic[j]=obj.nextLine();
				}
			}
			al[i].mes=obj.nextLine();
			al[i].match=d;
		}
		for(int i=0;i<n;i++)
		{
			al[i].setMesWrd();
			//System.out.println();
			System.out.println("Case #"+(i+1)+": "+al[i].matchPattern());
		}
		obj.close();
	}
}