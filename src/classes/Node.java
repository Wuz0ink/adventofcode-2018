package classes;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int quantityChildNodes;
    private int quantityMetadata;
    private List<Integer> metadata;
    private List<Node> childNodes;

    public Node(int childNodes, int metadata){
        quantityChildNodes = childNodes;
        quantityMetadata = metadata;
        this.metadata = new ArrayList<>();
        this.childNodes = new ArrayList<>();
    }

    public int getValueOfMetadata(){
        int value = 0;
        for(int i : metadata){
            value += i;
        }
        if(!childNodes.isEmpty()){
            for(Node node : childNodes){
                value += node.getValueOfMetadata();
            }
        }
        return value;
    }

    public int getValueOfNode(){
        int value = 0;
        if(childNodes.isEmpty()){
            value = getValueOfMetadata();
        }else{
            for(int i : metadata){
                if(i != 0){
                    i--;
                    if(i < childNodes.size()){
                        value += childNodes.get(i).getValueOfNode();
                    }
                }
            }
        }
        return value;
    }

    public List<Integer> addChildNode(Node node, List<Integer> data){
        data.remove(1);
        data.remove(0);
        data = node.addNodes(data);

        childNodes.add(node);
        return data;
    }

    public List<Integer> addNodes(List<Integer> data){
        if(quantityChildNodes != 0 ){
            for(int i = 0; i < quantityChildNodes; i++){
                data = addChildNode(new Node(data.get(0), data.get(1)), data);
            }
        }

        for(int i = 0; i < quantityMetadata; i++){
            metadata.add(data.get(0));
            data.remove(0);
        }

        return data;
    }
}
