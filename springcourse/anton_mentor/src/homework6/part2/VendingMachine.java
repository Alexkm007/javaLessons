package homework6.part2;

import java.util.Queue;

public class VendingMachine {
    private Queue<Person> persons;

    public VendingMachine() {
    }

    public VendingMachine(Queue<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(Queue<Person> persons) {
        this.persons = persons;
    }

    public void selCup(int countCup) {

        for (int i = 1; i <= 2; i = i + 1) {
            Person person = persons.poll();
            Person clone = null;
            try {
                clone = (Person) (person != null ? person.clone() : null);
                persons.offer(person);
                persons.offer(clone);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Person person : persons) {
            sb.append(person.getName()).append(",");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1) + "]";
    }
}
