package wonderland.number;

import java.util.*;

public class Utils {
    public static boolean hasSameDigits(int m, int n){
        Map<Integer, Integer> mDigitMap;
        Map<Integer, Integer> nDigitMap;
        Iterator<Integer> digitIterator;

        if(getNumberOfDigits(m) != getNumberOfDigits(n))
            return false;

        mDigitMap = mapDigitCount(m);
        nDigitMap = mapDigitCount(n);

        if(hasDifferentKeys(mDigitMap, nDigitMap)){
            return false;
        }

        digitIterator = getIteratorFromMap(mDigitMap);

        // can we make this stateless?
        while(digitIterator.hasNext()){
            if(isCurrentDigitCountDifferent(mDigitMap, nDigitMap, digitIterator.next()))
                return false;
        }
        return true;
    }

    private static int getNumberOfDigits(int n){
        if(n >= 0 && n < 10)
            return 1;

        return 1 + getNumberOfDigits(n / 10);
    }

    private static Map<Integer, Integer> mapDigitCount(int n){
        Map<Integer, Integer> digitCountMap = new HashMap<>();
        int tempNumber = n, currentDigit, currentDigitCount;

        if(n >= 0 && n < 10){
            digitCountMap.put(n, 1);
            return digitCountMap;
        }

        while(tempNumber != 0){
            currentDigit = tempNumber % 10;

            if(digitCountMap.containsKey(currentDigit)){
                currentDigitCount = digitCountMap.get(currentDigit);
                digitCountMap.put(currentDigit, currentDigitCount + 1);
            }
            else{
                digitCountMap.put(currentDigit, 1);
            }

            tempNumber = tempNumber / 10;
        }

        return digitCountMap;
    }

    private static boolean hasDifferentKeys(Map<Integer, Integer> mapA, Map<Integer, Integer> mapB){
        return !mapA.keySet().containsAll(mapB.keySet());
    }

    private static Iterator<Integer> getIteratorFromMap(Map<Integer, Integer> map){
        return map.keySet().iterator();
    }

    private static boolean isCurrentDigitCountDifferent(Map<Integer, Integer> mapA, Map<Integer, Integer> mapB, Integer currentItem){
        return !Objects.equals(mapA.get(currentItem), mapB.get(currentItem));
    }
}
