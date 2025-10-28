package student_management_system;

public class Student {
    private int age;
    private final int id;
    private String name;
    private final int rollNo;
    private String course;
    private String bloodGroup;
    private String fatherName;
    private String address;
    private String contactNo;
    private String parentContactNo;
    private double percent;
    private final String collegeName = "SRMU";
    private static int numberOfStudents;

    // Constructor
    private Student(Builder builder) {
        this.age = builder.age;
        this.id = builder.id;
        this.name = builder.name;
        this.rollNo = builder.rollNo;
        this.course = builder.course;
        this.bloodGroup = builder.bloodGroup;
        this.fatherName = builder.fatherName;
        this.address = builder.address;
        this.contactNo = builder.contactNo;
        this.parentContactNo = builder.parentContactNo;
        this.percent = builder.percent;
        numberOfStudents++;
    }

    // Static inner Builder class
    public static class Builder {
        private int id;
        private String name;
        private int age;
        private int rollNo;
        private String course;
        private String bloodGroup;
        private String fatherName;
        private String address;
        private String contactNo;
        private String parentContactNo;
        private double percent;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Builder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public Builder setParentContactNo(String parentContactNo) {
            this.parentContactNo = parentContactNo;
            return this;
        }

        public Builder setPercentage(double percent) {
            this.percent = percent;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    // getters for all attributes
    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public double getPercent() {
        return percent;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    // setters for required attributes
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    // display students info
    public void displayStudentInfo() {
        System.out.println("******************");
        System.out.println("***Student Info***");
        System.out.println("******************");
        System.out.println("College Name:" + collegeName);
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Roll Number:" + rollNo);
        System.out.println("Course:" + course);
        System.out.println("Blood Group:" + bloodGroup);
        System.out.println("Father's name:" + fatherName);
        System.out.println("Address:" + address);
        System.out.println("Contact number:" + contactNo);
        System.out.println("Parent's contact number:" + parentContactNo);
        System.out.println("Percent:" + percent);
    }

    // display number of students
    public static void displayNoOfStudents() {
        System.out.println("Total number of students are: " + numberOfStudents);
    }
}
