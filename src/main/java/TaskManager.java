public class TaskManager {

    private Task[] tasks = new Task[100];
    private int count = 0;

    /**
 * Agrega una nueva tarea al arreglo de tareas.
 *
 * Valida que el título y el usuario no sean nulos ni vacíos,
 * y que la prioridad esté en el rango permitido (1 a 3).
 * Si todo es válido, crea la tarea y la almacena en el arreglo.
 *
 * @param title título de la tarea
 * @param user usuario asignado a la tarea
 * @param priority prioridad de la tarea (1 a 3)
 */
public void addTask(String title, String user, int priority) {

    // Verifica que los datos no sean nulos ni vacíos
    if (title != null && user != null && !title.equals("") && !user.equals("")) {

        // Verifica que la prioridad esté dentro del rango válido
        if (priority >= 1 && priority <= 3) {

            // Crea una nueva tarea con los datos proporcionados
            Task t = new Task(title, user, priority);

            // La guarda en el arreglo de tareas
            tasks[count] = t;

            // Incrementa el contador de tareas
            count++;

            // Mensaje de confirmación
            System.out.println("Tarea añadida");

        } else {
            // Mensaje si la prioridad no es válida
            System.out.println("Prioridad incorrecta");
        }

    } else {
        // Mensaje si los datos son inválidos
        System.out.println("Datos incorrectos");
    }
}

    public void completeTask(String title) {
        Task task = findTask(title);

        if (task != null) {
            task.setDone(true);
            System.out.println("Tarea completada");
        }
    }

   /**
 * Cambia la prioridad de una tarea según su título.
 * 
 * Recorre todas las tareas almacenadas y, si encuentra una tarea
 * cuyo título coincide con el parámetro recibido, intenta actualizar
 * su prioridad siempre que esté en el rango válido (1 a 3).
 *
 * @param title título de la tarea a modificar
 * @param p nueva prioridad (debe estar entre 1 y 3)
 */
public void changePriority(String title, int p) {
    // Recorre todas las tareas almacenadas
    for (int i = 0; i < count; i++) {

        // Comprueba si el título de la tarea actual coincide con el buscado
        if (tasks[i].getTitle().equals(title)) {

            // Verifica si la prioridad está dentro del rango permitido (1 a 3)
            if (p >= 1 && p <= 3) {

                // Asigna la nueva prioridad a la tarea
                tasks[i].setPriority(p);

                // Mensaje de confirmación
                System.out.println("Prioridad cambiada");

            } else {
                // Mensaje si la prioridad no es válida
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