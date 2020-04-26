package MultipleInheritance;

public interface Interface1 {
    default void prittyPrint1() {
        System.out.println(this.getClass().getCanonicalName() + "   Default from interface1");
    }
}