package userlogin.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userlogin.model.UserModel;
import userlogin.repository.UserLoginRepository;
import userlogin.service.EncryptionAndDecryption;
import userlogin.service.PasscodeMailService;

@RestController
@RequestMapping(path="/employee")
public class Controller {
	
	@Autowired
	UserLoginRepository userLoginRepository;
	@Autowired
	EncryptionAndDecryption encryptionAndDecryption;
	//@Autowired
	//PasscodeMailService passcodeMailService;

    final String secretKey = "Encryption";
	
	@GetMapping(path="/login")
	public void userLogin(@RequestBody UserModel userModel)
	{
		String userName  = encryptionAndDecryption.encrypt(userModel.getUserName(), secretKey);
		
		List<UserModel> loginDetails = userLoginRepository.findByuserName(userName);
		
		if(loginDetails.isEmpty())
			System.out.println("UserName not found");
		
		
	}
	
	@GetMapping(path="/new-user")
	public void newUserLogin(@RequestBody UserModel userModel)
	{
		 if(!userLoginRepository.findByEmailId(userModel.getMailId()))
		 {
		 String userName = encryptionAndDecryption.encrypt(userModel.getUserName(), secretKey);
		 String passcode = encryptionAndDecryption.encrypt(userModel.getPasscode(), secretKey);
		 userModel.setUserName(userName);
		 userModel.setPasscode(passcode);
		 userLoginRepository.save(userModel);
		 }
		
	}
	@GetMapping(path="/reset-login")
	public void userPasswordReset(@RequestBody UserModel userModel)
	{
		PasscodeMailService passcodeMailService = new PasscodeMailService();
		try {
			passcodeMailService.sendEmail();
		} catch (MessagingException e) {
		
			e.printStackTrace();
		}
	}
	@PostMapping(path="/post")
	public String test()
	{
		return "success gateway is working";
	}

}
