package Student;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Data  myDataBase;

    public static void main(String[] args) {
        System.out.println("\n\n\t\t\t\t\t\t\t\tWelcome To Student Information System");
        if (loginValidity(scanner, "Admin", "1234")){
            loadData();
            if (myDataBase == null){
                System.out.println("Data loading failed");
                System.out.println("Program exit");
                return;
            }
            System.out.println("Loading data...");
            boolean quit = false;
            Student student;
            while (!quit){
                int choice = Data.getChoice(1, printChoice(), "choice");
                System.out.println("choice: " + choice);
                student = null;
                switch (choice){
                    case 1:
                        student = getStudent();
                        if (student != null){
                            myDataBase.addStudent(student);
                            System.out.println("Registration successful");
                            System.out.println("Your college id : " + student.getCollegeId());
                        }
                        else
                            System.out.println("Registration failed , Invalid details");
                        break;
                    case 2:
                        student = myDataBase.removeStudent(getId());
                        if (student != null){
                            System.out.println("Student with college id " + student.getCollegeId() + " removed successfully.");
                        }
                        else {
                            System.out.println("Can't remove.");
                            System.out.println("Student not found with given college id.");
                        }
                        break;
                    case 3:
                        myDataBase.updateStudent(getId());
                        break;
                    case 4:
                        student = myDataBase.searchStudent(getId());
                        if (student != null){
                            System.out.println("Existing information related with college id: "+ student.getCollegeId());
                            student.getInfo();
                        }
                        break;
                    case 5:
                        exploreDatabase();
                        break;
                    case 6:
                        quit = true;
                        if (storeData()){
                            System.out.println("Log out successfully.");
                        }
                        else {
                            System.out.println("Data storing failed.");
                            System.out.println("Log out with internal error!!!");
                        }

                }

            }
        }

    }

    private static void exploreDatabase(){
        System.out.println("\n\n\t\t\t\t\t\t\t"+ myDataBase.getName() + " Data-Base");
        System.out.println("==============================================================================================================================================");
        System.out.println("\tPersonal Information\t\t\tAcademic Information\t\t\t\tContact Information\t\t\t\t\t\t");
        System.out.println("==============================================================================================================================================");

        for (Student s1 : myDataBase.getMyData()) {
            System.out.println(" "+ s1.getCollegeId() + "\t" + s1.getfName() + "\t" +
                    s1.getlName() + "\t  " +
                    s1.getGender() + "\t" +
                    s1.getAge() + "\t" +
                    s1.getStream() + "\t" +
                    s1.getSection() + "\t" +
                    s1.getSemester()+ "\t" +
                    s1.getSession() + "\t" +
                    s1.getMobile() + "\t" +
                    s1.getEmail() + "\t" +
                    s1.getCity() + "\t" +
                    s1.getState() + "\t" +
                    s1.getPincode());
        }
    }

    private static int printChoice(){
        System.out.println("Choose:");
        System.out.println("\t\t1 - To registration new student\n" +
                "\t\t2 - To remove an existing old student\n" +
                "\t\t3 - To update an existing student's detail\n" +
                "\t\t4 - To view detail of an existing student detail\n" +
                "\t\t5 - To explore student's database\n" +
                "\t\t6 - To log out");
        return 6;
    }

    private static boolean loginValidity(Scanner scanner, String userId, String password){

        while (true){
            System.out.print("Enter your user id: ");
            String user = scanner.nextLine();
            System.out.print("Enter your password: ");
            String pass = scanner.nextLine();
            if (userId.equals(user) && password.equals(pass)){
                System.out.println("Login as " + userId);
                return true;
            }
            System.out.println("Invalid user id or password");
            System.out.println("Choose:");
            System.out.println("\t\t1 - Try to login again\n" +
                            "\t\t2 - To quit.");
            int choice = Data.getChoice(1,2, "choice");
            switch (choice) {
                case 1:
                    return loginValidity(scanner, userId, password);
                case 2:
                    return false;
            }


        }
    }

    private static Student getStudent(){
        int collegeId = generateId();
        System.out.println("Enter student details");
        System.out.print("Enter first name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lName = scanner.nextLine();
        String gender = getGender();
        int age = Data.getChoice(1,100, "age");
        String mobile = getRequiredLenghtString("mobile",10);
        String email = getEmail();
        System.out.print("Enter stream: ");
        String stream = scanner.nextLine();
        System.out.print("Enter section: ");
        String section = scanner.nextLine();
        System.out.print("Enter smester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter session: ");
        String session = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        String pincode = getRequiredLenghtString("pincode",6);
        return new Student(collegeId, fName, lName, gender, age, stream, section, semester, session, mobile, email, city, state, pincode);
    }

    public static String getGender(){

        while (true) {
            System.out.println("Select gender\n" +
                    "\t\t1 - For male\n" +
                    "\t\t2 - For female");
            int genderIndex = Data.getChoice(1, 2, "choice");
            if (genderIndex == 1)
                return "M";
            else
                return "F";
        }
    }

    public static String getRequiredLenghtString(String name, int size) {
        System.out.print("Enter "+ name + ": ");
        String result = scanner.nextLine();
        if (result.length() == size){
            return result;
        }
        else {
            System.out.println("Please enter a valid " + name + " of " + size + " digits");
            return getRequiredLenghtString(name, size);
        }

    }

    public static String getEmail(){
        System.out.print("Enter email id: ");
        String email = scanner.nextLine();
        if (email.contains("@") && email.contains("."))
            return email;
        else {
            System.out.println("Email must contains @ and . character");
            return getEmail();
        }
    }

    private static int generateId(){
        return 1000 + myDataBase.getMaxIndex();
    }

    private static int getId() {
        while (true){
            try {
                System.out.print("Enter college id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                return id;
            }catch (InputMismatchException e){
                System.out.println("Please enter an valid integer");
            }
        }
    }

    private static boolean loadData(){
        myDataBase = new Data("Techno Main SaltLake");
        Student student;
        String str;
        FileReader fileReader;
        try {
            fileReader = new FileReader("myData.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            myDataBase.setMaxIndex(Integer.parseInt(bufferedReader.readLine()));
            while ((str = bufferedReader.readLine()) != null){
                String[] data = str.split(" ");
                student = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]),
                        data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13]);
                myDataBase.addStudent(student);
            }
            int size = myDataBase.getMyData().size();
            myDataBase.setMaxIndex(myDataBase.getMaxIndex() - size);
            bufferedReader.close();
            return true;
        }catch (IOException e){

            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean storeData(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("myData.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(("" + myDataBase.getMaxIndex()));
            bufferedWriter.newLine();
            for(Student student: myDataBase.getMyData()){
                if (student != null){
                    bufferedWriter.write(student.toString());
                    bufferedWriter.newLine();
                }
                else
                    break;
            }
            bufferedWriter.close();
            return true;
        }catch (IOException e){
            System.out.println("Can't able to write data.");
        }
        return false;
    }

}
