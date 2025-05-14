import java.beans.*;

public class BeanIntrospection {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Class.forName("StudentBean");
        BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
        
        System.out.println("Properties of StudentBean:");
        PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor prop : props) {
            if (!prop.getName().equals("class")) { 
                System.out.println("Property: " + prop.getName() + 
                                 ", Type: " + prop.getPropertyType());
            }
        }
    }
}