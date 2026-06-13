class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
          while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek ()]){
            int previousIndex = stack.pop();
            result[previousIndex] = i - previousIndex;
          }
          stack.push(i);
        }
    return result;
    }
}
/*
Traverse the array from left to right
Maintain a stack where temperatures are in decreasing order
When the current temperature is higher than the temperature at the stack’s top index:
Pop the index
Calculate the number of days waited
Push current index onto the stack
*/