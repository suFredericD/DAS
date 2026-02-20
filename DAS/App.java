
public class App {
    public static void main(String[] args) throws Exception {
        // Réinitialisation de la console
        clearConsole();

        // Génération du joueur

        // Génération des éléments

        // Génération de la partie

        // Réinitialisation de la console

        // Page d'accueil

        // Retours en console

        // Fin d'affichage console
        System.out.println("---------------------------------------------------\n");
    }

    // ==============================================================================
    // =================================================================== FONCTIONS
    // ==============================================================================

    // ======================================= OUTILS
    // Astuce pour réinitialiser l'affichage de la console
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }
}