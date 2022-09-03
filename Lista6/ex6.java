package lista6;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[10];

        for (int i = 0; i < 10; i++){
            System.out.println("Informe o valor da posicao "+i);
            vet[i] = sc.nextInt();
        }

        System.out.println("Informe o valor X");
        int x = sc.nextInt();


        System.out.print("Os multiplos de X sao:");
        for (int i = 0; i < 10; i++){
            if (vet[i] % x == 0){
                System.out.print(vet[i]+" ");
            }
        }
    }
}
