/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.util.*;

/**
 *
 * @author Leon S
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int gcdP = gcdPrimeFactors(1989, 867);
        int gcdE = gcdEuclid(1989, 867);
        
        System.out.println(gcdP + " " + gcdE);
    }
    
    public static int gcdEuclid(int a, int b){
        if (b == 0)
            return a;
        return gcdEuclid(b, a % b);
    }
    
    public static int gcdPrimeFactors(int a, int b){
        int[] primeFactorsA = new int[a];
        int[] primeFactorsB = new int[b];
        
        getPrimeFactors(a, primeFactorsA);
        getPrimeFactors(b, primeFactorsB);
        
        boolean[] primeFactorsUsedA = new boolean[a];
        boolean[] primeFactorsUsedB = new boolean[b];
        
        int primeProduct = 1;

        int counterA = 0;
        while(primeFactorsA[counterA] != 0){
            int counterB = 0;
            while(primeFactorsB[counterB] != 0){
                if(primeFactorsA[counterA] == primeFactorsB[counterB] && !primeFactorsUsedB[counterB]){
                    primeProduct *= primeFactorsA[counterA];
                    primeFactorsUsedA[counterA] = true;
                    primeFactorsUsedB[counterB] = true;
                    break;
                }
                counterB++;
            }
            counterA++;
        }
        return primeProduct;
    }
    
    public static void getPrimeFactors(int num, int[] primeFactors){
        int counter = 0;
        while(num != 1){
            int curDivPrime = getNextPrime(1);
            while(curDivPrime <= num){
                if((num % curDivPrime) == 0){
                    num /= curDivPrime;
                    primeFactors[counter] = curDivPrime;
                    counter++;
                    break;
                }
                curDivPrime = getNextPrime(curDivPrime);
            }
        }
    }
    
    public static int getNextPrime(int prime){
        int newPrime = prime + 1;
        while(true){
            if(isPrime(newPrime))
                return newPrime;
            newPrime++;
        }
    }
    
    public static boolean isPrime(int number){
        for(int i = 2; i <= number / 2; i++){
            if((number % i) == 0)
                return false;
        }
        return true;
    }
    
}
