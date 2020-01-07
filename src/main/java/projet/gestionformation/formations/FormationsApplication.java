package projet.gestionformation.formations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import projet.gestionformation.formations.security.entities.AppRole;
import projet.gestionformation.formations.entities.Formation;
import projet.gestionformation.formations.repositories.FormationRepository;
import projet.gestionformation.formations.security.services.AccountService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootApplication
public class FormationsApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(FormationsApplication.class, args);
    }

    @Autowired
    private FormationRepository formationRepository;
    @Override
    public void run(String... args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        formationRepository.save(new Formation(null,"init-html","0dev1","0cc1","0dd1",31.2,df.parse("21/12/2019"),31));
        formationRepository.save(new Formation(null,"init-java","0dev2","0cc2","0dd2",32.2,df.parse("22/11/2019"),32));
        formationRepository.save(new Formation(null,"init-php","0dev3","0cc3","0dd3",33.2,df.parse("23/05/2019"),33));
        formationRepository.save(new Formation(null,"init-cobol","0dev4","0cc4","0dd4",34.2,df.parse("24/07/2019"),34));
        formationRepository.save(new Formation(null,"init-visuel basic","0dev5","0cc5","0dd5",35.2,df.parse("25/08/2019"),45));
        formationRepository.save(new Formation(null,"init-html1","0dev11","0cc11","0dd11",131.2,df.parse("20/01/2019"),41));
        formationRepository.save(new Formation(null,"init-java1","0dev12","0cc12","0dd12",132.2,df.parse("28/02/2019"),42));
        formationRepository.save(new Formation(null,"init-php1","0dev13","0cc13","0dd13",133.2,df.parse("27/04/2019"),43));
        formationRepository.save(new Formation(null,"init-cobol1","0dev14","0cc14","0dd14",134.2,df.parse("26/05/2019"),44));
        formationRepository.save(new Formation(null,"init-visuel basic1","0dev15","0cc15","0dd15",135.2,df.parse("25/09/2019"),15));

        formationRepository.save(new Formation(null,"html","dev1","cc1","dd1",21.2,df.parse("21/06/2019"),21));
        formationRepository.save(new Formation(null,"java","dev2","cc2","dd2",22.2,df.parse("22/06/2019"),22));
        formationRepository.save(new Formation(null,"php","dev3","cc3","dd3",23.2,df.parse("23/06/2019"),23));
        formationRepository.save(new Formation(null,"cobol","dev4","cc4","dd4",24.2,df.parse("24/06/2019"),24));
        formationRepository.save(new Formation(null,"visuel basic","dev5","cc5","dd5",25.2,df.parse("25/06/2019"),15));
        formationRepository.save(new Formation(null,"html1","dev11","cc11","dd11",121.2,df.parse("20/04/2019"),11));
        formationRepository.save(new Formation(null,"java1","dev12","cc12","dd12",122.2,df.parse("28/06/2019"),12));
        formationRepository.save(new Formation(null,"php1","dev13","cc13","dd13",123.2,df.parse("27/06/2019"),13));
        formationRepository.save(new Formation(null,"cobol1","dev14","cc14","dd14",124.2,df.parse("26/06/2019"),14));
        formationRepository.save(new Formation(null,"visuel basic1","dev15","cc15","dd15",125.2,df.parse("25/06/2019"),15));

    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.saveRole(new AppRole(null,"USER"));
            accountService.saveRole(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
                accountService.saveUser(un,"1234","1234");
            });

            accountService.addRoleToUser("admin","ADMIN");
        };
    }

}
