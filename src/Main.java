import exception.AmountException;
import exception.CustomerException;
import exception.ProductException;
import people.*;
import shop.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        Congratulations.congratulateToHoliday(employees, Holiday.FEBRUARY_23);
        Arrays.stream(people).forEach(System.out::println);

        Order[] orders = new Order[5];

        Object[][] info = {
                {people[0], items[0], 1},
                {people[1], items[1], -1},
                {people[0], items[2], 150},
                {people[1], new Item("Flower", 10), 1},
                {new Customer("Fedor", 40, "+3-444-555-66-77", Gender.MALE), items[3], 1},
        };

        int capacity = 0;
        int i = 0;
        while (capacity != orders.length - 1 || i != info.length) {
            try {
                orders[capacity] = buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                orders[capacity++] = buy((Customer) info[i][0], (Item) info[i][1], 1);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++i;
        }
    }


    private static boolean isInArray(Object[] arr, Object o) {
        for (Object value : arr) if (value.equals(o)) return true;
        return false;
    }


    public static Order buy(Customer who, Item what, int howMuch) {
        if (!isInArray(people, who))
            throw new CustomerException("Unknown customer: " + who);
        if (!isInArray(items, what))
            throw new ProductException("Unknown item: " + what);
        if (howMuch < 0 || howMuch > 100)
            throw new AmountException("Incorrect amount: " + howMuch);
        return new Order(who, what, howMuch);
    }

    static final Customer[] people = {
            new Customer("Ivan", 20, "+1-222-333-44-55", Gender.MALE),
            new Customer("Petr", 30, "+2-333-444-55-66", Gender.MALE),
            new Customer("Elena", 22, "+1-123-321-55-22", Gender.FEMALE),
    };


    static final Item[] items = {
            new Item("Ball", 100),
            new Item("Sandwich", 1000),
            new Item("Table", 10000),
            new Item("Car", 100000),
            new Item("Rocket", 10000000)
    };

    static final Employee[] employees = {
            new Employee("Ovchinnikov", "Ivan", "Igorevich",
                    "salesman", "8(495)100-22-33", 50000,
                    35, Gender.MALE),
            new Employee("Bezrukov", "Andrey", "Viktorovich",
                    "loader", "8(495)111-22-33", 52000,
                    28, Gender.MALE),
            new Employee("Delfinov", "Evgeniy", "Viktorovich",
                    "cashier", "8(495)222-33-44", 40000,
                    464, Gender.MALE),
            new Employee("Keks", "Natalia", "Pavlovna",
                    "salesman", "8(495)333-44-55", 90000,
                    31, Gender.FEMALE),
            new Employee("Krasotkina", "Tatiana", "Sergeevna",
                    "accountant", "8(495)444-55-66", 50000,
                    27, Gender.FEMALE),
    };

}