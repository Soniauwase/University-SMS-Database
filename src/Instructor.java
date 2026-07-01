public class Instructor extends Person{
    private String department;
    private String title;

    public Instructor(int id, String name, String email, String phoneNumber,String title,String department) {
        super(id, name, email, phoneNumber);
        this.department=department;
        this.title=title;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "department='" + department + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
