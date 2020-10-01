package ru.vlapin.experiments.demo9.model.jsonplaceholder;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.Setter;

@Data
@Setter(PRIVATE)
public class Album {

  Long userId;
  Long id;
  String title;
}
