
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
public class main {

    /**
     * main EX1
     *
     * @param args
     * @throws java.io.IOException
     */
 
    public static void main(String[] args) throws IOException {
     queue mq = new queue();
        int i = 0;
        String oldf = null;
        String newf = null;
        String email = "";
        int point = 0;
        int choice = 0;
      if (args[0].equals("-h")) {
            System.out.println("Help:");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucuture into csv file\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n");
            System.out.print("./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
            System.out.print("./lab1 2 -r <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
            return;
        }

        for (i = 0; i < args.length; i++) {
            if (args[i].equals("-r")) {
                oldf = args[i + 1];
            }
            if (args[i].equals("-s")) {
                newf = args[i + 1];
            }
            if (args[i].equals("-a")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 1;
            }
            if (args[i].equals("-d")) {
                email = args[i + 1];
                choice = 2;
            }
            if (args[i].equals("-u")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 3;
            }
            if (args[i].equals("-dt")) {
                choice = 4;
            }
            if (args[i].equals("-g")) {
                email = args[i + 1];
                choice = 5;
            }
            if (args[i].equals("-t")) {
                choice = 6;
            }
        }
        switch (choice) {
            case 0: {
                try {
                    FileReader file = new FileReader(oldf);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newf);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNextLine()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];

                            pointRead = Integer.parseInt(results[1]);
                            manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                break;
            }
            case 1: {
                try {
                    FileReader file = new FileReader(oldf);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newf);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];

                            pointRead = Integer.parseInt(results[1]);
                            manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    manageGamer e = new manageGamer(email, point);
                    mq.newqueue(e);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 2: {
                try {
                    FileReader file = new FileReader(oldf);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newf);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];

                            pointRead = Integer.parseInt(results[1]);
                            manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.delete(email);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 3: {
                try {
                    FileReader file = new FileReader(oldf);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newf);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];

                            pointRead = Integer.parseInt(results[1]);
                            manageGamer e = new manageGamer(emailRead, pointRead);

                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.update(email, point);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Not found email");
                }
                choice = 0;
                break;
            }
            case 4: {
                try {
                    FileReader file = new FileReader(oldf);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newf);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");                       
                            emailRead = results[0];
                            pointRead = Integer.parseInt(results[1]);
                                                       manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.dequeue();
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 5: {
                try {
                    FileReader file = new FileReader(oldf);
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];
                            pointRead = Integer.parseInt(results[1]);
                        manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    System.out.println(mq.search(email).getPoint());
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 6: {
                try {
                    FileReader file = new FileReader(oldf);
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                                                        emailRead = results[0];
                            pointRead = Integer.parseInt(results[1]);
                                                                                                              manageGamer e = new manageGamer(emailRead, pointRead);
                            mq.newqueue(e);
                        }
                        inputStream.close();
                    }
                    System.out.println(mq.front().getPoint());
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            
        }
    }
}

