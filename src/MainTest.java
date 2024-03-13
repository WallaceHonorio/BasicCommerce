import nordicwh.basiccommerce.model.Client;
import nordicwh.basiccommerce.model.Product;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTest {

    public static void main(String[] args) {

        try{
            //Test produto
            System.out.println("Digite o nome do produto:");
            Scanner scannerAux = new Scanner(System.in);
            String productAux1 = scannerAux.nextLine();

            System.out.println("Digite o preço do produto:");
            String productAux2 = scannerAux.nextLine();
            productAux2 = productAux2.replace(",",".");

            System.out.println("Digite o quantidade do produto:");
            String productAux3 = scannerAux.nextLine();

            Product product = new Product(productAux1, Double.valueOf(productAux2), Integer.valueOf(productAux3));

            System.out.println(product);


            //Test client
            System.out.println("Digite o email do cliente:");
            scannerAux = new Scanner(System.in);
            String clientAux1 = scannerAux.nextLine();

            System.out.println("Digite o password do cliente:");
            String clientAux2 = scannerAux.nextLine();

            System.out.println("Digite o name do cliente:");
            String clientAux3 = scannerAux.nextLine();

            Client client = new Client(clientAux1, clientAux2, clientAux3);

            System.out.println(client);
        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }



    }

}