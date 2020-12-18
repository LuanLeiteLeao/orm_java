package utils;

public class SyntaxConverter {
	public static String lowercaseAndUnderline(String classNameSon) {
		String newString = "";

		for (int i = 0; i < classNameSon.length(); i++) {
			char aux = classNameSon.charAt(i);

//			tem que ser maiusculo e nao pode ser a primeira posicao
			if (Character.isUpperCase(aux) && i != 0) {
//			divir em espacos com _ exmp: minha_classe_aqui 
				newString += "_";
			}

			newString += aux;
		}
		return newString.toLowerCase();
	}

	public static String firstCapitalLetter(String string) {
		char charCapitalLetter ;
		charCapitalLetter = Character.toTitleCase(string.charAt(0));
		String stringCapitalLetter = charCapitalLetter+string.substring(1);
		
		return stringCapitalLetter;

	}
}
