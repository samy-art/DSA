package Matrices;

import java.util.ArrayList;
import java.util.Scanner;

public class HateOnlyZeroesMatrix
{
	static Scanner sc = new Scanner(System.in);
	public static void HateOnlyZero(int m, int n) 
	{
		int Matrix[][] = new int[m][n]; 
		
		// 1. filling the matrix
		
		System.out.println("Enter the elements of the matrix: ");
		for(int i=0; i<m; i++) 
		{
			for(int j=0; j<n; j++)
			{
				Matrix[i][j] = sc.nextInt();  
			}
		}
		
		// 2. putting zero rows in a separate Arraylist
		
		ArrayList<Integer> zeroRows = new ArrayList<>();
		for(int i=0; i<m; i++)
		{
			boolean isZeroRow = true;
			for(int j=0; j<n; j++)
			{
				if(Matrix[i][j] !=0)
				{
					isZeroRow =false;
					break;
				}
			}
			if(isZeroRow) {
				zeroRows.add(i);
			}
		}
		
		// 3. putting zero columns in an arraylist
		
		ArrayList<Integer> zeroCols = new ArrayList<>();
		for(int j=0; j<n; j++)
		{
			boolean iszeroCol = true;
			for(int i=0; i<m; i++) 
			{
				if(Matrix[i][j] !=0) 
				{
					iszeroCol = false;
					break;
				}
			}
			
			if(iszeroCol) {
				zeroCols.add(j);
			}
		}
		
		// 4. creating another matrix which excludes all zero rows and columns 
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i=0; i<m; i++) 
		{
			if(zeroRows.contains(i))continue;  // skip this row
			ArrayList<Integer> newrow = new ArrayList<>();
			for(int j=0; j<n; j++) 
			{
				if(zeroCols.contains(j))continue;
				newrow.add(Matrix[i][j]);
				
			}
			result.add(newrow);
		}
		
		// 5. Print the resulting matrix
		
        for (ArrayList<Integer> row : result) 
        {
            for (int i = 0; i < row.size(); i++) 
            {
                System.out.print(row.get(i)); // Print each element
                if (i != row.size() - 1)
                {
                    System.out.print(" "); // Print space between elements in the same row
                }
            }
            System.out.println(); // Move to the next row
        }

        sc.close(); // Close the scanner
	}

	public static void main(String[] args)
	{
		System.out.println("Enter index for rows and columns: ");
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		HateOnlyZero(m,n);
		
	}
}
