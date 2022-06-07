package homework.braceChecker;

public class BraceChecker {

    Stack myStack = new Stack();

    private String text;


    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            char value = text.charAt(i);
            switch (value) {
                case '(':
                case '{':
                case '[':
                    myStack.push(value);
                    break;

                case ')':
                    char pop = (char) myStack.pop();
                    if (pop != '(') {
                        System.err.println("Error: opened" + pop + " but closed ) at " + i);
                    }
                    break;
                case '}':
                    char pop1 = (char) myStack.pop();
                    if (pop1 != '{') {
                        System.err.println("Error: opened" + pop1 + " but closed } at " + i);
                    }
                    break;
                case ']':
                    char pop2 = (char) myStack.pop();
                    if (pop2 != '[') {
                        System.err.println("Error: opened" + pop2 + " but closed ] at " + i);
                    }
                    break;
                default:

            }
        }
        while (!myStack.isEmpty()) {
            System.err.println("Error: opened " + myStack.pop() + " but dont closed");
        }


    }

}


