package classes;

import java.util.ArrayList;
import java.util.List;

public class Step {


    private Character step;
    private List<Step> whenDone;

    public Step(Character step){
        this.step  = step;
        whenDone = new ArrayList<>();
    }

    public Step(Character step, Step anotherStep){
        this.step  = step;
        whenDone = new ArrayList<>();
        whenDone.add(anotherStep);
    }

    public Character getStep() {
        return step;
    }

    public void addStep(Step s){
        whenDone.add(s);
    }

    public List<Step> getWhenDone() {
        return whenDone;
    }
}
