import javax.*;
import java.*;
import com.*;

@WebService(targetNamespace = "http://localhost", serviceName = "ServiceB", endpointInterface = "ServiceB", portName = "Server3port")

public class Server3 implements ServiceB
{

	String clientMessage;
	APIGateway apiGateway;

	public Server3 (APIGateway apiGateway)
	{
		this.apiGateway = apiGateway;
	}

	@Resource
	WebServiceContext websrvContext;

	public String getServiceB ()
	{
		apiGateway.request();
		MessageContext msgContext = websrvContext.getMessageContext();
		HttpExchange httpExchange = (HttpExchange) msgContext.get("com.sun.xml.internal.ws.http.exchange");
		InetSocketAddress remoteAddress = httpExchange.getRemoteAddress();
		String host = remoteAddress.getHostName();
		InetAddress address = remoteAddress.getAddress();

		System.out.println("REQ: " + apiGateway.getClientNumReq() + " \nClient: " + host + " connected with " + address + " on Server3 for ServiceB.");

		clientMessage = "Server 3 Active. Running Service B.";

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