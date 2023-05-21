public class Converter {
   int distance;
   int kilocalories;

    Converter(int dist, int kilocal) {
        distance = dist;
        kilocalories = kilocal;

    }


    void convert(StepTracker stepTracker, int Month) {
            System.out.println("Пройдено: " + ((stepTracker.monthToData[Month].findSumExpense() * distance) / 100000) + " км");
            System.out.println("Сожжено: " + ((stepTracker.monthToData[Month].findSumExpense() * kilocalories)/1000) + " килокалорий");
        }
    }
