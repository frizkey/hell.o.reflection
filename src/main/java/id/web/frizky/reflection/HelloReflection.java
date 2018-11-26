package id.web.frizky.reflection;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class HelloReflection {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static void main(String[] args)  {
        HelloReflection helloReflection = new HelloReflection();
        helloReflection.runnerReflection();
    }

    public void runnerReflection()  {
        Cat cat = new Cat();
        cat.jump();

        Method[] methods = Cat.class.getMethods();
        for (Method method : methods) {
            if(method.getModifiers() == Modifier.PUBLIC){
                logger.info(method.getName());
            }
        }

        try {
            Method jump = Cat.class.getMethod("jump");
            jump.invoke(cat);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }

        try {
            Method jump = Cat.class.getMethod("fly");
            jump.invoke(cat);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }

        try {
            Method jump = Bird.class.getMethod("fly");
            jump.invoke(cat);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }
    }
}
