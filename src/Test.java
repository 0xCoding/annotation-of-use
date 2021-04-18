import java.lang.reflect.Field;

/**
 * @author wei
 * @date 2021/3/24 - 22:08
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Person person =new Person("aabbcc",33);
        check(person);

    }
    public static void check(Person person) throws IllegalAccessException {
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field:fields) {
            if(field.isAnnotationPresent(Range.class)){
                field.setAccessible(true);
                Object o = field.get(person);
                Range range = field.getAnnotation(Range.class);
                if (o instanceof String){
                    String s = (String) o;
                    if(s.length()<range.min() || s.length()>range.max()){
                        throw  new RuntimeException("invalid field: "+field.getName());
                    }
                }
                if(o instanceof  Integer){
                    Integer i = (Integer) o;
                    if(range.min()>i || range.max()<i){
                        throw  new RuntimeException("invalid field: "+field.getName());
                    }
                }

            }
        }
    }
}

