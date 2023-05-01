package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WorkerTests {

    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker(
                65,
                "Joash",
                "Makentosh",
                "manager",
                "XL",
                15
        );
    }

    @Test
    void testGetters() {
        assertEquals(65, worker.getIdnp());
        assertEquals("Joash", worker.getNameEmploy());
        assertEquals("Makentosh", worker.getSurnameEmploy());
        assertEquals("manager",worker.getPositionEmploy());
        assertEquals("XL", worker.getSalaryCategory());
        assertEquals(15, worker.getExperienceEmploy());
    }

    @Test
    void testEqualsAndHashCode() {
        Worker other = new Worker(
                65,
                "Joash",
                "Makentosh",
                "manager",
                "XL",
                15
        );

        assertEquals(worker, other);
        assertEquals(worker.hashCode(), other.hashCode());

        other = new Worker(
                89,
                "Lana",
                "Parrilla",
                "actress",
                "L",
                18
        );

        assertNotEquals(worker, other);
        assertNotEquals(worker.hashCode(), other.hashCode());
    }

    @Test
    void testToString() {
        String expected = "65\tJoash\tMakentosh\tmanager\tXL\t15";
        assertEquals(expected, worker.toString());
    }

    @Test
    void testEmptyWorker() {
        Worker empty = Worker.emptyWorker();

        assertEquals(0, empty.getIdnp());
        assertEquals("Tonya", empty.getNameEmploy());
        assertEquals("Melnyk", empty.getSurnameEmploy());
        assertEquals("Designer",empty.getPositionEmploy());
        assertEquals("S", empty.getSalaryCategory());
        assertEquals(0, empty.getExperienceEmploy());

    }

    @Test
    void testCopyConstructor() {
        Worker copy = new Worker(worker);

        assertEquals(worker, copy);
        assertEquals(worker.hashCode(), copy.hashCode());
    }

}



