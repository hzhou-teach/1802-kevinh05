//package USACO2018feb;
//4 hours
//1 works and the rest timed out
//Difficulty 10/10
// This one was really difficulty, and I spent almost two hours trying to debug the timeouts and I still can't figure it out.
//I feel like I should've skipped to the next problem. But in the end the problem really challenged me to think and for the first time
//I was able to code less and put some more time into brainstorming.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

class grassPatch implements Comparable<grassPatch>{
	
	public int metersFromStart;
	public int tastiness;
	
	grassPatch(int metersFromStart, int tastiness){
		this.metersFromStart=metersFromStart;
		this.tastiness=tastiness;
	}

	public int compareTo(grassPatch c)
	{
		return tastiness-c.tastiness;
	}

	
}

public class reststops
{

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		
		int L=in.nextInt(); //Length of Trail
		int N=in.nextInt(); //Number of Rest Stops
		int rateOfFarmer=in.nextInt(); //Rate of Farmer Seconds Per Meter
		int rateOfBessie=in.nextInt(); //Rate of Bessie Seconds Per Meter
		grassPatch[] RestStopList=new grassPatch[N]; //List of RestStops
		
		for(int i=0; i<N; i++) {
			RestStopList[i]=new grassPatch(in.nextInt(), in.nextInt());
		}
		
		Arrays.sort(RestStopList);
		//----------------------------------------------------------------------------------------------------------------
		double pFarmer=0; //Position of Farmer
		double pBessie=0; //Position of Bessie
		int numberOfRests=0; //Counts Number Of Times Bessie Stopped
		int tastinessObtained=0; //Tastiness Bessie obtained
		DecimalFormat df=new DecimalFormat("###.###");
		//Cycles through the time
		for(int i=0; i<=(rateOfFarmer*L); i++) {
			
			//if there are no more rest stops to cycle thorugh then break
			if(N-1-numberOfRests<0) {
				break;
			}
			
			if((Double.valueOf(df.format(pBessie))==(double)(RestStopList[N-1-numberOfRests].metersFromStart))
				&&
				(pBessie>pFarmer)) //if Bessie is at a restStop with high amounts of tastiness and She is ahead of Farmer John
			{
				tastinessObtained+=RestStopList[N-1-numberOfRests].tastiness;
			}
			else {
				pBessie+=(1.0/(double)rateOfBessie);
			}
			
			pFarmer+=(1.0/(double)rateOfFarmer);
			
			//if Bessie already moved past the stop then cycle to next stop in the list
			if(pBessie>(double)(RestStopList[N-1-numberOfRests].metersFromStart)) {
				numberOfRests++;
			}
			

			
		
		}
		
		pw.print(tastinessObtained);
		pw.close();
		
		
		

	}

}
