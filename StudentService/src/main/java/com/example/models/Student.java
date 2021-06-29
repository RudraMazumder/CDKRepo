package com.example.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-29T12:34:36.625+02:00[Europe/Berlin]")
public class Student   {
  @JsonProperty("StudentID")
  private Integer studentID = null;

  @JsonProperty("StudentName")
  private String studentName = null;

  @JsonProperty("Age")
  private Integer age = null;

  @JsonProperty("GroupID")
  private String groupID = null;

  public Student studentID(Integer studentID) {
    this.studentID = studentID;
    return this;
  }

  /**
   * Get studentID
   * @return studentID
  **/
  @ApiModelProperty(example = "3", value = "")
  
    public Integer getStudentID() {
    return studentID;
  }

  public void setStudentID(Integer studentID) {
    this.studentID = studentID;
  }

  public Student studentName(String studentName) {
    this.studentName = studentName;
    return this;
  }

  /**
   * Get studentName
   * @return studentName
  **/
  @ApiModelProperty(example = "David", value = "")
  
    public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Student age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(example = "10", value = "")
  
    public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Student groupID(String groupID) {
    this.groupID = groupID;
    return this;
  }

  /**
   * Get groupID
   * @return groupID
  **/
  @ApiModelProperty(example = "GROUP-3", value = "")
  
    public String getGroupID() {
    return groupID;
  }

  public void setGroupID(String groupID) {
    this.groupID = groupID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.studentID, student.studentID) &&
        Objects.equals(this.studentName, student.studentName) &&
        Objects.equals(this.age, student.age) &&
        Objects.equals(this.groupID, student.groupID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentID, studentName, age, groupID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    studentID: ").append(toIndentedString(studentID)).append("\n");
    sb.append("    studentName: ").append(toIndentedString(studentName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    groupID: ").append(toIndentedString(groupID)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
