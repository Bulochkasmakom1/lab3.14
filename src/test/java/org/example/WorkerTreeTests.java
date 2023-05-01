package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WorkerTreeTests {

    @Test
    public void testAddWorker() {
        Worker worker1 = new Worker(75, "Anna", "Miller","director","XL",20);

        Worker worker2 = new Worker(76, "Jacob", "Davis","writer","S",5);

        WorkerTree workerTree = new WorkerTree(worker1);
        workerTree.addWorker(worker2);

        assertEquals(worker1, workerTree.findWorkerByIdnp(75));
        assertEquals(worker2, workerTree.findWorkerByIdnp(76));
    }

    @Test
    public void testFindWorkerByIdnp() {
        Worker worker1 = new Worker(75, "Anna", "Miller","director","XL",20);

        WorkerTree workerTree = new WorkerTree(worker1);

        assertEquals(worker1, workerTree.findWorkerByIdnp(75));
    }

    @Test
    public void testRemoveWorker() {
        Worker worker1 = new Worker(75, "Anna", "Miller","director","XL",20);

        Worker worker2 = new Worker(76, "Jacob", "Davis","writer","S",5);

        WorkerTree workerTree = new WorkerTree(worker1, worker2);
        workerTree.removeWorker(76);

        assertThrows(IllegalStateException.class, () -> workerTree.findWorkerByIdnp(76));
    }
}
