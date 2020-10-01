package ru.vlapin.experiments.demo9.config;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.experiments.demo9.dao.CatRepository;
import ru.vlapin.experiments.demo9.model.Cat;

@Component
@RequiredArgsConstructor
public class DataJpaIniter implements ApplicationRunner {

  CatRepository catRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Stream.of("Мурзик, Барсик, Матроскин".split(", "))
      .map(Cat::new)
      .forEach(catRepository::save);
  }
}
