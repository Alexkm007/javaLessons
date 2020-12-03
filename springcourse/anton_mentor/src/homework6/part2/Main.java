package homework6.part2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Person> persons = new ArrayDeque<>();
        persons.offer(new Person("Sheldon"));
        persons.offer(new Person("Leonard"));
        persons.offer(new Person("Penny"));
        persons.offer(new Person("Kutrapalli"));
        persons.offer(new Person("Volovitc"));

        VendingMachine vm = new VendingMachine(persons);

        vm.selCup(2);

        System.out.print(vm.toString());
    }
}
