package contador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void imprimir(List<Entry<String, Integer>> list) {

		System.out.println("+------+--------------------------------+");
		System.out.println("| Qtde | Palavra                        |");
		System.out.println("+------+--------------------------------+");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("| %-4s | %-30s |\n", list.get(i).getValue(), list.get(i).getKey());
		}
		System.out.println("+------+--------------------------------+");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ContadorPalavras objCP = new ContadorPalavras();
		Map<String, Integer> m = new HashMap<>();
		
		System.out.println("Digite o diretório do arquivo a ser lido: ");
		String dir= sc.next();
		m = objCP.contarPalavras(dir);

		List<Entry<String, Integer>> x = new ArrayList();

		for (Entry entry : m.entrySet()) {
			x.add(entry);
		}

		x.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		
		imprimir(x);
	}

}
