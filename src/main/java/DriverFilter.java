import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class DriverFilter {
	public static void main(String[] args) {
		
		// Voglio filtrare i file in una cartella e ricevere solo quelli che soddisfano un certo requisito
		// .listFile prende come parametro un oggetto che implementa l'interfaccia FileFilter, e chiama
		// il metodo accept (che ho io scelto come implementare) per usarlo per fare le sue lavorazioni
		// ci sono 3 modi di farlo:
		
		String path = System.getProperty("user.dir");
		File dir = new File(path);
		

		// Primo metodo: creo una classe (JavaFileFilter) che implementa l'interfaccia FileFilter
		JavaFileFilter jff = new JavaFileFilter();
		File[] javaFiles = dir.listFiles(jff);
		System.out.println(Arrays.toString(javaFiles));
		
		
		// Secondo metodo: creo una classe anonima che implementa l'interfaccia FileFilter
		FileFilter jff2 = new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		};
		File[] javaFiles2 = dir.listFiles(jff2);
		System.out.println(Arrays.toString(javaFiles2));
		
		
		// Terzo metodo: creo una lambda che fa la stessa cosa del secondo metodo
		FileFilter jff3 = (File pathname) -> pathname.getName().endsWith(".txt");
		File[] javaFiles3 = dir.listFiles(jff3);
		System.out.println(Arrays.toString(javaFiles3));
		
	}
}