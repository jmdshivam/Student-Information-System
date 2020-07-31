package Student;

public class Student {
    private int collegeId;
    private String fName;
    private String lName;
    private String gender;
    private int age;
    private String  mobile;
    private String email;
    private String stream;
    private String section;
    private String semester;
    private String session;
    private String city;
    private String state;
    private String pincode;


    public Student(int collegeId, String fName, String lName, String gender, int age,
                   String stream, String section, String semester, String session, String mobile, String email,
                   String city, String state, String pincode) {
        this.collegeId = collegeId;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.age = age;
        this. mobile =  mobile;
        this.email = email;
        this.stream = stream;
        this.section = section;
        this.semester = semester;
        this.session = session;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMobile() {
        return  mobile;
    }

    public void setMobile(String  mobile) {
        this. mobile =  mobile;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return collegeId + " "+ fName + " " + lName + " " + gender + " "+ age + " " +
                stream + " "+ section + " "+ semester +
                " "+ session + " " + mobile + " " + email + " " + city + " "+ state + " "+ pincode
                ;
    }

    public void getInfo() {
        System.out.println(
                "First name : "+ fName + "\n" +
                "Last name  : "+ lName + "\n" +
                "Gender     : "+ gender + "\n" +
                "Age        : "+ "" + age + "\n" +
                "Stream     : "+ stream + "\n" +
                "Section    : "+ section + "\n" +
                "Semester   : "+ semester + "\n" +
                "Session    : "+ session + "\n" +
                "Mobile     : "+ mobile + "\n" +
                "Email id   : "+ email + "\n" +
                "City       : "+ city + "\n" +
                "State      : "+ state + "\n" +
                "Pincode    : "+ pincode + "\n"
        );
    }
}
