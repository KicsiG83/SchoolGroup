package Client;

public class Client {
    private int clientID;
    private String name;
    private String email;
    private String phoneNumber;
    private String comment;
    private ClientType clientType;

   public Client(int clientID, String name, String email, String phoneNumber, String typeSetter){
        this.clientID = clientID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
         
        //A typesetterrel állítom be, hogy a kliens buyer vagy seller legyen!
         
        if (typeSetter.equalsIgnoreCase("vevő")) {
            this.clientType = ClientType.BUYER;
 
        }else if(typeSetter.equalsIgnoreCase("eladó")){
             
            this.clientType = ClientType.SELLER;
 
        }
    }
     
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public ClientType getClienType() {
        return clientType;
    }
    public void setClienType(ClientType clienType) {
        this.clientType = clienType;
    } 
    public int getClientID() {
        return clientID;
    }    
    public String getComment() {
    	return comment;
    }
    public void setComment(String comment) {
    	this.comment = comment;
    }
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
     
}