/**
 * Adds an event to the taskList
 */
public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    String firstArgumentText;
    String secondArgumentText;

    /**
     * Creates an EventCommand
     * @param argumentText supplied by the user
     * @throws DukeException if either part of the command is empty
     */
    EventCommand(String argumentText) throws DukeException {
        String[] eventParts = argumentText.split(" /at ");
        if (eventParts[0].equals("") || eventParts[1].equals("")) {
            throw new DukeException("The description of an event cannot be empty");
        } else {
            this.firstArgumentText = eventParts[0];
            this.secondArgumentText = eventParts[1];
        }
    }

    /**
     * Creates an event and adds it to the taskList
     * @return CommandResult with the success message
     */
    @Override
    public CommandResult execute() {
        Task newEvent = new Event(firstArgumentText, false, secondArgumentText);
        taskList.addToList(newEvent);
        return new CommandResult(getAddSuccessMessage(newEvent));
    }
}
