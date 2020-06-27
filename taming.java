//package USACO2018feb;
//25 min
//all ten cases work
//Difficulty 2/10
//I thought this problem was pretty easy but I thought I coul've made the code a bit more organized
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class taming
{

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int N=in.nextInt();
		int[]log = new int[N];
		for(int i=0; i<N; i++) {log[i]=in.nextInt();}
		log[0]=0;
		
		//--------------------------------------------------------------------------------------------
		//Start backwards counting
		int counter=N-1;
		boolean validLog=true;
		outer: while(counter>=0) {
			if(log[counter]>0) {
				counter--;
				while(log[counter+1]>0) {
					if((log[counter]!=(log[counter+1]-1))&&(log[counter]!=-1)) {
						validLog=false;
						break outer;
					}
					log[counter]=log[counter+1]-1;
					counter--;
				}
			}
			else {
				counter--;
			}
		}
		//-------------------------------------------------------------------------------------------------
		//Start counting max and min
		if(validLog==false) {
			pw.print(-1);
		}
		else {
			int max=0;
			int min=0;
			for(int i=0; i<N; i++) {
			if (log[i]==0||log[i]==-1) max++;
			if(log[i]==0)min++;
			}	
			pw.print(min+" "+max);
		}
		pw.close();
	}

}
