import model.Certificate;
import service.CertificateService;
import service.CertificateStorage;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Blockchain Certificate Verifier ---");
            System.out.println("1. Upload Certificate");
            System.out.println("2. Verify Certificate");
            System.out.println("3. Exit");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter issue date: ");
                    String date = sc.nextLine();
                    System.out.print("Enter path to certificate file (PDF): ");
                    String path = sc.nextLine();

                    File file = new File(path);
                    String hash = CertificateService.generateHash(file);
                    String id = UUID.randomUUID().toString().substring(0, 8);

                    Certificate cert = new Certificate(id, name, course, date, hash);
                    CertificateStorage.store(cert);

                    System.out.println("Certificate uploaded. ID: " + id);
                    break;

                case 2:
                    System.out.print("Enter Certificate ID: ");
                    String certId = sc.nextLine();
                    System.out.print("Enter path to certificate file to verify: ");
                    String verifyPath = sc.nextLine();

                    File verifyFile = new File(verifyPath);
                    String verifyHash = CertificateService.generateHash(verifyFile);

                    boolean isValid = CertificateStorage.verify(certId, verifyHash);
                    System.out.println(isValid ? "Certificate Verified ✅" : "Invalid Certificate ❌");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
