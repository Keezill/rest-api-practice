package mamedov.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import mamedov.utils.UserInfoContainer;
import mamedov.utils.RequestCounter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
public class VisitsServlet extends HttpServlet {
    private final List<UserInfoContainer> dataList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RequestCounter.add();
        PrintWriter responseBody = resp.getWriter();

        resp.setContentType("application/json");
        for (int i = 0; i < dataList.size(); i++) {
            if (i < 3) {
                UserInfoContainer data = dataList.get(i);
                responseBody.println(new ObjectMapper().writeValueAsString(data));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RequestCounter.add();
        UserInfoContainer data = new UserInfoContainer(req.getParameter("name"), req.getParameter("date"), req.getParameter("city"));
        synchronized (dataList) {
            dataList.add(data);
        }
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), dataList);
    }

}
