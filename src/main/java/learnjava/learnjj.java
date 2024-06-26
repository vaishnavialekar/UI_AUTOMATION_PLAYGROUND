package learnjava;

public class learnjj {

	public static void main(String[] args) {

		// reverse string

		String str = "a2b3c4";

		for (int i = 0; i < str.length(); i++) {

			if (Character.isAlphabetic(str.charAt(i))) {

				System.out.println(str.charAt(i));

			} else {

				int a = Character.getNumericValue(str.charAt(i));

				for (int j = 1; j < a; j++) {
					System.out.print(str.charAt(i-1));
				}

			}

		}

	}
}
