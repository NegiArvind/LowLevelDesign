package ProblemStatement;

public class File {
    private String fileName;

    File(String fileName) {
        this.fileName = fileName;
    }

    void ls() {
        System.out.println("File name: " + fileName);
    }
}
