public class Graduate extends Student{
    private double researchGrade;
    private double finalExamGrade;


    public Graduate(int id, String name, String email,String  phoneNumber, String field, String department,double researchGrade,double finalExamGrade) {
        super(id, name, email, phoneNumber, field, department);
        this.researchGrade=researchGrade;
        this.finalExamGrade=finalExamGrade;

    }

    public double getResearchGrade() {
        return researchGrade;
    }

    public void setResearchGrade(double researchGrade) {
        this.researchGrade = researchGrade;
    }

    public double getFinalExamGrade() {
        return finalExamGrade;
    }

    public void setFinalExamGrade(double finalExamGrade) {
        this.finalExamGrade = finalExamGrade;
    }

    @Override
    public double calculateGpa() {
         double graduateGpa=(researchGrade*60)/100+ (finalExamGrade*40)/100;
         return graduateGpa;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "researchGrade=" + researchGrade +
                ", finalExamGrade=" + finalExamGrade +
                '}';
    }
}
