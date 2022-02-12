package com.ruandev.querolanche.jpa;

import com.ruandev.querolanche.QuerolancheApiApplication;
import com.ruandev.querolanche.domain.model.Cozinha;
import com.ruandev.querolanche.domain.model.Restaurante;
import com.ruandev.querolanche.domain.repository.CozinhaRepository;
import com.ruandev.querolanche.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(QuerolancheApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> todosRestaurantes = restauranteRepository.todos();

        todosRestaurantes.forEach(restaurante ->
                System.out.printf("%s - %f - %s\n", restaurante.getNome(),
                restaurante.getTaxaFrete(), restaurante.getCozinha().getNome()));
    }

}
