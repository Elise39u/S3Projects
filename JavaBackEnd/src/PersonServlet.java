import com.company.DataStore;
import com.company.Person;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;

import java.lang.Object;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//issue with not finding the import, Maby looking for an alternative
// import org.json.json;

public class PersonServlet extends HttpServlet {

    private JSONParser JSONObject;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURI();
        String name = requestUrl.substring("/people/".length());

        Person person = DataStore.getInstance().getPerson(name);

        if(person != null) {
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
            json += "\"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
            json += "\"age\": " + person.getAge() + "\n";
            json += "}";
            resp.getOutputStream().println(json);
        } else {
            //This response is given back when the parmate name has not been found
            resp.getOutputStream().println("No person found with: " + name);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String about = req.getParameter("about");
        int age = Integer.parseInt(req.getParameter("age"));

        DataStore.getInstance().putPerson(new Person(name, about, age));

        resp.getOutputStream().println("Person with the name " + name + " has been added");
    }
}
