import java.util.ArrayList;
import java.util.List;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    String argumentText;

    TodoCommand(String argumentText) {
        this.argumentText = argumentText;
    }

    @Override
    public CommandResult execute() {
        Task newTodo = Todo.createTodo(argumentText, false);
        taskList.addToList(newTodo);
        return new CommandResult(getAddSuccessMessage(newTodo));
    }

}
