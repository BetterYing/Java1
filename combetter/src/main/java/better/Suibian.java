package better;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE.METHOD,ElementType.TYPE})
public @interface Suibian {
    String name();//注解属性的定义：类似接口的语法

}
