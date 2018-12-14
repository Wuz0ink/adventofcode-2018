package solutions;

import classes.Step;
import classes.Worker;
import tools.FileReader;
import java.util.ArrayList;
import java.util.List;


public class SolutionDaySeven {

    private List<Step> steps;

    public SolutionDaySeven(){
        fillList(readFile());
    }

    public String[] readFile() {
        steps = new ArrayList<>();
        String[] temp = null;

        try {
            FileReader fileReader = new FileReader();
            temp = fileReader.readFile("input_day_7.txt").split("\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void fillList(String[] temp){
        for (String s : temp) {
            Character one = s.charAt(5);
            Character two = s.charAt(36);

            boolean oneExists = false;
            int indexOne = 0;
            boolean twoExists = false;
            int indexTwo = 0;

            for (Step step : steps) {
                if (step.getStep().equals(one)) {
                    oneExists = true;
                    indexOne = steps.indexOf(step);
                }

                if (step.getStep().equals(two)) {
                    twoExists = true;
                    indexTwo = steps.indexOf(step);
                }
            }

            if (oneExists && twoExists) {
                steps.get(indexOne).addStep(steps.get(indexTwo));
            } else if (oneExists && !twoExists) {
                Step step = new Step(two);
                steps.get(indexOne).addStep(step);
                steps.add(step);
            } else if (!oneExists && twoExists) {
                Step step = new Step(one, steps.get(indexTwo));
                steps.add(step);
            } else {
                Step stepTwo = new Step(two);
                steps.add(stepTwo);
                Step stepOne = new Step(one, stepTwo);
                steps.add(stepOne);
            }
        }
    }

    public String partOne(){
        return sort();
    }

    public int partTwo(){
        fillList(readFile());
        return runJob();
    }

    public List<Worker> fillWorkerList(){
        List<Worker> workers = new ArrayList<>();
        for(int i = 1; i < 6; i++)
            workers.add(new Worker(i));
        return workers;
    }

    public int runJob(){
        List<Worker> workers = fillWorkerList();

        List<Step> temporaryList = getTemporaryList(steps);

        for(int second = 0; second < Integer.MAX_VALUE; second++){
            addSecondToWorkers(workers);

            for (Worker w : workers) {
                if(w.isDone() && w.isOccupied()){
                    Step tempStep = w.getStep();
                    w.removeStep();
                    removeFromList(tempStep, temporaryList);
                    removeFromList(tempStep, steps);
                }
            }
            temporaryList = getTemporaryList(steps);
            setWorking(temporaryList, workers);

            if(steps.isEmpty()){
                return second;
            }
        }
        return 0;
    }

    public void setWorking(List<Step> temporaryList, List<Worker> workers){
        for(int i = 0; i < temporaryList.size(); i++){
            innerLoop:
            if(!temporaryList.get(i).isWorking()) {
                for (Worker w : workers) {
                    if (!w.isOccupied()) {
                        temporaryList.get(i).setWorking(true);
                        w.startWorking(temporaryList.get(i));
                        break innerLoop;
                    }
                }
            }
        }
    }

    public void addSecondToWorkers(List<Worker> workers){
        for(Worker w : workers)
            w.setSecondCount();
    }

    public void removeFromList(Step t, List<Step> list){

        for(int i = 0; i < list.size(); i++){
            if(t.getStep().equals(list.get(i).getStep())){
                list.remove(i);
            }
        }
    }

    public List<Step> getTemporaryList(List<Step> stepsList){
        List <Step> temporaryList = new ArrayList<>();

        for (Step temp : stepsList) {
            Boolean contestant = true;
            for (Step tempTwo : stepsList) {
                for (Step s : tempTwo.getWhenDone()) {
                    if (temp.equals(s)) {
                        contestant = false;
                        break;
                    }
                }
            }
            if (contestant) {
                temporaryList.add(temp);
            }
        }
        return temporaryList;
    }

    public String sort(){
        String toReturn = "";
        List<Step> temporaryList;
        int count = steps.size();

        for(int i = 0; i < count; i++) {
            temporaryList = getTemporaryList(steps);
            Step tempStep = temporaryList.get(0);

            if (temporaryList.size() > 1) {
                tempStep = findFirstStep(temporaryList, tempStep);
                toReturn = toReturn + tempStep.getStep().toString();
            } else {
                tempStep = temporaryList.get(0);
                toReturn = toReturn + tempStep.getStep().toString();
            }
            temporaryList.remove(tempStep);
            steps.remove(tempStep);
        }
        return toReturn;
    }

    public Step findFirstStep(List<Step> temporaryList, Step tempStep){
        for (Step first : temporaryList) {
            for (Step second : temporaryList) {
                if (order(first, second) && order(first, tempStep)) {
                    tempStep = first;
                }
            }
        }
        return tempStep;
    }

    public Boolean order(Step a, Step b){
        return Character.toLowerCase(a.getStep()) < Character.toLowerCase(b.getStep());
    }
}
