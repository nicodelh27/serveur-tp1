import java.io.*;
import java.net.*;

public class ClientCalcul {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 2222);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connexion établie avec le serveur.");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine());  // message d'accueil du serveur

            String question;
            while ((question = in.readLine()) != null) {
                System.out.print(question);  // Afficher la question du serveur
                String reponseUtilisateur = userInput.readLine();  // Lire la réponse de l'utilisateur
                out.println(reponseUtilisateur);  // Envoyer la réponse au serveur

                String feedback = in.readLine();  // Recevoir la réponse du serveur
                System.out.println(feedback);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
