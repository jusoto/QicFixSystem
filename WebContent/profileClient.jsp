<%-- 
    Document   : profileClient
    Created on : Apr 26, 2016, 8:34:13 AM
    Author     : Juan
--%>

<%@page import="client.model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Client client = null;
    String state = "";
    if(session.getAttribute("client")!=null){
        client = (Client) session.getAttribute("client");
        state = client.getState()!=null?client.getState():"";
    }
%>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <div class="row register-form">
            <div class="col-md-8 col-md-offset-2">
                <form class="form-horizontal custom-form" action="updateClient" method="POST">
                    <h1>Profile Client</h1>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">First Name </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="fname" value="<%=client.getFname()%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Last Name </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="lname" value="<%=client.getLname()%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Date of Birth</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" pattern="\d{1,2}/\d{1,2}/\d{4}" alt="MM/DD/YYYY" name="dob" value="<%=client.getDob()!=null?client.getDob():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Phone </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="phone" value="<%=client.getPhone()!=null?client.getPhone():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Address </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="street_address" value="<%=client.getStreetAddress()!=null?client.getStreetAddress():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">City</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="city" value="<%=client.getCity()!=null?client.getCity():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">State</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <div class="dropdown">
                                <select name="state">
                                    <option value="AL" <%if(state.equals("AL")){%>selected="selected"<%}%>>Alabama</option>
                                    <option value="AK" <%if(state.equals("AK")){%>selected="selected"<%}%>>Alaska</option>
                                    <option value="AZ" <%if(state.equals("AZ")){%>selected="selected"<%}%>>Arizona</option>
                                    <option value="AR" <%if(state.equals("AR")){%>selected="selected"<%}%>>Arkansas</option>
                                    <option value="CA" <%if(state.equals("CA")){%>selected="selected"<%}%>>California</option>
                                    <option value="CO" <%if(state.equals("CO")){%>selected="selected"<%}%>>Colorado</option>
                                    <option value="CT" <%if(state.equals("CT")){%>selected="selected"<%}%>>Connecticut</option>
                                    <option value="DE" <%if(state.equals("DE")){%>selected="selected"<%}%>>Delaware</option>
                                    <option value="DC" <%if(state.equals("DC")){%>selected="selected"<%}%>>District Of Columbia</option>
                                    <option value="FL" <%if(state.equals("FL")){%>selected="selected"<%}%>>Florida</option>
                                    <option value="GA" <%if(state.equals("GA")){%>selected="selected"<%}%>>Georgia</option>
                                    <option value="HI" <%if(state.equals("HI")){%>selected="selected"<%}%>>Hawaii</option>
                                    <option value="ID" <%if(state.equals("ID")){%>selected="selected"<%}%>>Idaho</option>
                                    <option value="IL" <%if(state.equals("IL")){%>selected="selected"<%}%>>Illinois</option>
                                    <option value="IN" <%if(state.equals("IN")){%>selected="selected"<%}%>>Indiana</option>
                                    <option value="IA" <%if(state.equals("IA")){%>selected="selected"<%}%>>Iowa</option>
                                    <option value="KS" <%if(state.equals("KS")){%>selected="selected"<%}%>>Kansas</option>
                                    <option value="KY" <%if(state.equals("KY")){%>selected="selected"<%}%>>Kentucky</option>
                                    <option value="LA" <%if(state.equals("LA")){%>selected="selected"<%}%>>Louisiana</option>
                                    <option value="ME" <%if(state.equals("ME")){%>selected="selected"<%}%>>Maine</option>
                                    <option value="MD" <%if(state.equals("MD")){%>selected="selected"<%}%>>Maryland</option>
                                    <option value="MA" <%if(state.equals("MA")){%>selected="selected"<%}%>>Massachusetts</option>
                                    <option value="MI" <%if(state.equals("MI")){%>selected="selected"<%}%>>Michigan</option>
                                    <option value="MN" <%if(state.equals("MN")){%>selected="selected"<%}%>>Minnesota</option>
                                    <option value="MS" <%if(state.equals("MS")){%>selected="selected"<%}%>>Mississippi</option>
                                    <option value="MO" <%if(state.equals("MO")){%>selected="selected"<%}%>>Missouri</option>
                                    <option value="MT" <%if(state.equals("MT")){%>selected="selected"<%}%>>Montana</option>
                                    <option value="NE" <%if(state.equals("NE")){%>selected="selected"<%}%>>Nebraska</option>
                                    <option value="NV" <%if(state.equals("NV")){%>selected="selected"<%}%>>Nevada</option>
                                    <option value="NH" <%if(state.equals("NH")){%>selected="selected"<%}%>>New Hampshire</option>
                                    <option value="NJ" <%if(state.equals("NJ")){%>selected="selected"<%}%>>New Jersey</option>
                                    <option value="NM" <%if(state.equals("NM")){%>selected="selected"<%}%>>New Mexico</option>
                                    <option value="NY" <%if(state.equals("NY")){%>selected="selected"<%}%>>New York</option>
                                    <option value="NC" <%if(state.equals("NC")){%>selected="selected"<%}%>>North Carolina</option>
                                    <option value="ND" <%if(state.equals("ND")){%>selected="selected"<%}%>>North Dakota</option>
                                    <option value="OH" <%if(state.equals("OH")){%>selected="selected"<%}%>>Ohio</option>
                                    <option value="OK" <%if(state.equals("OK")){%>selected="selected"<%}%>>Oklahoma</option>
                                    <option value="OR" <%if(state.equals("OR")){%>selected="selected"<%}%>>Oregon</option>
                                    <option value="PA" <%if(state.equals("PA")){%>selected="selected"<%}%>>Pennsylvania</option>
                                    <option value="RI" <%if(state.equals("RI")){%>selected="selected"<%}%>>Rhode Island</option>
                                    <option value="SC" <%if(state.equals("SC")){%>selected="selected"<%}%>>South Carolina</option>
                                    <option value="SD" <%if(state.equals("SD")){%>selected="selected"<%}%>>South Dakota</option>
                                    <option value="TN" <%if(state.equals("TN")){%>selected="selected"<%}%>>Tennessee</option>
                                    <option value="TX" <%if(state.equals("TX")){%>selected="selected"<%}%>>Texas</option>
                                    <option value="UT" <%if(state.equals("UT")){%>selected="selected"<%}%>>Utah</option>
                                    <option value="VT" <%if(state.equals("VT")){%>selected="selected"<%}%>>Vermont</option>
                                    <option value="VA" <%if(state.equals("VA")){%>selected="selected"<%}%>>Virginia</option>
                                    <option value="WA" <%if(state.equals("WA")){%>selected="selected"<%}%>>Washington</option>
                                    <option value="WV" <%if(state.equals("WV")){%>selected="selected"<%}%>>West Virginia</option>
                                    <option value="WI" <%if(state.equals("WI")){%>selected="selected"<%}%>>Wisconsin</option>
                                    <option value="WY" <%if(state.equals("WY")){%>selected="selected"<%}%>>Wyoming</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Zipcode</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="zipcode" value="<%=client.getZipcode()!=null?client.getZipcode():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="email-input-field">Email</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="email" name="email" value="<%=client.getEmail()!=null?client.getEmail():""%>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="pawssword-input-field">Password </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="password" name="password"/>
                        </div>
                    </div>
                    <input class="btn btn-default submit-button" type="submit" value="Update">
                    
                </form>
            </div>
        </div>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>

