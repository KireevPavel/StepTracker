import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(75, 50);
        int target = 10000;
        System.out.println("Ваша текущая цель: " + target);

        while (true) {
            stepTracker.printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.saveSteps(scanner, stepTracker);
            } else if (command == 2) {
                System.out.println("Введите месяц от 0 до 11: ");
                int Month = scanner.nextInt();
                stepTracker.monthToData[Month].printAllsteps();
                System.out.println("Всего шагов за месяц: " + stepTracker.monthToData[Month].findSumExpense());
                System.out.println("Самое большое количество шагов в этом месяце: " + stepTracker.monthToData[Month].findMaxExpense());
                System.out.println("Среднее количество шагов за месяц: " + stepTracker.monthToData[Month].findSumExpense()/30);
                converter.convert(stepTracker, Month);
                stepTracker.monthToData[Month].findBestSeries(target);

            } else if (command == 3) {
                System.out.println("Введите новую цель ");
                target = scanner.nextInt();

                if (target > 0) {
                    System.out.println("Значение сохранено! Новая цель: " + target);
                } else {
                    System.out.println("Значение не может быть отрицательным!");
                }
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды не существует");
            }
        }
    }


}

