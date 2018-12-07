package solutions;

import tools.FileReader;

public class Solution_Day_5 {

    private String data;


    public Solution_Day_5(){
        FileReader fileReader = new FileReader();
        try {
            data = fileReader.readFile("input_day_5.txt");
            data = data.replaceAll("\n", "");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int part1(){
            for (int i = 0; i < data.length() - 1; i++) {
                char c1 = data.charAt(i);
                char c2 = data.charAt(i + 1);
                boolean b = Character.toLowerCase(c1) == Character.toLowerCase(c2);

                if (b) {
                    if (c1 != c2) {
                        data = data.substring(0, i) + data.substring(i+2);
                        i = -1;

                    }
                }
            }
        return data.length();
    }

    public int part2(){

        String temp = "Aa:Bb:Cc:Dd:Ee:Ff:Gg:Hh:Ii:Jj:Kk:Ll:Mm:Nn:Oo:Pp:Qq:Rr:Ss:Tt:Uu:Vv:Ww:Xx:Yy:Zz";
        String[] alphabet = temp.split(":");

        String originData = data;

        int shortestText = 50000;

        for(String s : alphabet){
            data = originData;
            data = data.replaceAll("[" + s + "]", "");

            int answerFromPartOne = part1();
            if(shortestText > answerFromPartOne){
                shortestText = answerFromPartOne;
            }
        }
        return shortestText;
    }

}
