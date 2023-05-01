package org.example;

public class WorkerTree {
    private Worker worker;

    private WorkerTree left;

    private WorkerTree right;

    public WorkerTree(Worker... workers) {
        for (Worker worker : workers) {
            this.addWorker(worker);
        }
    }

    public void addWorker(Worker worker) {
        if (this.worker == null) {
            this.worker = worker;
            return;
        }

        if (worker.getIdnp() > this.worker.getIdnp()) {
            if (this.right == null) {
                this.right = new WorkerTree(worker);
            } else {
                this.right.addWorker(worker);
            }
        } else if (worker.getIdnp() < this.worker.getIdnp()) {
            if (this.left == null) {
                this.left = new WorkerTree(worker);
            } else {
                this.left.addWorker(worker);
            }
        }
    }

    public Worker findWorkerByIdnp(long idnp) {
        if (this.worker == null) {
            throw new IllegalStateException("Нет работника с таким idnp");
        }
        if (idnp > this.worker.getIdnp()) {
            return this.right.findWorkerByIdnp(idnp);
        } else if (idnp < this.worker.getIdnp()) {
            return this.left.findWorkerByIdnp(idnp);
        } else {
            return this.worker;
        }
    }

    public void removeWorker(long idnp) {
        if (this.worker == null) {
            throw new IllegalStateException("Нет работника с таким idnp");
        }
        if (idnp > this.worker.getIdnp()) {
            if (this.right != null) {
                this.right.removeWorker(idnp);
            }
        } else if (idnp < this.worker.getIdnp()) {
            if (this.left != null) {
                this.left.removeWorker(idnp);
            }
        } else {
            if (this.left == null && this.right == null) {
                this.worker = null;
            } else if (this.left == null) {
                this.worker = this.right.worker;
                this.left = this.right.left;
                this.right = this.right.right;
            } else if (this.right == null) {
                this.worker = this.left.worker;
                this.right = this.left.right;
                this.left = this.left.left;
            } else {
                WorkerTree leftMost = this.right.getLeftmost();
                this.worker = leftMost.worker;
                this.right.removeWorker(leftMost.worker.getIdnp());
            }
        }
    }

    public WorkerTree getLeftmost() {
        if (this.left == null) {
            return this;
        }
        return this.left.getLeftmost();
    }

    public void preorderTraversal() {
        if (this.worker == null) {
            return;
        }
        System.out.println(this.worker);
        if (this.left != null) {
            this.left.preorderTraversal();
        }
        if (this.right != null) {
            this.right.preorderTraversal();
        }
    }

    public void inorderTraversal() {
        if (this.worker == null) {
            return;
        }
        if (this.left != null) {
            this.left.inorderTraversal();
        }
        System.out.println(this.worker);
        if (this.right != null) {
            this.right.inorderTraversal();
        }
    }

    public void postorderTraversal() {
        if (this.worker == null) {
            return;
        }
        if (this.left != null) {
            this.left.postorderTraversal();
        }
        if (this.right != null) {
            this.right.postorderTraversal();
        }
        System.out.println(this.worker);
    }

    public Worker getWorker() {
        return worker;
    }

    public WorkerTree getLeft() {
        return left;
    }

    public WorkerTree getRight() {
        return right;
    }
}

