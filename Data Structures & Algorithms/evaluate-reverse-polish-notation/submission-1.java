
class Solution {
    public int evalRPN(String[] tokens) {
      //using java 8 fetaures
      Stack<Integer> stack = new Stack<>();
      Map<String, java.util.function.BiFunction<Integer,Integer,Integer>> operations = new HashMap<>();
      operations.put("+",(a,b) -> a+b);
      operations.put("-",(a,b) -> a-b);
      operations.put("*",(a,b) -> a*b);
      operations.put("/",(a,b) -> a/b);
    
    for(String token : tokens){
        if(operations.containsKey(token)){
            int b = stack.pop();
            int a = stack.pop();
            int result = operations.get(token).apply(a,b);
            stack.push(result);
        }else{
            stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
    }

     /*
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();   // second operand
                int a = stack.pop();   // first operand

                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
    
    private boolean isOperator(String tokens){
        return tokens.equals("+") ||tokens.equals("*") 
        ||tokens.equals("-") || tokens.equals("/");
    }
    private int applyOperator(int a , int b , String op){
     switch(op){
        case("+") : return a+b;
        case("-") : return a-b;
        case("*") : return a*b;
        case("/") : return a/b;
     }
     return 0;
    } */
}
