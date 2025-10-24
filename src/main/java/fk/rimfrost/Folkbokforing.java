package fk.rimfrost;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import se.fk.rimfrost.api.folkbokforing.jaxrsspec.controllers.generatedsource.FolkbokforingControllerApi;
import se.fk.rimfrost.api.folkbokforing.jaxrsspec.controllers.generatedsource.model.FolkbokforingPersnrGet200Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/folkbokforing/{persnr}")
public class Folkbokforing implements FolkbokforingControllerApi
{
   private static final Logger log = LoggerFactory.getLogger(Folkbokforing.class);

   @Override
   public FolkbokforingPersnrGet200Response folkbokforingPersnrGet(@PathParam("persnr")@Pattern(regexp = "^\\d{8}-\\d{4}$") String personnummer) {
      log.info("Folkbokforing received request: personnummer={}", personnummer);
      var response = new FolkbokforingPersnrGet200Response();
      String lastFour = personnummer.substring(personnummer.length() - 4);
      response.setResult(!lastFour.equals("9999"));
      log.info("Folkbokforing sending response: {}", response);
      return response;
   }
}
