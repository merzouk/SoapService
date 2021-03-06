package org.com;

import java.util.List;

import org.com.model.Person;
import org.com.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : manageServiceWeb
 * @package : org.com
 * @date    : 7 févr. 2020 12:37:48
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {})
public class ReadListPersonByIdentity
{
   @Autowired
   private PersonService personService;
   /**
    * 
    */
   @Test
   public void readListPersonTest()
   {
      List<Person> list = personService.getPersonsListByIdentity( "Merzouk", "MENHOUR" );
      for( Person person : list )
      {
         System.out.println( person.toString() );
      }
   }
}
