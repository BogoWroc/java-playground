package pl.zebek.kata;

import java.util.Stack;

public class Indice {

    public static int solve(String str, int index){
        // write your code
        Stack<Integer> stack = new Stack<>();

        if(str.charAt(index) != '('){
            return -1;
        }

        for(int i=index; i<str.length(); i++){

                if(str.charAt(i) == '('){
                    stack.push(i);
                }
                else if(str.charAt(i) == ')'){
                    stack.pop();
                }

                if(stack.empty()){
                    return i;
                }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve("((1)23(45))(aB)",0));
    }
}
