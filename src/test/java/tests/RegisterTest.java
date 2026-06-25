//package tests;
//
//import org.testng.annotations.Test;
//
//import base.BaseTest;
//import pages.RegisterPage;
//import utils.FakerUtil;
//
//public class RegisterTest extends BaseTest {
//
//    @Test
//    public void verifyUserRegistration() {
//
//    	  RegisterPage register = new RegisterPage(page);
//
//    	    register.openRegisterPage();
//
//    	    String firstName = FakerUtil.getFirstName();
//    	    String lastName = FakerUtil.getLastName();
//    	    String email = FakerUtil.getEmail();
//    	    String password = FakerUtil.getPassword();
//
//    	    register.fillRegistrationForm(
//    	            firstName,
//    	            lastName,
//    	            email,
//    	            password
//    	    );
//
//    	    register.clickRegister();
//    }
//}