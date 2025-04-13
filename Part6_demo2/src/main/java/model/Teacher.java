package model;


public class Teacher {
    private Student student;

    public Teacher(Student student){
        this.student = student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "\nstudent=" + student.getName() +
                "\nmark= " + student.getMark() +
                "\n}";
    }
}
