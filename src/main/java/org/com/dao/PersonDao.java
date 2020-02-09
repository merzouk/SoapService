package org.com.dao;

import java.util.List;

import org.com.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : webapp
 * @package : org.com
 * @date    : 28 janv. 2020 19:22:50
 */
@Repository("personDao")
public interface PersonDao extends JpaRepository<Person, Integer>
{
   /**
    * 
    * @param firstname
    * @return
    */
   @Query("SELECT p FROM Person p WHERE p.firstname = :firstname")
   public List<Person> getPersonsListByFirstName( @Param("firstname") String firstName );
   
   /**
    * 
    * @param lastname
    * @return
    */
   @Query("SELECT p FROM Person p WHERE p.lastname = :lastname")
   public List<Person> getPersonsListByLastName( @Param("lastname") String lastname );
   
   /**
    * 
    * @param firstname
    * @param lastname
    * @return
    */
   @Query("SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname")
   public List<Person> getPersonsListByIdentity( @Param("firstname") String firstname, @Param("lastname") String lastname );
   
   /**
   * 
   * @param personId
   * @param firstname
   * @param lastname
   * @return
   */
   @Modifying
   @Transactional
   @Query("UPDATE Person p SET p.firstname = :firstname, p.lastname = :lastname WHERE p.id = :id")
   public int updatePerson( @Param("id") Integer personId, @Param("firstname") String firstname, @Param("lastname") String lastname );
}
