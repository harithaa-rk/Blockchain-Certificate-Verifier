package model;

public class Certificate {
    private String id;
    private String studentName;
    private String course;
    private String issueDate;
    private String hash;

    public Certificate(String id, String studentName, String course, String issueDate, String hash) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.issueDate = issueDate;
        this.hash = hash;
    }

    public String getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getCourse() { return course; }
    public String getIssueDate() { return issueDate; }
    public String getHash() { return hash; }
}
