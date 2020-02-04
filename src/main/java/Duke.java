import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    // Storage storage;
    Ui ui;
    TaskList taskList;

    public Duke() {
        // this.storage = new Storage();
        this.ui = new Ui();
        this.taskList = new TaskList();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }

    /**
     * Runs the program until execution
     */
    public void run() {
        this.start();
        this.runCommandLoop();
        this.exit();
    }

    /**
     * Reads the user command and executes it, until the user issues the exit command
     */
    public void runCommandLoop() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = (new Parser()).parseCommand(userCommandText);
            CommandResult result = executeCommand(command);
            ui.showResultToUser(result);
        } while (!ExitCommand.isExitCommand(command));
    }

    public CommandResult executeCommand(Command command) {
        command.setData(taskList);
        return command.execute();
    }

    public void start() {
        ui.showWelcomeMessage();
    }

    public void exit() {
        ui.showGoodbyeMessage();
        System.exit(0);
    }
}
