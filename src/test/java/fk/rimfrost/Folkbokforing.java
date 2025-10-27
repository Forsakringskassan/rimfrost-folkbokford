package se.fk.github.rimfrost.folkbokford;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class FolkbokforingTest
{
   @Test
   void testFolkbokforingTrue()
   {
      String actualResponse = given()
            .when().get("/folkbokforing/1234")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      assertThat(actualResponse).isEqualToIgnoringWhitespace("""
            {"result":true}
            """);
   }

   @Test
   void testFolkbokforingFalse()
   {
      String actualResponse = given()
            .when().get("/folkbokforing/19999")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      assertThat(actualResponse).isEqualToIgnoringWhitespace("""
            {"result":false}
            """);
   }

}
