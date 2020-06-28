//package USACO2018feb;
//15 min
//All the test cases work
//Difficulty 1/10
//I thought this problem was very easy and I used this opportunity to learn to use scanner

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class teleportation
{

	public static void main(String[] args) {
		Scanner in = new Scanner(new File("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
	
		
		//input info
		//input info
		int a=in.nextInt();
		int b=in.nextInt();
		int x=in.nextInt();
		int y=in.nextInt();
		
		pw.print(Math.min(    Math.min(Math.abs(a-x)+Math.abs(b-y) , Math.abs(a-y)+Math.abs(b-x)) ,   Math.abs(a-b)   ));
		pw.close();
		
		
		
		

	}

}
