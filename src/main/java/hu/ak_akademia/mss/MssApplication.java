package hu.ak_akademia.mss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  MssApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(MSSUserRepository repository) {
//        return args -> {
//            var client = new Client();
//            client.setLastName("Teszt");
//            client.setFirstName("Elek");
//            client.setMothersName("Anya");
//            client.setDateOfBirth(LocalDate.of(1999, 1, 1));
//            client.setTAJNumber("123-456-789");
//            client.setGender("Male");
//            client.setPhoneNumber("+36303519011");
//            client.setEmail("a.@b.c");
//            client.setPassword(new PasswordEncryption().encode("ABcc123***"));
//            client.setPlaceOfBirth("Budapest");
//            client.setActive(true);
//            client.setRoles("ROLE_CLIENT");
//            client.setRegistrationDate(LocalDateTime.now());
//            repository.save(client);
//        };
//    }
}




