package pl.milgodyn.taskdatatransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import pl.milgodyn.taskdatatransfer.application.configuration.SecurityConfiguration;

@SpringBootTest
@AutoConfigureMockMvc
@Import(SecurityConfiguration.class)
public abstract class AbstractIntegrationTest {

    protected static final String COORDINATES_REQUEST_PATH = "/v1/coordinates/";
    protected static final String VALID_AUTHORIZATION_HEADER_VALUE = "Basic dXNlcjpwYXNzd29yZA==";

    @Autowired
    protected MockMvc mockMvc;
}
