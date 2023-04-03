package uz.najottalim;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutputStream {
    private static final String PARENT_PATH = "src/main/resources/files";
    public static void main(String[] args) {
        File inputFile = new File(PARENT_PATH, "input.txt");
        File outputFile = new File(PARENT_PATH, "output.txt");
        if (inputFile.exists() && inputFile.isFile()
                && outputFile.exists() && outputFile.isFile()) {
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
            try (FileReader reader = new FileReader(inputFile)) {
                char[] charArray = new char[6];
                charArray[0] = 'm';
                reader.read(charArray, 1, 5);

                System.out.println(charArray);
                while (reader.read(charArray) != -1) {
                    System.out.println(charArray);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
