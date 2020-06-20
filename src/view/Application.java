package view;

import java.io.BufferedReader;
import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Application {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		
		String path = "relatorios";
	    String name = "relatorio.txt";
	    String newFolder = "arquivos csv";
		
		try {
			
			String conteudo = arqCont.readFile(path, name);
			
			String conteudoCSV = arqCont.transformarCSV(conteudo);
			
			arqCont.createFolders(path, newFolder);
			
			arqCont.createFile(path + "\\" + newFolder, "relatorioCSV.csv", conteudoCSV);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
