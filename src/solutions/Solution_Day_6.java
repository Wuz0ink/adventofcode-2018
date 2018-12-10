package solutions;

import classes.Coordinate;
import tools.FileReader;

import java.util.*;

public class Solution_Day_6 {

    private List<Coordinate> coordinates;
    private Coordinate minCoordinate, maxCoordinate;
    private HashMap<String, Coordinate> grid;

    public Solution_Day_6(){
        minCoordinate = new Coordinate(Integer.MAX_VALUE, Integer.MAX_VALUE);
        maxCoordinate = new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE);
        coordinates = new ArrayList<>();
        grid = new HashMap<>();

        try {
            FileReader fileReader = new FileReader();
            String[] temp = fileReader.readFile("input_day_6.txt").split("\n");

//            String t = "1, 1\n" +
//                    "1, 6\n" +
//                    "8, 3\n" +
//                    "3, 4\n" +
//                    "5, 5\n" +
//                    "8, 9";
//            String[] temp = t.split("\n");

            for(String s : temp){
                coordinates.add(new Coordinate(Integer.parseInt(s.split(",")[0].trim()), Integer.parseInt(s.split(",")[1].trim()), true));
            }

            for(Coordinate s : coordinates){
                setGridMaxMin(s);
            }

            minCoordinate.x--;
            minCoordinate.y--;
            maxCoordinate.x++;
            maxCoordinate.y++;

            fillGrid();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int part1(){

        graphItOut();

        findInfiniteInputCoordinates();

        int answer = Integer.MIN_VALUE;

        for(Coordinate tempCoordinator : coordinates){
            if(!tempCoordinator.isInfinite()){
                int count = highCount(tempCoordinator);
                if(count > answer){
                    answer = count;
                }
            }
        }

        return answer;
    }

    public int part2(){

        int count = 0;

            Iterator iterator = grid.entrySet().iterator();
            while(iterator.hasNext()){
                int distance = 0;
                Map.Entry coord = (Map.Entry)iterator.next();
                Coordinate tempCoordinateA = (Coordinate) coord.getValue();


                if(!tempCoordinateA.isBoarder()){
                    for(Coordinate tempCoordinateB : coordinates){

                        int temp = tempCoordinateA.distance(tempCoordinateB);
                        distance = distance + temp;

                    }
                    if(distance < 10000){
                        count++;
                    }
                }
        }
        return count;
    }


    public int highCount(Coordinate coord){
        int count = 1;
        Iterator iterator = grid.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry mapIterator = (Map.Entry) iterator.next();
            Coordinate tempCoordinate = (Coordinate) mapIterator.getValue();
            try{
                if(tempCoordinate.getClaimedBy().equals(coord) && !tempCoordinate.isClaimedMoreThanOnce() && !tempCoordinate.isBoarder()){
                    count++;
                }
            }catch(NullPointerException e){
                // dosen´t matter!
            }
        }

        return count;
    }


    public void findInfiniteInputCoordinates(){
        Iterator iterator = grid.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mapIterator = (Map.Entry)iterator.next();
            Coordinate tempCoordinate = (Coordinate) mapIterator.getValue();

            if(tempCoordinate.isBoarder() && !tempCoordinate.isClaimedMoreThanOnce()){
                int distance = Integer.MAX_VALUE;
                Coordinate closestCoordinate = null;

                for(Coordinate coordinateIterator : coordinates){
                    int temporaryDistance = tempCoordinate.distance(coordinateIterator);

                    if(temporaryDistance < distance){
                        distance = temporaryDistance;
                        closestCoordinate = coordinateIterator;
                    }
                }
                closestCoordinate.setInfinite();
            }
        }
    }

    public void graphItOut(){
        for(int y = minCoordinate.y; y <= maxCoordinate.y; y++){
            System.out.println();
            for(int x = minCoordinate.x; x <= maxCoordinate.x; x++){
                String key = x + "," + y;
                System.out.print(grid.get(key) + "\t\t");
            }
        }
        System.out.println("\n");
    }

    public Coordinate getClaimableCoordinate(int x, int y){
        Coordinate coordinateToReturn = new Coordinate(x, y);
        int distance = Integer.MAX_VALUE;

        for(Coordinate iterCoordinate : coordinates){
            int temporaryDistance = coordinateToReturn.distance(iterCoordinate);
            if(temporaryDistance < distance){
                distance = temporaryDistance;
                coordinateToReturn.setClaimedBy(iterCoordinate);
                coordinateToReturn.setClaimedMoreThanOnce(false);
            }else if(temporaryDistance == distance){
                coordinateToReturn.setClaimedMoreThanOnce(true);
            }
        }

        if(x == minCoordinate.x || x == maxCoordinate.x){
            coordinateToReturn.setBoarder();
        }

        if(y == minCoordinate.y || y == maxCoordinate.y){
            coordinateToReturn.setBoarder();
        }

        return coordinateToReturn;
    }



    public void setGridMaxMin(Coordinate coordinate){
       if(coordinate.x < minCoordinate.x)
           minCoordinate.x = coordinate.x;

       if(coordinate.x > maxCoordinate.x)
           maxCoordinate.x = coordinate.x;

       if(coordinate.y < minCoordinate.y)
           minCoordinate.y = coordinate.y;

       if(coordinate.y > maxCoordinate.y)
           maxCoordinate.y = coordinate.y;
    }

    public void fillGrid(){
        for(int y = minCoordinate.y; y <= maxCoordinate.y; y++){
            for(int x = minCoordinate.x; x <= maxCoordinate.x; x++){

                boolean doesExist  = false;
                int index = 0;
                for(int i = 0; i < coordinates.size(); i++){

                    if(x == coordinates.get(i).x && y == coordinates.get(i).y){
                        doesExist = true;
                        index = i;
                    }
                }


                if(doesExist){
                    grid.put(coordinates.get(index).x + "," + coordinates.get(index).y, coordinates.get(index));
                }else{
                    grid.put(x + "," + y , getClaimableCoordinate(x, y));
                }

            }
        }
    }
}
