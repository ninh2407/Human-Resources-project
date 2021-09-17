public class Department {
    private int idDepartment;
    private String nameDepartment;
    private int numberOfStaff = 0;

    public Department() {

    }

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Department(int idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    // Khoi tao cac setter
    public void setIdDepartment(int IdDepartment) {
        this.idDepartment = IdDepartment;
    }
    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }
    // Khoi tao cac getter
    public int getIdDepartment() {
        return idDepartment;
    }
    public String getNameDepartment() {
        return nameDepartment;
    }
    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public String toString() {
        return "ID: " + idDepartment + ", name: " + nameDepartment + ", number of staff: " + numberOfStaff; 
    }

    public void addEmployee() {
        numberOfStaff++;
    }
}
