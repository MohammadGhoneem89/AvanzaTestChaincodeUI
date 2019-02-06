package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.Message;
import Model.PartyInformation;
import Model.TransferParamObject;

/**
 * Servlet implementation class ViewParties
 */
public class ViewParties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewParties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		System.out.println("#######VIEW PARTIES INFO######");
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewA");
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		PartyInformation a = invocationBuilder.get(PartyInformation.class);
		
		System.out.println(a.getName());
		System.out.println(a.getCategory());
		System.out.println(a.getBalance());
		
		HttpSession session = request.getSession();
		session.setAttribute("partyA.name", a.getName());
		session.setAttribute("partyA.type", a.getCategory());
		session.setAttribute("partyA.balance", a.getBalance());
		
		
		
		
		
		
		Client client1 = ClientBuilder.newClient();
		WebTarget webTarget1 = client1.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewB");
		Builder invocationBuilder1 = webTarget1.request(MediaType.APPLICATION_JSON);
		PartyInformation b = invocationBuilder1.get(PartyInformation.class);
		
		System.out.println(b.getName());
		System.out.println(b.getCategory());
		System.out.println(b.getBalance());
		
		session.setAttribute("partyB.name", b.getName());
		session.setAttribute("partyB.type", b.getCategory());
		session.setAttribute("partyB.balance", b.getBalance());
		
		
		
		Client client2 = ClientBuilder.newClient();
		WebTarget webTarget2 = client2.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewC");
		Builder invocationBuilder2 = webTarget2.request(MediaType.APPLICATION_JSON);
		PartyInformation c = invocationBuilder2.get(PartyInformation.class);
		
		System.out.println(c.getName());
		System.out.println(c.getCategory());
		System.out.println(c.getBalance());
		
		session.setAttribute("partyC.name", c.getName());
		session.setAttribute("partyC.type", c.getCategory());
		session.setAttribute("partyC.balance", c.getBalance());
		
		
		
		
		
		
		response.sendRedirect("viewDetails.jsp");
		
		
		
	}

}
