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
                    "Escolha o algoritmo: ordenação crescente->(1: BubbleSortC, 2: InsertionSortC, 3: SelectionSortC, 4: MergeSortC, 5: QuickSortC, 6: HeapSortC), ordenação descrecente->(7: BubbleSortD, 8: InsertionSortD, 9: SelectionSortD, 10: MergeSortD, 12: HeapSortD),-> ordenacao aleatorio(14: InsertionSortA, 15: SelectionSortA, 16: MergeSortA, 17: QuickSortA, 18: HeapSortA, 19: encerrar aplicacao): ");
            int choice = scanner.nextInt();

            if (choice == 19) {
                break;
            }

            System.out.print("Digite a quantidade de números a serem ordenados: ");
            int n = scanner.nextInt();

            /*
             * System.out.print("Digite o nome do arquivo de entrada: ");
             * String inputFileName = scanner.next();
             * 
             * System.out.print("Digite o nome do arquivo de saída: ");
             * String outputFileName = scanner.next();
             */
            System.out.println("Selecione o arquivo de entrada:");
            System.out.println("1 - numeros-com-repeticao.txt");
            System.out.println("2 - numeros-sem-repeticao.txt");

            int filechoice = scanner.nextInt();
            String inputFileName = "";

            // Escolhe o arquivo de entrada com base na escolha do usuário
            switch (filechoice) {
                case 1:
                    inputFileName = "numeros-com-repeticao.txt";
                    break;
                case 2:
                    inputFileName = "numeros-sem-repeticao.txt";
                    break;
                default:
                    System.out.println("Opção inválida. O programa será encerrado.");
                    return; // Encerra o programa caso a escolha seja inválida
            }

            String outputFileName = "saida.txt"; // Arquivo de saída

            System.out.println("Arquivo de entrada selecionado: " + inputFileName);
            System.out.println("Arquivo de saída definido como: " + outputFileName);

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

            switch (choice) {
                case 1:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosBublleSortCrescente.txt");
                    break;
                case 2:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosInsertionSortCrescente.txt");
                    break;
                case 3:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosSelectionCrescente.txt");
                    break;
                case 4:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosMergeSortCrescente.txt");
                    break;
                case 5:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosQuickSortCrescente.txt");
                    break;
                case 6:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosHeapSortCrescente.txt");
                    break;
                case 7:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosBublleSortDecrescente.txt");
                    break;
                case 8:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosInsertionSortDecrescente.txt");
                    break;
                case 9:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosSelectionSortDecrescente.txt");
                    break;
                case 10:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosMergeSortDecrescente.txt");
                    break;
                case 11:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosQuickSortDecrescente.txt");
                    break;
                case 12:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosHeapSortDescrescente.txt");
                    case 13:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosBublleSortAleatorio.txt");
                    break;
                case 14:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosInsertionSortAleatorio.txt");
                    break;
                case 15:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosSelectionAleatorio.txt");
                    break;
                case 16:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosMergeSortAleatorio.txt");
                    break;
                case 17:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosQuickSortAleatorio.txt");
                    break;
                case 18:
                    exportarResultados(algorithm, n, tempoExecucao, "resultadosHeapAleatorio.txt");
                    default:

                    break;
            }

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
