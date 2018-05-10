import enums.AsciiTypeEnum;
import exception.WrongInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yong on 2018-05-10.
 *
 * @author yong
 */
public class InputSorting {

    private List<Integer> numberAsciiList;
    private List<Integer> upperAsciiList;
    private List<Integer> lowerAsciiList;

    public String sorting(String input) throws WrongInputException {
        resetListObj();
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int asciiValue = (int)chars[i];
            putAsciiValue(checkAsciiType(asciiValue), asciiValue);
        }
        String result = mergeList();
        return result;
    }

    public AsciiTypeEnum checkAsciiType(int asciiValue) throws WrongInputException {
        if(48 <= asciiValue && 57 >= asciiValue){
            return AsciiTypeEnum.NUMBER;
        } else if(65 <= asciiValue && 90 >= asciiValue){
            return AsciiTypeEnum.UPPER;
        } else if(97 <= asciiValue && 122 >= asciiValue){
            return AsciiTypeEnum.LOWER;
        } else {
            throw new WrongInputException("알파벳, 숫자 이외 값 입력");
        }
    }

    public void putAsciiValue(AsciiTypeEnum asciiTypeEnum, int asciiValue) throws WrongInputException {
        if(AsciiTypeEnum.NUMBER == asciiTypeEnum){
            numberAsciiList.add(asciiValue);
        } else if(AsciiTypeEnum.UPPER == asciiTypeEnum){
            upperAsciiList.add(asciiValue);
        } else if(AsciiTypeEnum.LOWER == asciiTypeEnum){
            lowerAsciiList.add(asciiValue);
        } else {
            throw new WrongInputException("알파벳, 숫자 이외 값 입력");
        }
    }

    public String mergeList() {
        int numberAsciiListCount = numberAsciiList.size();
        int upperAsciiListCount = upperAsciiList.size();
        int lowerAsciiListCount = lowerAsciiList.size();

        int middleCount = (numberAsciiListCount > upperAsciiListCount) ? numberAsciiListCount : upperAsciiListCount;
        int maxCount = (middleCount > lowerAsciiListCount) ? middleCount : lowerAsciiListCount;

        Collections.sort(numberAsciiList);
        Collections.sort(upperAsciiList);
        Collections.sort(lowerAsciiList);

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < maxCount; i++){
            if(i < upperAsciiListCount){
                result.append(getCharacter(upperAsciiList.get(i)));
            }
            if(i < lowerAsciiListCount){
                result.append(getCharacter(lowerAsciiList.get(i)));
            }
            if(i < numberAsciiListCount){
                result.append(getCharacter(numberAsciiList.get(i)));
            }
        }
        return result.toString();
    }

    public String getCharacter(int ascii){
        return Character.toString ((char) ascii);
    }

    public void resetListObj(){
        numberAsciiList = new ArrayList<Integer>();
        upperAsciiList = new ArrayList<Integer>();
        lowerAsciiList = new ArrayList<Integer>();
    }


}
