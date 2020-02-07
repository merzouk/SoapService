
package org.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * A Renseigner.
 * 
 * @author : Merzouk
 * @project : web
 * @package : org.com.model
 * @date : 26 janv. 2020 19:06:31
 */
@Entity(name = "Person")
@Table(name = "Person")
public class Person implements Serializable
{
   /**
   * 
   */
   private static final long serialVersionUID = -5450807399130318559L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer           id;
   
   @Column(name = "firstname", length = 255, unique = false, nullable = false)
   @NotNull
   private String            firstname;
   
   @Column(name = "lastname", length = 255, unique = false, nullable = false)
   @NotNull
   private String            lastname;
   public Person( Integer id, @NotNull String firstname, @NotNull String lastname )
   {
      super();
      this.id = id;
      this.firstname = firstname;
      this.lastname = lastname;
   }
   
   public Person( @NotNull String firstname, @NotNull String lastname )
   {
      super();
      this.id = 0;
      this.firstname = firstname;
      this.lastname = lastname;
   }
   
   public Person()
   {
      super();
   }
   
   public Integer getId()
   {
      return id;
   }
   
   public void setId( Integer id )
   {
      this.id = id;
   }
   
   public String getFirstname()
   {
      return firstname;
   }
   
   public void setFirstname( String firstname )
   {
      this.firstname = firstname;
   }
   
   public String getLastname()
   {
      return lastname;
   }
   
   public void setLastname( String lastname )
   {
      this.lastname = lastname;
   }
   
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( firstname == null ) ? 0 : firstname.hashCode() );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
      result = prime * result + ( ( lastname == null ) ? 0 : lastname.hashCode() );
      return result;
   }
   
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Person other = (Person) obj;
      if( firstname == null )
      {
         if( other.firstname != null ) return false;
      }
      else if( !firstname.equals( other.firstname ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      if( lastname == null )
      {
         if( other.lastname != null ) return false;
      }
      else if( !lastname.equals( other.lastname ) ) return false;
      return true;
   }
   
   @Override
   public String toString()
   {
      return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
   }
}
