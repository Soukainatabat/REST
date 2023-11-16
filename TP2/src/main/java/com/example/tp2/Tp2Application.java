package com.example.tp2;

import com.example.tp2.Entities.Bankccount;
import com.example.tp2.Enumeration.AccountType;
import com.example.tp2.Repositories.AccountBankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Tp2Application {

    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }
     @Bean
    CommandLineRunner start(AccountBankRepository bankccountRepository){
        return args ->{
            for(int i=0;i<10;i++){
                Bankccount bankccount=Bankccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5 ?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();

                bankccountRepository.save(bankccount);
            }
        };
    }

}
