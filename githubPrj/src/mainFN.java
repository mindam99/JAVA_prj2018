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
					System.out.println("3. Vigenere Cipher (with key)");
					System.out.println("4. Vigenere Cipher (simple Kasiski Examination)");
					System.out.println("5. Transposition Cipher (key cycle = 5)");
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
						Vig_Dec_Key();
						System.out.println();
						break;
					case 4:
						Vig_DecHelper();
						System.out.println();
						break;
					case 5:
						Trans_Dec();
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
	public static void Vig_DecHelper() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("This command is for simple Kasiski examination.");
		System.out.println("Use it only when your ciphertext is long enough.");
		System.out.println("Input your ciphertext.");
		System.out.print(">> ");

		char[] ciphertext = scanner.next().toUpperCase().toCharArray();
		int len = ciphertext.length;
		char[] reformedText = new char[len];
		int [] alphabet = new int[26];

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)ciphertext[i] && (int)ciphertext[i] <= 90) {
				reformedText[index] = ciphertext[i];
				index++;
			}
		}

		System.out.println("Please input a possible integer for key length.");
		System.out.print(">> ");
		int keylen = scanner.nextInt();
		
		int separate = reformedText.length / keylen;
		int mark = reformedText.length % keylen;
		int[] nums1 = new int[26];
		double sum1 = 0;
		int[] nums2 = new int[26];
		double sum2 = 0;
		
		for(int i = 0; i < index; i++) {
			if(i % keylen == 0) {
				if((int) reformedText[i] == 'A') nums1[0]++;
				else if((int) reformedText[i] == 'B') nums1[1]++;
				else if((int) reformedText[i] == 'C') nums1[2]++;
				else if((int) reformedText[i] == 'D') nums1[3]++;
				else if((int) reformedText[i] == 'E') nums1[4]++;
				else if((int) reformedText[i] == 'F') nums1[5]++;
				else if((int) reformedText[i] == 'G') nums1[6]++;
				else if((int) reformedText[i] == 'H') nums1[7]++;
				else if((int) reformedText[i] == 'I') nums1[8]++;
				else if((int) reformedText[i] == 'J') nums1[9]++;
				else if((int) reformedText[i] == 'K') nums1[10]++;
				else if((int) reformedText[i] == 'L') nums1[11]++;
				else if((int) reformedText[i] == 'M') nums1[12]++;
				else if((int) reformedText[i] == 'N') nums1[13]++;
				else if((int) reformedText[i] == 'O') nums1[14]++;
				else if((int) reformedText[i] == 'P') nums1[15]++;
				else if((int) reformedText[i] == 'Q') nums1[16]++;
				else if((int) reformedText[i] == 'R') nums1[17]++;
				else if((int) reformedText[i] == 'S') nums1[18]++;
				else if((int) reformedText[i] == 'T') nums1[19]++;
				else if((int) reformedText[i] == 'U') nums1[20]++;
				else if((int) reformedText[i] == 'V') nums1[21]++;
				else if((int) reformedText[i] == 'W') nums1[22]++;
				else if((int) reformedText[i] == 'X') nums1[23]++;
				else if((int) reformedText[i] == 'Y') nums1[24]++;
				else if((int) reformedText[i] == 'Z') nums1[25]++;
			}
		}
		for(int i = 0; i < 26; i ++) {
			if(nums1[i] > 1) {
				nums1[i] = nums1[i]*(nums1[i] - 1);
				sum1 += nums1[i];
			}
			else {
				nums1[i] = 0;
				sum1 += nums1[i];
			}
		}
		if(mark != 0)
		{
			sum1 = (double)(sum1 / ((separate + 1) * separate));
		}
		else{
			sum1 = (double)(sum1 / separate * (separate - 1));
		}
		
		for(int i = 0; i < index; i++) {
			if(i % keylen == 0) {
				if((int) reformedText[i] == 'A') nums2[0]++;
				else if((int) reformedText[i] == 'B') nums2[1]++;
				else if((int) reformedText[i] == 'C') nums2[2]++;
				else if((int) reformedText[i] == 'D') nums2[3]++;
				else if((int) reformedText[i] == 'E') nums2[4]++;
				else if((int) reformedText[i] == 'F') nums2[5]++;
				else if((int) reformedText[i] == 'G') nums2[6]++;
				else if((int) reformedText[i] == 'H') nums2[7]++;
				else if((int) reformedText[i] == 'I') nums2[8]++;
				else if((int) reformedText[i] == 'J') nums2[9]++;
				else if((int) reformedText[i] == 'K') nums2[10]++;
				else if((int) reformedText[i] == 'L') nums2[11]++;
				else if((int) reformedText[i] == 'M') nums2[12]++;
				else if((int) reformedText[i] == 'N') nums2[13]++;
				else if((int) reformedText[i] == 'O') nums2[14]++;
				else if((int) reformedText[i] == 'P') nums2[15]++;
				else if((int) reformedText[i] == 'Q') nums2[16]++;
				else if((int) reformedText[i] == 'R') nums2[17]++;
				else if((int) reformedText[i] == 'S') nums2[18]++;
				else if((int) reformedText[i] == 'T') nums2[19]++;
				else if((int) reformedText[i] == 'U') nums2[20]++;
				else if((int) reformedText[i] == 'V') nums2[21]++;
				else if((int) reformedText[i] == 'W') nums2[22]++;
				else if((int) reformedText[i] == 'X') nums2[23]++;
				else if((int) reformedText[i] == 'Y') nums2[24]++;
				else if((int) reformedText[i] == 'Z') nums2[25]++;
			}
		}

		for(int i = 0; i < 26; i ++) {
			if(nums2[i] > 1) {
				nums2[i] = nums2[i]*(nums2[i] - 1);
				sum2 += nums2[i];
			}
			else {
				nums2[i] = 0;
				sum2 += nums2[i];
			}
		}
		if(mark != 0)
		{
			sum2 = (double)(sum2 / ((separate + 1) * separate));
		}
		else{
			sum2 = (double)(sum2 / separate * (separate - 1));
		}
		
		double sum = (sum1 + sum2) / 2;
		if(sum >= 0.06) {
			System.out.println(keylen + " is appropriate key length for this ciphertext.");
		}
		else if (sum <= 0.04) {
			System.out.println(keylen + " is inappropriate key length for this ciphertext.");
		}
	}
	public static void Vig_Dec_Key() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which words / sentences do you want to decrypt?");
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

		System.out.print("Key >> ");
		char[] keyword = scanner.nextLine().toUpperCase().toCharArray();
		int keysize = keyword.length;
		int[] keyarr = new int[keyword.length];

		for(int i = 0; i < keyarr.length; i++) {
			keyarr[i] = (int) keyword[i] - 'A';
		}

		for(int i = 0; i < index; i++) {
			int shift = keyarr[i % keyarr.length];
			if((int) reformedText[i] - shift >= 65) {
				reformedText[i] = (char) ((int) reformedText[i] - shift);
			}
			else if ((int) reformedText[i] - shift < 65) {
				reformedText[i] = (char) ('Z' - (65 - (int) reformedText[i] + shift - 1));
			}
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
	public static void Trans_Dec() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input charaters");

		char[] ciphertext = scanner.next().toUpperCase().toCharArray();
		int len = ciphertext.length;
		char[] reformedText = new char[len];
		int [] alphabet = new int[26];

		class Perm {
			int[][] perm;
			int perm_pos;
			int[] input;

			Perm(int[] input) {
				perm = new int[120][];
				perm_pos = 0;
				this.input = input;
			}

			int[] get_permutation(int n) {
				return perm[n];
			}

			void permute() {
				permute(0);
			}

			void permute(int start) {
				if(start == input.length) {
					perm[perm_pos] = new int[start];
					for(int i = 0; i < start; i++) {
						perm[perm_pos][i] = input[i];
					}
					perm_pos++;
				}
				else {
					for(int i = start; i < input.length; i++) {
						int tmp = input[i];
						input[i] = input[start];
						input[start] = tmp;

						permute(start + 1);

						tmp = input[i];
						input[i] = input[start];
						input[start] = tmp;
					}
				}
			}
		}

		int[] tarr = new int[5];
		for(int i = 0; i < 5; i++)
			tarr[i] = i;
		Perm perm = new Perm(tarr);
		perm.permute();

		int index = 0;
		for(int i = 0; i < len; i++) {
			if(65 <= (int)ciphertext[i] && (int)ciphertext[i] <= 90) {
				reformedText[index] = ciphertext[i];
				index++;
			}
		}

		int pairs;
		pairs = index / 5;

		char charArray[][] = new char [pairs][5];


		int mark = 0;
		for(int i = 0; i < pairs; i++) {
			for(int j = 0; j < 5; j++) {
				charArray[i][j] = reformedText[mark + j];
			}
			mark += 5;
		}

		for(int k = 0; k < 120; k++) {
			int trans[];
			trans = perm.get_permutation(k);
			mark = 0;
			for(int i = 0; i < pairs; i++) {
				for(int j = 0; j < 5; j++) {
					System.out.print(charArray[i][trans[j]]);
				}

			}
			System.out.println();
		}
	}
}