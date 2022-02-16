package codeChallenge;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

// AD OGNI NUOVA CODE CHALLENGE è SUFFICIENTE MODIFICARE IL NOME DELLA CLASSE 
// AD ESEMPIO GoogleHashcode2021
// E, DI CONSEGUENZA, IL NOME DEL FILE
// E SUCCESSIVAMENTE COMPLETARE IL CODICE DOVE PRESENTE IL "TODO"
public class CodeChallenge {
	// VARIABILE PILOTA PER IL FILE DI INPUT CORRENTE
	private final String INPUT_FILE_FIRST_LETTER = "a"; // DA CAMBIARE PER CAMBIARE IL FILE DI INPUT

	// INIZIO - VARIABILI DEL PROGRAMMA RELATIVE AL PROBLEMA
	// TODO completare

	// FINE - VARIABILI DEL PROGRAMMA RELATIVE AL PROBLEMA

	private void elaboraDati() throws Exception {
		// logica del programma
		// TODO completare
	}

	private void interpretaRighe(List<String> fileRows) {
		// INIZIO - INTERPRETAZIONE RIGHE FILE
		// TODO completare

		// FINE - INTERPRETAZIONE RIGHE FILE
	}

	private void scriviFile(PrintWriter pw) {
		// INIZIO - SCRITTURA OUTPUT SU FILE
		// esempio utilizzo: pw.println(outputDaScrivere);
		// TODO completare

		// FINE - SCRITTURA OUTPUT SU FILE
	}

	public static void main(String[] args) throws Exception {
		CodeChallenge g = new CodeChallenge();
		g.inputDati();
		g.elaboraDati();
		g.outputDati();
	}

	private final void inputDati() throws Exception {
		// creazione directory necessarie
		Files.createDirectories(INPUT_DIRECTORY_PATH);
		Files.createDirectories(OUTPUT_DIRECTORY_PATH);

		// copia del file .java sorgente nella cartella di output
		Files.find(Paths.get("."), 5, (p, a) -> a.isRegularFile() && p.getFileName().toString().endsWith(".java"))
				.forEach(p -> {
					try {
						Files.copy(p, OUTPUT_DIRECTORY_PATH.resolve(p.getFileName()),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

		// ricerco il file di input nella directory input
		currentInputFile = Files.list(INPUT_DIRECTORY_PATH)
				.filter(f -> Files.isRegularFile(f) && f.getFileName().toString().startsWith(INPUT_FILE_FIRST_LETTER)
						&& !f.getFileName().toString().contains(".java"))
				.findFirst().get();

		// leggo tutte le righe del file di input
		List<String> fileRows = Files.readAllLines(currentInputFile);

		// interpreta le righe nel file di input
		interpretaRighe(fileRows);
	}

	private final void outputDati() throws Exception {
		// definizione del file di output
		Path outputFilePath = OUTPUT_DIRECTORY_PATH
				.resolve(currentInputFile.getFileName().toString() + "." + System.currentTimeMillis() + ".out");

		// creazione oggetto printWriter per la scrittura su file fisico
		// e sua apertura
		PrintWriter pw = new PrintWriter(outputFilePath.toFile());

		// scrittura su file
		scriviFile(pw);

		// chiusura printWriter
		pw.close();
	}

	// NOME DELLA CHALLENGE
	private final String CHALLENGE_NAME = this.getClass().getSimpleName();

	// INIZIO - VARIABILI RELATIVE A FILE E DIRECTORY DELLA CHALLENGE
	private final Path DESKTOP_PATH = Paths.get(System.getProperty("user.home"), "Desktop");
	private final Path CHALLENGE_DIRECTORY_PATH = DESKTOP_PATH.resolve(CHALLENGE_NAME);
	private final Path INPUT_DIRECTORY_PATH = CHALLENGE_DIRECTORY_PATH.resolve("input");
	private final Path OUTPUT_DIRECTORY_PATH = CHALLENGE_DIRECTORY_PATH.resolve("output");

	private Path currentInputFile;
	// FINE - VARIABILI RELATIVE A FILE E DIRECTORY DELLA CHALLENGE

	// INIZIO - CLASSI INTERNE RELATIVE AL PROBLEMA
	// TODO completare

	// FINE - CLASSI INTERNE RELATIVE AL PROBLEMA
}
