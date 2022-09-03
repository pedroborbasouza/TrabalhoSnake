/*
   Faça um programa para ler 5 valores e, em seguida, mostrar todos os valores lidos juntamente
com o maior, o menor e a média dos valores.
 */
package Facul.Lista6;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numMaior = 0;
        int numMenor = 0;
        int n1 = 1;
        int[] lerNum;
        int soma = 0;


        lerNum = new int[5];

        for(n1 = 0; n1 < 5; n1++) {

            System.out.println("Digite o "+(n1 +1)+"° número: ");
            lerNum[n1] = in.nextInt();

            numMaior = lerNum[n1];
            numMenor = lerNum[n1];

            soma = soma + lerNum[n1];
        }
        for(n1 = 0; n1 < 5; n1++) {
            if (lerNum[n1] > numMaior) {
                numMaior = lerNum[n1];
            } else if (lerNum[n1] < numMenor) {
                numMenor = lerNum[n1];
            }
            System.out.println("Valores lidos: "+lerNum[n1]);
        }

        System.out.println();
        System.out.println("O maior número dos 5 digitados é: "+numMaior);
        System.out.println("O menor número dos 5 digitados é: "+numMenor);
        System.out.println("Média dos valores: "+(soma/n1));
    }
}
