package in.mediumone.java8.puzzles;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxCombination {

    public static void main(String[] args) {

        //Input: {98, 9, 76, 45, 36, 4, 3, 1}
        //Output: 998764543631, 998764543631

        //Input: {98, 9, 76, 45, 36, 4, 3, 1}

        //Input: {98, 90, 76, 45, 36, 40, 30, 10}


        //Input: {12, 23, 34, 9, 8}
        //Output: 98342312

        //Input: {12, 23, 34, 90, 80}
        //Helper: {0, 0, 0, 1, 1}
        // {90, 80, 34, 23, 12}

        // 98342312

        //Solution

        //First Step. Reverse sort
        //Second Step. Take first value, 98.

//        int[] inputArr = {98, 9, 76, 45, 36, 4, 3, 1};
        int[] inputArr = {36, 4, 3, 1, 98, 9, 76, 45};

        List<Long> resultList = new ArrayList<>();
        long result = 0;

        resultList.add((long) inputArr[0]); //36

        for (int i = 1; i < inputArr.length; i++) {

            long newElementToCheck = inputArr[i]; //4

            System.out.println("Starting check with existing list: " + resultList + " and new item: " + newElementToCheck);

            List<List<Long>> candidates = new ArrayList<>();

            for (int j = 0; j <= resultList.size(); j++) {

                List<Long> eachCandidate = new ArrayList<>(resultList.size() + 1);

                eachCandidate.addAll(resultList);

                eachCandidate.add(j, newElementToCheck);

                candidates.add(eachCandidate);
            }

            System.out.println("Candidates: " + candidates);

            Map<Long, List<Long>> maxSumMap = new HashMap<>();

            for(List<Long> eachCandidate : candidates) {

                String numStr = "";

                for(Long eachNum: eachCandidate) {
                    numStr += eachNum;
                }

                Long numFromStr = Long.parseLong(numStr);

                maxSumMap.put(numFromStr, eachCandidate);
            }

            long maxValue = Collections.max(maxSumMap.keySet());

            resultList = maxSumMap.get(maxValue);
            result = maxValue;
        }

        System.out.println("Final solution: " + resultList + ", with result as: " + result);
    }

    private static void prevSolution() {

        int[] inputArr = {36, 4, 3, 1, 98, 9, 76, 45};

        List<Integer> inputArrList = Arrays.stream(inputArr).boxed().sorted().collect(Collectors.toList());

        System.out.println("Sorted: " + inputArrList);

        Collections.reverse(inputArrList);

        System.out.println("Rev Sorted: " + inputArrList);

        int maxSoFar = inputArrList.get(0);

        Map<Integer, Integer> maxNumMap = new HashMap<>();

        int maxLen = 0;

        for (int i = 1; i < inputArrList.size(); i++) {

            int nextNum = inputArrList.get(i);

            String combo1Str = "" + maxSoFar + "" + nextNum;

            if (combo1Str.length() > maxLen) {
                maxLen = combo1Str.length();
            }

            String combo2Str = "" + nextNum + "" + maxSoFar;

            if (combo2Str.length() > maxLen) {
                maxLen = combo2Str.length();
            }

            String extCombo1Str = combo1Str;
            String extCombo2Str = combo2Str;

            while (extCombo1Str.length() < maxLen) {
                extCombo1Str += "0";
            }

            while (extCombo2Str.length() < maxLen) {
                extCombo2Str += "0";
            }

            int combo1 = Integer.parseInt(combo1Str);
            int combo2 = Integer.parseInt(combo2Str);

            if (combo2 > combo1) {
                int extCombo2 = Integer.parseInt(extCombo2Str);
                maxNumMap.put(extCombo2, combo2);

                System.out.println("Checking " + maxSoFar + " and " + nextNum + " : " + combo1 + " , " + combo2 + " : " + combo2);
            } else {
                int extCombo1 = Integer.parseInt(extCombo1Str);
                maxNumMap.put(extCombo1, combo1);

                System.out.println("Checking " + maxSoFar + " and " + nextNum + " : " + combo1 + " , " + combo2 + " : " + combo1);
            }
        }

        int maxExtValue = Collections.max(maxNumMap.keySet());

        maxSoFar = maxNumMap.get(maxExtValue);

        System.out.println("Max so far: " + maxSoFar);
    }
}
