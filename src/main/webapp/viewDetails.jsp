
<%@page import="java.util.ArrayList"%>
<%@page import="Model.PartyInformation"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.Invocation.Builder"%>
<%@page import="javax.ws.rs.core.MediaType"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Wallet System</title>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




	<style type="text/css">
		.login-container{
			width: 100%;
			height: 100%;
			display: -webkit-box;
			display: -webkit-flex;
			justify-content: center;
			align-items: center;
			background: #111111;
			background: -webkit-linear-gradient(bottom,#5DADE2,#2E4053);
			position: absolute;
			z-index: -1;


		}

		.second-div{
			width: 900px;
			height: 750px;
			background: #fff;
			border-radius: 20px;
			

		}
		.login-title{
			width: 300px;
			margin: auto;
			margin-top: 50px;
			justify-content: center;
			text-align: center;
			
		}

		.login-body{
			width: 300px;
			margin: auto;
			margin-top: 70px;
			justify-content: center;
			text-align: center;
			
		}




.btn-default, .btn-default:hover, .btn-default:active, .btn-default:visited {
    /*background-color: #d43f8d !important;*/
    width: 75px; 
	height: 40px; 
	
}

	</style>



</head>
<%


Client client = ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewA");
Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
PartyInformation a = invocationBuilder.get(PartyInformation.class);

System.out.println(a.getName());
System.out.println(a.getCategory());
System.out.println(a.getBalance());


Client client1 = ClientBuilder.newClient();
WebTarget webTarget1 = client1.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewB");
Builder invocationBuilder1 = webTarget1.request(MediaType.APPLICATION_JSON);
PartyInformation b = invocationBuilder1.get(PartyInformation.class);

System.out.println(b.getName());
System.out.println(b.getCategory());
System.out.println(b.getBalance());




Client client2 = ClientBuilder.newClient();
WebTarget webTarget2 = client2.target("http://localhost:8080/BlockchainAPIs/webapi/digitalWallet/viewC");
Builder invocationBuilder2 = webTarget2.request(MediaType.APPLICATION_JSON);
PartyInformation c = invocationBuilder2.get(PartyInformation.class);

System.out.println(c.getName());
System.out.println(c.getCategory());
System.out.println(c.getBalance());



%>

<body >



	<div class="login-container">
		<div class="second-div">
			<div class="login-title">
				<h3>Participants Information</h3>
				<img src="wallet.png" style="width: 100px; height: 100px; margin-top: 25px;">
			</div>
			

			

				<hr>
				
				<div>
				
				<label style="margin: 5px 70px 50px 200px;"><%out.print(a.getName()); %></label> <label style="margin: 5px 70px 50px 90px;"> <%out.print(a.getCategory()); %></label> <label style="margin: 5px 70px 50px 90px;"><%out.print(a.getBalance()); %></label>
				</div>
				<hr>
				
				<div>
				
				<label style="margin: 5px 70px 50px 200px;"><%out.print(b.getName()); %></label> <label style="margin: 5px 70px 50px 90px;"> <%out.print(b.getCategory()); %></label> <label style="margin: 5px 70px 50px 70px;"><%out.print(b.getBalance()); %></label>
				</div>
				<hr>
				
				<div>
				
				<label style="margin: 5px 70px 50px 200px;"><%out.print(c.getName()); %></label> <label style="margin: 5px 70px 50px 90px;"> <%out.print(c.getCategory()); %></label> <label style="margin: 5px 70px 50px 90px;"><%out.print(c.getBalance()); %></label>
				</div>
				<hr>
				
			

<form action="ViewParties" method="Post">
<input type="submit" value="Refresh" class="btn btn-default" style="float:right; margin-right:20px;">
</form>

			
		</div>
	</div>

</body>

</html>







