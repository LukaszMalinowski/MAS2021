package pl.lukaszmalina.mas2021.test;

import pl.lukaszmalina.mas2021.model.Address;
import pl.lukaszmalina.mas2021.model.Client;
import pl.lukaszmalina.mas2021.model.Company;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Demo {

    private static boolean finished = false;

    private final static String EXTENSION_FILE_NAME = "extension.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!finished) {
            System.out.println("1) Create Clients");
            System.out.println("2) Log Clients");
            System.out.println("3) Save Clients");
            System.out.println("4) Read Clients");
            System.out.println("5) Finish");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createClients();
                    break;
                case 2:
                    logClients();
                    break;
                case 3:
                    saveClients();
                    break;
                case 4:
                    readClients();
                    break;
                default:
                    System.out.println("Closing app");
                    finished = true;
                    break;
            }
        }
    }

    public static void createClients() {
        new Client("Jan",
                   "Kowalski",
                   "500500500",
                   "jan@kowalski.pl",
                   new Address("Ulica",
                               "10",
                               "Warszawa",
                               "01-234"),
                   new Company("FirmaX",
                               new Address("Inna ulica",
                                           "20",
                                           "12",
                                           "Radom",
                                           "12-345"),
                               "12345"));

        new Client("Zbigniew",
                   "Nowak",
                   "600600600",
                   "zbigniew@nowak.pl",
                   new Address("Jeszcze inna ulica",
                               "1A",
                               "Warszawa",
                               "01-234"),
                   new Company("FirmaY",
                               new Address("Jakas aleja",
                                           "5",
                                           "Radom",
                                           "12-345"),
                               "23456"));
        System.out.println("Creating created.");
    }

    public static void logClients() {
        List<Client> extend = Client.getExtension();

        extend.forEach(client -> System.out.println(client.toString()));
    }

    public static void readClients() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(EXTENSION_FILE_NAME));
            Client.readExtend(objectInputStream);
            objectInputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Clients read.");
    }

    public static void saveClients() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(EXTENSION_FILE_NAME));
            Client.writeExtend(objectOutputStream);
            objectOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Clients saved.");
    }
}
