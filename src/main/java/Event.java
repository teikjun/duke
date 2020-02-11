public class Event extends Task {
    String date;

    Event(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    public static Event createEvent(String name, boolean isDone, String date) {
        return new Event(name, isDone, date);
    }

    public static Event decode(String text) {
        String[] parts = text.split(",");
        boolean decodedIsDone = parts[1].equals("1");
        return createEvent(parts[2], decodedIsDone, parts[3]);
    }

    @Override
    public String encodeTask() {
        int encodedIsDone = this.getIsDone() ? 1 : 0;
        return "E," + encodedIsDone + "," + name + "," + date;
    }

    @Override
    public Event complete() {
        return createEvent(this.getName(), true, this.getDate());
    }

    @Override
    public Task setName(String newName) {
        return createEvent(newName, isDone, date);
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[E]" + taskString + " (at: " + date + ")";
        return result;
    }

    public String getDate() {
        return this.date;
    }
}