package classes;

import java.util.ArrayList;
import java.util.List;

public class Step {


    private Character step;
    private List<Step> whenDone;
    private Boolean workingOn;

    public Step(Character step){
        this.step  = step;
        whenDone = new ArrayList<>();
        workingOn = false;
    }

    public Step(Character step, Step anotherStep){
        this.step  = step;
        whenDone = new ArrayList<>();
        whenDone.add(anotherStep);
        workingOn = false;
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

    public Boolean isWorking(){
        return workingOn;
    }

    public void setWorking(Boolean b){
        workingOn = b;
    }


    public int getSeconds(){
        int seconds = 60;

        switch (getStep()){
            case 'A':
                seconds += 1;
                break;
            case 'B':
                seconds += 2;
                break;
            case 'C':
                seconds += 3;
                break;
            case 'D':
                seconds += 4;
                break;
            case 'E':
                seconds += 5;
                break;
            case 'F':
                seconds += 6;
                break;
            case 'G':
                seconds += 7;
                break;
            case 'H':
                seconds += 8;
                break;
            case 'I':
                seconds += 9;
                break;
            case 'J':
                seconds += 10;
                break;
            case 'K':
                seconds += 11;
                break;
            case 'L':
                seconds += 12;
                break;
            case 'M':
                seconds += 13;
                break;
            case 'N':
                seconds += 14;
                break;
            case 'O':
                seconds += 15;
                break;
            case 'P':
                seconds += 16;
                break;
            case 'Q':
                seconds += 17;
                break;
            case 'R':
                seconds += 18;
                break;
            case 'S':
                seconds += 19;
                break;
            case 'T':
                seconds += 20;
                break;
            case 'U':
                seconds += 21;
                break;
            case 'V':
                seconds += 22;
                break;
            case 'W':
                seconds += 23;
                break;
            case 'X':
                seconds += 24;
                break;
            case 'Y':
                seconds += 25;
                break;
            case 'Z':
                seconds += 26;
                break;
        }

        return seconds;
    }
}
