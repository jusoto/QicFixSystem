<%-- 
    Document   : register
    Created on : Feb 5, 2016, 12:14:12 AM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <div class="row register-form">
            <div class="col-md-8 col-md-offset-2">
                <form class="form-horizontal custom-form" action="registerTower" method="POST">
                    <h1>Register Client Form</h1>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">First Name </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="fname">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Last Name </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="lname">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Date of Birth</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" pattern="\d{1,2}/\d{1,2}/\d{4}" alt="MM/DD/YYYY" name="dob">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Phone </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="phone">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Address </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="street_address">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">City</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="city">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">State</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <div class="dropdown">
                                <select name="state">
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="DC">District Of Columbia</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="name-input-field">Zipcode</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="text" name="zipcode">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="email-input-field">Email</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="email" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="pawssword-input-field">Password </label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="password" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="permit-number-input-field">Permit Number</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="permit_number">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 label-column">
                            <label class="control-label" for="price-mile-input-field">Price per Mile</label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <input class="form-control" type="price_mile">
                        </div>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">
                            I've read and accept the <a href="terms.jsp" target="_new">terms and conditions</a></label>
                    </div>
                    <input class="btn btn-default submit-button" type="submit" value="Register">
                    
                </form>
            </div>
        </div>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
