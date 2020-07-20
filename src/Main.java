import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class pc = Person.class;
        //get name of class
        String nameOfClass = pc.getName();
        System.out.println("Name of class " + nameOfClass);
        String simpleName = pc.getSimpleName();
        System.out.println("Simple Name " + simpleName);
        //get Modifier
        int modifier = pc.getModifiers();
        System.out.println("Modifier class = " + Modifier.toString(modifier));
        System.out.println("is static " + Modifier.isStatic(modifier));
        System.out.println("is public " + Modifier.isPublic(modifier));
        System.out.println("is abstract " + Modifier.isAbstract(modifier));
        //get name package
        Package classPackage = pc.getPackage();
        System.out.println("Name package = " + classPackage);
        //get superClass
        Class superClass = pc.getSuperclass();
        System.out.println("Super class = " + superClass);
        //get interface
        Class[] interfaces = pc.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        //get Constructor
        Constructor<Person>[] personConstractor = pc.getConstructors();
        for (int i = 0; i<personConstractor.length; i++) {
            Constructor<Person> constructor = personConstractor[i];
            System.out.println("Constructor = " + constructor);
        }
        System.out.println("Constructor size = " + personConstractor.length);
        //type of constructor
        Constructor<Person> constructor = personConstractor[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i=0;  i<parameterTypes.length; i++) {
           Class<?> class1 = parameterTypes[i];
            System.out.println("Type variable = " + class1);
        }
        //get Constructor by parameters
        Constructor<Person> singleConstructor = pc.getConstructor(String.class, int.class);
        System.out.println("Single constructor " + singleConstructor );
        Person newInstance = singleConstructor.newInstance("Maks", 23);
        System.out.println(newInstance);
        //get fields
        Field[] fields = pc.getFields();
        for(int i = 0; i<fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }
        System.out.println();
        fields = pc.getDeclaredFields();
        for(int i = 0; i<fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }
        //field set
        Field ageField = pc.getField("age");
        ageField.set(newInstance, 34);
        System.out.println("New age person " + newInstance);
        //field set private
        Field privateFirsNamePerson = fields[1];
        privateFirsNamePerson.setAccessible(true);
        System.out.println("first name private = " + privateFirsNamePerson.get(newInstance));
        System.out.println();
        //Methods
        Method[] methods = pc.getMethods();
        for(int i = 0; i<methods.length; i++) {
            Method method = methods[i];
            System.out.println(method);
        }
        //set private field
        methods[8].invoke(newInstance, "Katya");
        System.out.println();
        System.out.println(newInstance);



    }
}
