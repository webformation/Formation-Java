/*
 * 
 */
package com.formation.mediatheque;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Saisie {

    static ArrayList<Media> catalogue;

    public static void main(String[] args) {
        catalogue = new ArrayList<Media>();
        Importe();
        System.out.println("Catalogue importé");
        for (var l : catalogue) {
            System.out.println(l);
        }
        System.out.println("Saisissez type (L,D),titre,auteur, duree/nb Pages. (FIN pour finir)");
        Scanner sc = new Scanner(System.in);
        String ligne;

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
        Exporte();
    }

    static public void Exporte() {
        try {
            FileOutputStream f = new FileOutputStream("export.csv");
            PrintStream p = new PrintStream(f);
            for (Media m : catalogue) {
                m.enregistre(p);
            }
            p.close();
            f.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void Importe() {
        try {
            FileInputStream f = new FileInputStream("export.csv");
            Scanner sc = new Scanner(f);
            String ligne;
            while (sc.hasNextLine()) {
                ligne = sc.nextLine();
                String[] e = ligne.split(";");
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
            f.close();

        } catch (FileNotFoundException ex) {
            return;
            // Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
