package srp;

import org.apache.commons.text.StringEscapeUtils;
import java.util.function.Predicate;

public class Programmers implements Report {
    private Store store;

    public Programmers(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return StringEscapeUtils.escapeHtml4(text.toString());
    }
}
