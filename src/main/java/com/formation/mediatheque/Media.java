/*
 * 
 */
package com.formation.mediatheque;

import java.util.Objects;

/**
 *
 * @author D. Colombani <dc@webformation.fr>
 */
public class Media {
   
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
    public void setTitre(String Titre) {
        this.Titre = Titre;
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
    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }

    public Media(String Titre, String Auteur) {
        this.Titre = Titre;
        this.Auteur = Auteur;
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
        return Titre + " (" + Auteur + ")";
    }
 
}
