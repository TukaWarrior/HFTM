package ch.hftm.editor.service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;


public class FileAccess {

	public static String saveFileInfoPath = "lastSaveInfo.ser";
	private static LastSaveInfo lsi;

	public static String getActualDirectoryString() {
		return "C:/temp";
	}

	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static String getActualFileString() {
		if (lsi != null) {
			return lsi.getFilePath() + "\\" + lsi.getFileName();
		}
		return null;
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static Date getLastSaveDate() {
		if (lsi != null) {
			return lsi.getSaveDate();
		}
		return null;
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static void initializeActualPath() throws ClassNotFoundException, IOException {

		Path p = Paths.get(saveFileInfoPath);
		if (Files.exists(p)) {
			FileInputStream fileIn = new FileInputStream("LastSaveInfo.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			LastSaveInfo lsi1 = (LastSaveInfo) in.readObject();
			in.close();

			lsi = lsi1;
		}
	}

// Aufgabe 1 a ) Text-Datei speichern
	public static void saveFile(String pathString, String content) throws IOException {
        Path p = Paths.get(pathString);

		System.out.println("Original path: " + p.toString());

        if (!p.isAbsolute()) {
			System.out.println("Default path: " + getActualDirectoryString());
			p = Paths.get(getActualDirectoryString()).resolve(p);
			System.out.println("Resolved path: " + p.toString());
		}
// Aufgabe 2 a) Verzeichnisse erstellen beim Speichern
        if (!Files.exists(p.getParent())) {
            Files.createDirectories(p.getParent());
        }
        if (!Files.exists(p)) {
            Files.createFile(p);
        }

//		// Save last save info
		LastSaveInfo lsi1 = new LastSaveInfo(p.getFileName().toString(), p.getParent().toString(), new Date());
		FileOutputStream fileOut = new FileOutputStream("LastSaveInfo.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(lsi1);
		out.close();

        try {
            BufferedWriter bw = Files.newBufferedWriter(p, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            bw.write(content, 0, content.length());
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error writing file.");
            System.exit(0);
        }
//		throw new UnsupportedOperationException();
    }

//	Aufgabe 1 b) Text Datei lesen
	public static String readFile(String pathString) throws IOException {
		Path p = Paths.get(pathString);

		if (!p.isAbsolute()) {
			p = Paths.get(getActualDirectoryString()).resolve(p);
		}

		if (!Files.exists(p) || !Files.isRegularFile(p)) {
			throw new IOException("File not found: " + p);
		}

		StringBuilder content = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(p.toFile()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
		}

		return content.toString();
//		throw new UnsupportedOperationException();
	}
}