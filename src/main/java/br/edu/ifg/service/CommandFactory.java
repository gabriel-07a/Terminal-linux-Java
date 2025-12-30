package br.edu.ifg.service;

import br.edu.ifg.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String, Command> nomeComando = new HashMap<>();

    static{
        nomeComando.put("Cat", new CatCommand());
        nomeComando.put("Cd", new CdCommand());
        nomeComando.put("Echo", new EchoCommand());
        nomeComando.put("Exit", new ExitCommand());
        nomeComando.put("History", new HistoryCommand());
        nomeComando.put("Ls", new LsCommand());
        nomeComando.put("Mkdir", new MkdirCommand());  ;
        nomeComando.put("Pwd", new PwdCommand());
        nomeComando.put("Rm", new RmCommand());
        nomeComando.put("Touch", new TouchCommand());

    }

    public static Command getComand(String comands){
        return nomeComando.get(comands);
    }

}
