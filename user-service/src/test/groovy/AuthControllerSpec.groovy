import com.fasterxml.jackson.databind.ObjectMapper
import com.pulsetrade.user_service.api.controller.AuthController
import com.pulsetrade.user_service.api.dto.AuthResponse
import com.pulsetrade.user_service.api.dto.RegisterRequest
import com.pulsetrade.user_service.application.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

import java.lang.runtime.ObjectMethods

@WebMvcTest(AuthController.class)
class AuthControllerSpec extends Specification{
    @Autowired
    MockMvc mockMvc

    @MockBean
    AuthService authService

    def objectMapper = new ObjectMapper()

    def "should register user successfully"(){
        given:
        def request = new RegisterRequest(email: "abc@gmail.com", password: "pass123", firstName: "John", lastName: "Doe")
        def response = new AuthResponse(token: "dummy-token")

        authService.register(_) >> response
        expect:
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOK())

    }


}
