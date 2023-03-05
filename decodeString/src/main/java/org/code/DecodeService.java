package org.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DecodeService {

    String decodeString(String line){
        Map<Integer, Integer> brackets = new HashMap<>();
        Stack<Integer> openBrackets = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '['){
                openBrackets.push(i);
            }
            if(line.charAt(i) == ']'){
                Integer elementFromTop = openBrackets.pop();
                brackets.put(elementFromTop, i);
            }
        }
        return decode(line, 0, line.length()-1, brackets);
    }

    private String decode(String line, int startBracket, int finishBracket, Map<Integer, Integer> brackets){

        int k = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = startBracket; i <= finishBracket ; i++) {
            char current = line.charAt(i);

            if (Character.isLetter(current)){
                answer.append(current);
            }else if (Character.isDigit(current)) {
                k = k*10 + current - '0';
            }else if(current == '['){
                String decodeWithinLine = decode(line, i + 1, brackets.get(i) - 1, brackets);
                answer.append(decodeWithinLine.repeat(k));
                k=0;
                i = brackets.get(i);
            }
        }
        return answer.toString();
    }
}