
package sorting.algorithms;


public class SortingAlgorithms {
    static int StepIS=0; // Insertionsort adım sayısı
    static int StepSS=0; // Selection Sort adım sayısı
    static int StepBS=0; // Buuble sort adım sayısı
    static int StepSheS=0; // Sheel sort adım sayısı
    static int StepQS=0; //Quick Sort adım sayısı
    static int StepCS=0; //Count sort adım sayısı
    static void Insertionsort(int arr[]) {
        int n = arr.length;
        //int Step=0;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

            }
            arr[j + 1] = key;
            printArray(arr);
            StepIS++;
            //System.out.println(Step);
        }
    }
    static void selectionSort(int arr[]) {
        int n = arr.length;
        //int Step=0;
        for(int i = 0; i < n -1; i ++) {
            int index_min = i;
            for (int j = i; j < n; j++) {
                if(arr[j] < arr[index_min]) {
                index_min = j;
                }
            }
            if(index_min != i) {
                int temp = arr[i];
                arr[i] = arr[index_min];
                arr[index_min] = temp;
                printArray(arr);
                StepSS++;
                //System.out.println(Step);
            }
        }
    }
    static int[] bubbleSort(int arr[]) {
        int length = arr.length;
        int temp;
        //int Step=0;
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    StepBS++;
                    //System.out.println(Step);
                }
            }
        return arr;
    }
    static int shellSort(int arr[]) {
        int n = arr.length;
        //int Step=0;

        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
                StepSheS++;
                //System.out.println(Step);
            }
        }
        return 0;
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            StepQS++;
        }
    }
    static void countSort(int arr[], int n) { //Saymalı Sıralama
        int[] output = new int[n + 1];

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            StepCS++;
        }
    }    
    

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
   /* static void printArray(int[] arr, int size) {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }    */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        //printArray(arr, arr.length);
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }    


    public static void main(String[] args) {
        int[]arr={4,5,1,3,2,8,9,6};
        int[]arr2=new int[arr.length];
        //Insertionsort(arr);
        //selectionSort(arr);
        //arr2=bubbleSort(arr);
        //printArray(arr2);
        //shellSort(arr);
        //printArray(arr);
        //System.out.println(StepSheS);
        //quickSort(arr, 0, arr.length-1);
        //printArray(arr);
        //System.out.println(StepQS);
        countSort(arr, arr.length);
        printArray(arr);
        System.out.println(StepCS);
        
    }
    
}