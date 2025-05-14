public class TestBeans {
    public static void main(String[] args) {
        // Test SimpleBean
        SimpleBean simple = new SimpleBean();
        simple.setName("Test Name");
        System.out.println("SimpleBean Name: " + simple.getName());
        // Test BooleanBean
        BooleanBean bool = new BooleanBean();
        bool.setActive(true);
        System.out.println("BooleanBean Active: " + bool.isActive());
        // Test IndexedBean
        IndexedBean indexed = new IndexedBean();
        indexed.setValues(new int[]{10, 20, 30});
        System.out.println("IndexedBean Value at index 1: " + indexed.getValues(1));
    }
}