package FileSystemSolution1WithCompositeDesign;

public class File implements FileSystem {

    private String fileName;

    File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ls() {
        System.out.println("File Name: " + fileName);
    }
}
