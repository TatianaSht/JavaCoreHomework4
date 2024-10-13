package people;

public class Congratulations {

    public static void congratulateToHoliday(Employee[] employees, Holiday holiday) {

        for (Employee employee: employees)
            switch (holiday) {
                case NEW_YEAR -> System.out.println(employee.name + " "+ employee.middleName +
                        ", Happy New Year!!");
                case FEBRUARY_23 -> {
                    if (employee.gender == Gender.MALE)
                        System.out.println(employee.name + " "+ employee.middleName +
                        ", We congratulate you on February 23!!");
                }
                case MARCH_8 -> {
                    if (employee.gender == Gender.FEMALE)
                        System.out.println(employee.name + " "+ employee.middleName +
                        ", We congratulate you on March 8!!");
                }
                case NO_HOLIDAY -> System.out.println("Good afternoon!");
            }
    }
}
