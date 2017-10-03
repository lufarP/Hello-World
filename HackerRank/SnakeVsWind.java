import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakeVsWind
{
   static int arr[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int y = in.nextInt();
        int x = in.nextInt();
         in.close();
        arr=new int[n][n];
        for(int j=0;j<arr.length;j++)
        {
            for(int k=0;k<arr.length;k++)
                arr[j][k]=0;
        }
        int i=0;
        arr[y][x]=++i;
       
        
        while(true)
           
        {
            char c=choice(x,y,d);
            if(c=='b')
                break;
            switch(c)
            {
				case 'n':
					y--;
					arr[y][x] = ++i;
					// System.out.println(++i);
					break;
				case 's':
					y++;
					arr[y][x] = ++i;
					// System.out.println(++i);
					break;
				case 'w':
					x--;
					arr[y][x] = ++i;
					// System.out.println(++i);
					break;
				case 'e':
					x++;
					arr[y][x] = ++i;
					// System.out.println(++i);
					break;
                    
            }
            
        }
        for(int j=0;j<arr.length;j++)
        {
            for(int k=0;k<arr.length;k++)
                System.out.print(arr[j][k]+" ");
            System.out.println();
        }
       
    }
   static char choice(int x,int y,char d)
    {
        if(d=='n')
        {
            if(y!=0 && arr[y-1][x]==0)
                return 'n';
           else if(x!=0 && arr[y][x-1]==0)
                return 'w';
            else if(x!=arr.length-1 && arr[y][x+1]==0)
                return 'e';
          else  if(y!=arr.length-1 && arr[y+1][x]==0)
                return 's';
            else
                return 'b';
        }
     else   if(d=='s')
        {
            if(y!=arr.length-1 && arr[y+1][x]==0)
                return 's';
           else if(x!=0 && arr[y][x-1]==0)
                return 'w';
           else if(x!=arr.length-1 && arr[y][x+1]==0)
                return 'e';
           else if(y!=0 && arr[y-1][x]==0)
                return 'n';
            
            else
                return 'b';
            
            
        }
     else   if(d=='w')
        {
            if(x!=0 && arr[y][x-1]==0)
                return 'w';
            
         else   if(y!=0 && arr[y-1][x]==0)
                return 'n';
            
         else   if(y!=arr.length-1 && arr[y+1][x]==0)
                return 's';
         else    if(x!=arr.length-1 && arr[y][x+1]==0)
                return 'e';
            
            else
                return 'b';
        }
   else     if(d=='e')
        {
            if(x!=arr.length-1 && arr[y][x+1]==0)
                return 'e';
           else  if(y!=arr.length-1 && arr[y+1][x]==0)
                return 's';
            
           else  if(y!=0 && arr[y-1][x]==0)
                return 'n';
           else  if(x!=0 && arr[y][x-1]==0)
                return 'w';
            
            else
                return 'b';
        }
        else
        	HashSet  e=new HashSet<Integer>();
        e.
            return 'b';
    }
}
