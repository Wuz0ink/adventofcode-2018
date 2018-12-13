package solutions;

import classes.Step;
import classes.Worker;
import tools.FileReader;

import java.util.ArrayList;
import java.util.List;


public class Solution_Day_7 {

    private List<Step> steps;

    public Solution_Day_7(){
        steps = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader();
            String[] temp = fileReader.readFile("input_day_7.txt").split("\n");

//            String[] temp = ("Step C must be finished before step A can begin.\n" +
//                    "Step C must be finished before step F can begin.\n" +
//                    "Step A must be finished before step B can begin.\n" +
//                    "Step A must be finished before step D can begin.\n" +
//                    "Step B must be finished before step E can begin.\n" +
//                    "Step D must be finished before step E can begin.\n" +
//                    "Step F must be finished before step E can begin.").split("\n");

            for(String s : temp){
                Character one = s.charAt(5);
                Character two = s.charAt(36);

                boolean oneExists = false;
                int indexOne = 0;
                boolean twoExists = false;
                int indexTwo = 0;

                for(Step step : steps){
                    if(step.getStep().equals(one)){
                        oneExists  = true;
                        indexOne = steps.indexOf(step);
                    }

                    if(step.getStep().equals(two)){
                        twoExists = true;
                        indexTwo = steps.indexOf(step);
                    }
                }

                if(oneExists && twoExists){
                    steps.get(indexOne).addStep(steps.get(indexTwo));
                }else if(oneExists && !twoExists){
                    Step step = new Step(two);
                    steps.get(indexOne).addStep(step);
                    steps.add(step);
                }else if(!oneExists && twoExists){
                    Step step = new Step(one, steps.get(indexTwo));
                    steps.add(step);
                }else{
                    Step stepTwo = new Step(two);
                    steps.add(stepTwo);
                    Step stepOne = new Step(one, stepTwo);
                    steps.add(stepOne);
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public String part1(){

        return sort();
    }

    public int part2(){

        List<Worker> workers = new ArrayList<>();
        for(int i = 1; i < 6; i++)
            workers.add(new Worker(i));

        List<Step> stepsList = steps;
        String done = "";
        int secondsToReturn = 0;

        ArrayList<Step> temporaryList;
        System.out.print("Sek\t");

        for(Worker w : workers){
            System.out.print(w.getId() + "\t");
        }

        temporaryList = getTemporaryList(stepsList);

        loop:
        for(int second = 0; second < 5000; second++){
            for(Worker w : workers){
                w.setSecondCount();
            }

            for (Worker w : workers) {
                if(w.isDone() && w.isOccupied()){
                    Step t = w.getStep();
                    w.removeStep();

                    loopOne:
                    for(int i = 0; i < temporaryList.size(); i++){
                        if(t.getStep().equals(temporaryList.get(i).getStep())){
                            temporaryList.remove(i);
                            break loopOne;
                        }
                    }

                    loopTwo:
                    for(int i = 0; i < stepsList.size(); i++){
                        if(t.getStep().equals(stepsList.get(i).getStep())){
                            stepsList.remove(i);
                            break loopTwo;
                        }
                    }

                    done += t.getStep();
                }
            }

            temporaryList = getTemporaryList(stepsList);
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

            graphIt(second, workers, done);

            if(stepsList.isEmpty()){
                secondsToReturn = second;
                break loop;
            }
        }
        
        System.out.println();
        return secondsToReturn;
    }

    public void graphIt(int second, List<Worker> workers, String done){
        System.out.println();
        System.out.print(second + "\t");
        for(Worker w : workers){
            if(w.isOccupied()) {
                System.out.print(w.getStep().getStep() + "\t");
            }else{
                System.out.print(".\t");
            }
        }
        System.out.print("\t" + done);
    }

    public ArrayList<Step> getTemporaryList(List<Step> stepsList){
        ArrayList <Step> temporaryList = new ArrayList<>();

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
        ArrayList<Step> temporaryList;
        int count = steps.size();

        for(int i = 0; i < count; i++) {

            temporaryList = getTemporaryList(steps);

            Step tempStep = temporaryList.get(0);
            if (temporaryList.size() > 1) {
                for (Step first : temporaryList) {
                    for (Step second : temporaryList) {
                        if (order(first, second)) {
                            if(order(first, tempStep)){
                                tempStep = first;
                            }
                        }
                    }
                }

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

    public Boolean order(Step a, Step b){
        return Character.toLowerCase(a.getStep()) < Character.toLowerCase(b.getStep());
    }
}
