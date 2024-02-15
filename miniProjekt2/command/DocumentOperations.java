package command;

import java.util.ArrayList;
import java.util.List;

public class DocumentOperations {
    private List<Command> commandHistory = new ArrayList<>();
    private List<Command> redoHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
        // Clear redo history when a new command is executed
        redoHistory.clear();
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
            // Add the undone command to redo history
            redoHistory.add(lastCommand);
        }
    }

    public void redoLastCommand() {
        if (!redoHistory.isEmpty()) {
            Command lastUndoneCommand = redoHistory.remove(redoHistory.size() - 1);
            lastUndoneCommand.execute();
            // Add the redone command back to command history
            commandHistory.add(lastUndoneCommand);
        }
    }
}
