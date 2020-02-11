import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deadline extends Task {
    String date;

    Deadline(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    public static Deadline createDeadline(String name, boolean isDone, String date) {
        return new Deadline(name, isDone, date);
    }

    public static Deadline decode(String text) {
        String[] parts = text.split(",");
        boolean decodedIsDone = parts[1].equals("1");
        return createDeadline(parts[2], decodedIsDone, parts[3]);
    }

    @Override
    public String encodeTask() {
        int encodedIsDone = this.getIsDone() ? 1 : 0;
        return "D," + encodedIsDone + "," + name + "," + date;
    }

    @Override
    public Deadline complete() {
        return createDeadline(this.getName(), true, this.getDate());
    }

    @Override
    public Task setName(String newName) {
        return createDeadline(newName, isDone, date);
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[D]" + taskString + " (by: " + date + ")";
        return result;
    }

    public String getDate() {
        return this.date;
    }
}
