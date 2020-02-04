public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    String firstArgumentText;
    String secondArgumentText;

    EventCommand(String firstArgumentText, String secondArgumentText) {
        this.firstArgumentText = firstArgumentText;
        this.secondArgumentText = secondArgumentText;
    }

    @Override
    public CommandResult execute() {
        Task newEvent = Event.createEvent(firstArgumentText, false, secondArgumentText);
        taskList.addToList(newEvent);
        return new CommandResult(getAddSuccessMessage(newEvent), taskList);
    }
}
