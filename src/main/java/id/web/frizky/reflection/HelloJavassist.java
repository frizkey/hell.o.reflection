package id.web.frizky.reflection;

import javassist.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class HelloJavassist {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        HelloJavassist helloJavassist = new HelloJavassist();
        helloJavassist.runnerJavassist();
    }

    public void runnerJavassist() {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass birdClass = pool.get(Bird.class.getName());
            CtMethod flyMethod = birdClass.getDeclaredMethod("fly");

            CtClass ctClass = pool.get(Cat.class.getName());
            CtMethod ctMethod = new CtMethod(flyMethod, ctClass, null);
            ctClass.addMethod(ctMethod);
            ctClass.setName("id.web.frizky.NewCatBreed");

            Class<?> aClass = ctClass.toClass();
            Method fly = aClass.getDeclaredMethod("fly");
            Method jump = aClass.getDeclaredMethod("jump");
            Object obj = aClass.newInstance();

            logger.info(obj.getClass().getPackage());
            fly.invoke(obj);
            jump.invoke(obj);
        } catch (NotFoundException | CannotCompileException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
