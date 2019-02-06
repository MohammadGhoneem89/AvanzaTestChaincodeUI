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
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.Message;
import Model.TransferParamObject;

/**
 * Servlet implementation class TransferAPIClient
 */
public class TransferAPIClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferAPIClient() {
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
		
		
		System.out.println("########HIIIIIIIIIII######");
		
		TransferParamObject tpo = new TransferParamObject();
		
		tpo.setSender(request.getParameter("sender"));
		tpo.setReceiver(request.getParameter("receiver"));
		tpo.setBalanceTT(Double.parseDouble( request.getParameter("points")));
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/transfer");
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response resp = invocationBuilder.post(Entity.entity(tpo, MediaType.APPLICATION_JSON));
		System.out.println("XXXXXXYYYYYYYZZZZZ");
		
		
		Message message = resp.readEntity(Message.class);
		System.out.println(resp.getStatus());
		System.out.println(message.getResponseMessage());
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message.getResponseMessage());
		
		response.sendRedirect("index.jsp");
		
	}

}
