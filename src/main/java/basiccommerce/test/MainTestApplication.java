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

    static EntityManager em = JPAUtil.getEntityManager();
    private static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        var function = showMenu();

        while (function != 9) {

            try {
                switch (function) {
                    case 1:
                        registerProduct();
                        break;
                    case 2:
                        //changeProduct();
                        break;
                    case 3:
                        searchId();
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
            function = showMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int showMenu() {
        System.out.println("""
                BasicCommerce - ESCOLHA UMA OPÇÃO:
                1 - Registrar um produto.
                2 - Alterar um cadastro de produto.
                3 - Filtrar um produto por ID.
                4 - Remover um produto.
                5 - Registrar uma categoria.
                6 - Alterar um cadastro de categoria.
                7 - Filtrar uma categoria.
                8 - Remover uma categoria.
                9 - Sair.
                """);
        return keyboard.nextInt();
    }

    private static void searchId(){
        try{
            System.out.println("Digite o id do produto:");
            Scanner scannerAux = new Scanner(System.in);
            String searchAux1 = scannerAux.nextLine();

            ProductDao pdDao = new ProductDao(em);
            Product product = new Product(pdDao.searchID(1L));//Long.getLong(searchAux1)));

            System.out.println(product);

        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }
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