package model;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBField {
 public String colummn()	;
 public boolean isPrimaryKey() default false;
 public boolean isRequired() default true;	
}