public class Parser {
    public Command parseCommand(String userCommandText) {
        String[] words = userCommandText.split(" ");
        String commandWord = words[0];
        String argumentText = words.length == 1 ? "" : Parser.getArguments(words);

        try {
            switch (commandWord) {
            case ListCommand.COMMAND_WORD:
                return new ListCommand();
            case DoneCommand.COMMAND_WORD:
                // complete the task at number given by user
                int taskNumberToComplete = Integer.parseInt(words[1]);
                return new DoneCommand(taskNumberToComplete);
            case DeleteCommand.COMMAND_WORD:
                int taskNumberToDelete = Integer.parseInt(words[1]);
                return new DeleteCommand(taskNumberToDelete);
            case TodoCommand.COMMAND_WORD:
                if (argumentText.equals("")) {
                    throw new DukeException("The description of a todo cannot be empty.");
                } else {
                    return new TodoCommand(argumentText);
                }
            case DeadlineCommand.COMMAND_WORD:
                String[] deadlineParts = argumentText.split(" /by ");
                if (deadlineParts[0].equals("") || deadlineParts[1].equals("")) {
                    throw new DukeException("The description of a deadline cannot be empty");
                } else {
                    return new DeadlineCommand(deadlineParts[0], deadlineParts[1]);
                }
            case EventCommand.COMMAND_WORD:
                String[] eventParts = argumentText.split(" /at ");
                if (eventParts[0].equals("") || eventParts[1].equals("")) {
                    throw new DukeException("The description of an event cannot be empty");
                } else {
                    return new EventCommand(eventParts[0], eventParts[1]);
                }
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
            }
        } catch (DukeException e) {
            return new IncorrectCommand(e.getMessage());
        }
    }

    /**
     * Combines a String array from index 1 to (length - 1)
     */
    public static String getArguments(String[] parts) {
        String result = parts[1];
        for (int i = 2; i < parts.length; i++) {
            result += " " + parts[i];
        }
        return result;
    }
}
