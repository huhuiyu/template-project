package top.huhuiyu.springbase.entity;

import java.io.Serializable;

/**
 * 演示用实体类
 * 
 * @author 胡辉煜
 *
 */
public class Info implements Serializable {

  private static final long serialVersionUID = -7587233175092357198L;

  private String name;
  private Integer age;

  public Info() {
  }

  public Info(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Info [name=" + name + ", age=" + age + "]";
  }

}
