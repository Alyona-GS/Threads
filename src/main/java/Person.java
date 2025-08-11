public final class Person {

    private final String name;
    private final int age;

    // Конструктор для инициализации полей
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттер для получения имени
    public String getName() {
        return name;
    }

    // Геттер для получения возраста
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}