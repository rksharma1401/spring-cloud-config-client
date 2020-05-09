
package learn.springcloud.configclient; 

public class Person {
	  private String firstName;
	  private String lastName;
	  private int age;
	  private String place;
	  public String getFirstName() {
	    return firstName;
	  }
	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }
	  public String getLastName() {
	    return lastName;
	  }
	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }
	  public int getAge() {
	    return age;
	  }
	  public void setAge(int age) {
	    this.age = age;
	  }
	  public String getPlace() {
	    return place;
	  }
	  public void setPlace(String place) {
	    this.place = place;
	  }

	  public String toString(){
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getFirstName())
	      .append(", ")
	      .append(this.getLastName())
	      .append(", ")
	      .append(this.getPlace())
	      .append(", ")
	      .append(this.getAge());

	    return builder.toString();
	  }

	}