
package org.com.services;

import java.util.List;

import org.com.model.Person;

/**
 * 
 * A Renseigner.
 * @author  : Merzouk
 * @project : manageServiceWeb
 * @package : org.com.services
 * @date    : 7 févr. 2020 09:30:15
 */
public interface PersonService
{
   /**
    * 
    * @param person
    * @return
    */
   public Person addPerson( Person person );
   
   /**
    * 
    * @param id
    * @return
    */
   public String deletePersonById( Integer id );
   
   /**
    * 
    * @param person
    * @return
    */
   public boolean updatePerson( Person person );
   
   /**
    * 
    * @param firstname
    * @return
    */
   public List<Person> getPersonsListByFirstName( String firstname );
   
   /**
    * 
    * @param lastname
    * @return
    */
   public List<Person> getListPersonByLastName( String lastname );
   
   /**
    * 
    * @param firstname
    * @param lastname
    * @return
    */
   public List<Person> getPersonsListByIdentity( String firstname, String lastname );
   
   /**
    * 
    * @return
    */
   public List<Person> getListPerson();
   
   /**
    * 
    * @param id
    * @return
    */
   public Person readPersonById( Integer id );
}
