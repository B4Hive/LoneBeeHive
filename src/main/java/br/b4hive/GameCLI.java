package br.b4hive;

public class GameCLI {

	public static void clear() {
		String os = System.getProperty("os.name").toLowerCase();

		try {
			if (os.contains("win")) {
				// Comando para Windows
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				// Comando para Linux/Unix/Mac
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			System.out.println("Erro ao tentar limpar a tela: " + e.getMessage());
		}
	}
}
