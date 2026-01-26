package br.edu.ifg.terminal;

import br.edu.ifg.service.CommandHandler;
import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

import java.util.Scanner;


public class Terminal {
    public static void main(String[] agrs){
        String input;
        Scanner scanner = new Scanner(System.in);
        var directory = new DirectoryManager();
        var file = new FileManager();
        var comands = new CommandHandler(directory, file);


        while(true){
            //exemplo de print padrão do linux
            System.out.print("gabriel@gabriel-N370:~$ ");
            input = scanner.nextLine();

            //mano esse isBlank é um isempty maiss inteligente, ele desconsidera os espaços em branco
            if(input == null || input.isBlank()){
                continue;
            }

            comands.execute(input);
        }




    }


}
