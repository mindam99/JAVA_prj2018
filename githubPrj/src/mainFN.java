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
						Vig_Enc();
						System.out.println();
						break;
					case 4:
						Trans_Enc();
						System.out.println();
						break;
					case 5:
						BlockSPN_Enc();
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
						Sub_DecHelper();
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
		System.out.println("S-box is an ordered pair of alphabets for your encryption.");
		System.out.println("Enter random alphabet string for your substitution.");
		char[] Sbox = scanner.nextLine().toUpperCase().toCharArray();

		for(int i = 0; i < index; i++) { // len -> index
			reformedText[i] = Sbox[(int)reformedText[i] - 65];
		}

		for(int i = 0; i < index; i++) { // len -> index
			System.out.print(reformedText[i]);
		}
	}
	public static void Sub_DecHelper() {
		System.out.println("This function does not support complete decryption.\nIt will give you a guide for easier problem solving.");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n<Table of Frequency of Alphabet Appearance>");
		System.out.println("E(12.7%)");
		System.out.println("T(9.1%) / A(8.2%) / O(7.5%) / I(7.0%) / N(6.7%) / S(6.3%) / H(6.1%) / R(6.0%)");
		System.out.println("D(4.3%) / L(4.0%)");
		System.out.println("C(2.8%) / U(2.8%) / M(2.4%) / W(2.3%) / F(2.2%) / G(2.0%) / Y(2.0%)");
		System.out.println("P(1.9%) / B(1.5%) / V(1.0%)");
		System.out.println("K(0.08%) / J(0.02%) / Q(0.01%) / X(0.01%) / Z(0.01%)");
		
		System.out.println("\n<Table of Freuquent Digrams & Trigrams>");
		System.out.println("Use digrams and trigrams for easier decryption.");
		System.out.println("Digram───────────────────────────────────────────────────────┐");
		System.out.println("| TH, HE, IN, ER, AN, RE, ED, ON, ES, ST, EN, AT, TO, NT, HA |");
		System.out.println("| ND, OU, EA, NG, AS, OR, TI, IS, ET, IT, AR, TE, SE, HI, OF |");
		System.out.println("└────────────────────────────────────────────────────────────┘");
		System.out.println("\nTrigram──────────────────────────────────────────────────────┐");
		System.out.println("| THE, ING, AND, HER, ERE, ENT, THA, NTH, WAS, ETH, FOR, DTH |");
		System.out.println("└────────────────────────────────────────────────────────────┘");
		
		System.out.println("Which words / sentences do you want to decrypt?");
		System.out.print(">> ");

		char[] ciphertext = scanner.next().toUpperCase().toCharArray();
		int len = ciphertext.length;
		char[] reformedText = new char[len];
		class Alpha {
			int v;
			char c;
		};
		Alpha[] alphabet = new Alpha[26];
		for(int i = 0; i < 26; i++) {
			alphabet[i] = new Alpha();
			alphabet[i].v = 0;
			alphabet[i].c = (char) ('A' + i);
		}
		
		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)ciphertext[i] && (int)ciphertext[i] <= 90) {
				reformedText[index] = ciphertext[i];
				index++;
			}
		}
		
		for(int i = 0; i < len; i++)
		{
			alphabet[(int)reformedText[i] - 'A'].v++;
		}
		
		Arrays.sort(alphabet, new Comparator<Alpha>() {
			public int compare(Alpha x, Alpha y) {
				if(x.v < y.v) return 1;
				else if(x.v > y.v) return -1;
				else return 0;
			}
		});
		
		Arrays.sort(alphabet, new Comparator<Alpha>() {
			public int compare(Alpha x, Alpha y) {
				if(x.v < y.v) return 1;
				else if(x.v > y.v) return -1;
				else return 0;
			}
		});

		for(int i = 0; i < alphabet.length; i ++)
		{
			System.out.print(alphabet[i].c + " = " + alphabet[i].v + " appearance(s)");
			System.out.println();
		}

		System.out.println(alphabet[0].c + " is likely to be E.");
		for(int i = 1; i < 9; i++) {
			if(i < 8) {
				System.out.print(alphabet[i].c + ", ");
			}
			else if(i == 8) {
				System.out.print(alphabet[i].c + ". ");
			}
		}
		System.out.println("These characters are likely to be secondly frequent alphabets according to statistical characteristics from normal plaintexts.");
		System.out.println("Thus, they are likely to be T, A, O, I, N, S, H, R.");
		System.out.println("During decryption, try to find vowels first and utilize digrams and trigrams actively.\n");
		System.out.println("If " + alphabet[0].c + " is not E, try other cases. In ordinary circumstances, one of the characters in secondly frequent characters' group is highly probable to be E.");
		System.out.println("(Try at least " + alphabet[1].c + ", " + alphabet[2].c + ", " + alphabet[3].c + ", " + alphabet[4].c + ", " + alphabet[5].c + ", " + alphabet[6].c + ", " + alphabet[7].c + ", and " + alphabet[8].c + ".)");
	}
	public static void Vig_Enc() {
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
		
		System.out.println("Which word do you want to use as a key?");
		System.out.println("'ANT' is a proper example for your key.");
		System.out.print(">> ");
		char[] keyword = scanner.nextLine().toUpperCase().toCharArray();
		int keysize = keyword.length;
		int[] keyarr = new int[keyword.length];
		
		for(int i = 0; i < keyarr.length; i++) {
			keyarr[i] = (int) keyword[i] - 'A';
		}
		
		for(int i = 0; i < index; i++) {
			int shift = keyarr[i % keyarr.length];
			reformedText[i] = (char) (((int) reformedText[i] - 'A' + shift) % 26 + 'A');
		}
		
		for(int i = 0; i < index; i++) {
			System.out.print(reformedText[i]);
		}
		System.out.println();
	}
	
	public static void Trans_Enc() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to encrypt?");
		System.out.print(">> ");

		String plaintext = scanner.nextLine();
		plaintext = plaintext.toUpperCase();
		int len = plaintext.length();
		char text[] = plaintext.toCharArray();
		char reformedText[] = new char[len / 5 * 5 + (len % 5 == 0 ? 0 : 5)];

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)text[i] && (int)text[i] <= 90) {
				reformedText[index] = text[i];
				index++;
			}
		}

		switch(index % 5) {
		case 1:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 2] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 3] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 4;
			break;
		case 2:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 2] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 3;
			break;
		case 3:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 2;
			break;
		case 4:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 1;
			break;
		default:
			break;
		}

		int trans[];
		trans = new int [5];
		System.out.println("Decide the order of five characters.");
		System.out.println("Integers 1 to 5 will be appropriate inputs.");
		System.out.print("1 2 3 4 5 will be shifted as... >> ");
		for(int i = 0; i < 5; i++) {
			trans[i] = scanner.nextInt();
		}

		int pairs;
		if(index % 5 == 0) {
			pairs = index / 5;
		}
		else {
			pairs = (index / 5) + 1;
		}

		char charArray[][] = new char [pairs][5];

		int mark = 0;
		for(int i = 0; i < pairs; i++) {
			for(int j = 0; j < 5; j++) {
				charArray[i][j] = reformedText[mark + j];
			}
			mark += 5;
		}
		
		System.out.println("\nThe result is...");
		for(int i = 0; i < pairs; i++) {
			System.out.print(charArray[i][trans[0]-1]);
			System.out.print(charArray[i][trans[1]-1]);
			System.out.print(charArray[i][trans[2]-1]);
			System.out.print(charArray[i][trans[3]-1]);
			System.out.print(charArray[i][trans[4]-1]);
		}
		System.out.println();
	}
	public static void BlockSPN_Enc() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to encrypt?");
		System.out.print(">> ");

		String plaintext = scanner.nextLine();
		plaintext = plaintext.toUpperCase();
		int len = plaintext.length();
		char text[] = plaintext.toCharArray();
		char reformedText[] = new char[len / 5 * 5 + (len % 5 == 0 ? 0 : 5)];

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)text[i] && (int)text[i] <= 90) {
				reformedText[index] = text[i];
				index++;
			}
		}
		
		switch(index % 5) {
		case 1:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 2] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 3] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 4;
			break;
		case 2:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 2] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 3;
			break;
		case 3:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			reformedText[index + 1] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 2;
			break;
		case 4:
			reformedText[index] = (char)((int)(Math.random()*(90 - 65 + 1)) + 65);
			index += 1;
			break;
		default:
			break;
		}
		
		System.out.println("You need to make your own S-box.");
		System.out.println("S-box is an ordered pair of alphabets for your encryption.");
		System.out.println("Enter random alphabet string for your substitution.");
		char[] Sbox = scanner.nextLine().toUpperCase().toCharArray();
		
		int boxsize = index / 5;
		char converter1[] = new char[boxsize];
		for(int i = 0; i < boxsize; i++) {
			converter1[i] = reformedText[i];
		}
		char converter2[] = new char[boxsize];
		for(int i = 0; i < boxsize; i++) {
			converter2[i] = reformedText[i + boxsize];
		}
		char converter3[] = new char[boxsize];
		for(int i = 0; i < boxsize; i++) {
			converter3[i] = reformedText[i + boxsize*2];
		}
		char converter4[] = new char[boxsize];
		for(int i = 0; i < boxsize; i++) {
			converter4[i] = reformedText[i + boxsize*3];
		}
		char converter5[] = new char[boxsize];
		for(int i = 0; i < boxsize; i++) {
			converter5[i] = reformedText[i + boxsize*4];
		}
		
		for(int i = 0; i < boxsize; i++) {
			converter1[i] = Sbox[(int)converter1[i] - 65];
			converter2[i] = Sbox[(int)converter2[i] - 65];
			converter3[i] = Sbox[(int)converter3[i] - 65];
			converter4[i] = Sbox[(int)converter4[i] - 65];
			converter5[i] = Sbox[(int)converter5[i] - 65];
		}
		
		/*
		for(int i = 0; i < boxsize; i++) {
			System.out.print(converter1[i]);
			System.out.print(converter2[i]);
			System.out.print(converter3[i]);
			System.out.print(converter4[i]);
			System.out.print(converter5[i]);
			System.out.println();
		}
		*/
		
		int shiftingOrder[] = new int[5];
		for (int i = 0; i < 5; i++) {
			shiftingOrder[i] = (int)(Math.random()*5 + 1);
			for(int j = 0; j < i; j++) {
				if(shiftingOrder[i] == shiftingOrder[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	//From this part, they are for permutation.
	public static void perm(int[] arr, int pivot) { 
		if(pivot == arr.length) { 
			print(arr); return; 
		} 
		for(int i = pivot; i < arr.length; i++) { 
			swap(arr, i, pivot); 
			perm(arr, pivot + 1); 
			swap(arr, i, pivot); 
		} 
	} 

	public static void swap(int[] arr, int i, int j) { 
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 

	public static void print(int[] arr) { 
		for(int i = 0; i < arr.length; i++) { 
			if(i == arr.length - 1) 
				System.out.println(arr[i]); 
			else 
				System.out.print(arr[i]); 
		} 
	} 
}