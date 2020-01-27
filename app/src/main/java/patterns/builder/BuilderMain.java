package patterns.builder;

public class BuilderMain {
    public static void main(String... args) {
        System.out.println("BUILDER PATTERN");
        Person person = new Person.Builder()
                .setFirstName("Juan")
                .setMiddleName("Carlos")
                .setLastName("Contreras Ramírez")
                .setAge(28)
                .setMothersName("Ma. Celia")
                .setFathersName("Jorge")
                .setHeight(100)
                .setWeight(100).build();
        System.out.println(person.toString());

        System.out.println(person.getFirstName());
    }
}
