import java.rmi.*;
import java.rmi.server.*;
 
public class StartServer {
	public static void main(String[] args) {
		try {
				//System.setSecurityManager(new RMISecurityManager());
			 	java.rmi.registry.LocateRegistry.createRegistry(1099);
			 	
				ChatServerInt b=new ChatServer();	
				Naming.rebind("rmi://10.25.2.49/chat", b);
				System.out.println("Chat Server listo.");
			}catch (Exception e) {
					System.out.println("Chat Server falló: " + e);
			}
	}
}