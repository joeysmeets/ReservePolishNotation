import java.util.Scanner;

public class Postfix {
	private StackAsList<Double> operands;
	private StackAsList<Character> operators;
	
	/*constructor*/
	public Postfix() {
		this.operands = new StackAsList<Double>();
		this.operators = new StackAsList<Character>();
	}

	/** 
	 * @param pfx - A postfix expression
	 * @return - the integer the postfix expression evaluates to
	 * @throws StackUnderflowException 
	 */
	public double evaluate(String pfx) throws StackUnderflowException {
		if (pfx == null) {
			System.out.println("Error");
		}
		
		double result = 0;
		
		for (int i = 0; i < pfx.length(); i++) {
			Character t = pfx.charAt(i);
			//t is an operand -> push it to operands stack
			if(Character.isDigit(t)) {
				operands.push((double)(Character.getNumericValue(t))); //only works for digits 0-9
			//t is whitespace -> do nothing, move on to next character
			}else if (t == ' '){
				
			//t is (maybe) an operator
			}else {
				double rhs = operands.pop();
				double lhs = operands.pop();
				switch (t) {
					case '+': 
						result = lhs + rhs;
						break;
					case '-':
						result = lhs - rhs;
						break;
					case '/':
						result = lhs / rhs;
						break;
					case '*':
						result = lhs * rhs;
						break;
					case '^':
						result = Math.pow(lhs, rhs);
						break;						
				}
				operands.push(result);
			}
		}
		return result;
	}
	
	public String infixToPostfix(String ifx) {
		//TODO: implement a method that converts a String in ifx format to a String in pfx format
		String pfx = "";
		if (ifx.isBlank()) {return pfx;}
		
		StackAsList<Character> operators = new StackAsList<Character>();
		StackAsList<Double> operands = new StackAsList<Double>();
		
		for (int i = 0; i < ifx.length(); i++) {
			Character t = ifx.charAt(i);
			
			//t is an operand -> push it to operands stack
			if(Character.isDigit(t)) {
				operands.push((double)(Character.getNumericValue(t))); //only works for digits 0-9
			//t is whitespace -> do nothing, move on to next character
			}else if (t == ' '){
				
			//t is (maybe) an operator
			}else {
				double rhs = operands.pop();
				double lhs = operands.pop();
				switch (t) {
					case '+': 
						result = lhs + rhs;
						break;
					case '-':
						result = lhs - rhs;
						break;
					case '/':
						result = lhs / rhs;
						break;
					case '*':
						result = lhs * rhs;
						break;
					case '^':
						result = Math.pow(lhs, rhs);
						break;	
		}
		return pfx;
	}
	
	public static void main(String[] args) {
		Postfix test = new Postfix();
		test.fromConsole();
	}
	
	/*
	 * implement a method that reads an infix String from the console, converts it to RPN,
	 * evaluates it, and prints the result to the console.
	 */
	public void fromConsole() {
		System.out.println("Put in an Infix-equation without an equal sign here:");
        Scanner in = new Scanner(System.in);
        try {
            while (in.hasNextLine() == true) {
                String line = in.nextLine();
                try {
                    String pf = infixToPostfix(line);
                    System.out.println("Result: " + evaluate(pf));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        in.close();
    }
}