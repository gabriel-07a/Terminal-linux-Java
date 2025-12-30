package br.edu.ifg.terminal;

import br.edu.ifg.service.CommandHandler;

import java.util.Scanner;


public class Terminal {
    public static void main(String[] agrs){
        String args;
        Scanner scanner = new Scanner(System.in);
        var comands = new CommandHandler();

        while(true){
            System.out.print();
            args = scanner.nextLine();
            comands.execute(args);
        }




    }


}
