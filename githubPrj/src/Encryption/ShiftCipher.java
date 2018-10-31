package Encryption;

import java.util.Scanner;

public class ShiftCipher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type your plaintext");
		String sentence = scanner.next();
		System.out.println("Enter your key");
		int key = scanner. nextInt();
		
		char plaintext[] = new char[sentence.length()];
		for(int i = 0; i<plaintext.length; i++)
		{
			plaintext[i] = sentence.charAt(i);
			for(int j = 0; j<plaintext.length; j++)
			{
				if((int)plaintext[i] <= 90)
				{
					
				}
				else if((int)plaintext[i] > 90)
				{
					
				}
			}
		}
		
	}

}
