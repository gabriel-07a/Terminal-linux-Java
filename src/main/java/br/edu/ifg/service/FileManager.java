package br.edu.ifg.service;

import br.edu.ifg.model.File;
//biblis do java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Esse vai ser o que lida com a parte de salvar os arquivos reais no disco para o historico
public class FileManager {
    //para ler um arquivo
    public String readFile(File file) {
        if (file == null) {
            return "Erro: Arquivo não existe.";
        }
        if (file.getContent().isEmpty()) {
            return ""; // Retorna vazio se não tiver nada
        }
        return file.getContent();
    }

    //sobreescreve um arquivo
    public void writeToFile(File file, String text) {
        if (file != null) {
            file.setContent(text);
        }
    }

    //adiciona texto em um arquivo
    public void appendToFile(File file, String text) {
        if (file != null) {
            file.appendContent(text);
        }
    }

    /**
     * salva um log no computador
     * vai ser usado para salvar o histórico de comandos num .txt de verdade.
     */
    public void saveLog(String logData, String fileName) {
        //try-catch para erros de disco
        try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(logData);

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo no disco: " + e.getMessage());
        }
    }

}
