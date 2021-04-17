import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DriverChainConsumer {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("one", "two", "three");
		List<String> result = new ArrayList<String>();
		
		// Creo un oggetto di tipo Consumer, che diventa a tutti gli effetti
		// una funzione all'interno di una variabile, per stampare i membri della lista
		Consumer<String> c1 = s -> System.out.println(s);
		//Consumer<String> c1 = System.out::println;
		
		
		// creo una funzione consumer che aggiunge gli elementi di una lista alla
		// lista results (NON lo sta facendo ora, è solo la creazione dell'oggetto lambda!)
		Consumer<String> c2 = s -> result.add(s);
		//Consumer<String> c2 = result::add;
		
		
		// il metodo foreach vuole come parametro un oggetto di tipo Consumer
		// quindi per ogni elemento della lista strings, applica la funzione Consumer
		// andThen è dell interfaccia consumer e chiaramente fa concatenare piu funzioni	
		strings.forEach(c1.andThen(c2));
		System.out.println("size of result " + result.size());
	}

}