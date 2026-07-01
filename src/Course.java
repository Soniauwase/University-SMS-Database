import java.util.HashSet;
import java.util.Set;

public class Course {
    private int id;
    private String courseName;
    private String courseCode;
    private  int courseCredit;
    Set<Student>students= new HashSet<>();

    public Course(int id, String courseName, String courseCode, int courseCredit) {
        this.id=id;
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.courseCredit=courseCredit;

        this.students=new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseCredit=" + courseCredit +
                '}';
    }
    public  void addingStudent(Student student){
        students.add(student);
    }
}
