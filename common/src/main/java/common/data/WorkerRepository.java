package worker;

import java.util.TreeMap;

/**

 The WorkerRepository class represents a repository for storing in a TreeMap and managing workers.
 */
public class WorkerRepository {
    private int id = Worker.getCounter();
    public TreeMap<Integer, Worker> map = new TreeMap<>();

}
