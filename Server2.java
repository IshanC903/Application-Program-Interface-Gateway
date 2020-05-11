import javax.*;
import java.*;
import com.*;

@WebService(targetNamespace = "http://localhost", serviceName = "ServiceA", endpointInterface = "ServiceA", portName = "Server2port")

public class Server2 implements ServiceA
{

	String clientMessage;
	APIGateway apiGateway;

	public Server2 (APIGateway apiGateway)
	{
		this.apiGateway = apiGateway;
	}

	@Resource
	WebServiceContext websrvContext;

	public String getServiceA ()
	{
		apiGateway.request();
		MessageContext msgContext = websrvContext.getMessageContext();
		HttpExchange httpExchange = (HttpExchange) msgContext.get("com.sun.xml.internal.ws.http.exchange");
		InetSocketAddress remoteAddress = httpExchange.getRemoteAddress();
		String host = remoteAddress.getHostName();
		InetAddress address = remoteAddress.getAddress();

		System.out.println("REQ: " + apiGateway.getClientNumReq() + " \nClient: " + host + " connected with " + address + " on Server2 for ServiceA.");

		clientMessage = "Server 2 Active. Running Service A.";

		return clientMessage;
	}

	public String getClientMessage()
	{
		return clientMessage;
	}

	public void nullMessage()
	{
		clientMessage = null;
	}

}