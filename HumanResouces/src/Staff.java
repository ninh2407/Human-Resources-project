
public abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double coefficientsSalary;
    private String dateStartWork;
    private Department department;
    private int dayOff;

    public Staff(String id, String name, int age, double coefficientsSalary, String dateStartWork, Department department ,int dayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.dateStartWork = dateStartWork;
        this.department = department;
        this.dayOff = dayOff;
    }

    // Khoi tao cac ham setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
    public void setDateStartWork(String dateStartWork) {
        this.dateStartWork = dateStartWork;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setDayoff(int dayOff) {
        this.dayOff = dayOff;
    }
    // Khoi tao cac ham getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }
    public String getDateStartWork() {
        return dateStartWork;
    }
    public Department getDepartment() {
        return department;
    }
    public String getDepartmentName() {
        return department.getNameDepartment();
    }
    public int getDayOff() {
        return dayOff;
    }
    // Khoi tao ham truu tuong
    abstract void displayInformation();
    abstract double getSalary();

}
