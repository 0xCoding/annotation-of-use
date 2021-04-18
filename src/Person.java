/**
 * @author wei
 * @date 2021/3/24 - 22:06
 */
public class Person {
    @Range(max = 5)
    private  String name;
    @Range(min = 3,max = 100)
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
