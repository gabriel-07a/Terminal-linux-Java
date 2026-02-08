package br.edu.ifg.commands;

import br.edu.ifg.model.Directory;
import br.edu.ifg.model.Element;
import br.edu.ifg.model.File;
import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CatCommand implements Command {
    @Override
    public void execute(String[] args, DirectoryManager dirManager, FileManager fileManager) {
        if (args.length < 2){
            System.out.println("erro: não foi digitada nenhum nome de arquivo");
            return;
        }

        String nomeArquivo = args[1];
        // localiza o arquivo na pasta atual do seu FileManager
        Directory currentDir = dirManager.getCurrentDirectory();

        // verifica se o arquivo existe e se não é uma pasta
        //cat: pogrma: Arquivo ou diretório inexistente
        for(Element child: currentDir.getChildren()){
            //verifica se o nome do arquivo digitado existe no diretorio atual
            if (child.getName().equals(nomeArquivo)){
                //agora é verificar se ele é um arquivo mesm
                if(child instanceof File){
                    //ve se o child, que é child porque está dentro de um diretorio pai,
                    //se ele é uma instancia de arquivo

                    File arquivoEncontrado = (File) child;
                    String conteudoDoArquivo = arquivoEncontrado.getContent();
                    // o scanner recebe a string do conteúdo, não o arquivo físico
                    try (Scanner leitor = new Scanner(conteudoDoArquivo)) {


                        // Enquanto o arquivo tiver linhas, ele imprime no console
                        while (leitor.hasNextLine()) {
                            String linha = leitor.nextLine();
                            System.out.println(linha);
                        }

                    } catch (Exception e) {
                        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                    }
                    return;

                }else{
                    //no terminal linux: cat: teste: É um diretório
                    System.out.println("cat: "+ nomeArquivo + ": É um diretório");
                    return;
                }
            }


        }
        //se o for rodar tudo e n achar nada
        //no terminal: cat: sla: Arquivo ou diretório inexistente
        System.out.println("cat:" + nomeArquivo +": Arquivo ou diretório inextistente");
    }
}
