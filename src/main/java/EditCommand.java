public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";
    int taskNumber;
    String newName;

    EditCommand(int taskNumber, String newName) {
        this.taskNumber = taskNumber;
        this.newName = newName;
    }

    @Override
    public CommandResult execute() {
        Task editedTask = taskList.edit(taskNumber, newName);
        return new CommandResult(getEditSuccessMessage(editedTask));
    }

    public String getEditSuccessMessage(Task editedTask) {
        return "Got it. The task has been successfully updated to:\n"
                + editedTask;
    }
}
