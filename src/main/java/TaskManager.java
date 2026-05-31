public class TaskManager {

    private Task[] tasks = new Task[100];
    private int count = 0;

   public void addTask(String title, String user, int priority) {
    if (!isValidInput(title, user)) {
        System.out.println("Datos incorrectos");
        return;
    }

    if (!isValidPriority(priority)) {
        System.out.println("Prioridad incorrecta");
        return;
    }

    tasks[count++] = new Task(title, user, priority);
    System.out.println("Tarea añadida");
}

private boolean isValidInput(String title, String user) {
    return title != null && user != null
            && !title.trim().isEmpty()
            && !user.trim().isEmpty();
}

private boolean isValidPriority(int priority) {
    return priority >= 1 && priority <= 3;
}

    public void completeTask(String title) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTitle().equals(title)) {
                tasks[i].setDone(true);
                System.out.println("Tarea completada");
            }
        }
    }

    public void changePriority(String title, int p) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTitle().equals(title)) {
                if (p >= 1 && p <= 3) {
                    tasks[i].setPriority(p);
                    System.out.println("Prioridad cambiada");
                } else {
                    System.out.println("Prioridad no valida");
                }
            }
        }
    }

    public void showAllTasks() {
        System.out.println("LISTADO DE TAREAS");
        for (int i = 0; i < count; i++) {
            System.out.println(tasks[i].toString());
        }
    }

    public void showTasksByUser(String user) {
        System.out.println("TAREAS DE " + user.toUpperCase());
        for (int i = 0; i < count; i++) {
            if (tasks[i].getUser().equals(user)) {
                System.out.println(tasks[i].toString());
            }
        }
    }

    public int getPendingCount() {
        int x = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].isDone() == false) {
                x++;
            }
        }
        return x;
    }

    public int getCompletedCount() {
        int x = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].isDone() == true) {
                x++;
            }
        }
        return x;
    }

    public int getHighPriorityCount() {
        int x = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getPriority() == 3) {
                x++;
            }
        }
        return x;
    }

    public int getMediumPriorityCount() {
        int x = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getPriority() == 2) {
                x++;
            }
        }
        return x;
    }

    public int getLowPriorityCount() {
        int x = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getPriority() == 1) {
                x++;
            }
        }
        return x;
    }

    public int getCount() {
        return count;
    }

    public Task[] getTasks() {
        return tasks;
    }
}