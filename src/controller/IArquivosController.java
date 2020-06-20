package controller;

import java.io.IOException;

public interface IArquivosController {

	public void readDir(String path) throws IOException;
	public void createFile(String path, String name, String conteudo) throws IOException;
	public String readFile(String path, String name) throws IOException;
	public void openFile(String path, String name) throws IOException;
	public void createFolders(String path, String name) throws IOException;
	public String transformarCSV(String text);
}
