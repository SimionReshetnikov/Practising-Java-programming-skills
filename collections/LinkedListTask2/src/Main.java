import java.util.List;

public class Main {
    public static void main(String[] args) {
        TodoList tasks = new TodoList();
        tasks.addTask("Купить молоко", 3);
        tasks.addTask("Создать проект", 1);
        tasks.addTask("Позвонить маме", 2);
        tasks.addTask("Вынести мусор", 3);
        tasks.addTask("Записаться к врачу", 1);

        System.out.println(tasks.getAllTasksString());

        tasks.addToStart("Срочно!", 5);
        tasks.addToEnd("На потом", 5);

        System.out.println(tasks.getAllTasksString());

        System.out.println(tasks.completeFirst());
        System.out.println();
        System.out.println(tasks.getAllTasksString());

        List<Task> priorityThree = tasks.getTasksByPriority(3);
        printListTasks(priorityThree);

        tasks.moveToEnd(3);
        System.out.println(tasks.getAllTasksString());

        tasks.removeTask(5);
        System.out.println(tasks.size());

        tasks.clear();
        System.out.println(tasks.getAllTasksString());
    }

    private static void printListTasks(List<Task> list) {
        System.out.println();
        for (Task task : list) {
            System.out.println(task);
        }
        System.out.println();
    }
}