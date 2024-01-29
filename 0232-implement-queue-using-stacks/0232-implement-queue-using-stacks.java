class MyQueue {
    Stack<Integer> adding = new Stack<>();
    Stack<Integer> actualQueue = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        adding.add(x);
    }
    
    public int pop() {
        while(!adding.isEmpty()){
            actualQueue.add(adding.pop());
        }
        int x =actualQueue.pop();
        while(!actualQueue.isEmpty()){
            adding.add(actualQueue.pop());
        }
        return x;
    }
    
    public int peek() {
        while(!adding.isEmpty()){
            actualQueue.add(adding.pop());
        }
        int x =actualQueue.peek();
        while(!actualQueue.isEmpty()){
            adding.add(actualQueue.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return adding.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */