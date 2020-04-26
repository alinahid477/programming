package MultipleInheritance;

public class MultiInheritance implements Interface1, Interface2 {

    @Override
    public void prittyPrint() {
        System.out.println(this.getClass().getCanonicalName());
    }

    
}