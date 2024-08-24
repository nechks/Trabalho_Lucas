import java.io.*;
import java.util.*;

import OrdenacaoAleatoria.OrdenacaoAleatoria;
import OrdenacaoCrescente.OrdenacaoCrescente;
import OrdenacaoDecrescente.OrdenacaoDecrescente;


public class SortingExample {

    static OrdenacaoCrescente ordenacaoCrescente = new OrdenacaoCrescente();
    static OrdenacaoDecrescente ordenacaoDecrescente = new OrdenacaoDecrescente();
    static OrdenacaoAleatoria ordenacaoAleatoria = new OrdenacaoAleatoria();
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            
        System.out.println("");

        System.out.print(
                "Escolha o algoritmo: ordenação crescente->(1: BubbleSort, 2: InsertionSort, 3: SelectionSort, 4: MergeSort, 5: QuickSort, 6: HeapSort), ordenação descrecente->(7: BubbleSort, 8: InsertionSort, 9: SelectionSort, 10: MergeSort, 11: QuickSort, 12: HeapSort), ordenação aleatória->(13: BubbleSort, 14: InsertionSort, 15: SelectionSort, 16: MergeSort, 17: QuickSort, 18: HeapSort, 19: encerrar aplicacao): ");
        int choice = scanner.nextInt();

        if (choice == 19) {
            break;
        }    

        System.out.print("Digite a quantidade de números a serem ordenados: ");
        int n = scanner.nextInt();

        System.out.print("Digite o nome do arquivo de entrada: ");
        String inputFileName = scanner.next();

        System.out.print("Digite o nome do arquivo de saída: ");
        String outputFileName = scanner.next();

        // Ler os números do arquivo de entrada
        int[] numbers = new int[n];
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }

        String algorithm = "";
        double tempoInicial = System.currentTimeMillis();

        switch (choice) {
            // Ordenação Crescente
            case 1:
                ordenacaoCrescente.bubbleSort(numbers);
                algorithm = "BubbleSort Crescente";
                break;
            case 2:
                ordenacaoCrescente.insertionSort(numbers);
                algorithm = "Insertion Sort";
                break;
            case 3:
                ordenacaoCrescente.selectionSort(numbers);
                algorithm = "SelectionSort Crescente";
                break;
            case 4:
                ordenacaoCrescente.mergeSort(numbers, 0, n - 1);
                algorithm = "MergeSort Crescente";
                break;
            case 5:
                ordenacaoCrescente.quickSort(numbers, 0, n - 1);
                algorithm = "QuickSort Crescente";
                break;
            case 6:
                ordenacaoCrescente.heapSort(numbers);
                algorithm = "HeapSort Crescente";
                break;

            // Ordenação Decrescente
            case 7:
                ordenacaoDecrescente.bubbleSort(numbers);
                algorithm = "BubbleSort Decrescente";
                break;
            case 8:
                ordenacaoDecrescente.insertionSort(numbers);
                algorithm = "InsertionSort Decrescente";
                break;
            case 9:
                ordenacaoDecrescente.selectionSort(numbers);
                algorithm = "SelectionSort Decrescente";
                break;
            case 10:
                ordenacaoDecrescente.mergeSort(numbers, 0, n - 1);
                algorithm = "MergeSort Decrescente";
                break;
            case 11:
                ordenacaoDecrescente.quickSort(numbers, 0, n - 1);
                algorithm = "QuickSort Decrescente";
                break;
            case 12:
                ordenacaoDecrescente.heapSort(numbers);
                algorithm = "HeapSort Decrescente";
                break;

            // Ordenação Aleatória (Embaralhamento)
            case 13:
                ordenacaoAleatoria.bubbleShuffle(numbers);
                algorithm = "BubbleShuffle Aleatório";
                break;
            case 14:
                ordenacaoAleatoria.insertionShuffle(numbers);
                algorithm = "InsertionShuffle Aleatório";
                break;
            case 15:
                ordenacaoAleatoria.selectionShuffle(numbers);
                algorithm = "SelectionShuffle Aleatório";
                break;
            case 16:
                ordenacaoAleatoria.mergeShuffle(numbers, 0, n - 1);
                algorithm = "MergeShuffle Aleatório";
                break;
            case 17:
                ordenacaoAleatoria.quickShuffle(numbers, 0, n - 1);
                algorithm = "QuickShuffle Aleatório";
                break;
            case 18:
                ordenacaoAleatoria.heapShuffle(numbers);
                algorithm = "HeapShuffle Aleatório";
                break;

            default:
                System.out.println("Algoritmo de ordenação inválido.");
        }

        double tempoFinal = System.currentTimeMillis();
        double tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em segundos: " + tempoExecucao / 1000);

        // Gravar os números ordenados no arquivo de saída
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int number : numbers) {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }

        System.out.println("Ordenação concluída e salva no arquivo: " + outputFileName);
        exportarResultados(algorithm, n, tempoExecucao, "resultados.txt");
        
        
    }
        scanner.close();
    }

    public static void exportarResultados(String algorithm, int numElements, double tempoExecucao, String outputFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
            bw.write(String.format("%-25s %-20d %.4f", algorithm, numElements, tempoExecucao));
            bw.newLine();
            System.out.println("Resultados exportados para: " + outputFile);
        } catch (IOException e) {
            System.out.println("Erro ao exportar os resultados: " + e.getMessage());
        }
    }

}
