package seminar03;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
                new Worker("Ivanov", "Ivan", "Ivanovich",
                        "backend-developer", "+7-999-888-77-66", 100,
                        LocalDate.of(1940, 10, 17)),
                new Worker("Petrov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1969, 11, 17)),
                new Worker("Pavlov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1980, 11, 17)),
                new Worker("Denisov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1962, 11, 17)),
                new Worker("Nosov", "Oleg", "Pavlovich", "worker",
                        "+7-999-111-22-66", 2000,
                        LocalDate.of(1970, 11, 17)),
                new Manager("Golopushko", "Apollonariy", "Mitrofanovitch", "manager",
                        "+375-29-649-49-49",3000,
                        LocalDate.of(1968, 7, 13))
        };

        List<Worker> workerList = Arrays.asList(workers);
        System.out.println();
        System.out.println("Доблестная команда сразу после внесения в массив:");
        System.out.println(workerList);

        System.out.println("Average age: " + getAverageAge(workers));
        System.out.println("Average salary: " + getAverageSalary(workers));

        Manager.addSalary(workers, 45, 50);

        System.out.println(Arrays.toString(workers));



        System.out.println("---".repeat(5));
        Collections.sort(workerList);
        System.out.println(workerList);
        System.out.println("---".repeat(5));

        workerList.sort(new WorkerSalaryComparator());
        System.out.println(workerList);

        System.out.println("---".repeat(5));

        workerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(workerList);

        workerList.sort(new WorkerSalaryComparator());
        System.out.println();
        System.out.println("После сортировки по имени:");
        workerList.sort(new WorkerNameComparator());
        for (Worker w: workerList) {
            System.out.println(w.getSurname()  + " " + w.getName() + " " + w.getMiddleName());
        }
    }

    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }

}