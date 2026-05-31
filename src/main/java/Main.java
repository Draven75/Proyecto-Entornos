public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask("hacer memoria", "ana", 2);
        tm.addTask("subir repositorio", "luis", 1);
        tm.addTask("refactorizar codigo", "ana", 3);
        tm.addTask("hacer diagrama", "marta", 2);

        tm.completeTask("subir repositorio");
        tm.changePriority("hacer memoria", 3);

        tm.showAllTasks();
        System.out.println();
        tm.showTasksByUser("ana");
        System.out.println();

        Report r = new Report();
        r.printReport(tm);

        System.out.println();
        System.out.println("Total tareas: " + tm.getCount());
    }
}