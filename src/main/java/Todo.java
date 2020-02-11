public class Todo extends Task {
    Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    public static Todo createTodo(String name, boolean isDone) {
        return new Todo(name, isDone);
    }

    public static Todo decode(String text) {
        String[] parts = text.split(",");
        boolean decodedIsDone = parts[1].equals("1");
        return createTodo(parts[2], decodedIsDone);
    }

    @Override
    public String encodeTask() {
        int encodedIsDone = this.getIsDone() ? 1 : 0;
        return "T," + encodedIsDone + "," + name;
    }

    @Override
    public Todo complete() {
        return createTodo(this.getName(), true);
    }

    @Override
    public Task setName(String newName) {
        return createTodo(newName, isDone);
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[T]" + taskString;
        return result;
    }
}

