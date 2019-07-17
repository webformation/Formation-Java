/*
 * 
 */
package com.formation.mediatheque;

import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {

    public static void main(String[] args) {
        System.out.println("Saisissez les titres. (FIN pour finir)");
        Scanner sc = new Scanner(System.in);
        String titre;
        var catalogue = new ArrayList<String>();
        while (!(titre = sc.nextLine()).equals("FIN")) {
            if (!catalogue.contains(titre)) {
                catalogue.add(titre);
            }
        }
        System.out.println("Catalogue");
        for (var l : catalogue) {
            System.out.println(l);
        }
    }

}
