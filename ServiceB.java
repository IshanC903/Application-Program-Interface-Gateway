import javax.jws.*;

@WebService(targetNamespace = "http://localhost", serviceName = "ServiceA")

public interface ServiceB
{
    @WebMethod
    public String getServiceB();
}