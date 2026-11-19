import java.util.Arrays;
import java.util.Comparator;

public class Metodos {

    // V1: Método básico - Bubble Sort
    public void sortBubble(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    // V2: Método investigado - Quick Sort (partición Lomuto, pivote al final)
    public void sortQuick(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    private int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // V3: Biblioteca estándar sobre primitivos
    public void sortArrays(int[] arr) {
        Arrays.sort(arr);
    }

    // V4: Biblioteca estándar sobre objetos Integer con Comparator
    public void sortArraysComparator(Integer[] arr, Comparator<Integer> comparator) {
        Arrays.sort(arr, comparator);
    }
}