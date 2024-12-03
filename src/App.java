import controllers.CarroController; // Importação do controller

// Classe principal
public class App {
    public static void main(String[] args) throws Exception {
        CarroController controller = new CarroController(); // Cria o controller
        controller.iniciar(); // Inicia o controller
    }
}