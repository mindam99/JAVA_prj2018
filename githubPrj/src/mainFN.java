import java.util.*;

public class mainFN {
	public static void main(String[] args) {
		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("|Welcome to use this program of Cryptograpgy!|");
		System.out.println("└────────────────────────────────────────────┘");
		
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
					System.out.println("Select the type of cipher.");
					
					System.out.println("1. Shift Cipher (Caesar Cipher)");
					System.out.println("2. Substitution Cipher");
					System.out.println("3. Vigenere Cipher");
					System.out.println("4. Transposition Cipher (key cycle = 5)");
					System.out.println("5. Block Cipher (SPN structure)");
					System.out.println();
					
					System.out.print(">> ");
					int enc_sel = scanner.nextInt();

					switch(enc_sel) {
					case 1:
						Shift_Enc();
						System.out.println();
						break;
					case 2:
						Sub_Enc();
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					case 4:
						System.out.println();
						break;
					case 5:
						System.out.println();
						break;
					default:
						System.out.println("Error!");
						System.out.println("Please select the function again.");
					}
				}
				else if(entercode == 2)
				{
					System.out.println("Select the type of cipher to decrypt the ciphertext appropriately.");
					
					System.out.println("1. Shift Cipher (Caesar Cipher)");
					System.out.println("2. Substitution Cipher");
					System.out.println("3. Vigenere Cipher");
					System.out.println("4. Transposition Cipher");
					System.out.println();
					
					System.out.print(">> ");
					int dec_sel = scanner.nextInt();
					
					switch(dec_sel) {
					case 1:
						Shift_Dec();
						System.out.println();
						break;
					case 2:
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					case 4:
						System.out.println();
						break;
					default:
						
					}
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
				System.out.println("Please select the function again.\n");
				scanner.next();
				continue;
			}
		}
		
		System.out.println("Thank you for using this program.");
		scanner.close();
	}
	
	public static void Shift_Enc() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to encrypt?");
		System.out.print(">> ");

		String plaintext = scanner.nextLine();
		plaintext = plaintext.toUpperCase();
		int len = plaintext.length();
		char text[] = plaintext.toCharArray();
		char reformedText[] = new char[len];

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)text[i] && (int)text[i] <= 90) {
				reformedText[index] = text[i];
				index++;
			}
		}
		
		System.out.println();
		System.out.println("Which integer do you want to use as a key?");
		System.out.print(">> ");
		int key = scanner.nextInt();
		
		System.out.println("The result of Encryption");
		System.out.print(">> ");
		for(int i = 0; i < len; i++) {
			if(Character.isLetter(reformedText[i])) {
				reformedText[i] = (char)(((int)reformedText[i] + key - 65) % 26 + 65);
			}
		}
		for(int j = 0; j < len; j++) {
			System.out.print(reformedText[j]);
		}
		System.out.println();
	}
	public static void Shift_Dec() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to decrypt?");
		System.out.print(">> ");
		
		String ciphertext = scanner.nextLine();
		ciphertext = ciphertext.toUpperCase();
		int len = ciphertext.length();
		char text[] = ciphertext.toCharArray();
		char reformedText[] = new char[len];
		
		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)text[i] && (int)text[i] <= 90) {
				reformedText[index] = text[i];
				index++;
			}
		}
		
		System.out.println();
		System.out.println("The result of Exhaustive Search: ");
		
		for(int i = 1; i < 26; i++) {
			for(int j = 0; j < len; j++) {
				if(Character.isLetter(reformedText[j])) {
					reformedText[j] = (char)(((int)reformedText[j] + 1 - 65) % 26 + 65);
				}
				System.out.print(reformedText[j]);
			}
			System.out.println();
		}
		System.out.println("There will be an answer for your ciphertext.");
		System.out.println("If not, please try again or use other decryption functions.");
	}
	public static void Sub_Enc() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to encrypt?");
		System.out.print(">> ");

		String plaintext = scanner.nextLine();
		plaintext = plaintext.toUpperCase();
		int len = plaintext.length();
		char text[] = plaintext.toCharArray();
		char reformedText[] = new char[len];

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)text[i] && (int)text[i] <= 90) {
				reformedText[index] = text[i];
				index++;
			}
		}

		System.out.println("You need to make your own S-box.");
		System.out.println("Enter random alphabet string for your substitution.");
		char[] Sbox = scanner.nextLine().toUpperCase().toCharArray();

		for(int i = 0; i < len; i++) {
			reformedText[i] = Sbox[(int)reformedText[i] - 65];
		}

		for(int i = 0; i < len; i++) {
			System.out.print(reformedText[i]);
		}
	}
	public static void Sub_Dec() {
		
	}
}

