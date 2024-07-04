package com.example.helloworld;
import java.util.LinkedList;
import java.util.Scanner;

class HelloWorld
{
    public static void main(String[] args) {
        LinkedList<Task> list = new LinkedList<Task>();
        Scanner input = new Scanner(System.in);
        String name = input.next();
        String description = input.next();
        int priority = input.nextInt();

        System.out.println("Enter in your input for the name, description, and priority number of your task: ");

        while (!(name = input.next()).equalsIgnoreCase("done") && (description = input.next()) != null && (priority = input.nextInt()) >= 0){
            list.add(new Task(name, description, priority));
            input.nextLine();
        }

        System.out.println("Enter the name of the task you wish to delete: ");
        name = input.next();
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            if (task.getName().equalsIgnoreCase(name)) {
                list.remove(i);
                i--;
            }

            System.out.println("Enter the name of the task you want to search for: ");
            name = input.next();

            boolean found = false;

            for (int x = 0; x < list.size(); x++) {
                if (task.getName().equalsIgnoreCase(name)) {
                    System.out.println("Task found: " + task.getName() + ", " + task.getDescription() + ", Priority: " + task.getPriority());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Task not found.");
            }
        }

        for (int y = 0; y < list.size() - 1; y++) {
            for (int z = 0; z < list.size() - y - 1; z++) {
                if (list.get(z).getPriority() > list.get(z + 1).getPriority()) {
                    Task temp = list.get(z);
                    list.set(z, list.get(z + 1));
                    list.set(z + 1, temp);
                }
            }
        }
    }
}
