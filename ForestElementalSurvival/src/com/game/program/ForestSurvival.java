package com.game.program;

import java.util.Scanner;

public class ForestSurvival {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("WELCOME TO THE FOREST SURVIVAL GAME");
		System.out.println("------------------------------------");
		System.out.print("Enter N : ");
		int n=sc.nextInt();
		sc.nextLine();
		
		char[][] forest=new char[n][n];
		System.out.println("------------------------------------");
		System.out.println("Enter Forest Map : ");
		for(int i=0;i<n;i++) {
			String[] row=sc.nextLine().split(" ");
			for(int j=0;j<n;j++) {
				forest[i][j]=row[j].charAt(0);
			}
		}
		System.out.println("------------------------------------");
		boolean hasShield=false;
		int x=0,y=0;
		String path="";
		while(x<n-1 || y<n-1) {
			char cell=forest[x][y];
			if(cell=='S') {
				hasShield=true;
			}else if (cell=='F' || cell=='W' || cell=='L') {
				if(!hasShield) {
					System.out.println("No Result Found !!");
					return;
				}else {
					hasShield=false;
				}
			}
			else if (cell=='O') {
				System.out.println("No Result Found !!");
				return;
			}
			
			if(y+1<n && forest[x][y+1]!='O') {
				y++;
				path+="R ";
			}
			else if (x+1<n && forest[x+1][y]!='O') {
				x++;
				path+="D ";
			}
			else {
				System.out.println("No Result Found !!");
				sc.close();
				return;
			}
		}
		System.out.println("Path : "+path);
		System.out.println("------------------------------------");
		sc.close();
	}
}