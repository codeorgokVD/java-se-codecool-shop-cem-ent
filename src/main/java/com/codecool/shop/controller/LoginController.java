package com.codecool.shop.controller;


import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    /**
     * Singleton. Creates the object if it is not exists.
     * Returns the one and only object of the class.
     */
    private static LoginController instance = null;
    private LoginController() {}

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    /**
     * Renders login with login.html
     * @param req request parameter
     * @param res response parameter
     * @return ModelAndView object
     */
    public ModelAndView renderLogin(Request req, Response res) {
        UserDaoMem userDataStore = UserDaoMem.getInstance();

        Map<String, Object> params = new HashMap<>();
        params.put("users", userDataStore.getAll());
        return new ModelAndView(params, "login");
    }

    /**
     * This method checks the login attempt. If the user passed the right values then the user can log in.
     * @param req request parameter
     * @param res response parameter
     * @return renderLogin call
     */
    public ModelAndView renderLoginPost(Request req, Response res){
        UserDaoMem userDataStore = UserDaoMem.getInstance();
        User user = userDataStore.find(req.queryParams("username"));
        if (req.queryParams("username").equals(user.getName())){
            if (req.queryParams("password").equals(user.getPassword())) {
                req.session(true);
                req.session().attribute("user", req.queryParams("username"));
                req.session().attribute("type", user.getRank());
                res.redirect("/");
            }
        }
        return renderLogin(req, res);
    }
}
