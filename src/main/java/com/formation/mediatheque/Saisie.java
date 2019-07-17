/*
 * 
 */
package com.formation.mediatheque;

import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {

    public static void main(String[] args) {
        System.out.println("Saisissez type (L,D),titre,auteur, duree/nb Pages. (FIN pour finir)");
        Scanner sc = new Scanner(System.in);
        String ligne;
        var catalogue = new ArrayList<Media>();
        while (!(ligne = sc.nextLine()).equals("FIN")) {
            String[] e = ligne.split(",");
            if (e.length == 0) {
                continue;
            }

            try {
                Media m;
                switch (e[0]) {
                    case "D":
                        m = new DVD(e[1], e[2], Integer.parseInt(e[3].strip()));
                        break;
                    case "L":
                        m = new Livre(e[1], e[2], Integer.parseInt(e[3].strip()));
                        break;
                    default:
                        continue;
                }
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
        System.out.println("----------------------------");
        System.out.println("Catalogue empruntable");
        for (var l : catalogue) {
            if (l instanceof Empruntable) {
                System.out.println(l);
            }
        }
    }

}
