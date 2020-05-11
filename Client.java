import java.net.URL;
import javax.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{

		try
		{

			String serviceName = args[0];

			if((serviceName.equals("ServiceA") || serviceName.equals("ServiceB")) && args.length == 1)
			{

				URL url = new URL("http://localhost:6984/" + serviceName + "?wsdl");
				QName qName = new QName("http://localhost", serviceName);
				Service service = service.create(url, qName);

				if(serviceName.equals("ServiceA"))
				{
					ServiceA serviceA = service.getPort(ServiceA.class);
					System.out.println(serviceA.getServiceA());
				}
				else if(serviceName.equals("ServiceB"))
				{
					ServiceB serviceB = service.getPort(ServiceB.class);
					System.out.println(serviceA.getServiceB());
				}
			}
			else
			{
				System.out.println("Invalid Service Entered. Try Again.")
			}

		}
		catch(Exception a)
		{
			System.out.println(a);
		}

	}
}