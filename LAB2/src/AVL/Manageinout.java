/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author SE140279
 */
public class Manageinout {

    /**
     *
     * @param parameter
     */
    AVLTree tree = new AVLTree();
    HashMap<String, Integer> data = new HashMap<>();
    HashMap<Integer, String> data2 = new HashMap<>();

    /**
     * read the file and import data to tree, the data is email and point
     * @param inputFile
     */
    public void insert(String inputFile) throws IOException {
        File f1;
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            f1 = new File(inputFile);
            fr = new FileReader(f1);
            bf = new BufferedReader(fr);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] arr = s.split(", ");
                if (!(arr[0].equalsIgnoreCase("email"))) {
                    String email = arr[0].trim();
                    int point = Integer.parseInt(arr[1].trim());
                    tree.insert(point, email);
                    data.put(email, point);
                    data2.put(point, email);
                }
            }
        } catch (IOException e) {
            System.out.println("File not exist!!");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println("Something wrong with Reading file");
            }
        }
    }

    public void delete(int point, String type) {
        String email = data2.get(point);
        switch (type) {
            case "copy-right":
                System.out.println("\n[DELETE COPYING RIGHTMOST] " + "(" + email + ", " + point + ")");
                break;
        }
        data2.remove(point);
    }
    public void update(String filename, String type) {
        File f;
        FileReader fr = null;
        BufferedReader bf = null;
        int oldPoint, newPoint;
        try {
            f = new File(filename);
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] arr = s.split(", ");
                if (!(arr[0].equalsIgnoreCase("email"))) {
                    String email = arr[0].trim();
                    oldPoint = data.get(email);
                    //remove old info
                    delete(oldPoint, type);

                    //add new info to tree
                    newPoint = Integer.parseInt(arr[1].trim());
                    tree.insert(newPoint, email);
                    data.put(email, newPoint);
                }
            }
        } catch (IOException e) {
            System.out.println("File not exist!!");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                } 
            } catch (IOException e) {
                System.out.println("Something wrong with Reading file");
            }
        }
    }

    public void write(String type, String filename) {
        File f;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            f = new File(filename);
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            pw.println("Email, Point");
            switch (type.trim().toLowerCase()) {
                case "lnr":
                    tree.lnr(pw);
                    break;
                case "nlr":
                    tree.nlr(pw);
                    break;
                case "lrn":
                    tree.lrn(pw);
                    break;
            }
        } catch (IOException e) {
            System.out.println("Can't write to file!!");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputCLI(String[] arr) {
        Manageinout cage = new Manageinout();
        int point = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case "-r":
                        String inputFile = arr[i + 1].trim();
                        cage.insert(inputFile);
                        break;
                    case "-lnr":
                        String outputLNR = arr[i + 1].trim();
                        cage.write("lnr", outputLNR);
                        break;
                    case "-nlr":
                        String outputNLR = arr[i + 1].trim();
                        cage.write("nlr", outputNLR);
                        break;
                    case "-lrn":
                        String outputLRN = arr[i + 1].trim();
                        cage.write("lrn", outputLRN);
                        break;
                    case "-insert":
                        String insertFile = arr[i + 1].trim();
                        cage.insert(insertFile);
                        break;
                    case "-delete":
                        point = Integer.parseInt(arr[i + 1].trim());
                        cage.delete(point, arr[i + 3]);
                        break;
                    case "-update":
                        String updateFile = arr[i + 1].trim();
                        String mode = arr[i + 3].trim();
                        cage.update(updateFile, mode);
                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't not find enough argument to excecute!!");
        } catch (IOException e) {
            System.out.println("Something wrong with file input!!");
        }
    }

    public static void main(String[] args) throws IOException {
        Manageinout cage = new Manageinout();
        String[] cmd = {"-r", "testcase.csv", "-update", "update.csv", "-mode", "copy-right", "-lnr", "output2.csv"};
        Manageinout.inputCLI(cmd);
    }
}