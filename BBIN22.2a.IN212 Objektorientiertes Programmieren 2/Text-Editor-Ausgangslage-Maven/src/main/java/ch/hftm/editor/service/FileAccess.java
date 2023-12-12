package ch.hftm.editor.service;

import java.io.IOException;
import java.util.Date;

public class FileAccess {
	
	public static String getActualDirectoryString() {
		return "C:/temp";
	}
	
	// TODO: Implementieren für IO Aufgabe Teil 2 b)
	public static String getActualFileString() {
		return "";
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
		throw new UnsupportedOperationException();
	}

	public static String readFile(String pathString) throws IOException {
		throw new UnsupportedOperationException();
	}

}
