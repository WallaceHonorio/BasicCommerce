package basiccommerce.test;

import basiccommerce.dao.CategoryDao;
import basiccommerce.dao.ProductDao;
import basiccommerce.model.Category;
import basiccommerce.model.Product;
import basiccommerce.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTestApplication {

    private static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        var function = exibirMenu();

        while (function != 9) {

            try {
                switch (function) {
                    case 1:
                        registerProduct();
                        break;
                    default:
                        function = 9;
                        break;
                }

            } catch (Exception e) {
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                keyboard.next();
            }
            function = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int exibirMenu() {
        System.out.println("""
                BasicCommerce - ESCOLHA UMA OPÇÃO:
                1 - Registrar um produto.
                2 - 
                3 - 
                4 - 
                5 - 
                6 - 
                7 - 
                8 - 
                9 - Sair
                """);
        return keyboard.nextInt();
    }

    private static void registerProduct() {
        try{
            System.out.println("Digite o nome do produto:");
            Scanner scannerAux = new Scanner(System.in);
            String productAux1 = scannerAux.nextLine();

            System.out.println("Digite o preço do produto:");
            String productAux2 = scannerAux.nextLine();
            productAux2 = productAux2.replace(",",".");

            System.out.println("Digite o quantidade do produto:");
            String productAux3 = scannerAux.nextLine();

            System.out.println("Digite a categoria do produto:");
            String categoryAux = scannerAux.nextLine();

            Category category = new Category(categoryAux);
            Product product = new Product(productAux1, Double.valueOf(productAux2), Integer.valueOf(productAux3), category);

            EntityManager em = JPAUtil.getEntityManager();
            ProductDao pdDao = new ProductDao(em);
            CategoryDao ctDao = new CategoryDao(em);

            em.getTransaction().begin();

            ctDao.register(category);
            pdDao.register(product);
            em.flush();
            em.clear();

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }
    }

}