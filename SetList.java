package SetOperations;

class SetList {
	
		  private String[] arr;
		    private int size;

			public SetList(){
		        this.arr =  new String[13];
		    }

		    public void add(String element) {
		    	if (!contains(element)) {
		        if (this.size+1 >= this.arr.length){
		            this.resize();
		        }
		        this.arr[this.size()] = element;
		        this.size++;}
		    }

		    public int size() {
		        return this.size;
		    }

		    private void resize()
		    {
				String[] newArray =  new String[this.arr.length * 2];

		        for (int i = 0; i < this.size(); i++)
		            newArray[i] = this.arr[i];

		        this.arr = newArray;
		    }
		    
		    public SetList Union(SetList b){
        		SetList u = new SetList();
        		for(int i=0;i<b.size;i++) {
        			u.add(b.arr[i]);
        		}
        	   for(int i=0 ; i<size ; i++){
        		 u.add(arr[i]); 
        	   }	
        	   return u;
        }
         public SetList InterSection(SetList b){
        	
        	SetList c = new SetList();
        	
        	for(int i=0; i<size ; i++){
        		if(b.contains(arr[i])){
        		 c.add(arr[i]);
        		}
        	}
        	return c;
        }
        
        public SetList Complement(SetList b){
            SetList c = new SetList();
            for(int i=0 ; i < size; i++){
              if(!b.contains(arr[i])){
        			 c.add(arr[i]);
        		}  
            }
         return c;    
        }
        public boolean contains(String element) {
	        if(element == null){
	            for(int i=0 ; i<size ; i++){
	                if(arr[i] == null){
	                    return true;
	                }
	            }
	        }
	       else{
	          for(int i=0 ; i<size ; i++){
	                if(arr[i].equals(element)){
	                    return true;
	                }
	            } 
	       } 
			return false;
	    }
        public String toString() {
    		if (null == arr || size == 0) {
    			return "[EMPTY]";
    		} else {
    			String s = "[";
    			for (int i = 0; i < size ; i++) {
    				if(i == size-1) {
    					s += arr[i];	
    				}
    				else {	s += arr[i] + ",";
    			 }
    			}
    			s += "]";
    			return s;
    		}
    	
    	}
        public void clear() {
    		arr = new String[13];
    		size = 0;
    	}
  public boolean IsSubset(SetList b){
        	
        	for(int i=0; i<size ; i++){
        		if(!(b.contains(arr[i]))){
        			return false;
        		}
        	}
        	return true;
        }
	}


