public class CommandResult {
    String feedbackToUser;
    TaskList taskList;

    CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    CommandResult(String feedbackToUser, TaskList taskList) {
        this.feedbackToUser = feedbackToUser;
        this.taskList = taskList;
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public TaskList getTaskList() {
        return taskList;
    }
}
