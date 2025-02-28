
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Исходный массив
        int[] array = {30, 53, 11, 35, 17};
        // Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(array);

        // Сортировка четных элементов
        sortEvenElements(array);

        // Вывод массива после сортировки четных элементов
        System.out.println("***Массив после сортировки четных элементов:");
        printArray(array);
    }

    // Метод сортировки четных элементов
    public static void sortEvenElements(int[] arr) {
        // Сбор четных элементов
        int[] evenElements = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray(); // Исправлено

        // Сортировка четных элементов методом пузырька
        bubbleSort(evenElements);

        // Вставка отсортированных четных элементов обратно в массив
        int evenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = evenElements[evenIndex++];
            }
        }
    }


    // Метод сортировки пузырьком
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Изменено условие для сортировки по убыванию
                if (arr[j] < arr[j + 1]) {
                    // Меняем местами arr[j] и arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // Вывод текущего состояния массива после каждой итерации
            printArray(arr);
        }
    }

    // Метод для вывода массива
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.print();
    }
}