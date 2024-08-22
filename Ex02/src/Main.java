import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XDAO xdao = new XDAO();
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                	System.out.println("\nLista de objetos X:");
                    for (X x : xdao.list()) {
                        System.out.println(x);
                    }
                    break;
                case 2:
                	System.out.print("Digite o nome: ");
                    String name = scanner.next();
                    X newX = new X(name);
                    xdao.insert(newX);
                    break;
                case 3:
                	System.out.print("Digite o ID do objeto a ser excluído: ");
                    int idToDelete = scanner.nextInt();
                    xdao.delete(idToDelete);
                    break;
                case 4:
                	System.out.print("Digite o ID do objeto a ser atualizado: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Digite o novo nome: ");
                    String newName = scanner.next();
                    xdao.update(idToUpdate, newName);
                    break;
                case 5:
                	System.out.println("Saindo...");
                    break;
                default:
                	System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }
}
