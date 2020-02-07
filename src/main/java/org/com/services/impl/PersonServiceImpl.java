/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : webapp
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	PersonService.java
 * Créé le 		: 	28 janv. 2020 à 21:03:59
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.com.dao.PersonDao;
import org.com.model.Person;
import org.com.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * A Renseigner.
 * 
 * @author : Merzouk
 * @project : webapp
 * @package : org.com.services
 * @date : 28 janv. 2020 21:03:59
 */
@Service("service")
public class PersonServiceImpl implements PersonService
{
   private static final Logger logger = LoggerFactory.getLogger( PersonServiceImpl.class );
   
   @Autowired
   private PersonDao           personDao;
   /**
    * 
    * @param person
    * @return
    */
   @Transactional(readOnly = false, rollbackFor = { Exception.class, Error.class, SQLException.class })
   public Person addPerson( Person person )
   {
      logger.info( "add new Person firstname : " + person.getFirstname() + "  lastName " + person.getLastname() );
      logger.info( "new Person " + person.toString() );
      return personDao.save( person );
   }
   
   @Transactional(readOnly = false, rollbackFor = { Exception.class, Error.class, SQLException.class })
   public String deletePersonById( Integer id )
   {
      logger.info( "delete Person by id : " + id );
      if( personDao.existsById( id ) )
      {
         personDao.deleteById( id );
         return "ID " + id + " found and deleted succeful";
      }
      return "ID " + id + " not found";
   }
   
   @Transactional(readOnly = false, rollbackFor = { Exception.class, Error.class, SQLException.class })
   public boolean updatePerson( Person person )
   {
      if( person != null && person.getId() != null && person.getId().intValue() > 0 )
      {
         logger.info( "update Person  : " + person );
         if( personDao.existsById( person.getId() ) )
         {
            logger.info( "id " + person.getId() + " found in database" );
            if( person.getFirstname() != null && person.getFirstname().trim().length() > 0 && person.getLastname() != null && person.getLastname().trim().length() > 0 )
            {
               int result = personDao.updatePerson( person.getId(), person.getFirstname(), person.getLastname() );
               logger.info( "result of updating : " + result );
               return true;
            }
         }
         else
         {
            logger.info( "id " + person.getId() + " not found in database" );
            return false;
         }
      }
      return false;
   }
   
   @Transactional(readOnly = true)
   public List<Person> getPersonsListByFirstName( String firstname )
   {
      logger.info( "get List Person by firstname : " + firstname );
      return personDao.getPersonsListByFirstName( firstname );
   }
   
   @Transactional(readOnly = true)
   public List<Person> getListPersonByLastName( String lastname )
   {
      logger.info( "get List Person by lastname : " + lastname );
      return personDao.getPersonsListByLastName( lastname );
   }
   
   /**
    * 
    * @param firstname
    * @param lastname
    * @return
    */
   @Transactional(readOnly = true)
   public List<Person> getPersonsListByIdentity( String firstname, String lastname )
   {
      logger.info( "get List Person by identity firstName : " + firstname + " & lastName : " + lastname );
      return personDao.getPersonsListByIdentity( firstname, lastname );
   }
   
   /**
    * 
    * @return
    */
   @Transactional(readOnly = true)
   public List<Person> getListPerson()
   {
      logger.info( "get List Person  " );
      return personDao.findAll();
   }
   
   /**
    * 
    * @param id
    * @return
    */
   @Transactional(readOnly = true, rollbackFor = { Exception.class, Error.class, SQLException.class })
   public Person readPersonById( Integer id )
   {
      logger.info( "read Person by id : " + id );
      java.util.Optional<Person> person = personDao.findById( id );
      if( person.isPresent() )
      {
         return person.get();
      }
      return null;
   }
}
