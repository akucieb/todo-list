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

@WebServlet(name = "TodoServlet", urlPatterns = {"/todo", "/todo/create", "/todo/delete"})
public class TodoServlet extends HttpServlet {

    private TodoService todoService;

    public TodoServlet() {
        this.todoService = new TodoService(new TodoRepository(PersistenceUtil.getEntityManager()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getServletPath();
        if (path.equals("/todo/create")) {
            req.getRequestDispatcher("/todo/create.jsp").forward(req, resp);
        } else if (path.equals("/todo/delete")) {
            String id = req.getParameter("id");
            //todo : try-catch TodoNotPresentException
            TodoItem toDelete = todoService.getById(Long.parseLong(id));
            req.setAttribute("itemToDelete", toDelete);
            req.getRequestDispatcher("/todo/delete.jsp").forward(req, resp);
        } else {
            List<TodoItem> allTodos = todoService.getAllTodos();
            req.setAttribute("todos", allTodos);
            req.getRequestDispatcher("/todo/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String servletPath = req.getServletPath();
        if (servletPath.equals("/todo/create")) {
            TodoItem todoItem = new TodoItem();
            todoItem.setTitle(req.getParameter("title"));
            todoItem.setDescription(req.getParameter("description"));
            // todo: parse date from request
            //    todoItem.setStartDate();
            todoService.save(todoItem);
            req.getSession().setAttribute("todo_created", true);
            resp.sendRedirect("/todo");
        } else if (servletPath.equals("/todo/delete")) {
            String id = req.getParameter("id");
            boolean result = this.todoService.delete(Long.parseLong(id));
            req.getSession().setAttribute("delete_result", result);
            resp.sendRedirect("/todo");

        }

    }
}