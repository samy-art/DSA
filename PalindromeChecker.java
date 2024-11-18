package Palindrome;

import java.util.Scanner;

public class PalindromeChecker 
{
	public static boolean IsPalindrome(String str, int start, int end) 
	{
		if(start>=end)  //termination condition
			return true;
		
		if(str.charAt(start) != str.charAt(end))
			return false;
		
		return IsPalindrome(str,start+1, end-1);  // recursive call
		
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your string: ");
		String input = sc.next().toLowerCase();
		
		if(IsPalindrome(input, 0, input.length()-1))
		{
			System.out.println("the string \"" + input + "\"is a palindrome");
		}
		else System.out.println("the string \"" + input + "\"is not a palindrome");	
		
		sc.close();
	}
}
