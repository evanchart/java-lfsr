import java.util.Scanner;

public class LFSR16 {
	/* In-place string obfuscation */
	public static void lfsr16Obfuscate(byte[] s, int length, short seed_U) {
		int lsb;

		for(int i = 0; i < length; i++) {
			s[i] = (byte)(s[i] ^ Short.toUnsignedInt(seed_U) & 0x00ff);
			lsb = Short.toUnsignedInt(seed_U) & 1;
			seed_U = (short)(Short.toUnsignedInt(seed_U) >> 1);
			if(lsb != 0) {
				seed_U = (short)(Short.toUnsignedInt(seed_U) ^ 0xB400);
			}
		}
	}

	public static void main(String[] args) {
		int n;
		
		System.out.println("Enter message to be obfuscated: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		scanner.close();
		System.out.println("Original message: " + message);
		n = message.length();
		byte[] byteArray = message.getBytes();

		/* Obfuscate the message */
		lfsr16Obfuscate(byteArray, message.length(), (short)0xACE1);
		System.out.print("Obfuscated results (in hex):");
		for(int i = 0; i < n; i++) {
			System.out.println(" %02hhx" + message.charAt(i));
		}
		System.out.println('\n');

		/* Repeat the obfuscation process to retrieve original message */
		lfsr16Obfuscate(byteArray, message.length(), (short)0xACE1);
		System.out.println("Recovered message: " + message);
	}
}