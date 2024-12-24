package main;

class Student implements Comparable<Student> {
    int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public int compareTo(Student other) {
        // Compare by studentId
        return Integer.compare(this.studentId, other.studentId);
    }

    @Override
    public String toString() {
        return "Student{id=" + studentId + ", name='" + studentName + "'}";
    }
}