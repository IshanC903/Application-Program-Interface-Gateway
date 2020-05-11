import javax.jws.*;

@WebService(targetNamespace = "http://localhost", serviceName = "ServiceA")

public interface ServiceA
{
    @WebMethod
    public String getServiceA();
}