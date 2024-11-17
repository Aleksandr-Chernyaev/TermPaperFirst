import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Александр", "Павел", "Михаил", "Николай", "Анатолий", "Владимир"};
    private final static String[] PATRONYMIC = {"Иванович", "Петрович", "Александрович", "Николаевич", "Владимирович", "Алексеевич"};
    private final static String[] SURNAMES = {"Иванов", "Петров", "Сидоров", "Николаев", "Борисов", "Алексеев"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC[RANDOM.nextInt(0, PATRONYMIC.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(70000, 120000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        printEmployees();
        System.out.println("Общая сумма ЗП сотрудников в месяц: " + calculateAmountOfSalaries());
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinimumSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя ЗП: " + calculateAverageOfSalaries());
        printFullNames();

    }

    private static void printEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateAmountOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinimumSalary() {
        Employee findEmployeeWithMinimumSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (findEmployeeWithMinimumSalary == null || employee.getSalary() < findEmployeeWithMinimumSalary.getSalary()) {
                findEmployeeWithMinimumSalary = employee;
            }
        }
        return findEmployeeWithMinimumSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee findEmployeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (findEmployeeWithMaxSalary == null || employee.getSalary() > findEmployeeWithMaxSalary.getSalary()) {
                findEmployeeWithMaxSalary = employee;
            }
        }
        return findEmployeeWithMaxSalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateAmountOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullNames() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}
