package org.lld.practice.navi.ledger.co;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();

        String filePath = args[0];
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(
                    fileLine -> commandManager.execute(fileLine)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
