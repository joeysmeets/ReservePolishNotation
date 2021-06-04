import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Postfix {
	//https://www.learn4master.com/algorithms/convert-infix-notation-to-reverse-polish-notation-java
	
	/*constructor*/
	public Postfix() {
		
	}

	/** 
	 * @param pfx - A postfix expression
	 * @return - the double the postfix expression evaluates to
	 * @throws StackUnderflowException 
	 */
	public double evaluate(String pfx) throws StackUnderflowException {
		if (pfx == null) {
			System.out.println("Error");
		}
		
		StackAsList<Double> operands = new StackAsList<Double>();
		
		double result = 0;
		
		for (int i = 0; i < pfx.length(); i++) {
			Character t = pfx.charAt(i);
			//t is an operand -> push it to operands stack
			if(Character.isDigit(t)) {
				operands.push((double)(Character.getNumericValue(t))); //only works for digits 0-9
			//t is whitespace -> do nothing, move on to next character
			}else if (t == ' '){
				
			//t is (maybe) an operator
			}else{
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
	
	public String infixToPostfix(String ifx) throws StackUnderflowException {
		HashMap<Character, Integer> precedences = new HashMap<>();
		precedences.put('+', 1);
		precedences.put('-', 1);
		precedences.put('/', 2);
		precedences.put('*', 2);
		precedences.put('^', 3);
		precedences.put('(', 0);
		
		String pfx = "";
		if (ifx.isBlank()) {return pfx;}
	
		StackAsList<Character> operators = new StackAsList<Character>();
		
		for (int i = 0; i < ifx.length(); i++) {
			Character t = ifx.charAt(i);
			
			if (Character.isDigit(t) || Character.isAlphabetic(t)) {
				pfx += t;
				
			}else if(t == '(') {
				operators.push(t);
				
			}else if(t == ')') {
				while(operators.peek() != '(') {
					pfx += operators.pop();
				}
				operators.pop(); //to pop the '(' off without adding it to the pfx string
			
			}else if (isOperator(t)) {
				//no operators on the stack yet -> add to stack
				if (operators.empty()) {
					operators.push(t);
				}else{
					//negative if t is higher precedence, 0 if same, positive if t is lower
					int a = precedences.get(operators.peek()) - precedences.get(t);
					
					//precedence of t is lower than top or equal precedence and right associative
					if (a >= 0) { //|| (a == 0 && (t == '+' || t == '*')))
						while (!operators.empty()) {
							pfx += operators.pop();
						}
					}
					operators.push(t);
				}
			}
		}
		while(!operators.empty()) {
			pfx += operators.pop();
		}
		return pfx;
	}
	
	public double evaluateInfixFromConsole() throws StackUnderflowException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String pfx = infixToPostfix(br.readLine());
		System.out.println(pfx);
		br.close();
		isr.close();
		return evaluate(pfx);
	}
	
	public boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {return true;}
		else {return false;}
	}
	
	/**
	 * @param ifx - An infix expression
	 * @return - true if the expression is correctly formatted, false otherwise
	 */
	/*public boolean isFormatted(String ifx) {
		if (ifx.isBlank()) {return true;}
		
		int operators = 0;
		int operands = 0;
	
		for (int i = 0; i < ifx.length(); i++) {
		//should have one less operator than operands
			
		//each digit (or variable) must be separated from the next digit by an operator
		
		}
	}*/
}


