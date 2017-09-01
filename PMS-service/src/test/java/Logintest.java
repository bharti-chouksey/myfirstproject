import org.junit.Test;

import com.aartek.repository.LoginRepository;
import com.aartek.service.LoginService;

import mockit.Injectable;
import mockit.Tested;

public class Logintest {
	@Injectable
	private LoginRepository loginRepository;
	@Tested
	private LoginService loginService;
	
	@Test
	public void testservice()
	{
		
	}

}
