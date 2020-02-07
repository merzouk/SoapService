/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : manageServiceWeb
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
 * Fichier 		:	ReadListPersonByIdentity.java
 * Créé le 		: 	7 févr. 2020 à 12:37:48
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

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
