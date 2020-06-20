package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);

		if (dir.exists() && dir.isDirectory()) {

			File[] listFiles = dir.listFiles();

			for (File file : listFiles) {
				if (file.isFile()) {
					System.out.println("     \t" + file.getName());
				} else {
					System.out.println("<DIR>\t" + file.getName());
				}
			}

		} else {
			throw new IOException("Diretorio não existe ou é um arquivo");
		}

	}

	@Override
	public void createFile(String path, String name, String conteudo) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name);

		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override
	public String readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String conteudo = "";
			while (linha != null) {
				conteudo += linha + "\n";
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

			return conteudo;
		} else {
			throw new IOException("Diretorio inválido");
		}
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}

	}

	@Override
	public void createFolders(String path, String name) throws IOException {

		File dir = new File(path, name);
		dir.mkdirs();

	}

	public String transformarCSV(String text) {

		text = text.replaceAll(" ", ";");

		System.out.println(text);

		return text;
	}

}
