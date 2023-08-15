<%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>   --%> 
<%-- <%@ taglib uri="jakarta.tags.core" prefix="c"   %> --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="com.apilogin.auth.utilities.Customer" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>


<!doctype html>
<html lang="en">
 
<head>
    <meta charset="utf-8">
    <!-- <meta http-equiv="refresh" content="0; URL=?method=GET"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
    <link rel="stylesheet" href="/css/style.css">
    <title>Customer List</title>
</head>

<body>

    <div class="container">
        <div class="row justify-content-center align-items-center" style="min-height: 100vh;">
            <div class="col-lg-12">
                <div class="border border-2 rounded-3 p-lg-5 p-4 my-4 shadow-lg">
                    <h3 class="mb-4 fs-3 text-center fw-bold">Customer List</h3>
                    <div class="pb-3 border-bottom border-2 d-flex justify-content-between">
                        <a href="customer" class="btn btn-primary py-2 px-4 text-white fw-bold fs-6 rounded-3 shadow-none">Add
                            Customer <i class="fa-solid fa-plus"></i></a>
                            <a href="/Logout" class="btn btn-primary py-2 px-4 text-white fw-bold fs-6 rounded-3 shadow-none">Log Out
                             <i ></i></a>
                    </div>
                    
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            
                            
                                <tr>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">City</th>
                                    <th scope="col">State</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Action</th>
                                </tr>
                                
                                
                                
                            </thead>
                            <tbody>
                            
                            <%-- <tab:forEach var="j" begin="0" end="8"> --%>
                            
                            <%
                          // out.println(request.getAttribute("customers"));
                          
     //                       ArrayList<Customer> customersList =(ArrayList<Customer>)request.getAttribute("customers");
                            
                        
                            
                             for (Customer allCustomer : (ArrayList<Customer>)request.getAttribute("customers")){
                            	
                            	String uuid =allCustomer.getUuid();
                 			    String firstName=  allCustomer.getFirst_name();
                 			    String lastName =allCustomer.getLast_name();
                 			    String street=allCustomer.getStreet();
                 			    String address=allCustomer.getAddress();
                 			    String city  =allCustomer.getCity();
                 			    String state=allCustomer.getState();
                 			    String email=allCustomer.getEmail();
                 			    String phone =allCustomer.getPhone();
                     		
                  		  
                    		
                            %>
                               
                                <tr>
                                    <td><%= firstName %></td>
                                    <td><%= lastName %></td>
                                    <td><%= address %></td>
                                    <td><%= city %></td>
                                    <td><%= state %></td>
                                    <td><%= email %></td>
                                    <td><%= phone %></td>
                                    <td>
                                        <a href="customerList/delete?cmd=delete&uuid=<%= uuid %>"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="customerList/update?cmd=update&uuid=<%= uuid %>"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                             
                          <%-- </tab:forEach> --%>
                                  <% 
                             		
                              	}
                             
                            %>
                                
                            <%--   
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Sakshi</td>
                                    <td>Sharma</td>
                                    <td>India</td>
                                    <td>Kanpur</td>
                                    <td>Uttar Pradesh</td>
                                    <td>test@email.com</td>
                                    <td>+12 1212131231</td>
                                    <td>
                                        <a href="#"><i class="fa-solid fa-trash-can text-danger fs-4 me-2"></i></a>
                                        <a href="#"><i class="fa-regular fa-pen-to-square text-primary fs-4"></i></a>
                                    </td>
                                </tr> 
                                
                                
                                --%>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>