package restapi;
@Controller
public class RestController {
 
    @GetMapping(value = "/student/{studentId}")
    public @ResponseBody Student getTestData(@PathVariable Integer studentId) {
        Student student = new Student();
        student.setName("Peter");
        student.setId(studentId);
 
        return student;
    }
}