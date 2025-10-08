public class Recherches {
    public static void main(String[] args) {
        
    }

    public static int rechercheLineaire(int[] tab, int valeur) {
        for (int i = 0; i < tab.length; i++)
            if (tab[i] == valeur) return i;
        return -1;
    }

    public static int rechercheBinaire(int[] tab, int valeur) {
        int debut = 0, fin = tab.length - 1;
        while (debut <= fin) {
            int milieu = (debut + fin) / 2;
            if (tab[milieu] == valeur) return milieu;
            if (tab[milieu] < valeur) debut = milieu + 1;
            else fin = milieu - 1;
        }
        return -1;
    }
    
    
}