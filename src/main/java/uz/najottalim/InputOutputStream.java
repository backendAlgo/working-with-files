package uz.najottalim;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputOutputStream {
    private static final String PARENT_PATH = "src/main/resources/files";
    public static void main(String[] args) throws IOException, InterruptedException {
        File inputFile = new File(PARENT_PATH, "input.txt");
        File outputFile = new File(PARENT_PATH, "output.txt");
//        if (inputFile.exists() && inputFile.isFile()
//                && outputFile.exists() && outputFile.isFile()) {
//            FileInputStream inputFile = null;
//            try {
//                inputFile = new FileInputStream(file);
//            } catch (FileNotFoundException ex) {
//                System.out.println("xatolik");
//            } finally {
//                inputFile.close();
//            }

//            try (FileInputStream fileInputStream = new FileInputStream(inputFile);
//                 FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
//                int c;
//                while ((c = fileInputStream.read()) != -1) {
//                    fileOutputStream.write(c);
//                }
//                Scanner sc = new Scanner(System.in);
//            }
//            catch (FileNotFoundException exception) {
//                System.out.println("xatolik");
//            }
//            catch (IOException e) {
//                System.out.println("oqishdagi");
//            }
//            catch (Exception ex) {
//                System.out.println("nomalum xatolik");
//            }
//        }

//        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(
//                new FileInputStream(inputFile)
//        )) {
//            bufferedInputStream.read();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//            try (FileReader reader = new FileReader(inputFile)) {
//                char[] charArray = new char[6];
//                charArray[0] = 'm';
//                reader.read(charArray, 1, 5);
//
//                System.out.println(charArray);
//                while (reader.read(charArray) != -1) {
//                    System.out.println(charArray);
//                }
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        }
        Path inputFilePath = Path.of(PARENT_PATH, "input.txt");
        if (Files.exists(inputFilePath)) {
            System.out.println(inputFilePath.getFileName() + " fayl mavjud");
        }
        if (Files.isRegularFile(inputFilePath)) {
            System.out.println(inputFilePath.getFileName() + " regular file");
        }
        String fileName = "myFile_" + UUID.randomUUID() + ".txt";
        Files.createFile(Path.of(PARENT_PATH, fileName));
        String prefix = "log_";
        String suffix = ".txt";
        Path p = Paths.get(PARENT_PATH + "/");

        Files.createTempFile(p, null, null);
        Files.createTempFile(p, null, null);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("kirdi");
            Path parentFile = Path.of(PARENT_PATH);
            try {
                Files.list(parentFile)
//                        .peek(path -> System.out.println(path))
                        .filter(path -> path.getFileName().toString().endsWith(".tmp"))
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
//        Files.createDirectories(Path.of(
//                "src/main/resource/files/aad/adsasd/adad"
//        ));
//        Files.createDirectory(Path.of(
//                "src/main/resource/files"
//        ));
        Path secondParentPath = Path.of("src/main/resource/files");
//        Files.list(Path.of(PARENT_PATH))
//                        .filter(path -> Files.isRegularFile(path))
//                                .forEach(path -> {
//                                    Path copyFile = Path.of(secondParentPath + File.separator + "m" + path.getFileName() );
//                                    try {
//                                        Files.copy(path, copyFile);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                });
        Path aadDirectory = Path.of(secondParentPath.toString() ,"aad");
//        try(Stream<Path> pathStream = Files.list(secondParentPath)) {
//          pathStream.filter(Files::isRegularFile)
//                    .forEach(path -> {
//                        try {
//                            Files.move(path, Path.of(aadDirectory + File.separator + path.getFileName()));
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//        }
//        Files.move(aadDirectory, Path.of(PARENT_PATH, "newTemp"), StandardCopyOption.REPLACE_EXISTING);
        List<String> linesList = Files.readAllLines(Path.of(PARENT_PATH, "input.txt"));
        System.out.println(linesList);
        try (Stream<String> stream = Files.lines(inputFile.toPath());) {
            var lines = stream.filter(
                    line -> {
                        int pointer = line.length() - 2;
                        int number = 0;
                        int decimal = 1;
                        char c;
                        while (Character.isDigit(c = line.charAt(pointer))) {
                            number += (c - '0') * decimal;
                            pointer--;
                            decimal *= 10;
                        }
                        return number % 2 == 0;
                    }
            ).collect(Collectors.toList());
            System.out.println(lines);
        }
        System.exit(200);
    }
}
