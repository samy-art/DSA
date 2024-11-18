package Matrices;

import java.util.Scanner;

public class MagicSquare 
{
	public static void MagicSquareImp(int n) 
	{
		int magicsquare[][] = new int[n][n];
		int num = 1;
		int row = 0;
		int column = n/2;
		
		while(num<=n*n) 
		{
			magicsquare[row][column]=num;
			num++;
			
			int newRow = (row - 1 + n) % n;
			int newColumn = (column + 1) % n;
			
			if(magicsquare[newRow][newColumn] !=0) // if already filled
			{
				row = (row + 1) % n;
				
			}else 
			{
				row = newRow;
				column = newColumn;
			}
			
		}
		
		 System.out.println("Magic Square of size " + n + ":");
	        for (int i = 0; i < n; i++) 
	        {
	            for (int j = 0; j < n; j++)
	            {
	                System.out.print(magicsquare[i][j] + "\t");
	            }
	            System.out.println();
	        }
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the odd numbers for size of Magic Square: ");
		int size = sc.nextInt();
		MagicSquareImp(size);
		sc.close();
		
	}
}
