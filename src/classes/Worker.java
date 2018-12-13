package classes;

public class Worker {

    private int id;
    private boolean occupied;
    private boolean done;
    private int secondCount;
    private int secondsOnStep;
    private Step step;

    public Worker(int id){
        this.id = id;
    }

    public void startWorking(Step step){
        setOccupied(true);
        setSecondsOnStep(step.getSeconds());
        secondCount = 0;
        setDone(false);
        this.step = step;
    }

    public void removeStep(){
        step = null;
        setOccupied(false);
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setSecondCount() {
        secondCount++;
        checkIfDone();
    }

    public void setSecondsOnStep(int secondsOnStep) {
        this.secondsOnStep = secondsOnStep;
    }

    public void checkIfDone(){
        if(secondCount == secondsOnStep){
            setDone(true);
            secondCount = 0;
            secondsOnStep = 0;
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public Step getStep() {
        return step;
    }

    public int getId() {
        return id;
    }
}
