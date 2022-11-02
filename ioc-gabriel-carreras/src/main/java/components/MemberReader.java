package components;




import entity.Member;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
@AllArgsConstructor
public class MemberReader {

        private static final Logger log = LoggerFactory.getLogger(MemberReader.class);

    private Scanner scanner;


    public Member requestMemberData(){
        log.info("Introduce DNI del miembro");
        String dni = scanner.nextLine();
        log.info("Introduce nombre del miembro");
        String name = scanner.nextLine();
        log.info("Introduce apellidos del miembro");
        String surname = scanner.nextLine();
        log.info("Introduce codigo postal del miembro");
        int postalCode = scanner.nextInt();
        scanner.nextLine();
        return new Member(dni,name,surname,postalCode);
    }

}
