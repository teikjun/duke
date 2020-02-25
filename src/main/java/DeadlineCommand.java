/**
 * Adds a deadline to the taskList
 */
public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    String firstArgumentText;
    String secondArgumentText;

    /**
     * creates a DeadlineCommand
     * @param argumentText the arguments supplied by the user
     * @throws DukeException if either part of the command is empty
     */
    DeadlineCommand(String argumentText) throws DukeException {
        String[] deadlineParts = argumentText.split(" /by ");
        if (deadlineParts[0].equals("") || deadlineParts[1].equals("")) {
            throw new DukeException("The description of a deadline cannot be empty");
        } else {
            this.firstArgumentText = deadlineParts[0];
            this.secondArgumentText = deadlineParts[1];
        }
    }

    /**
     * Creates a new deadline and adds it to the taskList
     * @return CommandResult with the success message
     */
    @Override
    public CommandResult execute() {
        Task newDeadline = new Deadline(firstArgumentText, false, secondArgumentText);
        taskList.addToList(newDeadline);
        return new CommandResult(getAddSuccessMessage(newDeadline));
    }
}
