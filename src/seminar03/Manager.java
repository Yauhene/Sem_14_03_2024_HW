package seminar03;

import java.time.*;

public class Manager extends Worker{

    public Manager(String surname, String name, String middleName, String position, String phoneNumber, int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if (worker.getAge() >= age && !worker.getPosition().equals("manager")) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.println("Зарплата повышена успешно!!!");
    }
}
