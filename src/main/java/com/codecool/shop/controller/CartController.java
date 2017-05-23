package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
//import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.jdbc.ProductDaoJdbc;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.LineItem;
import org.json.simple.JSONObject;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class CartController {
    /**
     * Singleton. Creates the object if it is not exists.
     * Returns the one and only object of the class.
     */

    private static CartController instance = null;
    private CartController() {}

    public static CartController getInstance() {
        if (instance == null) {
            instance = new CartController();
        }
        return instance;
    }

    /**
     * This method controls the item adding to the cart.
     * @param req request parameter
     * @param res response parameter
     * @return JSONObject
     */
    public JSONObject addItemToCart(Request req, Response res) {
        int addedProductId = Integer.parseInt(req.params(":id"));
        ProductDao productDataStore = new ProductDaoJdbc();
        Cart cartDataStore = getCart(req);

        LineItem lineItemCandidate = new LineItem(productDataStore.find(addedProductId));
        cartDataStore.add(lineItemCandidate);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("numberOfProductsInCart", cartDataStore.getAllQuantity());
        res.type("application/json");
        return jsonObj;
    }

    /**
     * Renders cart with cartview.html
     * @param req request parameter
     * @param res response parameter
     * @return ModelAndView object
     */
    public ModelAndView renderCart(Request req, Response res) {
        Cart cartDataStore = getCart(req);
        Map<String, Object> params = new HashMap<>();
        params.put("lineitems", cartDataStore.getAll());
        params.put("sum", cartDataStore.getSum());
        return new ModelAndView(params, "cartview");
    }

    /**
     * Singleton.If cart is not existing then it creates a new cart object.
     * @param req request parameter
     * @return Cart object
     */
    public Cart getCart(Request req) {
        Cart cart = req.session().attribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.session().attribute("cart", cart);
        }
        return cart;
    }
}
