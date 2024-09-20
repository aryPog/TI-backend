package ex03.crud;

import static spark.Spark.*;
import com.google.gson.Gson;


public class ProdutoService {
    private static Gson gson = new Gson();
    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public static void main(String[] args) {
        port(7749);

        staticFiles.location("/resources");
        
        post("/produtos", (req, res) -> {
            Produto produto = gson.fromJson(req.body(), Produto.class);
            return produtoDAO.save(produto);
        }, gson::toJson);

        get("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return produtoDAO.find(id);
        }, gson::toJson);

        put("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Produto produto = gson.fromJson(req.body(), Produto.class);
            produto.setId(id);
            return produtoDAO.update(produto);
        }, gson::toJson);

        delete("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return produtoDAO.delete(id);
        }, gson::toJson);
        
        get("/produtos", (req, res) -> {
            return produtoDAO.findAll();
        }, gson::toJson);
    }
}
