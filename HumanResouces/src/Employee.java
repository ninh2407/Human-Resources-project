public class Employee extends Staff implements ICalculator {
    private int overtimeHours;
    private double salary;

    public Employee(String id, String name, int age, double coefficientsSalary, String dateStartWork, Department department ,int dayOff, int overtimeHours) {
        super(id, name, age, coefficientsSalary, dateStartWork, department, dayOff);
        this.overtimeHours = overtimeHours;
        salary = (double) super.getCoefficientsSalary() * 3000000 + overtimeHours * 200000;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    public int getOvertimeHours() {
        return overtimeHours;
    }
    public double getSalary() {
        return salary;
    }

    public double caculateSalary() {
        salary = (double) super.getCoefficientsSalary() * 3000000 + overtimeHours * 200000;
        return salary;
    }
   
    public void displayInformation() {
        System.out.printf("%-8s", super.getId());
        System.out.printf("%-25s", super.getName());
        System.out.printf("%-8s", super.getAge());
        System.out.printf("%-20s", "");
        System.out.printf("%-25s", super.getCoefficientsSalary());
        System.out.printf("%-15s", super.getDateStartWork());
        System.out.printf("%-25s", super.getDepartmentName());
        System.out.printf("%-15s", super.getDayOff());
        System.out.printf("%-15s", overtimeHours);
        System.out.printf("%.0f\n", salary);   
    }

}
