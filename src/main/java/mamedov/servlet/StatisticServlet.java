package mamedov.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import mamedov.utils.CounterAndDateContainer;
import mamedov.utils.RequestCounter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RequestCounter.add();
        PrintWriter responseBody = resp.getWriter();

        resp.setContentType("application/json");
        CounterAndDateContainer counterAndDateContainer = new CounterAndDateContainer();
        responseBody.println(new ObjectMapper().writeValueAsString(counterAndDateContainer));
    }
}
