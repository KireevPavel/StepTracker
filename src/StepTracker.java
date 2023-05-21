import java.util.Scanner;

public class StepTracker {

    Scanner scanner;

    {
        scanner = new Scanner(System.in);

    }

    MonthData[] monthToData;

    public StepTracker() {

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }


    void saveSteps(Scanner scanner, StepTracker stepTracker) {

        System.out.println("Введите месяц от 0 до 11: ");

        int Month = scanner.nextInt();
        System.out.println("За какой день вы хотите ввести количество шагов: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
        int day = scanner.nextInt();
        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
        stepTracker.monthToData[Month].chooseADay(day, steps);
        System.out.println("Значение сохранено!");

    }

    class MonthData {

        int[] daysToData;

        MonthData() {
            daysToData = new int[30];

        }

        int chooseADay(int day, int steps) {
            daysToData[day - 1] = daysToData[day - 1] + steps;
            return steps;
        }
        int findMaxExpense() {
            int maxSteps = 0;
            for (int i = 0; i < daysToData.length; i++) {
                if (daysToData[i] > maxSteps) {
                    maxSteps = daysToData[i];
                }
            }
            return maxSteps;
        }
        void findBestSeries(int target) {
            for (int i = 0; i < daysToData.length; i++) {
                if (daysToData[i] >= target) {
                    System.out.println("Лучшая серия за месяц: День " + (i + 1) + ". Пройдено " + daysToData[i] + " шагов");
                }
            }
        }
        int findSumExpense() {
            int sumSteps = 0;
            for (int i = 0; i < daysToData.length; i++) {
                    sumSteps = daysToData[i] + sumSteps;
            }
            return sumSteps;
        }

        void printAllsteps() {
            for (int i = 0; i < daysToData.length; i++) {
                System.out.println("День " + (i + 1) + ". Пройдено " + daysToData[i] + " шагов");
            }

            }
        }

    }





