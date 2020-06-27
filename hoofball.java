//package USACO2018feb;
//50 min
//1,2,3 works  4,8 timed out 5,6,7,9,10 dindn't work
//Difficulty 6/10
//This problem was a bit tricky and I feel like I missed a case and I felt like I could've spent a way longer time thinking about the problem than actually writing the code.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner; 
public class hoofball
{

	public static void main(String[] args) throws IOException 
	{
		
		Scanner in = new Scanner(new File("hoofball.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		int N=in.nextInt();
		int [] cowPositions=new int [N];
		for(int i=0; i<N; i++) {
			cowPositions[i]=in.nextInt();
		}
		Arrays.sort(cowPositions);
		
		//-------------------------------------------------------------------------------------------------------------------------
		//Counts the number of breaks which is also the answer
		int pointer=0;
		int numberOfBreaks=0;
		
		
		while(true) {
			
		
			//loops for descending
			if(Math.abs(cowPositions[pointer]-cowPositions[pointer+1])>Math.abs(cowPositions[pointer+1]-cowPositions[pointer+2])) {
				if(Math.abs(cowPositions[pointer]-cowPositions[pointer+1])>Math.abs(cowPositions[pointer+1]-cowPositions[pointer+2])) {
					pointer+=2;
					if(pointer+2==N)break;
				}
				while(Math.abs(cowPositions[pointer]-cowPositions[pointer-1])>Math.abs(cowPositions[pointer+1]-cowPositions[pointer])) {
					pointer++;
					if(pointer+2==N)break;
				}
			}
			//loops for ascending
			else {
				if(Math.abs(cowPositions[pointer]-cowPositions[pointer+1])<=Math.abs(cowPositions[pointer+1]-cowPositions[pointer+2])) {
					pointer+=2;
					if(pointer+2==N)break;
				}
				while(Math.abs(cowPositions[pointer]-cowPositions[pointer-1])<=Math.abs(cowPositions[pointer+1]-cowPositions[pointer])) {
					pointer++;
					if(pointer+2==N)break;
				}
				if((cowPositions[pointer]-cowPositions[pointer-1])>(cowPositions[pointer+1]-cowPositions[pointer])) {
					pointer--;
				}
			}
			pointer++;
			numberOfBreaks++;
			if(pointer+2==N) {
				numberOfBreaks++;
				break;
			}
		}
		
		pw.print(numberOfBreaks);
		pw.close();
	}
}
