package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckWorkerTests {

    private static final String TEST_FILE_NAME = "test_worker.txt";


    private CheckWorker checkWorker;

    @BeforeEach
    void setUp() {
        checkWorker = new CheckWorker();
    }

    @Test
    void testCheckingWorkers() throws IOException {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(1, "James", "Bond", "actor","M",14));
        workers.add(new Worker(2, "Lana", "Malito", "manager","L",12));
        workers.add(new Worker(3, "Pol", "Maky", "seller","XL",10));
        Path testFilePath = Path.of(TEST_FILE_NAME);
        checkWorker.check(workers, testFilePath);

        List<Worker> checkedWorkers = CheckWorker.toCheck(testFilePath);

        assertEquals(workers, checkedWorkers);

        Files.deleteIfExists(testFilePath);
    }

    @Test
    void testToCheckFileNotFoundException() {
        Path nonExistentFile = Path.of(TEST_FILE_NAME);
        assertThrows(IOException.class, () -> CheckWorker.toCheck(nonExistentFile));
    }
}
