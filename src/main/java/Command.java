public abstract class Command {
    TaskList taskList;

    public abstract CommandResult execute();

    public void setData(TaskList tasklist) {
        this.taskList = taskList;
    }

    public String getAddSuccessMessage(Task newTask) {
        assert(taskList != null);
        return "Got it. I've added this task:\n"
                + newTask + "\n"
                + "Now you have " + taskList.getSize() + " tasks in the list.";
    }

}
