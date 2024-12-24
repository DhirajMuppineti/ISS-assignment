package main;

class Student {
    int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }


    @Override
    public String toString() {
        return "Student{id=" + studentId + ", name='" + studentName + "'}";
    }
}