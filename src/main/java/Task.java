public class Task {
    String title;
    String user;
    int priority;
    boolean done;

    public Task(String t, String u, int p) {
        title = t;
        user = u;
        priority = p;
        done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setUser(String u) {
        user = u;
    }

    public void setPriority(int p) {
        priority = p;
    }

    public void setDone(boolean d) {
        done = d;
    }

    public String toString() {
        String s = "";
        s = s + "Tarea: " + title + " | ";
        s = s + "Usuario: " + user + " | ";
        s = s + "Prioridad: " + priority + " | ";
        s = s + "Estado: ";
        if (done) {
            s = s + "HECHA";
        } else {
            s = s + "PENDIENTE";
        }
        return s;
    }
}