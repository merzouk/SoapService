package org.com;

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
public class ReadListPersonById
{
   @Autowired
   private PersonService personService;
   /**
    * 
    */
   @Test
   public void readListPersonTest()
   {
      Person person = personService.readPersonById( 2 );
      System.out.println( person.toString() );
   }
}
