import com.example.myboot.web.FirstController;
import com.example.myboot.web.WebController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

@SpringBootTest
public class WebControllerTest {

    private MockMvc mockMvc;
    //private WebApplicationContext webApplicationContext = new GenericWebApplicationContext();

    @Before
    public void setUp() throws Exception {
        //standaloneSetup  方法controller只能有一个方法
        //MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }
    @Test
    public void getUser() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

   @Test
    public void validPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/validPerson")
                .param("name","22")
                .param("age","666")
                .param("pass","test236")
        );
    }
}
