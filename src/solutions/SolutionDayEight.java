package solutions;

import classes.Node;
import tools.FileReader;

import java.util.ArrayList;
import java.util.List;

public class SolutionDayEight {

    List<Integer> data;
    Node masterNode;

    public SolutionDayEight(){
        getData();
    }

    private void createIntArray(String[] temp){
        data = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            data.add(Integer.parseInt(temp[i].trim()));
        }
        createNodes();
    }

    private void getData(){
        String[] temp = null;
        try {
            FileReader fileReader = new FileReader();
            temp = fileReader.readFile("input_day_8.txt").split(" ");
            createIntArray(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNodes(){
        masterNode = new Node(data.get(0), data.get(1));
        data.remove(1);
        data.remove(0);
        data = masterNode.addNodes(data);
    }

    public int partOne(){
        return masterNode.getValueOfMetadata();
    }

    public int partTwo(){
        return masterNode.getValueOfNode();
    }

}
