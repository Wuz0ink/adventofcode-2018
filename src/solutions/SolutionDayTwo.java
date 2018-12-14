package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDayTwo {


    public String partOne(){
        List<String> idsToAnalyse = new ArrayList<>(Arrays.asList(boxId.split("\n")));
        int twoTimer = 0;
        int threeTimer = 0;

        for(String id : idsToAnalyse){
            boolean two  = false;
            boolean three = false;

            char[] charList = id.toCharArray();
            for(char iterateor : charList){
                int occurrences = 0;

                for(char innerIterator : charList){
                    if(innerIterator == iterateor){
                        occurrences++;
                    }
                }
                if(occurrences == 2){
                    two = true;
                }else if(occurrences == 3){
                    three = true;
                }
            }
            if(two){
                twoTimer++;
            }
            if(three){
                threeTimer++;
            }
        }
        return "Two: " + twoTimer + " * Three: " + threeTimer + " = " + twoTimer * threeTimer;
    }

    public String partTwo(){
        List<String> idsToAnalyse = new ArrayList<>(Arrays.asList(boxId.split("\n")));
        String answer = "";

        for(int iterator = 0; iterator < idsToAnalyse.size();iterator++){
            String temp = idsToAnalyse.get(0);
            idsToAnalyse.remove(0);
            char[] firstCharList = temp.toCharArray();

            for(String secondId : idsToAnalyse){
                int differ = 0;
                char[] secondCharList = secondId.toCharArray();

                for(int i = 0; i < firstCharList.length; i++){
                    if(firstCharList[i] != secondCharList[i]){
                        differ++;
                    }
                }
                 if(differ == 1){
                     for(int t = 0; t < 26; t++){
                         if(firstCharList[t] == secondCharList[t]){
                             answer += firstCharList[t];
                         }
                     }
                 }

            }
        }




        return answer;
    }

    static String boxId = "dghfbsyiznoumojleevappwqtr\n" +
            "dghfbsyiznoumkjljevacpmqer\n" +
            "dghfbbyizioumkjlxevacpwdtr\n" +
            "dghfbsesznoumkjlxevacpwqkr\n" +
            "dghfbsynznoumkjlxziacpwqtr\n" +
            "cghfbsyiznjumkjlxevacprqtr\n" +
            "dghfjsyizwoumkjlxevactwqtr\n" +
            "dghfdsyfinoumkjlxevacpwqtr\n" +
            "hghfbsyiznoumkjlxivacpwqtj\n" +
            "dgcfbsyiznoumkjlxevacbuqtr\n" +
            "dghfbsyiznoymnjlxevacpwvtr\n" +
            "dfhfbsyiznoumkulxevacptqtr\n" +
            "dghfasyiznovmkjlxevacpwqnr\n" +
            "dghfbsyihnouikjlxevackwqtr\n" +
            "dghfbayiznolmkjlyevacpwqtr\n" +
            "jghfbsyiznoumnjldevacpwqtr\n" +
            "dhhfbsyuznoumkjlxevakpwqtr\n" +
            "nehfrsyiznoumkjlxevacpwqtr\n" +
            "dghfbsyiznxdmkolxevacpwqtr\n" +
            "dgpfbsyizwlumkjlxevacpwqtr\n" +
            "yghfbsyiznoumkjlsevacpwqtm\n" +
            "dghfssyiznoumkjlxevvcpwqjr\n" +
            "dahfbsyiznoumkjlfevacpwqto\n" +
            "duhfcsyiznouvkjlxevacpwqtr\n" +
            "dghfbvyiznoumkjlrevacpwvtr\n" +
            "dghfgsyiznoumknlxgvacpwqtr\n" +
            "jghfbeyiznkumkjlxevacpwqtr\n" +
            "daofbsyiznoumkjlxevampwqtr\n" +
            "dghfbsyiznojmkjlxeracpcqtr\n" +
            "dghnbsyiznouokjlxevaclwqtr\n" +
            "dgifbsyiznoumkjlxevnspwqtr\n" +
            "dgkfpsziznoumkjlxevacpwqtr\n" +
            "dghfxsyijnoumkjlxevaccwqtr\n" +
            "dghfbsyiznolmkjlwevzcpwqtr\n" +
            "dkhfbsaiznoumkjlxevacpwqtg\n" +
            "dghfbsygknoumkjlaevacpwqtr\n" +
            "dghfbsyizizumkjlxevacpxqtr\n" +
            "ighfbbyijnoumxjlxevacpwqtr\n" +
            "dghfbsyizrouekjlxevacpwktr\n" +
            "dghobsyiznoujkjlxevacnwqtr\n" +
            "dghpbsyizyoumkjlxeaacpwqtr\n" +
            "dghffsyiznoymkjlxevacewqtr\n" +
            "dghkbssiznoumzjlxevacpwqtr\n" +
            "dghfbsyawnoumkjlxevacpwjtr\n" +
            "drhfbsyiznormkjlfevacpwqtr\n" +
            "dghfbsoiznouwkjlxevacpwqtn\n" +
            "dghfmsyiznoumkjlxlvecpwqtr\n" +
            "dxhfbsyiznoumkjlxeeacvwqtr\n" +
            "dghnbsyiznoumkjsxevacpwqur\n" +
            "dghfbsyiznrujkjlxevacpwqtc\n" +
            "dghfbstoznoumhjlxevacpwqtr\n" +
            "dghfboyiznzumkjlvevacpwqtr\n" +
            "dghfbsyiznjumkjlxevgcpwmtr\n" +
            "dghfbsnizaoumkjlxevacpwetr\n" +
            "dghfbsyirnoumkjoxevacplqtr\n" +
            "dghfbsyiznoumkjlxavvckwqtr\n" +
            "dghfbjdiznoumkjlxevacpwptr\n" +
            "dghfbsywznoumkjlxeiacpwqcr\n" +
            "djhfbsyizuoumkjlxelacpwqtr\n" +
            "dghffsniznoumkjlxpvacpwqtr\n" +
            "dghebsyizuoumkjlxevecpwqtr\n" +
            "rghfbsyiznourkjcxevacpwqtr\n" +
            "dghfbsyignoumkwlxenacpwqtr\n" +
            "dghfbsyiznrufkjlxevacpwqth\n" +
            "dgifbsyiznoumkjlxevacpjqnr\n" +
            "dghfbsyiznoumkjbxevaxpwqtw\n" +
            "dsufbsyizncumkjlxevacpwqtr\n" +
            "dihfbsyiznoumujlxecacpwqtr\n" +
            "dghfbiyiznoumkjlxevajpwqtn\n" +
            "dghqbsyixnoumkjlrevacpwqtr\n" +
            "dghfbsyiznouukjlxeuacpwqtx\n" +
            "dghfbsyizyoumksfxevacpwqtr\n" +
            "dghfbsiiznopfkjlxevacpwqtr\n" +
            "eghfbsyidnoumkjlxexacpwqtr\n" +
            "dghfbgyiznouwkjlwevacpwqtr\n" +
            "dghfbsyyznoumkjlxevacwwqtf\n" +
            "bghfbtypznoumkjlxevacpwqtr\n" +
            "dghfbsyiznoumtjlxebacpwetr\n" +
            "dghfbsgiznonmkplxevacpwqtr\n" +
            "dghfbsyiznoumxjlxevanpwqpr\n" +
            "dghfbsyiznwumujuxevacpwqtr\n" +
            "dghxbsyiznoumkjzxevaypwqtr\n" +
            "dghfbsyhznoumkjlxlvacpiqtr\n" +
            "dghfbsyiznoumkjlxevzcnwqrr\n" +
            "dvhfbsyiznoumkjluevacpzqtr\n" +
            "dghcbsyiznoumkjlxmvacpwetr\n" +
            "dghfbsyiznohmkjvxbvacpwqtr\n" +
            "dghfzsyiznouokjlxevacpwqpr\n" +
            "dghfbsyiznoumkjlxevachtqth\n" +
            "dghfbsyiznoumkjlxjvacpfutr\n" +
            "dghfbsyiznoumkjlxevsppwqtt\n" +
            "dghfusyiznouakhlxevacpwqtr\n" +
            "dghfbsyizcoumkjlxrvaipwqtr\n" +
            "dghebsyipnoumfjlxevacpwqtr\n" +
            "dgdfbsyiznoumkjlwevacpkqtr\n" +
            "dghfbsyiznoumkjlcffacpwqtr\n" +
            "dghfbsypznfumkjlxevacpwqar\n" +
            "dghfbsyiznojmkjlxevgcpkqtr\n" +
            "dghfbsyiznoumkjlaevlcpwstr\n" +
            "dgafrsyiunoumkjlxevacpwqtr\n" +
            "dghfbsyiznouqljlxevacrwqtr\n" +
            "dyhkbsyiznokmkjlxevacpwqtr\n" +
            "pghfbsciznoumkjlxevacpwvtr\n" +
            "dghfbxyiznonmkjllevacpwqtr\n" +
            "ighfbsyizxoumkjlxevacpzqtr\n" +
            "dgffbsyoznoumkjlxevacpwqto\n" +
            "hghfbsyiznoumkjlpevachwqtr\n" +
            "dlhfosyiznoumkjldevacpwqtr\n" +
            "dghfbsvizkoumkjlxvvacpwqtr\n" +
            "dbafbsyiznozmkjlxevacpwqtr\n" +
            "dghfbsyidnoumkjlxrvjcpwqtr\n" +
            "dghfbsyiznfumkjlxeqacpwqta\n" +
            "dghfbsfiznoumkjvxevacjwqtr\n" +
            "dghfbsyimnoumrjlhevacpwqtr\n" +
            "dghflsyiznoumkjlxevacpvqmr\n" +
            "dghfbmfiznoumkjlxevacpdqtr\n" +
            "dghfbsyizsouzkjlxevscpwqtr\n" +
            "dghfksyiznoumimlxevacpwqtr\n" +
            "dghfbsyiznoumkjlxevbwpwqur\n" +
            "wghcbsyiznoumkjlkevacpwqtr\n" +
            "kghfbioiznoumkjlxevacpwqtr\n" +
            "dghfbsiizeoumkjlxmvacpwqtr\n" +
            "dglfbsyilnoumkjlxevpcpwqtr\n" +
            "dgqfbsylznoumkjlxevacpwqcr\n" +
            "dglfhsyiznoumkjlxevacpwqdr\n" +
            "dghfbsymznoumkjlxbvacpwqtb\n" +
            "hghfbsyizhoumkjlxtvacpwqtr\n" +
            "dghdbsyiznoumkjlxeiacpyqtr\n" +
            "dohfbsyiznoumkjmxlvacpwqtr\n" +
            "xhhfbsyiznoumkjlxegacpwqtr\n" +
            "dlhfbsyiznoumkjlxnvahpwqtr\n" +
            "dghfbsyiznovdpjlxevacpwqtr\n" +
            "dgcfbsyiznoumkjlxevactwqdr\n" +
            "dghfksyiknoumkjlxevacpwqcr\n" +
            "ughfqsyiznoumkjlxevacpwctr\n" +
            "dghfbjyiznoumkjlxsvacnwqtr\n" +
            "dgwfbagiznoumkjlxevacpwqtr\n" +
            "dghfbsyiznoumknlxevtcpwqdr\n" +
            "jghfksyiznoumkjlxeoacpwqtr\n" +
            "dghfbsyiznoimkjlwezacpwqtr\n" +
            "dghfbsyiunoumkjlxeqacpwstr\n" +
            "dghfbsyizjoumkwlxevaypwqtr\n" +
            "dghfysriznoumkjlxevucpwqtr\n" +
            "dghfbsygzjoumkjfxevacpwqtr\n" +
            "dghfbhviznoumkjlxevacpwqtq\n" +
            "dghfbsyiznoumkjvwevacpwqur\n" +
            "dghfbsyiznoumtjlxevacplqnr\n" +
            "yghfbsysznouykjlxevacpwqtr\n" +
            "dgwfbsiiznoumkjlxevacfwqtr\n" +
            "dghfbsyizooumkjlxevampiqtr\n" +
            "dshfbsyiznoumkjlxevawpoqtr\n" +
            "dghtbsyxznuumkjlxevacpwqtr\n" +
            "dkhfblyiznoumkjlxevacpaqtr\n" +
            "dgkfbsyiinoumkjlxegacpwqtr\n" +
            "dghfbtxiznouhkjlxevacpwqtr\n" +
            "dghfbsyiznoumkjlxkvmcpeqtr\n" +
            "dghfbsyiznoumkjlghvacpwqmr\n" +
            "dghfbsbizioumkjlcevacpwqtr\n" +
            "dphfbsyizhoumkjwxevacpwqtr\n" +
            "dghfbsyiznqumkjlugvacpwqtr\n" +
            "dghfbsjinnoumkjlxevacpwetr\n" +
            "mghfbsyiznoumkjlxfvacpjqtr\n" +
            "dghfbsxiznoumkjlxetacwwqtr\n" +
            "dghmbsyiznoumbjlxevacpwqyr\n" +
            "dghfbsyiznwumkjlwevacmwqtr\n" +
            "dgkfbsyiznotmkjlxevacpwstr\n" +
            "dghfbsyiznouykjlxeiacuwqtr\n" +
            "dghfbsynznbhmkjlxevacpwqtr\n" +
            "dgyfbsyiznoumtjlbevacpwqtr\n" +
            "dghfbftiznoumkjlxevacpwatr\n" +
            "dghfvsyiznouikjlievacpwqtr\n" +
            "dghfbsyiznodmkjlxevncpwqtz\n" +
            "yfhfbsyiznoumkjluevacpwqtr\n" +
            "dghfbzyiznoumhflxevacpwqtr\n" +
            "dphfbsyizncumkjlxevacpwqtf\n" +
            "dghfasyiznoumkjlxeaicpwqtr\n" +
            "dgffbsyiznoumkjlzevacpwqsr\n" +
            "dghfbsyiznoumkmxxcvacpwqtr\n" +
            "dghffsyiznoumkjlxevacpwqre\n" +
            "dghfbsyizndmmkjlxemacpwqtr\n" +
            "dghfbsviznoamkjlxevappwqtr\n" +
            "dghfbsyiznouckrlxevacpdqtr\n" +
            "dgwfbsyiznyumkjlxevacpqqtr\n" +
            "dujfbsyiznoumgjlxevacpwqtr\n" +
            "dghobsailnoumkjlxevacpwqtr\n" +
            "dghfkqyiznoumknlxevacpwqtr\n" +
            "dghfbyypznoumkjlxevacpwatr\n" +
            "wqhfbsyiznoumkjlxevzcpwqtr\n" +
            "dghfbsyiznoumwjlxrvacppqtr\n" +
            "dghfbsymznoumkflxevacplqtr\n" +
            "dghfbsyiznounkjpgevacpwqtr\n" +
            "ighfbsyijnoumxjlxevacpwqtr\n" +
            "dghfbsyizroumkjllevncpwqtr\n" +
            "dghfbsliznokmkjlxevacpwqtb\n" +
            "dgefbsyiznoumkqlxevpcpwqtr\n" +
            "dghfbtypznouzkjlxevacpwqtr\n" +
            "dmhfbsyiznoumkjlxeyactwqtr\n" +
            "vohfbsyiznoumkjlqevacpwqtr\n" +
            "dgsfpsyiznodmkjlxevacpwqtr\n" +
            "dghfzsyijnoumkjnxevacpwqtr\n" +
            "dghfbayijroumkjlxevacpwqtr\n" +
            "dghfbsyiznodmxjlxgvacpwqtr\n" +
            "dghfbsyiznocmkjlxhvaipwqtr\n" +
            "dghmbsyignoumkjlxevacpoqtr\n" +
            "dghfbsyiznosmkjlncvacpwqtr\n" +
            "dggfbsyiznuumkjlxevacpwqrr\n" +
            "dghibsyilnoumkjlxevacowqtr\n" +
            "dghfbsyiznoumkjluevbcowqtr\n" +
            "dghfbsaiznyuvkjlxevacpwqtr\n" +
            "dgnfxsyiznommkjlxevacpwqtr\n" +
            "dghfbnyiznoumkjlsnvacpwqtr\n" +
            "dghfssiiznoumkjlxavacpwqtr\n" +
            "dghfbsyizneumajlxevacfwqtr\n" +
            "dghfbsyiznoumkjlxevycpvptr\n" +
            "qghfbsyizgoumkjlxevacpwttr\n" +
            "vghfbsyiznoumkjlievaepwqtr\n" +
            "dghfbsyiznoumejlxjvacpwdtr\n" +
            "dghfbsyispoumkjlxevacpwqtg\n" +
            "duhfbsyizpoumkjlxenacpwqtr\n" +
            "dghfbsyifnoumkblxevacpnqtr\n" +
            "bghfbsyxznoumkjleevacpwqtr\n" +
            "dgtfbsyzpnoumkjlxevacpwqtr\n" +
            "dghfbsyiznoumkjlsecacpwqth\n" +
            "dghfqsyiznjumkjlxevawpwqtr\n" +
            "dgcfbsyizboumkjlxevacqwqtr\n" +
            "dghfbqyiznoumkjkxevacpwqtj\n" +
            "dgyfbsyfznoumkjlievacpwqtr\n" +
            "dghfdsyiznoumkplxevacpwdtr\n" +
            "dphfbsyuznkumkjlxevacpwqtr\n" +
            "dghfbsyiznoupkjitevacpwqtr\n" +
            "dghfisyiznoamkjlxevacpwqwr\n" +
            "dgufbsyiznoumkjlxivvcpwqtr\n" +
            "dghfbvyiznoumkjlxevacvwqtz\n" +
            "dghfbsyiqnxumkjlxbvacpwqtr\n" +
            "dghubsyiznqumkflxevacpwqtr\n" +
            "dghfbsyiznzumkjlxevacpdbtr\n" +
            "dghfbsyiznoumkjlxehacpwwrr\n" +
            "mghfbsyiznoumkjlxevacpwqbp\n" +
            "dvhfbryiznoumkclxevacpwqtr\n" +
            "dghbbsyiznotmkjlxevacpwqhr\n" +
            "dghfrsyiznoomkjlxevacpwqto\n" +
            "dghfbkyiznoumkjlxeracpxqtr\n" +
            "dghfbfyizfoumkjlxevacpwjtr\n" +
            "dghfbsyizqoulkjlxevacpwqtt\n" +
            "dghfbsyiwnoumkjlxevacxwgtr\n" +
            "dghfbsyiznormkjlgxvacpwqtr\n" +
            "dghybsyizioumkjoxevacpwqtr\n" +
            "dchfbsyiznoumkjlxyvacpwqtc\n" +
            "dgyfbsyiznouckjlxewacpwqtr\n" +
            "dakfbsyeznoumkjlxevacpwqtr";
}
