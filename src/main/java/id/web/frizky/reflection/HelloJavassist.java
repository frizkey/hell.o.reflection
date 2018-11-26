package id.web.frizky.reflection;

import javassist.ClassPool;
import org.springframework.context.annotation.Bean;


public class HelloJavassist {
    @Bean
    public void runnerJavassist(){
        ClassPool pool = ClassPool.getDefault();
    }
}
