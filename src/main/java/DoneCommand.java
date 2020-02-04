public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    int taskNumber;

    DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public CommandResult execute() {
        Task completedTask = taskList.markAsDone(taskNumber);
        return new CommandResult(getDoneSuccessMessage(completedTask));
    }

    public String getDoneSuccessMessage(Task completedTask) {
        return "Nice! I've marked this task as done:\n"
                + completedTask + "\n"
                + "Now you have " + taskList.getSize() + " tasks in the list.";
    }
}
