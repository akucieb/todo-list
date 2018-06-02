package pl.sda.poznan.servlets;

import pl.sda.poznan.model.TodoItem;
import pl.sda.poznan.repository.TodoRepository;
import pl.sda.poznan.service.TodoService;
import util.PersistenceUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoServlet", urlPatterns = {"/todo"})
public class TodoServlet extends HttpServlet {

    private TodoService todoService;

    public TodoServlet() {
        this.todoService = new TodoService(new TodoRepository(PersistenceUtil.getEntityManager()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<TodoItem> allTodos = todoService.getAllTodos();
        req.setAttribute("todos", allTodos);
        req.getRequestDispatcher("/todo/index.jsp").forward(req, resp);
    }


}