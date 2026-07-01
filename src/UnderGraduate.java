public class UnderGraduate extends Student{
    private double assignmentGrade;
    private double midtermGrade;
    private double finalExamGrade;

    public UnderGraduate(int id, String name, String email, String phoneNumber, String field, String department, double assignmentGrade, double midtermGrade, double finalExamGrade) {
        super(id, name, email, phoneNumber, field, department);
        this.assignmentGrade=assignmentGrade;
        this.midtermGrade=midtermGrade;
        this.finalExamGrade=finalExamGrade;
    }

    public double getAssignmentGrade() {
        return assignmentGrade;
    }

    public void setAssignmentGrade(double assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }

    public double getMidtermGrade() {
        return midtermGrade;
    }

    public void setMidtermGrade(double midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public double getFinalExamGrade() {
        return finalExamGrade;
    }

    public void setFinalExamGrade(double finalExamGrade) {
        this.finalExamGrade = finalExamGrade;
    }

    @Override
    public double calculateGpa() {
        double underGraduateGrade=(assignmentGrade*30)/100+(midtermGrade*30)/100+(finalExamGrade*40)/100;
        return underGraduateGrade;
    }

    @Override
    public String toString() {
        return "UnderGraduate{" +
                "assignmentGrade=" + assignmentGrade +
                ", midtermGrade=" + midtermGrade +
                ", finalExamGrade=" + finalExamGrade +
                '}';
    }

}
