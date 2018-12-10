package solutions;

import classes.Step;
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

    public String sort(){
        String toReturn = "";
        ArrayList<Step> temporaryList;
        int count = steps.size();

        for(int i = 0; i < count; i++) {

            temporaryList = new ArrayList<>();

            for (Step temp : steps) {
                Boolean contestant = true;
                for (Step tempTwo : steps) {
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

//            for(Step s : temporaryList)
//                System.out.print(s.getStep() + " : ");

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


//            for (Step temp : tempStep.getWhenDone()) {
//                if (temporaryList.indexOf(temp) == -1) {
//                    temporaryList.add(temp);
//                }
//            }
            temporaryList.remove(tempStep);
            steps.remove(tempStep);

        }

        return toReturn;
    }

    public Boolean order(Step a, Step b){
        return Character.toLowerCase(a.getStep()) < Character.toLowerCase(b.getStep());
    }
}
