/*
 * 
 */
package com.formation.mediatheque;

import java.io.PrintStream;
import java.util.Objects;

/**
 * Représentation d'un ouvrage de la médiathèque
 * 
 * Cette classe est, dans cette version, une classe concrète, sans classe dérivée.
 * Dans les prochaines étapes du projet, elle servira de classe de base pour d'autres classes 
 * et sera transformée en classe abstraite.
 * @author D. Colombani
 */
abstract public class Media {
   
    private String Titre;

    /**
     * Get the value of Titre
     *
     * @return the value of Titre
     */
    public String getTitre() {
        return Titre;
    }

    /**
     * Set the value of Titre
     *
     * @param Titre new value of Titre
     */
    public void setTitre(String Titre) throws Exception {
                if (Titre == null || Titre.strip().length() == 0) {
            throw new Exception("Le titre est vide");
        }
        this.Titre = Titre.strip();
    }

    private String Auteur;

    /**
     * Get the value of Auteur
     *
     * @return the value of Auteur
     */
    public String getAuteur() {
        return Auteur;
    }

    /**
     * Set the value of Auteur
     *
     * @param Auteur new value of Auteur
     */
    public void setAuteur(String Auteur) throws Exception {
        if (Auteur == null || Auteur.strip().length() == 0) {
            throw new Exception("L'auteur est vide");
        }
        this.Auteur = Auteur.strip();
    }

    public Media(String Titre, String Auteur) throws Exception {
        setAuteur(Auteur);
        setTitre(Titre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.Titre);
        hash = 17 * hash + Objects.hashCode(this.Auteur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Media other = (Media) obj;
        if (!Objects.equals(this.Titre, other.Titre)) {
            return false;
        }
        if (!Objects.equals(this.Auteur, other.Auteur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(Titre);
        sb.append(" (");
        sb.append(Auteur );
        sb.append(")");
        return  sb.toString();
    }
 
    public abstract void enregistre(PrintStream p); 
}
