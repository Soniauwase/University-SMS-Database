import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String field;
    private String department;
    protected List<Course>enrolledCourses=new ArrayList<>();

    public Student(int id, String name, String email, String phoneNumber,String field,String department) {
        super(id, name, email, phoneNumber);
        this.field=field;
        this.department=department;
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "field='" + field + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
    public double calculateGpa(){
        return 0.0;

    }
    // method for adding course to specific student
    public void enrollCourse(Course course){
        enrolledCourses.add(course);

    }

}
