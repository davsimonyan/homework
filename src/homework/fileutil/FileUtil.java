package homework.fileutil;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        fileSearch();
        contentSearch();
        findLines();
        printSizeOfPackage();
        createFileWithContent();

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        String pathName = scanner.nextLine();
        File myFile = new File(pathName);
        System.out.println("isDirectory: " + myFile.isDirectory());
        String fileName = scanner.nextLine();
        for (int i = 0; i < Objects.requireNonNull(myFile.list()).length; i++) {
            if (fileName.equals(Objects.requireNonNull(myFile.list())[i])) {
                System.out.println("the text exists: " + Objects.requireNonNull(myFile.list())[i]);
                break;
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() throws IOException {
        String patName = scanner.nextLine();
        File myFile = new File(patName);
        String keyword = scanner.nextLine();
        String[] list = myFile.list();

        for (int i = 0; i < Objects.requireNonNull(list).length; i++) {
            String[] txt = Objects.requireNonNull(list)[i].split("\\.");
            if ("txt".equals(txt[txt.length - 1])) {
                File file = new File(myFile + "/" + list[i]);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();
                String[] words = line.split(" ");

                for (int j = 0; j < words.length; j++) {
                    if (keyword.equals(words[j])) {
                        System.out.println(file.getName());
                        break;
                    }
                }
            }
        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() throws IOException {

        String txtPath = scanner.nextLine();
        File file = new File(txtPath);
        if (file.isFile()) {
            String keyword = scanner.nextLine();
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);) {
                String line;
                while (bufferedReader.read() != -1) {
                    line = bufferedReader.readLine();
                    String[] words = line.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (keyword.equals(words[i])) {
                            System.out.println(Arrays.toString(words));
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() throws IOException {
        long size = 0;
        String myFile = scanner.nextLine();
        File file = new File(myFile);
        File[] files = file.listFiles();
        for (File listFile : files) {
            size = size + Files.size(listFile.toPath());
        }
        System.out.println(size + " bite");

    }


    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
// 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
// 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
// 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
// որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() throws IOException {
        String path = scanner.nextLine();
        String name = scanner.nextLine();
        String content = scanner.nextLine();

        File file = new File(path, name + ".txt");
        if (!file.exists()) {
            Files.createFile(file.toPath());
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();

    }

}
