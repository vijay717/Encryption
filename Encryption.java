import java.util.Scanner;
public class Encryption
{
	Scanner reader = new Scanner(System.in);
	public Encryption()
	{
		String key = "passwordusernameandsuch";
		System.out.print("Enter text to be encrypted: ");
		String text = reader.nextLine();
		System.out.println();
		encrypt(text, key);
		System.out.print("Enter text to be dercypted: ");
		text = reader.nextLine();
		System.out.println();
		decrypt(text, key);
	}

	public void encrypt(String plainText, String k)
	{
		int cipherValue = 0;
		char cipher = 'a';
		for(int i = 0; i < plainText.length(); i++)
		{
			char letter = plainText.charAt(i);
			if(Character.isLowerCase(letter))
			{
				cipherValue = ((int)letter-97 + (int)Character.toLowerCase(k.charAt(i % k.length()))-97 ) % 26 +97;
				cipher = (char)cipherValue;
			}
			else
			{
				cipherValue = ((int)letter-65 + (int)Character.toUpperCase(k.charAt(i % k.length()))-65 ) % 26 + 65;
				cipher = (char)cipherValue;
			}

			if(Character.isLetter(letter))
				System.out.print(cipher);
			else
				System.out.print(letter);
		}
		System.out.println("\n");
	}

	public void decrypt(String encryptedText, String k)
	{
		int textValue = 0;
		char text = 'a';

		for(int i = 0; i < encryptedText.length(); i++)
		{
			char letter = encryptedText.charAt(i);
			if(Character.isLowerCase(letter))
			{
				textValue = ((int)(letter)-97 - (int)(Character.toLowerCase(k.charAt(i % k.length()))-97));
				if(textValue<0)
					textValue=26+textValue;
				textValue=textValue%26+97;
				text = (char)textValue;
			}
			else
			{
				textValue = ((int)(letter)-65 - (int)(Character.toUpperCase(k.charAt(i % k.length()))-65));
				if(textValue<0)
					textValue=26+textValue;
				textValue=textValue%26+65;
				text = (char)textValue;
			}

			if(Character.isLetter(letter))
				System.out.print(text);
			else
				System.out.print(letter);
		}
		System.out.println("\n");
	}

	public static void main(String args[])
	{
		Encryption app = new Encryption();
	}
}