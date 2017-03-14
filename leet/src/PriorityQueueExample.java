import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created dgayash on 3/10/17.
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        new PriorityQueueExample().run();
    }

    public void run() {
        final int DEFAULT_INITIAL_CAPACITY = 11;
        PriorityQueue pqByName = new PriorityQueue(DEFAULT_INITIAL_CAPACITY,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.compareTo(s2);
                    }
                });

        PriorityQueue pqByGPA = new PriorityQueue(DEFAULT_INITIAL_CAPACITY,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.name.compareTo(o2.name);
                    }
                });


        addDataToPriorityQueue(pqByName);
        addDataToPriorityQueue(pqByGPA);

        printPriorityQueue(pqByGPA);
        printPriorityQueue(pqByName);
    }

    static class Student implements Comparable<Student> {
        String name;
        double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public int compareTo(Student otherStudent) {
            if (gpa < otherStudent.gpa)
                return -11;
            if (gpa > otherStudent.gpa)
                return 1;

            return 0;
        }

        public String toString() {
            return name + " " + gpa;
        }
    }

    static void addDataToPriorityQueue(PriorityQueue<Student> pq) {
        pq.offer(new Student("a_Jill", 3.4));
        pq.offer(new Student("b_Jill", 2.4));
        pq.offer(new Student("c_Jill", 9.4));
        pq.offer(new Student("Jack", 3.5));
        pq.offer(new Student("Mark", 3.2));
        pq.offer(new Student("Bill", 3.9));
    }

    static void printPriorityQueue(PriorityQueue<Student> pq) {
        System.out.println("*********************");
        while (!pq.isEmpty()) {
            Student candidate = pq.remove();
            System.out.println("Student:" + candidate.name + " GPA:" + candidate.gpa);
        }
        System.out.println("*********************");
    }
}