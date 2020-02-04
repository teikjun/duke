import java.util.ArrayList;
import java.util.List;

public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    String firstArgumentText;
    String secondArgumentText;

    DeadlineCommand(String firstArgumentText, String secondArgumentText) {
        this.firstArgumentText = firstArgumentText;
        this.secondArgumentText = secondArgumentText;
    }

    @Override
    public CommandResult execute() {
        Task newDeadline = Deadline.createDeadline(firstArgumentText, false, secondArgumentText);
        taskList.addToList(newDeadline);
        return new CommandResult(getAddSuccessMessage(newDeadline), taskList);
    }
}
