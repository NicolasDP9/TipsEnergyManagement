import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Creator {

    public static void createFolder(){
        // Obtenez la date du jour
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date);

        // Spécifiez le répertoire dans lequel vous voulez créer le dossier
        String repertoireParent = "/Users/nicola/Documents/GitHub/TipsEnergyManagement/export";

        // Construisez le chemin complet du nouveau dossier
        String cheminDossier = repertoireParent + "/" + getDate();

        // Créez le dossier s'il n'existe pas déjà
        Path cheminDossierPath = Paths.get(cheminDossier);
        if (!Files.exists(cheminDossierPath)) {
            try {
                Files.createDirectories(cheminDossierPath);
                System.out.println("Dossier créé avec succès : " + cheminDossier);
            } catch (Exception e) {
                System.err.println("Erreur lors de la création du dossier : " + e.getMessage());
            }
        }
    }

    public static void createFile(String text, String code){
        createFolder();
        // Spécifiez le chemin du fichier à créer
        String cheminFichier = "/Users/nicola/Documents/GitHub/TipsEnergyManagement/export/" + getDate() + "/" + code + ".json";


        // Convertissez la chaîne en tableau de bytes
        byte[] bytes = text.getBytes();

        // Utilisez la classe Files pour créer le fichier et écrire le contenu
        try {
            Path cheminFichierPath = Paths.get(cheminFichier);
            Files.write(cheminFichierPath, bytes);
            System.out.println("Fichier créé avec succès : " + cheminFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String getFile(String code){
        // Spécifiez le chemin du fichier à lire
        String cheminFichier = "/Users/nicola/Documents/GitHub/TipsEnergyManagement/export/" + getDate() + "/" + code + ".json";

        // Utilisez BufferedReader pour lire le fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                //System.out.println(ligne);
                return ligne;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return null;
    }

}
