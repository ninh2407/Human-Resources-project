import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HumanResources {
    public static ArrayList<Staff> staffList = new ArrayList<>();
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Department department = new Department();
    public static int selection = -1;
    public static String answer = "";
    // Pattern cho ngay bat dau vao lam viec
    public static Pattern pattern = Pattern.compile("^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$");

    public static void begin() {
        System.out.println("HR MANAGENMENT PROGRAM");
        System.out.println("---------------------------------------------------------");
        System.out.println();
        System.out.println("1. Display the list of existing employees in the company");
        System.out.println("2. Show departments in the company");
        System.out.println("3. Display employees by department");
        System.out.println("4. Add new employees to the company");
        System.out.println("5. Search for employee information by name");
        System.out.println("6. Search for employee information by employee Id");
        System.out.println("7. Display payroll of employees throughout the company");
        System.out.println("8. Display employee payroll in ascending order");
        System.out.println("9. Display the payroll of company employees in descending order");
        System.out.println("0. Exit");
        System.out.print("Enter your selection: ");
        selection = sc.nextInt();
        while (selection < 0 || selection > 9) {
            System.out.println("Your selection is not valid, please re-enter: ");
            selection = sc.nextInt();
        }
        System.out.println();
    }

    // Khoi tao phong ban co san
    public static void setDepartment() {
        departmentList.add(new Department(101, "Business"));
        departmentList.add(new Department(102, "Project"));
        departmentList.add(new Department(103, "Technical"));
    }

    // Khoi tao nhan vien co san
    public static void setEmployee() {
        staffList.add(new Employee("01", "NGUYEN VAN A", 25, 1.5, "25/02/2006", departmentList.get(0), 12, 5));
        departmentList.get(0).addEmployee();
        staffList.add(new Employee("02", "NGUYEN VAN B", 25, 2, "22/02/2001", departmentList.get(1), 12, 5));
        departmentList.get(1).addEmployee();
        staffList.add(new Employee("03", "NGUYEN VAN C", 25, 1, "21/02/2002", departmentList.get(2), 12, 5));
        departmentList.get(2).addEmployee();
    }

    // Khoi tao quan ly co san
    public static void setManager() {
        staffList.add(0,
                new Manager("101", "NGUYEN THI A", 44, 3, "20/01/2001", departmentList.get(0), 12, "Business Leader"));
        departmentList.get(0).addEmployee();
        staffList.add(0,
                new Manager("102", "NGUYEN THI B", 40, 3.3, "20/01/2010", departmentList.get(1), 12, "Project Leader"));
        departmentList.get(1).addEmployee();
        staffList.add(0, new Manager("103", "NGUYEN THI C", 59, 3.1, "01/01/2006", departmentList.get(2), 12,
                "Technical Leader"));
        departmentList.get(2).addEmployee();
    }

    // 1. Display the list of existing employees in the company
    public static void displayListOfStaff() {
        System.out.printf("%-8s%-25s%-8s%-20s%-25s%-15s%-25s%-12s%-18s%-15s\n", "ID", "NAME", "AGE", "JOB TITLE", "COEFFICIENTS SALARY", "DATE", "DEPARTMENT", "DAY OFF", "OVERTIME HOURS", "SALARY");
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).displayInformation();
        }
    }

    // 2. Show departments in the company
    public static void showDepartment() {
        System.out.println("List of department:");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i).toString());
        }
    }

    // 3. Display employees by department
    public static void displayStaffByDepartment() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getDepartment().getNameDepartment().compareTo(o2.getDepartment().getNameDepartment());
            }
        });
        System.out.println("LIST OF EMPLOYEE BY DEPARTMENT:");
        displayListOfStaff();
    }

    // 4a. Add new employees to the company (Employee)
    public static void addEmployee() {
        System.out.print("Enter Employee's ID: ");
        String id = sc.next();
        System.out.print("Enter Employee's name: ");
        String name = sc.nextLine();
        name = sc.nextLine();
        System.out.print("Enter Employee's age: ");
        int age = Integer.parseInt(sc.nextLine());
        while (age <= 0) {
            System.out.print("Age is not valid, please re-enter Employee's age: ");
            age = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Enter Employee's Coefficients Salary: ");
        double coefficientsSalary = Double.parseDouble(sc.next());
        while (coefficientsSalary <= 0) {
            System.out.print("Coefficients Salary is not valid, please re-enter Employee's Coefficients Salary: ");
            coefficientsSalary = Double.parseDouble(sc.next());
        }
        String dateStartWork = "";
        while (true) {
            System.out.print("Enter date start work(dd-MM-yyy): ");
            dateStartWork = sc.next();
            if (pattern.matcher(dateStartWork).find()) {
                break;
            } else {
                System.out.print("Date is not valid, please re-enter(dd-MM-yyy)!");
            }
        }
        System.out.print("Enter Employee's department: ");
        String departmentChoice = sc.nextLine();
        departmentChoice = sc.nextLine();
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentChoice.equalsIgnoreCase(departmentList.get(i).getNameDepartment())) {
                departmentList.get(i).addEmployee();
                department = departmentList.get(i);
                break;
            }
            if (i == departmentList.size() - 1 && !departmentChoice.equalsIgnoreCase(departmentList.get(i).getNameDepartment())) {
                departmentList.add(new Department(departmentChoice));
                department = departmentList.get(departmentList.size() - 1);
                departmentList.get(departmentList.size() - 1).addEmployee();
                break;
            }
        }
        System.out.print("Enter Employee's day off: ");
        int dayOff = sc.nextInt();
        System.out.print("Enter Employee's overtime hours: ");
        int overtimeHours = sc.nextInt();
        staffList.add(new Employee(id, name, age, coefficientsSalary, dateStartWork, department, dayOff, overtimeHours));
    }

    // 4b. Add new employees to the company (Manager)
    public static void addManager() {
        String id = sc.nextLine();
        System.out.print("Enter Manager's ID: ");
        id = sc.nextLine();
        System.out.print("Enter Manager's name: ");
        String name = sc.nextLine();
        System.out.print("Enter Manager's job title: ");
        String jobTitle = sc.nextLine();
        System.out.print("Enter Manager's age: ");
        int age = Integer.parseInt(sc.nextLine());
        while (age <= 0) {
            System.out.print("Age is not valid, please re-enter Manager's age: ");
            age = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Enter Manager's Coefficients Salary: ");
        double coefficientsSalary = Double.parseDouble(sc.nextLine());
        while (coefficientsSalary <= 0) {
            System.out.print("Coefficients Salary is not valid, please re-enter Manager's Coefficients Salary: ");
            coefficientsSalary = Double.parseDouble(sc.nextLine());
        }
        String dateStartWork = "";
        while (true) {
            System.out.print("Enter date start work(dd-MM-yyy): ");
            dateStartWork = sc.next();
            if (pattern.matcher(dateStartWork).find()) {
                break;
            } else {
                System.out.println("Date is not valid, please re-enter(dd-MM-yyy): ");
                dateStartWork = sc.next();
            }
        }
        System.out.print("Enter Manager's department: ");
        String departmentChoice = sc.nextLine();
        departmentChoice = sc.nextLine();
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentChoice.equalsIgnoreCase(departmentList.get(i).getNameDepartment())) {
                departmentList.get(i).addEmployee();
                department = departmentList.get(i);
                break;
            }
            if (i == departmentList.size() - 1 && !departmentChoice.equalsIgnoreCase(departmentList.get(i).getNameDepartment())) {
                departmentList.add(new Department(departmentChoice));
                department = departmentList.get(departmentList.size() - 1);
                departmentList.get(departmentList.size() - 1).addEmployee();
                break;
            }
        }
        System.out.print("Enter Manager's day off: ");
        int dayOff = Integer.parseInt(sc.next());
        staffList.add(0, new Manager(id, name, age, coefficientsSalary, dateStartWork, department, dayOff, jobTitle));
    }

    // 5. Search for employee information by name
    public static void searchByName() {
        System.out.print("Enter employee's name: ");
        String nameSearch = sc.nextLine();
        nameSearch = sc.nextLine();
        int count = 0;
        System.out.println("Search results:\n");
        System.out.printf("%-8s%-25s%-8s%-20s%-25s%-15s%-25s%-12s%-18s%-15s\n", "ID", "NAME", "AGE", "JOB TITLE",
                "COEFFICIENTS SALARY", "DATE", "DEPARTMENT", "DAY OFF", "OVERTIME HOURS", "SALARY");
        for (int i = 0; i < staffList.size(); i++) {
            if (nameSearch.equals(staffList.get(i).getName())) {
                staffList.get(i).displayInformation();
                count++;
            }
        }
        System.out.println();
        System.out.println("Total results: " + count);
    }

    // 6. Search for employee information by ID
    public static void searchById() {
        System.out.print("Enter employee's ID ");
        String idSearch = sc.next();
        int count = 0;
        System.out.println("Search results:");
        System.out.printf("%-8s%-25s%-8s%-20s%-25s%-15s%-25s%-12s%-18s%-15s\n", "ID", "NAME", "AGE", "JOB TITLE",
                "COEFFICIENTS SALARY", "DATE", "DEPARTMENT", "DAY OFF", "OVERTIME HOURS", "SALARY");
        for (int i = 0; i < staffList.size(); i++) {
            if (idSearch.equals(staffList.get(i).getId())) {
                staffList.get(i).displayInformation();
                count++;
            }
        }
        System.out.println("Total results: " + count);
    }

    // 7. Display payroll of employees throughout the company
    public static void showPayroll() {
        System.out.println("Payroll of employees throughout the company\n");
        displayListOfStaff();
    }

    // 8. Display employee payroll in ascending order
    public static void showPayrollInOder() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.getSalary() > o2.getSalary())
                    return 1;
                else if (o1.getSalary() == o2.getSalary())
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("Payroll of employees throughout the company in ascending order\n");
        displayListOfStaff();
    }

    // 9. Display the payroll of company employees in descending order
    public static void showPayrollInDescending() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.getSalary() < o2.getSalary())
                    return 1;
                else if (o1.getSalary() == o2.getSalary())
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("Payroll of employees throughout the company in ascending order\n");
        displayListOfStaff();
    }

    public static void main(String[] args) {
        setDepartment();
        setEmployee();
        setManager();
        do {
            begin();
            switch (selection) {
                case 1:
                    System.out.println("LIST OF EMPLOYEE");
                    displayListOfStaff();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 2:
                    showDepartment();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 3:
                    displayStaffByDepartment();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 4:
                    System.out.print("Do you want to add Employee or Manager (Enter 1 to add Employee, Enter 2 to add Manager): ");
                    int choice = sc.nextInt();
                    while (choice < 1 || choice > 2) {
                        System.out.print("Choosen is not valid, please re-enter:");
                        choice = sc.nextInt();
                    }
                    if (choice == 1)
                        addEmployee();
                    else if (choice == 2)
                        addManager();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 5:
                    searchByName();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 6:
                    searchById();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 7:
                    showPayroll();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 8:
                    showPayrollInOder();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
                case 9:
                    showPayrollInDescending();
                    System.out.print("Do you want to continue (Yes/No)? ");
                    answer = sc.next();
                    break;
            }
            System.out.println();
            if (!answer.equalsIgnoreCase("yes")) break;
        } while (selection != 0);
    }
}
