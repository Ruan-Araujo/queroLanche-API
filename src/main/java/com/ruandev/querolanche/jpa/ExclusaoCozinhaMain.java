package com.ruandev.querolanche.jpa;

import com.ruandev.querolanche.QuerolancheApiApplication;
import com.ruandev.querolanche.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(QuerolancheApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha  = new Cozinha();
        cozinha.setId(1L);

        cadastroCozinha.remover(cozinha);
    }

}
