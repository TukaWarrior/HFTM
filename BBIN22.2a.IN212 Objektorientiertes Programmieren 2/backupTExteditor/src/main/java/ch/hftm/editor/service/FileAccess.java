package ch.hftm.editor.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class FileAccess {

	private static String defaultPath = "C:/temp";

	public static String getActualDirectoryString() {
		return "C:/temp";
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static String getActualFileString() {
		return defaultPath.toString();
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static Date getLastSaveDate() {
		return null;
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static void initializeActualPath() throws ClassNotFoundException, IOException {
		return;
	}

	public static void saveFile(String pathString, String content) throws IOException {
		Path p = Paths.get(pathString);
		try {
			BufferedWriter bw = Files.newBufferedWriter(p, Charset.forName("UTF-8"), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			bw.write(content, 0, content.length());
			bw.close();
		}

		catch (IOException ioe) {
			System.out.println("Error reading file.");
			System.exit(0);
		}
		throw new UnsupportedOperationException();
	}

	public static String readFile(String pathString) throws IOException {
		throw new UnsupportedOperationException();
	}

}
