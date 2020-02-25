public class Deadline extends Task {
    String date;

    Deadline(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    public static Deadline decode(String text) {
        String[] parts = text.split(",");
        boolean decodedIsDone = parts[1].equals("1");
        return new Deadline(parts[2], decodedIsDone, parts[3]);
    }

    @Override
    public String encodeTask() {
        int encodedIsDone = this.getIsDone() ? 1 : 0;
        return "D," + encodedIsDone + "," + name + "," + date;
    }

    @Override
    public Deadline complete() {
        return new Deadline(this.getName(), true, this.getDate());
    }

    @Override
    public Task setName(String newName) {
        return new Deadline(newName, isDone, date);
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
