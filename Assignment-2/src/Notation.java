/**
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class Notation {

	
    public Notation() {
        
    } 
    
	/**
	 * Method to convert infix to postfix
	 * @param infix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

		
		NotationQueue<Character> pfQueue = new NotationQueue<>(infix.length());
		NotationStack<Character> pfStack = new NotationStack<>(infix.length());
		char[] array = infix.toCharArray();

		try {
			for (char x : array) {
				if (x == ' ') {
					continue;
				}
				if (Character.isDigit(x)) {
					pfQueue.enqueue(x);
					continue;
				}
				if (x == '(') {
					pfStack.push(x);
				}
				if (x == '*' || x == '/' || x == '+' || x == '-') {
					if (!pfQueue.isEmpty()) {
						char top = pfStack.top();
						if (top == '*' || top == '/' || x == '-' && top == '-' || x == '-' && top == '+'
								|| x == '+' && top == '-' || x == '+' && top == '+') {
							pfQueue.enqueue(pfStack.pop());

						}
					}
					pfStack.push(x);
					continue;
				}
				if (x == ')') {
					while (pfStack.top() != '(') {
						pfQueue.enqueue(pfStack.pop());
						if (pfStack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					pfStack.pop();
				}

			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		return pfQueue.toString();

	}
	
	
	/**
	 * Method to convert postfix to infix
	 * @param postfix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		NotationStack<String> ifStack = new NotationStack<>(postfix.length());

		try {
			for (int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);

				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					ifStack.push(Character.toString(current));
					continue;
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (ifStack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String first = ifStack.pop();
					String second = ifStack.pop();
					String s = "(" + second + current + first + ")";
					ifStack.push(s);

				}
			}

		} catch (StackUnderflowException | StackOverflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		if (ifStack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return ifStack.toString();
	}
    
	
	
	/**
	 * Method to evaluate postfix operation
	 * @param fst
	 * @param scnd
	 * @param e
	 * @return
	 */
	private static double evaluation(String fst, String scnd,char e) {
		double result=0,a,b;
		switch(e) {
		case '+':
			a=Double.parseDouble(fst);
			b=Double.parseDouble(scnd);
			result=a+b;
			break;
		
		case '-':
			a=Double.parseDouble(fst);
			b=Double.parseDouble(scnd);
			result=a-b;
			break;
		
		case '*':
			a=Double.parseDouble(fst);
			b=Double.parseDouble(scnd);
			result=a*b;
			break;
		
		case '/':
			a=Double.parseDouble(fst);
			b=Double.parseDouble(scnd);
			result=a/b;
			break;
		
		default:
			System.out.println("Unknown operator");
		}	
		return result;
	}
	
	
	/**
	 * 
	 * @param pfExpression
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String pfExpression) throws InvalidNotationFormatException {
		String a, b;
		double result=0;
		NotationStack<String> pfStack=new NotationStack<String>(10);
		char[] array=pfExpression.toCharArray();
		
		try {
			for(int i=0;i<array.length;i++) {
				if(array[i]==' ') {
					continue;
				}
				if(Character.isDigit(array[i])|| array[i]=='(') {
					pfStack.push(String.valueOf(array[i]));
				}
				else {
					if(pfStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						b=pfStack.pop();
						a=pfStack.pop();
						result=evaluation(a,b,array[i]);
						pfStack.push(Double.toString(result));
						
					}
				}
			}
			if(pfStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			s.printStackTrace();
		}
		
					
		return result;
	}
}