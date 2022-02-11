package com.ruandev.querolanche.jpa;

import com.ruandev.querolanche.QuerolancheApiApplication;
import com.ruandev.querolanche.domain.model.Cozinha;
import com.ruandev.querolanche.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(QuerolancheApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1  = new Cozinha();
        cozinha1.setNome("Italiana");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinha1 = cozinhaRepository.adicionar(cozinha1);
        cozinha2 = cozinhaRepository.adicionar(cozinha2);

        System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
        System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
    }

}
