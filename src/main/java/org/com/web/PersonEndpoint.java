
package org.com.web;

import java.util.List;

import org.com.model.Person;
import org.com.schema.AddPersonRequest;
import org.com.schema.AddPersonResponse;
import org.com.schema.DeletePersonByIdRequest;
import org.com.schema.DeletePersonByIdResponse;
import org.com.schema.GetPersonByFirstNameRequest;
import org.com.schema.GetPersonByFirstNameResponse;
import org.com.schema.GetPersonByIdRequest;
import org.com.schema.GetPersonByIdResponse;
import org.com.schema.GetPersonByLastNameRequest;
import org.com.schema.GetPersonByLastNameResponse;
import org.com.schema.Personlist;
import org.com.schema.ReadListPersonRequest;
import org.com.schema.ReadListPersonResponse;
import org.com.schema.UpdatePersonRequest;
import org.com.schema.UpdatePersonResponse;
import org.com.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * 
 * @Endpoint – registers the class with Spring WS as a Web Service Endpoint
 * @PayloadRoot – defines the handler method according to the namespace and localPart attributes
 * @ResponsePayload – indicates that this method returns a value to be mapped to the response payload
 * @RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request
 * 
 * 
 *
 * @author  : Merzouk
 * @project : manageServiceWeb
 * @package : org.com.web
 * @date    : 7 févr. 2020 09:30:44
 */
@Endpoint
public class PersonEndpoint
{
   private static final Logger logger        = LoggerFactory.getLogger( PersonEndpoint.class );
   
   private static final String NAMESPACE_URI = "http://org.com/personService";
   
   private PersonService       service;
   @Autowired
   public PersonEndpoint( PersonService service )
   {
      this.service = service;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "readListPersonRequest")
   @ResponsePayload
   public ReadListPersonResponse readListPerson( @RequestPayload ReadListPersonRequest request )
   {
      logger.info( "readListPerson " );
      List<Person> list = service.getListPerson();
      Personlist personlist = new Personlist();
      for( Person person : list )
      {
         org.com.schema.Person p = new org.com.schema.Person();
         p.setFirstname( person.getFirstname() );
         p.setId( person.getId() );
         p.setLastname( person.getLastname() );
         personlist.getPerson().add( p );
      }
      ReadListPersonResponse listResponse = new ReadListPersonResponse();
      listResponse.setPersonValues( personlist );
      return listResponse;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPersonRequest")
   @ResponsePayload
   public AddPersonResponse addPerson( @RequestPayload AddPersonRequest request )
   {
      logger.info( "addPerson " + request.getNewPersonRequest().getFirstname() + "   " + request.getNewPersonRequest().getLastname() );
      Person person = new Person();
      person.setFirstname( request.getNewPersonRequest().getFirstname() );
      person.setLastname( request.getNewPersonRequest().getLastname() );
      person.setId( request.getNewPersonRequest().getId() );
      person = service.addPerson( person );
      AddPersonResponse response = new AddPersonResponse();
      org.com.schema.Person resp = new org.com.schema.Person();
      resp.setFirstname( person.getFirstname() );
      resp.setLastname( person.getLastname() );
      resp.setId( person.getId() );
      response.setNewPersonResponse( resp );
      return response;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePersonRequest")
   @ResponsePayload
   public UpdatePersonResponse updatePerson( @RequestPayload UpdatePersonRequest request )
   {
      logger.info( "updatePerson " + request.getUpdatePersonRequest().getFirstname() + "   " + request.getUpdatePersonRequest().getLastname() + "   " + request.getUpdatePersonRequest().getId() );
      Person person = new Person();
      person.setFirstname( request.getUpdatePersonRequest().getFirstname() );
      person.setLastname( request.getUpdatePersonRequest().getLastname() );
      person.setId( request.getUpdatePersonRequest().getId() );
      Boolean result = service.updatePerson( person );
      if( result )
      {
         UpdatePersonResponse response = new UpdatePersonResponse();
         org.com.schema.Person resp = new org.com.schema.Person();
         resp.setFirstname( person.getFirstname() );
         resp.setLastname( person.getLastname() );
         resp.setId( person.getId() );
         response.setUpdatePersonResponse( resp );
         return response;
      }
      else
      {
         UpdatePersonResponse response = new UpdatePersonResponse();
         org.com.schema.Person resp = new org.com.schema.Person();
         response.setUpdatePersonResponse( resp );
         return response;
      }
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByFirstNameRequest")
   @ResponsePayload
   public GetPersonByFirstNameResponse getPersonByFirstName( @RequestPayload GetPersonByFirstNameRequest request )
   {
      logger.info( "getPersonByFirstName " + request.getFirstname() );
      Personlist responseList = new Personlist();
      List<Person> list = service.getPersonsListByFirstName( request.getFirstname() );
      for( Person person : list )
      {
         org.com.schema.Person personSchema = new org.com.schema.Person();
         personSchema.setFirstname( person.getFirstname() );
         personSchema.setLastname( person.getLastname() );
         personSchema.setId( person.getId() );
         responseList.getPerson().add( personSchema );
      }
      GetPersonByFirstNameResponse response = new GetPersonByFirstNameResponse();
      response.setPersonvalues( responseList );
      return response;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByLastNameRequest")
   @ResponsePayload
   public GetPersonByLastNameResponse getPersonByLastName( @RequestPayload GetPersonByLastNameRequest request )
   {
      logger.info( "getPersonByLastName " + request.getLarstname() );
      Personlist responseList = new Personlist();
      List<Person> list = service.getListPersonByLastName( request.getLarstname() );
      for( Person person : list )
      {
         org.com.schema.Person personSchema = new org.com.schema.Person();
         personSchema.setFirstname( person.getFirstname() );
         personSchema.setLastname( person.getLastname() );
         personSchema.setId( person.getId() );
         responseList.getPerson().add( personSchema );
      }     
      GetPersonByLastNameResponse response = new GetPersonByLastNameResponse();
      response.setPersonvalues( responseList );
      return response;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByIdRequest")
   @ResponsePayload
   public GetPersonByIdResponse getPersonById( @RequestPayload GetPersonByIdRequest request )
   {
      logger.info( "getPersonById " + request.getId() );
      Person person = service.readPersonById( request.getId() );
      org.com.schema.Person per = new org.com.schema.Person();
      per.setFirstname( person.getFirstname() );
      per.setId( person.getId() );
      per.setLastname( person.getLastname() );
      GetPersonByIdResponse response = new GetPersonByIdResponse();
      response.setPersonById( per );
      return response;
   }
   
   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePersonByIdRequest")
   @ResponsePayload
   public DeletePersonByIdResponse deletePersonById( @RequestPayload DeletePersonByIdRequest request )
   {
      logger.info( "deletePersonById " + request.getId() );
      String result = service.deletePersonById( request.getId() );
      DeletePersonByIdResponse response = new DeletePersonByIdResponse();
      response.setResult( result );
      return response;
   }
}
