package basiccommerce.test;

import basiccommerce.dao.CategoryDao;
import basiccommerce.dao.ProductDao;
import basiccommerce.model.Category;
import basiccommerce.model.Product;
import basiccommerce.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTestApplication {

    private static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        var function = showMenu();

        while (function != 10) {

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
                    case 4:
                        searchAll();
                    break;
                    default:
                        function = 10;
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
                4 - Filtrar todos os produtos.
                5 - Remover um produto.
                6 - Registrar uma categoria.
                7 - Alterar um cadastro de categoria.
                8 - Filtrar uma categoria.
                9 - Remover uma categoria.
                10 - Sair.
                """);
        return keyboard.nextInt();
    }

    private static void searchId(){
        try{
            System.out.println("Digite o id do produto:");
            Scanner scannerAux = new Scanner(System.in);
            String searchAux1 = scannerAux.nextLine();

            EntityManager em = JPAUtil.getEntityManager();

            ProductDao pdDao = new ProductDao(em);
            Product p = pdDao.searchID(Long.getLong(searchAux1));

            System.out.println(p);
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }
    }

    private static void searchAll(){
        try{

            EntityManager em = JPAUtil.getEntityManager();

            ProductDao pdDao = new ProductDao(em);
            List<Product> all = pdDao.searchAll();
            all.forEach(p-> System.out.println(p.getName()));

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

            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();

            ProductDao pdDao = new ProductDao(em);
            CategoryDao ctDao = new CategoryDao(em);

            ctDao.register(category);
            pdDao.register(product);
            em.getTransaction().commit();
            em.close();

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }
    }

}