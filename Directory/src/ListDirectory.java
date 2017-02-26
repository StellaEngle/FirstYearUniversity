//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014


public class ListDirectory implements Directory{	
	public Node start;
	public Node end;
	public int size;
	//An inner class
	private class Node{
		public Entry data;
		public Node nextNode;		
		
		public Node(){
			this.data=null;
			this.nextNode=null;
		}
		public Node(Entry data){
			this.data=data;
			this.nextNode=null;
			
		}
		public Entry getData() {
			return data;
		}
		public void setData(Entry data) {
			this.data = data;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		
	}
	
	//Method to insert new staff to the LinkedList
	public void insertNew(String name) {	
		Entry entry = new Entry(name);
		Node node = new Node(entry);
		
		//if statement to check if the LinkedList is empty		
		if (end==null){
			start=node;
			end=node;
		}
		else{
			
		end.setNextNode(node);
		end=node;
				 }
		
		//Increments the size of the LinkedList
		size++;
		
	}

	//Method to delete a staff from the LinkedList, by his name(surname and initial) or number
	public void delete(String name, String num) {
		Node currentNode = this.start;
		//if statement to check if the LinkedList is empty and if yes to do nothing
        if (this.size == 0) {
          return;
        }
      
        if(name!=null){
        //if statement to check if we are deleting the first node
        if (start.data.getName().equals(name)) {          
          if (currentNode.getNextNode() == null) {
            this.start.setData(null);
            this.start = new Node();
            this.end= this.start;          
            return;
          }
          currentNode.setData(null);
          currentNode = currentNode.getNextNode();
          this.start = currentNode;        
          return;
        }
        
			Node current=start;
			Node previous = start;	
		//A while loop to check until the end of the LinkedList for the name(Surname and Initial)
		while(current.nextNode!=null){			
			current=current.nextNode;
			//if statement to delete the node 
			if(name!=null && current.data.getName().equals(name)){					
				previous.nextNode=(previous.nextNode.nextNode);				
				current.nextNode=null;		
			//else to make the previous reference to the next node	
			}else{					
						previous=previous.nextNode;
			}	
		}
        }
        else if(num!=null){
			 if (start.data.getNumber().equals(num)) {
				//if statement to check if we are deleting the first node
		           if (currentNode.getNextNode() == null) {
		            this.start.setData(null);
		            this.start = new Node();
		            this.end= this.start;		           
		            return;
		          }
		          currentNode.setData(null);
		          currentNode = currentNode.getNextNode();
		          this.start = currentNode;		         
		          return;
		        }

					Node current1=start;
					Node previous1 = start;	
					//A while loop to check until the end of the LinkedList for the number
				while(current1.nextNode!=null){					
					current1=current1.nextNode;
					//if statement to delete the node 
					if(num!=null && current1.data.getNumber().equals(num)){					
						previous1.nextNode=(previous1.nextNode.nextNode);				
						current1.nextNode=null;		
						//else to make the previous reference to the next node	
					}else{							
								previous1=previous1.nextNode;
					}								
		}			
		
		}
        //Decreases the size of the LinkedList
        this.size--;	
		}
	
		
	

	//Method to return the number  of staff by his/her name(surname and initial)
	public String lookUp(String surname) {
		String value="The staff you are looking for, does not exist in the directory";		
		//Checks if the LinkedList is empty
		if(start==null){
			return "There are not any stuff in the directory";
		}
		
		Node node= start;
		
		while(node.nextNode!=null){
			//check the first node of the list
			if(node.data.getName().equals(surname)){
				System.out.print("Number of the person you are searching is: " );
				value=node.data.getNumber();
			}
			//checks for all the rests nodes to find the number
			node=node.nextNode;
			 if(node.data.getName().equals(surname)){
				//count++;
				value=node.data.getNumber();
			}			
		}		
		return value;		
	}

	
	//Method to change the number of staff, given his name(surname and initial)	
	public void changeNum(String surname, String newNumber) {
		Node node=start;
		//calls the search method to find the old number of the staff
		String oldNum=lookUp(surname);
		//while the nextNode is not null 
		while(node.nextNode!=null){
			//if statement to change the number of the first staff in the LinkedList
			if(node.data.getName().equals(surname)){
				node.data.num=newNumber;
		}
			//if statement to check the rest linkedList and change the number
			node=node.nextNode;
			if(node.data.getName().equals(surname)){
				node.data.num=newNumber;
			}			
		
		}
		
	}

	//Method to print the LinkedList
	public void printDirectory() {	
		System.out.println("_____________________________________________");
		System.out.println();
		System.out.println("            Directory                   ");
		System.out.println();
		System.out.println(" Surname " +      "             " + "Initial"+ "     "+ "Tel. Extension");
		System.out.println("________________________________________________");
		for (Node node = start; node != null; node = node.nextNode) {
			System.out.printf("\n %-20s %5s %12s",node.data.getSurname(),node.data.getInitial(),node.data.getNumber());
			System.out.printf("\n");
			System.out.println(	"________________________________________________");
		}
		
	}
		
	}


