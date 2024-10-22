package ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectList;

    Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectList = new ArrayList<>();
    }

    public void add(Object obj) {
        objectList.add(obj);
    }

    public void ls() {
        System.out.println("Directory name: " + directoryName);
        for(Object object: objectList) {
            // This is the problem that we have to check instance and then call respect ls method. We can solve it using composite design pattern
            if(object instanceof File) {
                ((File)object).ls();
            } else if(object instanceof Directory) {
                ((Directory)object).ls();
            }
        }
    }
}
