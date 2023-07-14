package com.context;

import com.context.ApplicationConstants;
import com.models.Truck;
import com.repositories.Impl.TruckRepositoryImpl;
import com.repositories.TruckRepository;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private  static final Scanner scanner = new Scanner(System.in);
    private static final TruckRepository repository = new TruckRepositoryImpl();

    public void startApp(){
        //todo make this outside app loop
        String requestPath = "";
        String responsePath = "";
        Truck[] trucks;


        while (true){
            while (true){
                System.out.print("Укажите путь до файла для считывания: ");
                requestPath = scanner.nextLine();

                try {
                    trucks = repository.read(requestPath);
                    break;
                }
                catch (Exception exception){
                    System.out.print("Файл не найден!\n");
                }


            }


            printStartMenu();

            int choose = 0;
            try {
                choose = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException exception){
                System.out.println("Необходимо вводит цифры!!!\n");
                scanner.nextLine();
            }
            if (choose == 1){
                try {
                    showAllTrucksState(trucks);
                }
                catch (NullPointerException exception){
                    System.out.println("В базе не грузовиков. Вероятно файл который вы указали пцстой!");
                }
            }

            if (choose == 2) {

                while (true){
                    System.out.print("\nВведите id грузовика: ");
                    int chooseId = 0;
                    try {
                        chooseId = scanner.nextInt();
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Необходимо вводит цифры!!!");
                        scanner.nextLine();
                    }

                    try {
                        System.out.println(printInfoAboutOneTruck(trucks[chooseId - 1]));
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException exception){
                        System.out.println("В базе нет грузовика с таким ID ");
                    }
                }
            }

            if (choose == 3) {
                System.out.println("\n--- Обновление грузовика ---");
                System.out.print("Укажите номер грузовика и состояние через пробел (2 run):");
                scanner.nextLine();
                String stateChange = scanner.nextLine();
                String[] stateChangeArray = stateChange.split(" ");
                System.out.println(Arrays.toString(stateChangeArray));

                int truckId = 0;
                try {
                    truckId = Integer.parseInt(stateChangeArray[0]);
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException exception){
                    System.out.println("Нет грузовика с таким номером");
                }

                String truckStateChange = stateChangeArray[1].toLowerCase();

                switch (truckStateChange){
                    case "run" -> trucks[truckId - 1].startRun();
                    case "repair" -> trucks[truckId - 1].startRepair();
//                    case "driver" -> trucks[truckId - 1].changeDriver();
                }
            }
            //todo уточнить надо ли делать проверку пути до файла
            if (choose == 4) {
                while (true){
                    System.out.print("Укажите путь до файла для записи: ");
                    responsePath = scanner.nextLine();
                    try {
                        repository.write(responsePath, trucks);
                        break;
                    }
                    catch (Exception exception){
//                        System.out.println("Файл не найден!");
                    }
                }
                System.exit(0);
            }
            if (choose > 4){
                System.out.println("\nНет такого пункта в меню!\n");
            }
        }
    }

    private static void printStartMenu() {
        System.out.print("Меню: " +
                "\n\t1. Отобразить текущее состояние грузовиков" +
                "\n\t2. Показать данные грузовика" +
                "\n\t3. Обновить состояние грузовика" +
                "\n\t4. Завершить программу и выгрузить все данные" +
                "\nВыберите действие: ");
    }

    private static void showAllTrucksState(Truck[] trucks) {
        System.out.println("\n №  |          Грузовик           |    Водитель      |    Состояние   ");
        System.out.println("-----------------------------------------------------------------------");
        for (Truck element : trucks) {
            System.out.println(element + "\n");
        }
    }

    public String printInfoAboutOneTruck(Truck truck) {
        String myString = String.format(  "\n|   ID      |   %d  " +
                "\n| Марка     | %2s     " +
                "\n| Водитель  |  %s           " +
                "\n| Состояние |  %s    \n", truck.getId(), truck.getName(), truck.getDriver(), truck.getStateName());
        return myString;
    }

}
