import java.util.List;
import java.util.ArrayList;

/**
 * Stores a list of tasks and methods to make changes to the list
 */
public class TaskList {
    private final List<Task> tasks;

    TaskList() {
        tasks = new ArrayList<>();
    }

    TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the size of the tasks list
     * @return the number of tasks
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds a task to the tasks list
     * @param newTask the task to be added
     */
    public void addToList(Task newTask) {
        tasks.add(newTask);
    }

    /**
     * Deletes a task
     * @param taskNumber the target task number to delete
     * @return the task that is deleted
     */
    public Task delete(int taskNumber) {
        int index = taskNumber - 1;
        Task removedTask = tasks.remove(index);
        return removedTask;
    }

    /**
     * Mark a task as done by substituting the current task with a completed task in the list
     * @param taskNumber the target task number to delete
     * @return the Task that is marked as done
     */
    public Task markAsDone(int taskNumber) {
        // the index of a task in the list is one less than the taskNumber
        int index = taskNumber - 1;
        Task currentTask = tasks.get(index);
        Task completedTask = currentTask.complete();
        tasks.set(index, completedTask);
        return completedTask;
    }

    /**
     * Gets a String representation of all tasks in the list
     * @return a String representing all tasks in the list
     */
    public String getAllTasks() {
        String result = "Here are the tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            result += "\n";
            Task currentTask = tasks.get(i);
            int taskNumber = i + 1;
            result += taskNumber + ". " + currentTask;
        }
        return result;
    }

}
