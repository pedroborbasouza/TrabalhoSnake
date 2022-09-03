/*
   Leia um vetor com 20 números inteiros. Escreva os elementos do vetor eliminando elementos
repetidos.
 */
package Facul.Lista6;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vet[] = new int[20];
        int i, j;
        boolean rept;

        for(i = 0; i < 20; i++) {
            System.out.println("Digite o "+(i + 1)+" valor: ");
            vet[i] = in.nextInt();
        }

        for(i = 0; i < 20; i++) {
            rept = false;
            for(j = 0; j < i; j++) {
                if(vet[i] == vet[j]) {
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