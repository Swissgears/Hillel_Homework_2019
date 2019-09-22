import java.util.ArrayList;
import java.util.List;

public class GroupPersons {
  private String name;
        private List<Person> persons = new ArrayList<>();

        public GroupPersons(String name) {
            this.name = name;
        }

        public void addPersons(Person person) {
            persons.add(person);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "GroupPersons{" +
                    "name: " + getName() +
                    ", persons=" + persons +
                    '}';
        }
    }

