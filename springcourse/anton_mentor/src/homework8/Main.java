package homework8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;

public class Main {
    public static void main(String[] args) {
        MetaData meta = TextContainer.class.getAnnotation(MetaData.class);
        TextContainer tc = new TextContainer();
        tc.setText("Hello Word");
        String path = meta.fileName();
        String methodName = meta.methodName();

        try {
            Method method = Saver.class.getMethod(methodName,String.class,TextContainer.class);
            method.invoke(null,path,tc);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
