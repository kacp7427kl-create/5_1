/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.Collection;

class Main {
    public static void main(String[] args) {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== 1. Dodawanie nowego studenta ===");

            System.out.print("Podaj Imię studenta: ");
            String name = scanner.nextLine();

            int age = -1;
            while (age < 0) {
                System.out.print("Podaj Wiek studenta: ");
                String ageInput = scanner.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    if (age < 0) {
                        System.out.println("Wiek nie może być ujemny.");
                        age = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Błąd: Wiek musi być liczbą całkowitą.");
                }
            }

            System.out.print("Podaj Datę Urodzenia (jako String, np. 20.04.2003): ");
            String dob = scanner.nextLine();

            Student newStudent = new Student(name, age, dob);
            s.addStudent(newStudent);
            System.out.println("--- Student " + name + " został dodany do bazy danych. ---");

        } catch (IOException e) {
            System.err.println("Błąd operacji plikowej podczas dodawania studenta: " + e.getMessage());
        }

        try {
            System.out.println("\n=== 2. Wyszukiwanie studenta ===");
            System.out.print("Podaj Imię do wyszukania: ");
            String searchName = scanner.nextLine();

            Student foundStudent = s.findStudentByName(searchName);

            if (foundStudent != null) {
                System.out.println("Znaleziono studenta (pierwszy wynik):");
                System.out.println(foundStudent.ToString());
            } else {
                System.out.println("Nie znaleziono studenta o imieniu: " + searchName);
            }

        } catch (IOException e) {
            System.err.println("Błąd operacji plikowej podczas wyszukiwania studenta: " + e.getMessage());
        }

        try {
            System.out.println("\n=== 3. Aktualna Lista Studentów ===");
            Collection<Student> students = s.getStudents();

            if (students.isEmpty()) {
                 System.out.println("Brak studentów w bazie.");
            } else {
                for(Student current : students) {
                    System.out.println(current.ToString());
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd operacji plikowej podczas odczytu studentów: " + e.getMessage());
        } finally {
             scanner.close();
        }
    }
}