package uz.najottalim;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    private static final String PARENT_PATH = "src/main/resources";
    public static void main(String[] args) throws IOException {
        File birinchiFile = new File(PARENT_PATH,"birinchiFile.txt");
        System.out.println(birinchiFile.exists());

        //

        File newFile = new File( PARENT_PATH, "newFile.txt");
        boolean ochildimiYoqmi = newFile.createNewFile();
//        System.out.println(Arrays.toString(newFile.list()));
        System.out.println(ochildimiYoqmi);
        //
        File resourcesPapkam = new File(PARENT_PATH);
        System.out.println(resourcesPapkam.isDirectory());
        System.out.println(Arrays.toString(resourcesPapkam.list()));
//        System.out.println(newFile.get);
//        Optional.ofNullable(newFile.list())
//                .ifPresent(file -> System.out.println(file.length));
        if (newFile.getName()
                .split("\\.")[1].equals("txt")) {
            newFile.delete();
        }
    }
}
