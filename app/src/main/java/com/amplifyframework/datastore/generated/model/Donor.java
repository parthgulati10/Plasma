package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Donor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Donors")
public final class Donor implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField NAME = field("name");
  public static final QueryField EMAIL = field("email");
  public static final QueryField BLOOD_GROUP = field("bloodGroup");
  public static final QueryField PHONE_NO = field("phoneNo");
  public static final QueryField ADDRESS = field("address");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String email;
  private final @ModelField(targetType="BloodGroupTypes", isRequired = true) BloodGroupTypes bloodGroup;
  private final @ModelField(targetType="String", isRequired = true) String phoneNo;
  private final @ModelField(targetType="String") String address;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getEmail() {
      return email;
  }
  
  public BloodGroupTypes getBloodGroup() {
      return bloodGroup;
  }
  
  public String getPhoneNo() {
      return phoneNo;
  }
  
  public String getAddress() {
      return address;
  }
  
  private Donor(String id, String name, String email, BloodGroupTypes bloodGroup, String phoneNo, String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.bloodGroup = bloodGroup;
    this.phoneNo = phoneNo;
    this.address = address;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Donor donor = (Donor) obj;
      return ObjectsCompat.equals(getId(), donor.getId()) &&
              ObjectsCompat.equals(getName(), donor.getName()) &&
              ObjectsCompat.equals(getEmail(), donor.getEmail()) &&
              ObjectsCompat.equals(getBloodGroup(), donor.getBloodGroup()) &&
              ObjectsCompat.equals(getPhoneNo(), donor.getPhoneNo()) &&
              ObjectsCompat.equals(getAddress(), donor.getAddress());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getEmail())
      .append(getBloodGroup())
      .append(getPhoneNo())
      .append(getAddress())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Donor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("bloodGroup=" + String.valueOf(getBloodGroup()) + ", ")
      .append("phoneNo=" + String.valueOf(getPhoneNo()) + ", ")
      .append("address=" + String.valueOf(getAddress()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Donor justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Donor(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      email,
      bloodGroup,
      phoneNo,
      address);
  }
  public interface NameStep {
    EmailStep name(String name);
  }
  

  public interface EmailStep {
    BloodGroupStep email(String email);
  }
  

  public interface BloodGroupStep {
    PhoneNoStep bloodGroup(BloodGroupTypes bloodGroup);
  }
  

  public interface PhoneNoStep {
    BuildStep phoneNo(String phoneNo);
  }
  

  public interface BuildStep {
    Donor build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep address(String address);
  }
  

  public static class Builder implements NameStep, EmailStep, BloodGroupStep, PhoneNoStep, BuildStep {
    private String id;
    private String name;
    private String email;
    private BloodGroupTypes bloodGroup;
    private String phoneNo;
    private String address;
    @Override
     public Donor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Donor(
          id,
          name,
          email,
          bloodGroup,
          phoneNo,
          address);
    }
    
    @Override
     public EmailStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BloodGroupStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public PhoneNoStep bloodGroup(BloodGroupTypes bloodGroup) {
        Objects.requireNonNull(bloodGroup);
        this.bloodGroup = bloodGroup;
        return this;
    }
    
    @Override
     public BuildStep phoneNo(String phoneNo) {
        Objects.requireNonNull(phoneNo);
        this.phoneNo = phoneNo;
        return this;
    }
    
    @Override
     public BuildStep address(String address) {
        this.address = address;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String email, BloodGroupTypes bloodGroup, String phoneNo, String address) {
      super.id(id);
      super.name(name)
        .email(email)
        .bloodGroup(bloodGroup)
        .phoneNo(phoneNo)
        .address(address);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder bloodGroup(BloodGroupTypes bloodGroup) {
      return (CopyOfBuilder) super.bloodGroup(bloodGroup);
    }
    
    @Override
     public CopyOfBuilder phoneNo(String phoneNo) {
      return (CopyOfBuilder) super.phoneNo(phoneNo);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
  }
  
}
