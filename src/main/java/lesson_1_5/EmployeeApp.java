package lesson_1_5;

public class EmployeeApp {

    public static void main(String[] args) {

        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Olga Go", "cleaner", "olga@gmail.com", "+375448888888", 600, 42);
        employeesArray[1] = new Employee("Asya Gone", "super cleaner", "asya@gmail.com", "+375449988888", 900, 44);
        employeesArray[2] = new Employee("Vasya Gorr", "manager", "12569@gmail.com", "+375448888758", 100, 40);
        employeesArray[3] = new Employee("Oleg Ernst", "super manager", "999@gmail.com", "+375448848908", 20000, 101);
        employeesArray[4] = new Employee("Filya Dor", "programmer", "hello@gmail.com", "+375448888800", 9800, 35);

        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40) {
                employeesArray[i].info();
            }
        }

    }
}
