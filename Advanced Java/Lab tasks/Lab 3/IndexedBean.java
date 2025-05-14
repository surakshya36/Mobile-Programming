public class IndexedBean {
    private int[] values;
    
    public int[] getValues() { return values; }
    public void setValues(int[] values) { this.values = values; }
    
    public int getValues(int index) { return values[index]; }
    public void setValues(int index, int value) { values[index] = value; }
}