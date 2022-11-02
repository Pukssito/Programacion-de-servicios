package configuration;


import components.MemberProgram;
import components.MemberReader;
import components.MemberStorage;
import entity.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Scanner;

@Configuration
public class MemberConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
    @Bean
    public MemberReader memberReader(Scanner scanner) {
        return new MemberReader(scanner);
    }
    @Bean
    public MemberStorage memberStorage(Map<String, Member> members) {
        return new MemberStorage(members);
    }
    @Bean
    public MemberProgram memberProgram(Scanner scanner, MemberStorage memberStorage, MemberReader memberReader) {
        return new MemberProgram(scanner, memberStorage, memberReader);
    }
}
