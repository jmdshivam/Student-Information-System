package Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    private String name;
    private int maxIndex;
    private ArrayList<Student> myData;

    public Data(String name) {
        this.name = name;
        myData = new ArrayList<>();
    }


    //Method for seaching student
    private int findStudent(int collegeId){
        for (int i = 0; i<myData.size(); i++){
            if (myData.get(i).getCollegeId() == collegeId)
                return i;
        }
        return -1;
    }

    public Student searchStudent(int collegeId){
        int pos = findStudent(collegeId);
        if (pos >=0 )
            return myData.get(pos);
        else{
            System.out.println("College id " + collegeId+ " not found!");
            return null;
        }
    }

    //Method for add student
    public boolean addStudent(Student student){
        if (student != null){
            myData.add(student);
            maxIndex++;
            return true;
        }
        return false;
    }

    //Method for deleting student from database
    public Student removeStudent(int collegeId) {
        int pos = findStudent(collegeId);
        if (pos >=0){
            Student student = myData.get(pos);
            myData.remove(pos);
            return student;
        }
        return null;
    }

    //Method for updating student detail.
    public boolean updateStudent(int collegeId){
        Scanner scanner = new Scanner(System.in);
        int pos = findStudent(collegeId);
        if (pos >= 0) {
                System.out.println("Existing information related with college id: "+ collegeId );
                myData.get(pos).getInfo();
                System.out.println("Choose :");
                System.out.println(
                                "\t\t01 - To update first name\n" +
                                "\t\t02 - To update last name\n" +
                                "\t\t03 - To update geder\n" +
                                "\t\t04 - To update age\n" +
                                "\t\t05 - To update stream\n" +
                                "\t\t06 - To update section\n" +
                                "\t\t07 - To update semester\n" +
                                  "\t\t08 - To update session\n" +
                                "\t\t09 - To update mobile number\n" +
                                "\t\t10 - To udate email id\n" +
                                "\t\t11 - To update city\n" +
                                 "\t\t12 - To update state\n" +
                                "\t\t13 - To update pincode\n" +
                                "\t\t14 - To quit"
                                );
                int[] options = isValid(1, 14);
                Student newStudent = null;
                for (int choice : options) {
                    newStudent = myData.get(pos);
                    switch (choice) {
                        case 1:
                            System.out.println("Old first name : " + newStudent.getfName());
                            System.out.print("Enter new first name: ");
                            newStudent.setfName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Old last name : " + newStudent.getlName());
                            System.out.print("Enter new last name: ");
                            newStudent.setlName(scanner.nextLine());
                            break;
                        case 3:
                            System.out.println("Old gender : " + newStudent.getGender());
                            newStudent.setGender(Main.getGender());
                            break;
                        case 4:
                            System.out.println("Old age : " + newStudent.getAge());
                            newStudent.setAge(getChoice(1, 100, "choice"));
                            break;
                        case 5:
                            System.out.println("Old stream : " + newStudent.getStream());
                            System.out.print("Enter new stream: ");
                            newStudent.setStream(scanner.nextLine());
                            break;
                        case 6:
                            System.out.println("Old section: " + newStudent.getSection());
                            System.out.print("Enter new section: ");
                            newStudent.setSection(scanner.nextLine());
                            break;
                        case 7:
                            System.out.println("Old semester: " + newStudent.getSemester());
                            System.out.print("Enter new semester: ");
                            newStudent.setSemester(scanner.nextLine());
                            break;
                        case 8:
                            System.out.println("Old session: " + newStudent.getSession());
                            System.out.print("Enter new session: ");
                            newStudent.setSession(scanner.nextLine());
                            break;
                        case 9:
                            System.out.println("Old contact number: " + newStudent.getMobile());
                            newStudent.setMobile(Main.getRequiredLenghtString("mobile", 10));
                            break;
                        case 10:
                            System.out.println("Old email id: " + newStudent.getEmail());
                            newStudent.setEmail(Main.getEmail());
                            break;
                        case 11:
                            System.out.println("Old city: " + newStudent.getCity());
                            System.out.print("Enter new city: ");
                            newStudent.setCity(scanner.nextLine());
                            break;
                        case 12:
                            System.out.println("Old state: " + newStudent.getState());
                            System.out.print("Enter new state: ");
                            newStudent.setState(scanner.nextLine());
                            break;
                        case 13:
                            System.out.println("Old pincode: " + newStudent.getPincode());
                            newStudent.setPincode(Main.getRequiredLenghtString("picode", 6));
                            break;
                        case 14:
                            break;
                    }

                }
                if (newStudent != null) {
                    System.out.println("\nUpdated information attached with college id: " + collegeId);
                    newStudent.getInfo();
                }

        }else {
            System.out.println("Student with college id " + collegeId +" not found.");
            return false;
        }
        return true;
    }

    //For taking integer input for the switch case
    public static int getChoice(int min, int max, String data){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.print("Enter your " + data+ ": ");
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
                else{
                    System.out.println("Please enter a valid integer between " + min + " to " + max + ".");
                    return getChoice(min, max, data);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer between " + min + " to " + max + ".");
                scanner.nextLine();
            }
        }
    }

    private int[] isValid(int min, int max){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your choices sepreted with space(eg. 1 2 3): ");
                String[] input = scanner.nextLine().split(" ");
                int[] output = new int[input.length];
                int i = 0;
                for (String str : input) {
                    int in = Integer.parseInt(str);
                    if (in >= min && in <= max) {
                        output[i++] = in;
                    }
                    else {
                        System.out.println("Please enter integers between " + min + " to " + max + ".");
                        break;
                    }
                }
                if (i == input.length)
                    return output;
            }catch (Exception e){
                System.out.println("Please enter integers between " + min + " to " + max + ".");
            }
        }

    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getMyData() {
        return myData;
    }
}
