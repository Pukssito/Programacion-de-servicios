package components;

import entity.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Scanner;
@AllArgsConstructor
@NoArgsConstructor
public class MemberProgram {

    private Scanner scanner;
    private MemberStorage memberStorage;
    private MemberReader memberReader;

    public void execute() {
        while (true) {
            System.out.println("Elige una opcion");
            System.out.println("1. Añadir socio");
            System.out.println("2. Eliminar socio");
            System.out.println("3. Listar socios");
            System.out.println("4. Salir");

            Integer option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                   Member member = memberReader.requestMemberData();
                   memberStorage.addMember(member);
                    break;
                case 2:
                    System.out.println("Introduce el DNI del socio a eliminar");
                    String dni = scanner.nextLine();
                    memberStorage.removeMember(dni);

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