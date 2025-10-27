package se.fk.github.rimfrost.folkbokford;

import jakarta.ws.rs.GET;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import se.fk.rimfrost.api.folkbokforing.jaxrsspec.controllers.generatedsource.PopulationRegistrationControllerApi;
import se.fk.rimfrost.api.folkbokforing.jaxrsspec.controllers.generatedsource.model.PopulationRegistrationSocialSecurityNrGet200Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/population_registration/{social_security_nr}")
public class PopulationRegistration implements PopulationRegistrationControllerApi
{
   private static final Logger log = LoggerFactory.getLogger(PopulationRegistration.class);

   public PopulationRegistrationSocialSecurityNrGet200Response populationRegistrationSocialSecurityNrGet(
         String social_security_nr)
   {
      log.info("PopulationRegistration received request: social_security_nr={}", social_security_nr);
      var response = new PopulationRegistrationSocialSecurityNrGet200Response();
      String lastFour = social_security_nr.substring(social_security_nr.length() - 4);
      response.setResult(!lastFour.equals("9999"));
      log.info("PopulationRegistration sending response: {}", response);
      return response;
   }
}
