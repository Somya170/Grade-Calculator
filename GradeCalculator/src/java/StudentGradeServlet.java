import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentGradeServlet")
public class StudentGradeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve marks from the form
        int subject1 = Integer.parseInt(request.getParameter("subject1"));
        int subject2 = Integer.parseInt(request.getParameter("subject2"));
        int subject3 = Integer.parseInt(request.getParameter("subject3"));
        int subject4 = Integer.parseInt(request.getParameter("subject4"));
        int subject5 = Integer.parseInt(request.getParameter("subject5"));

        // Calculate total marks, average, percentage, CGPA, and grade
        int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
        double average = totalMarks / 5.0;
        double percentage = (totalMarks / 500.0) * 100;
        double cgpa = percentage / 9.5;

        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Set attributes to be displayed in the result page
        request.setAttribute("average", average);
        request.setAttribute("percentage", percentage);
        request.setAttribute("cgpa", cgpa);
        request.setAttribute("grade", grade);

        // Forward to the result page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
