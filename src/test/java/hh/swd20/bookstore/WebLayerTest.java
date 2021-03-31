package hh.swd20.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class WebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test  // This test doesn't work correctly.
	public void testDeleteById() throws Exception {
		this.mockMvc.perform(post("/delete/1")).andDo(print()).andExpect(status().isOk());
	}

	
	


}
