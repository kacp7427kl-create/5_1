public class Student {

  private String Name;
  private int Age;
  private String DateOfBirth; 

  public Student(String name, int age, String dateOfBirth) {
    Name = name;
    Age = age;
    DateOfBirth = dateOfBirth;
  }

  public String GetName() { return Name; }
  public int GetAge() { return Age; }
  public String GetDateOfBirth() { return DateOfBirth; }

  public String ToString() {
    
    return Name + " " + Integer.toString(Age) + " " + DateOfBirth;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");

    if(data.length != 3) 
      return new Student("Parse Error", -1, "");

    return new Student(data[0], Integer.parseInt(data[1]), data[2]);
  }
}