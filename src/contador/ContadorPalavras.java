package contador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorPalavras {

	public static Map<String, Integer> contarPalavras(String caminho) {

		//LEITURA DO ARQUIVO:
		List<String> linhas = null;
		try {
			linhas = Files.readAllLines(Paths.get(caminho));
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo de entrada." + e.getMessage());
			System.exit(1);
		}

		//USAR A LISTA DE LINHAS PRA CRIAR LISTA DE PALAVRAS:
		List<String> palavras = new ArrayList<>();
		for (String x : linhas) {
			String vetorPalavras[] = x.split(" "); //separa toda vez que encontrar um espaço e guarda no vetor
			for (String y : vetorPalavras) {
				palavras.add(y.toUpperCase()); //add na lista de palavras em maiusculo
			}
		}

		//CONTAR AS PALAVRAS REPETIDAS DA LISTA DE PALAVRAS E GUARDAR NUM HASHMAP:
		Map<String, Integer> mapPalavras = new HashMap<>();

		for (String x : palavras) {
			if (!mapPalavras.containsKey(x)) { //palavra ainda não está no mapa
				mapPalavras.put(x, 1);
			} else {
				mapPalavras.put(x, mapPalavras.get(x) + 1); //palavra já está no mapa
			}
		}

		return mapPalavras;

	}
}
