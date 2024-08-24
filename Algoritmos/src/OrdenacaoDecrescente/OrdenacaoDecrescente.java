package OrdenacaoDecrescente;

public class OrdenacaoDecrescente {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {  
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {  
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {  
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
    
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
    
            mergeDescending(arr, l, m, r);
        }
    }
    
    public static void mergeDescending(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
    
        int[] L = new int[n1];
        int[] R = new int[n2];
    
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
    
        int i = 0, j = 0;
        int k = l;
    
    
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        double tempoInicial = System.currentTimeMillis();

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }

        double tempoFinal = System.currentTimeMillis();
        double tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] > pivot);

            do {
                j--;
            } while (arr[j] < pivot);

            if (i >= j)
                return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    
    
      
    /* 
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDescending(arr, low, high);
    
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
    
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {  // Invertido para decrescente
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
    
        return i + 1;
    }    
    */
    
    public void heapSort(int[] arr) {
        int n = arr.length;
    
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
    
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
    
        if (left < n && arr[left] < arr[smallest])
            smallest = left;
    
        if (right < n && arr[right] < arr[smallest])
            smallest = right;
    
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
    
            heapify(arr, n, smallest);
        }
    }
}
