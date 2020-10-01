package ru.vlapin.experiments.demo9.jsonplaceholder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.demo9.model.jsonplaceholder.Post;
import ru.vlapin.experiments.demo9.service.jsonplaceholder.PostService;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PostControllerTest {

  long id = 57L;
  PostService postService;

  @ParameterizedTest
  @ValueSource(strings = { "Hello", "World" })
  void testWithStringParameter(String argument) {
    assertNotNull(argument);
  }

  @ParameterizedTest
  @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    // или даже так: @CsvFileSource(resources = "/two-column.csv")
  void testWithCsvSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }

  @Test
  @SneakyThrows
  @DisplayName("Get method works correctly")
  void get() {
    assertThat(postService.all())
        .isNotNull()
        .isNotEmpty()
        .hasSize(100);
  }

  @Test
  @SneakyThrows
  @DisplayName("Get one post method works correctly")
  void getOnePostMethodWorksCorrectlyTest() {

    final var idCondition = new Condition<Post>(post -> post.getId() == id, "id is equals");
    final var bodyCondition = new Condition<Post>(post -> post.getBody().equals("""
        at pariatur consequuntur earum quidem
        quo est laudantium soluta voluptatem
        qui ullam et est
        et cum voluptas voluptatum repellat est"""), "body is equals");

    assertThat(postService.findById(id))
        .isNotNull()
        .satisfies(idCondition)
        .satisfies(bodyCondition)
        .extracting(Post::getTitle)
        .isEqualTo("sed ab est est");
  }
}
