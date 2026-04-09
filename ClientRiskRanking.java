import java.util.*;

class Client {
    String name;
    int riskScore;
    int accountBalance;

    Client(String name, int riskScore, int accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskRanking {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Bubble (asc): " + format(arr));
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion (desc): " + format(arr));
    }

    static int compare(Client a, Client b) {
        if (a.riskScore != b.riskScore) {
            return a.riskScore - b.riskScore;
        }
        return a.accountBalance - b.accountBalance;
    }

    static void topRisks(Client[] arr, int k) {
        System.out.print("Top " + k + " risks: ");
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ")");
            if (i != k - 1 && i != arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    static String format(Client[] arr) {
        List<String> res = new ArrayList<>();
        for (Client c : arr) {
            res.add(c.name + ":" + c.riskScore);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Client[] clients = {
            new Client("clientC", 80, 1000),
            new Client("clientA", 20, 5000),
            new Client("clientB", 50, 3000)
        };

        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);

        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);

        topRisks(insertionArr, 10);
    }
}