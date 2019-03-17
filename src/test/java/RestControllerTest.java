import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest(classes = {com.example.myboot.web.MyRestController.class, com.example.myboot.service.impl.RestServiceImpl.class})
@RunWith(SpringRunner.class)
public class RestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc
                = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test() throws Exception{
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "text");
        params.add("count", "summary");
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params))
               .andReturn().getResponse().getContentAsString();

        System.out.println("Result === "+result);
    }

}
