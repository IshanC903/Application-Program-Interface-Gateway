import javax.jws.*;
import javax.xml.*;

@WebService

public class APIGateway
{

	Server1 server1;
	Server2 server2;
	Server3 server3;
	Server4 server4;

	Endpoint endPointA;
	Endpoint endPointB;

	int clientNumReq;

	public APIGateway()
	{

		System.out.println("Starting Service.")
		clientReqNum = 0;

		server2 = new Server2(this);
		server4 = new Server4(this);
		endPointA = Endpoint.publish("http://localhost:6984/ServiceA", server1 = new Server1(this));
		endPointB = Endpoint.publish("http://localhost:6984/ServiceA", server2 = new Server2(this));
	}

	public void run()
	{

		while(true)
		{

			if(server1.getClientMessage() != null)
			{
				endPointA.stop();
				endPointA = Endpoint.publish("http://localhost:6984/ServiceA", server2 = new Server2(this));
			}
			else if(server2.getClientMessage() != null)
			{
				endPointA.stop();
				endPointA = Endpoint.publish("http://localhost:6984/ServiceA", server1 = new Server1(this));
			}

			if(server3.getClientMessage() != null)
			{
				endPointB.stop();
				endPointB = Endpoint.publish("http://localhost:6984/ServiceA", server4 = new Server4(this));
			}
			else if(server4.getClientMessage() != null)
			{
				endPointB.stop();
				endPointB = Endpoint.publish("http://localhost:6984/ServiceA", server3 = new Server3(this));
			}

			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException a)
			{
				System.out.println(a);
			}

		}

	}

	public int getClientNumReq()
	{
		return clientNumReq;
	}

	public void addClientRequest()
	{
		clientNumReq++;
	}

	public static void main(String[] args)
	{
		APIGateway otherGateway = new APIGateway();
		otherGateway.run();
	}

}