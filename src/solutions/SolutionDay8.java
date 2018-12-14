package solutions;

import classes.Node;
import tools.FileReader;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay8 {

    List<Integer> data;
    int sum;


    public SolutionDay8(){
        getData();
    }

    private void createIntArray(String[] temp){
        data = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            data.add(Integer.parseInt(temp[i].trim()));
        }
    }

    private void getData(){
        String[] temp = null;
        try {
            FileReader fileReader = new FileReader();
            temp = fileReader.readFile("input_day_8.txt").split(" ");

        } catch (Exception e) {
            e.printStackTrace();
        }
        createIntArray(temp);
    }

    public int part1(){
        sum = 0;
        Node masterNode = new Node(data.get(0), data.get(1));
        data.remove(1);
        data.remove(0);
        data = masterNode.addNodes(data);

        return masterNode.getValueOfMetadata();
    }

}
