import java.util.Arrays;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        
        int opc, valorInicial, soma;

        int[] sequencia = new int[10];
        int[][] somaMatrizes;

        System.out.println("""
        === BEM VINDO ===        
        1. Progressão geométrica
        2. Sequência decrescente
        3. Vetor dinâmico
        4. Sequência crescente com soma
        5. Matriz com valores incrementais
        6. Operação entre matrizes
        0. Sair
        """);

        opc = ler.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Digite um número menor ou igual a 20: ");
                valorInicial = ler.nextInt();
                System.out.println(Arrays.toString(progressaoGeometrica(valorInicial)));
                break;
            case 2:
                System.out.println("Digite um número maior que 1 e menor que 100");
                valorInicial = ler.nextInt();
                System.out.println(Arrays.toString(sequenciaDecrescente(valorInicial)));
                break;
            case 3:
                System.out.println("Digite um número maior que 1 e menor ou igual a 1000");
                valorInicial = ler.nextInt();
                System.out.println(Arrays.toString(vetorDinamico(valorInicial)));
                break;
            case 4:
                System.out.println("Digite um número maior que 1 e menor que 100");
                valorInicial = ler.nextInt();
                sequencia = sequenciaCresenteComSoma(valorInicial);
                soma = calcularSoma(sequencia);
                System.out.println(Arrays.toString(sequencia) + " Soma: " + soma);
                break;
            case 5:
                System.out.println("Digite um número maior que 3 e menor ou igual a 50");
                valorInicial = ler.nextInt();
                exibirMatriz(matrizIncrementais(valorInicial));
                break;
            case 6:
                System.out.println("Digite um número maior que 3 e menor ou igual a 50");
                valorInicial = ler.nextInt();
                System.out.println("Matriz N e Z valores: ");
                exibirMatriz(operacaoEntreMatrizes(valorInicial)[0]);
                System.out.println("Matriz Soma valores: ");
                exibirMatriz(operacaoEntreMatrizes(valorInicial)[2]);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }   

        ler.close();
    }
    
    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void exibirMatriz(int[][] matriz) {
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Exercicio 01: Progressao Geometrica
     * @param valorInicial Valor inicial (deve ser <= 20)
     * @return Vetor de 10 elementos com progressao geometrica (dobro) ou null se invalido
     */
    public static int[] progressaoGeometrica(int valorInicial) {
        if(valorInicial > 20){
            return null;
        }

        int[] progressao = new int[10];
        progressao[0] = valorInicial;

        for(int i = 1; i < 10; i++){
            progressao[i] = progressao[i - 1] * 2; 
        }

        return progressao; 
    }
    
    /**
     * Exercicio 02: Sequencia Decrescente
     * @param valorInicial Valor inicial (deve ser > 1)
     * @return Vetor de 10 elementos com sequencia decrescente ou null se invalido
     */
    public static int[] sequenciaDecrescente(int valorInicial) {
        // TODO: Implementar sequencia decrescente
        // Validar se valorInicial > 1 (retornar null se invalido)
        if(valorInicial <= 1 || valorInicial >= 100){
            return null;
        }

        int[] sequencia = new int[10];
        sequencia[0] = valorInicial;

        for(int i = 1; i < sequencia.length; i++){
            sequencia[i] = sequencia[i - 1] - 1;
        }

        return sequencia;
    }
    
    /**
     * Exercicio 03: Vetor Dinamico
     * @param tamanho Tamanho do vetor (deve ser <= 1000)
     * @return Vetor com sequencia de 1 ate tamanho ou null se invalido
     */
    public static int[] vetorDinamico(int tamanho) {
        if(tamanho > 1000 || tamanho <= 1){
            return null;
        }
            
        int[] vetor = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            vetor[i] = i + 1;
        }
        return vetor;
    }
    
    /**
     * Exercicio 04: Sequencia Crescente com Soma
     * @param valorInicial Valor inicial
     * @return Vetor de 10 elementos com sequencia crescente
     */
    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] sequencia = new int[10];

        if (valorInicial <= 1 || valorInicial >= 100) {
            return null;
        }

        sequencia[0] = valorInicial;

        for(int i = 1; i < sequencia.length; i++){
            sequencia[i] = sequencia[i - 1] + 1;
        }

        return sequencia;
    }
    
    /**
     * Calcula a soma de todos os elementos do vetor
     * @param vetor Vetor para calcular a soma
     * @return Soma de todos os elementos
     */
    public static int calcularSoma(int[] vetor) {
        int soma = 0;

        for(int i = 0; i < vetor.length; i++){
            soma += vetor[i];
        }

        return soma;
    }
    
    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em tamanho+1
     */
    public static int[][] matrizIncrementais(int tamanho) {
        int cont = tamanho + 1;

        if(tamanho < 3 || tamanho > 50){
            return null;
        }

        int[][] incrimental = new int[4][4];

        for(int i = 0; i < incrimental.length; i++){
            for(int j = 0; j < incrimental[i].length; j++){
                incrimental[i][j] = cont;
                cont++;
            }
        }

        return incrimental;
    }
    
    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Soma
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] matrizN = matrizIncrementais(tamanho);
        int[][] matrizZ = matrizN;
        int[][] matrizSoma = new int[tamanho][tamanho];

        if(tamanho < 3 || tamanho > 50){
            return null;
        }

        for(int i = 0; i < matrizN.length; i++){
            for(int j = 0; j < matrizN[i].length; j++){
                matrizSoma[i][j] = matrizN[i][j] + matrizZ[i][j];
            }
        }

        int[][][] matrizes = {matrizN, matrizZ, matrizSoma};

        return matrizes;
    }
    
    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================
    
    /**
     * Metodo ex01 para compatibilidade com autograder
     * @return resultado do exercicio 01
     */
    public static int[] ex01() {
        // TODO: Implementar leitura de entrada e chamar progressaoGeometrica()
        return null; // Remover esta linha apos implementacao
    }
    
    /**
     * Metodo ex02 para compatibilidade com autograder
     * @return resultado do exercicio 02
     */
    public static int[] ex02() {
        // TODO: Implementar leitura de entrada e chamar sequenciaDecrescente()
        return null; // Remover esta linha apos implementacao
    }
    
    /**
     * Metodo ex03 para compatibilidade com autograder
     * @return resultado do exercicio 03
     */
    public static int[] ex03() {
        // TODO: Implementar leitura de entrada e chamar vetorDinamico()
        return null; // Remover esta linha apos implementacao
    }
    
    /**
     * Metodo ex04 para compatibilidade com autograder
     * @return resultado do exercicio 04
     */
    public static int[] ex04() {
        // TODO: Implementar leitura de entrada e chamar sequenciaCresenteComSoma()
        return null; // Remover esta linha apos implementacao
    }
    
    /**
     * Metodo ex05 para compatibilidade com autograder
     * @return resultado do exercicio 05
     */
    public static int[][] ex05() {
        // TODO: Implementar leitura de entrada e chamar matrizIncrementais()
        return null; // Remover esta linha apos implementacao
    }
    
    /**
     * Metodo ex06 para compatibilidade com autograder
     * @return resultado do exercicio 06
     */
    public static int[][][] ex06() {
        // TODO: Implementar leitura de entrada e chamar operacaoEntreMatrizes()
        return null; // Remover esta linha apos implementacao
    }
}