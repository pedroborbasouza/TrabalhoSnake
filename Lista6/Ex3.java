/*
   Faça um programa que leia um vetor de 10 posições e verifique se existem valores iguais e os
escreva na tela.
 */
package Facul.Lista6;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vet[] = new int[10];
        int i, j;
        boolean rept;

        for(i = 0; i < 10; i++) {
            System.out.println("Digite o "+(i + 1)+" valor: ");
            vet[i] = in.nextInt();
        }

        for(i = 0; i < 10; i++) {
            rept = false;
            for(j = 0; j < i; j++) {
                if(vet[i] != vet[j]) {
                    rept = true;
                    break;
                }
            }
            if(!rept) {
                System.out.println(vet[i]);
            }
        }
    }
}
