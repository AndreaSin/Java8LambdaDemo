import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		
		// Ordinare delle stringhe dalla piu corta alla piu lunga
		// usando l'interfaccia Comparator e il suo metodo compare
		// questo sarà usato internamente da .sort
		
		List<String> list = Arrays.asList("*","***","**");
		
		
		// Primo metodo: creo una classe (StringCompare) che implementa l'interfaccia Comparator
		JavaCompare jv = new JavaCompare();
		Collections.sort(list, jv);
		for (String string : list) {
			System.out.println(string);
		}
		/* (metodi alternativi per la stampa senza loop)
		System.out.println(Arrays.toString(list.toArray()));
		list.forEach(System.out::println);
		*/
		
		
		// Secondo metodo: creo una classe anonima che implementa l'interfaccia Comparator
		Comparator<String> jv2 = new Comparator<String>() {
				public int compare(String s1, String s2) {
					return Integer.compare(s1.length(), s2.length());
				}
		};
		Collections.sort(list, jv2);
		for (String string : list) {
			System.out.println(string);
		}

		
		// Terzo metodo: creo una lambda che fa la stessa cosa del secondo metodo
		Comparator<String> jv3 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
		Collections.sort(list, jv3);
		for (String string : list) {
			System.out.println(string);
		}
		
		
	}
}
