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
 * Course
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-29T12:34:36.625+02:00[Europe/Berlin]")
public class Course   {
  @JsonProperty("CourseUID")
  private Integer courseUID = null;

  @JsonProperty("CourseName")
  private String courseName = null;

  @JsonProperty("CourseFee")
  private Integer courseFee = null;

  public Course courseUID(Integer courseUID) {
    this.courseUID = courseUID;
    return this;
  }

  /**
   * Get courseUID
   * @return courseUID
  **/
  @ApiModelProperty(example = "3", value = "")
  
    public Integer getCourseUID() {
    return courseUID;
  }

  public void setCourseUID(Integer courseUID) {
    this.courseUID = courseUID;
  }

  public Course courseName(String courseName) {
    this.courseName = courseName;
    return this;
  }

  /**
   * Get courseName
   * @return courseName
  **/
  @ApiModelProperty(example = "Mathematics", value = "")
  
    public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Course courseFee(Integer courseFee) {
    this.courseFee = courseFee;
    return this;
  }

  /**
   * Get courseFee
   * @return courseFee
  **/
  @ApiModelProperty(example = "110", value = "")
  
    public Integer getCourseFee() {
    return courseFee;
  }

  public void setCourseFee(Integer courseFee) {
    this.courseFee = courseFee;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(this.courseUID, course.courseUID) &&
        Objects.equals(this.courseName, course.courseName) &&
        Objects.equals(this.courseFee, course.courseFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseUID, courseName, courseFee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Course {\n");
    
    sb.append("    courseUID: ").append(toIndentedString(courseUID)).append("\n");
    sb.append("    courseName: ").append(toIndentedString(courseName)).append("\n");
    sb.append("    courseFee: ").append(toIndentedString(courseFee)).append("\n");
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
