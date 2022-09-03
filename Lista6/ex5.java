package lista6;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] vet = new float[5];
        int codigo;

        for (int i = 0; i < 5; i++){
            System.out.println("Informe o valor do vetor na posicao "+i);
            vet[i] = sc.nextFloat();
        }

        do {
            System.out.println("1- vetor na ordem direta");
            System.out.println("2- vetor na ordem inversa");
            System.out.println("0- sair");
            codigo = sc.nextInt();

            if (codigo == 1){
                for (int i = 0; i < 5; i++){
                    System.out.print(vet[i]+" ");
                }
                System.out.println();
            } else if (codigo == 2){
                for (int i = 4; i >= 0; i--){
                    System.out.print(vet[i]+" ");
                }
                System.out.println();
            }else if ( codigo != 0){
                System.out.println("codigo invalido informe novamente");
            }
        } while (codigo != 0);
    }


}
