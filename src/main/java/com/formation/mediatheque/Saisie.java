/*
 * 
 */
package com.formation.mediatheque;

import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {
    
    public static void main(String[] args) {
        System.out.println("Saisissez titre,auteur. (FIN pour finir)");
        Scanner sc = new Scanner(System.in);
        String ligne;
        var catalogue = new ArrayList<Media>();
        while (!(ligne = sc.nextLine()).equals("FIN")) {
            String[] e = ligne.split(",");
            if (e.length == 0) continue;
            try {
                Media m = new Media(e[0], e[1]);
                if (!catalogue.contains(m)) {
                    catalogue.add(m);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Catalogue");
        for (var l : catalogue) {
            System.out.println(l);
        }
    }
    
}
