public class Student {

    private String Name;
    private int Age;
    private String DateOfBirth;
    public Student(String name, int age, String dob) {
        Name = name;
        Age = age;
        DateOfBirth = dob;
    }

    public String GetName() {
        return Name;
    }

    public int GetAge() {
        return Age;
    }

    public String GetDateOfBirth() {
        return DateOfBirth;
    }

    public String ToString() {
        return Name + "," + Integer.toString(Age) +
               "," + DateOfBirth;
    }

    public static Student Parse(String str) {
        String[] data = str.split(",");

        if(data.length != 3)
            return new Student("Parse Error", -1, "N/A");

        try {
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String dob = data[2];
            return new Student(name, age, dob);
        } catch (NumberFormatException e) {
            return new Student("Parse Error (Age)", -1, "N/A");
        }
    }
}