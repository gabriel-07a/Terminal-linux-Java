package br.edu.ifg.commands;

import br.edu.ifg.model.Directory;
import br.edu.ifg.model.Element;
import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

public class CdCommand implements Command {
    @Override
    public void execute(String[] args, DirectoryManager dirManager, FileManager fileManager) {
        // 1. Validação: Se digitar só "cd", no Linux volta pra Home.

        if (args.length < 2) {
            return;
        }

        String caminhoDestino = args[1];
        Directory diretorioAtual = dirManager.getCurrentDirectory();

        //se for pra voltar
        if (caminhoDestino.equals("..")) {

            Directory pai = diretorioAtual.getParent();

            // Se pai for null, significa que já estamos na Raiz (/)
            if (pai != null) {
                dirManager.changeDirectory(pai);
            }
            return; // Encerra o comando aqui
        }


        //se for pra entrar
        // Temos que procurar na lista de filhos se existe essa pasta
        for (Element child : diretorioAtual.getChildren()) {

            // Verifica o nome
            if (child.getName().equals(caminhoDestino)) {

                // Verifica se é REALMENTE um diretório (não dá pra entrar num arquivo txt)
                if (child instanceof Directory) {

                    // Converte (Cast) e manda o gerente mudar o foco
                    Directory pastaAlvo = (Directory) child;
                    dirManager.changeDirectory(pastaAlvo);
                    return; // Sucesso!

                } else {
                    // Erro: Tentou dar cd num arquivo
                    System.out.println("cd: " + caminhoDestino + ": Não é um diretório");
                    return;
                }
            }
        }

        //se não existir
        System.out.println("cd: " + caminhoDestino + ": Arquivo ou diretório inexistente");

    }
}
