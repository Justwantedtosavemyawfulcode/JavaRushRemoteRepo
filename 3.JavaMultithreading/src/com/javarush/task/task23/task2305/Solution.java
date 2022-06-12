package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        Solution solutionOne = new Solution();
        solutionOne.innerClasses[0] = solutionOne.new InnerClass();
        solutionOne.innerClasses[1] = solutionOne.new InnerClass();
        Solution solutionTwo = new Solution();
        solutionTwo.innerClasses[0] = solutionTwo.new InnerClass();
        solutionTwo.innerClasses[1] = solutionTwo.new InnerClass();
        result[0] = solutionOne;
        result[1] = solutionTwo;

        return result;
    }

    public static void main(String[] args) {

    }
}
