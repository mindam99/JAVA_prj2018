import java.util.*;

class basicElements_Enc {
	String plaintext;
	int len1 = plaintext.length();
	char text1[] = plaintext.toCharArray();
	char reformedText1[] = new char[len1];
	int index1 = 0;
}

class basicElements_Dec {
	String ciphertext;
	int len2 = ciphertext.length();
	char text2[] = ciphertext.toCharArray();
	char reformedText2[] = new char[len2];
	int index2 = 0;
}

class shiftCipher_Enc extends basicElements_Enc {
	Scanner scanner = new Scanner(System.in);
	for(int a = 0; a < len; a++) {
		System.out.print(reformedText1[a]);
	}
	
	System.out.println();
	System.out.println("Which integer do you want to use as a key?");
	System.out.print(">> ");
	int key = scanner.nextInt();
	
	System.out.println("The result of Encryption");
	System.out.print(">> ");
	for(int b = 0; b < len; b++) {
		if(Character.isLetter(reformedText1[b])) {
			reformedText1[b] = (char)(((int)reformedText1[b] + key - 65) % 26 + 65);
		}
	}
	for(int c = 0; c < len; c++) {
		System.out.print(reformedText1[c]);
	}
}

class shiftCipher_Dec extends basicElements_Dec {
	
}

public class mainFN {
	public static void main(String[] args) {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("|Welcome to use this encoder / decoder!|");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		System.out.println("1. Encryption");
		System.out.println("2. Decryption");
		System.out.println("Enter a number to use these tools.");
		System.out.println("To quit this program, enter a negative number.\n");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Your command >> ");
			try {
				int entercode = scanner.nextInt();
				if(entercode == 1)
				{
					
				}
				else if(entercode == 2)
				{
					
				}
				else if(entercode != 1 && entercode !=2 && entercode>=0)
				{
					System.out.println("Please enter 1 or 2 to use this program.\n");
				}
				else if(entercode < 0)
					break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Warning! It is not an appropriate input!");
				scanner.next();
				continue;
			}
		}
		
		System.out.println("Thank you for using this program.");
		scanner.close();
	}
}

