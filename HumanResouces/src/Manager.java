public class Manager extends Staff implements ICalculator {
    private String jobTitle;
    private int bonusSalary = 0;
    private double salary;

    public Manager(String id, String name, int age, double coefficientsSalary, String dateStartWork, Department department ,int dayOff, String jobTitle) {
        super(id, name, age, coefficientsSalary, dateStartWork, department, dayOff);
        this.jobTitle = jobTitle;
        if (jobTitle.equals("Business Leader")) bonusSalary = 8000000;
        if (jobTitle.equals("Project Leader")) bonusSalary = 5000000;
        if (jobTitle.equals("Technical Leader")) bonusSalary = 8000000;
        salary = (double) super.getCoefficientsSalary() * 5000000 + bonusSalary;    
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public double getSalary() {
        return salary;
    }

    public void displayInformation() {
        System.out.printf("%-8s", super.getId());
        System.out.printf("%-25s", super.getName());
        System.out.printf("%-8s", super.getAge());
        System.out.printf("%-20s", jobTitle);
        System.out.printf("%-25s", super.getCoefficientsSalary());
        System.out.printf("%-15s", super.getDateStartWork());
        System.out.printf("%-25s", super.getDepartmentName());
        System.out.printf("%-15s", super.getDayOff());
        System.out.printf("%-15s","");
        System.out.printf("%.0f\n", salary);     
    }

    public double caculateSalary() {
        salary = (double) super.getCoefficientsSalary() * 5000000 + bonusSalary;
        return salary;
    }

}
