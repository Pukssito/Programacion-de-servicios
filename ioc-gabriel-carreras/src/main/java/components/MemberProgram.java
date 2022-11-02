package components;

import entity.Member;
import lombok.AllArgsConstructor;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

@AllArgsConstructor
public class MemberProgram {

    private Scanner scanner;
    private MemberStorage memberStorage;
    private MemberReader memberReader;

    public void execute(){
        while (true){
            System.out.println("Elige una opcion");
            System.out.println("1. Añadir socio");
            System.out.println("2. Eliminar socio");
            System.out.println("3. Listar socios");
            System.out.println("4. Salir");

            Integer option = scanner.nextInt();
            switch (option){
                case 1:
                    memberReader.requestMemberData();
                    break;
                case 2:
                    System.out.println("Introduce el DNI del socio a eliminar");
                    String dni = scanner.nextLine();
                    scanner.nextLine();
                    memberStorage.removeMember(dni);
                    System.out.println("Socio eliminado");
                    break;
                case 3:
                    memberStorage.listMembers();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }



    }
}
