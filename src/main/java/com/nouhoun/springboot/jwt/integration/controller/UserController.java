package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.domain.InfoUser;
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.NotasGols;
import com.nouhoun.springboot.jwt.integration.domain.UserDTO;
import com.nouhoun.springboot.jwt.integration.domain.security.Authority;
import com.nouhoun.springboot.jwt.integration.domain.security.User;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	public JogoService jogoService;

	// @Autowired
	// private JogoService jogoService;
	public int getfifteen() {
		return 15;
	}

    /**
     * Register new user
     * POST body expected in the format - {"user":{"displayName":"Display Name", "email":"something@somewhere.com"}}
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST, headers = {"content-type=application/json","content-type=application/xml"})
    public @ResponseBody APIResponse register(@RequestBody UserDTO userDTO,
                                              HttpServletRequest request) throws NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
        Validate.isTrue(StringUtils.isNotBlank(userDTO.getEmail()), "Email is blank");
        Validate.isTrue(StringUtils.isNotBlank(userDTO.getEncryptedPassword()), "Encrypted password is blank");
        Validate.isTrue(StringUtils.isNotBlank(userDTO.getName()), "Display name is blank");
      //  String password = decryptPassword(userDTO);

        LOG.info("Looking for user by email: "+userDTO.getEmail());
      //  if(userService.isEmailExists(userDTO.getEmail())) {
      //      return APIResponse.toErrorResponse("Email is taken");
      //  }

        LOG.info("Creating user: "+userDTO.getEmail());
        User user = new User();
        user.setEmail(userDTO.getEmail());
    //    user.setRoles(userDTO.getRoles());
        user.setUsername(userDTO.getName());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(true);
        List<Authority> roles = new ArrayList<Authority>();
        roles.add(new Authority(new Long(1)));
        roles.add(new Authority(new Long(2)));
        user.setAuthorities(roles);
        user.setLastPasswordResetDate(new Date(System.currentTimeMillis() + 1000 * 1000));
        userService.saveUser(user, request);

        HashMap<String, Object> authResp = new HashMap<>();

        return APIResponse.toOkResponse(authResp);
    }

//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public @ResponseBody APIResponse updateMensagem(@RequestBody UserDTO userDTO,
//            HttpServletRequest request) throws NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
//		ModelAndView modelAndView = new ModelAndView();
//		List<String> erros = new ArrayList<String>();
//		User userExists = userService.findUserByEmail(userDTO.getEmail());
//		if (userExists == null) {
//			erros.add("There is already a user registered with the email provided");
//		}
//		
//		User user23= userService.updateUser(new User(userDTO), request);
//		modelAndView.addObject("successMessage", "User has been registered successfully");
//		modelAndView.addObject("user", userDTO);
//		modelAndView.setViewName("registration");
//
//		HashMap<String, Object> authResp = new HashMap<String, Object>();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		InfoUser info = getInfoUser(user23); 
//		user23.setQntJogos(info.getQntJogos());
//		user23.setQntGols(info.getQntGols());
//		user23.setMediaNota(info.getMediaNota());
//		user23.setMediaGols(info.getMediaGols());
//		Object token = auth.getCredentials();
//		authResp.put("token", token);
//		authResp.put("user", user23);
//		authResp.put("Error", erros);
//
//		return APIResponse.toOkResponse(authResp);
//	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/findUserById", method = RequestMethod.POST)
	public User getUsers(@RequestBody Integer id, HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		User user = userService.findUserById(id);
		
		InfoUser info = getInfoUser(user); 
		user.setQntJogos(info.getQntJogos());
		user.setQntGols(info.getQntGols());
		user.setMediaNota(info.getMediaNota());
		user.setMediaGols(info.getMediaGols());

		return user;
	}

	private InfoUser getInfoUser(User user) {
		List<Jogo> quadra = jogoService.findJogoByUser(user.getId().intValue());
		Integer countJogos = 0;
		Integer countGols = 0;
		Integer countMedia = 0;
		Double media = new Double(0);
		for (Jogo jogo : quadra) {
			if(jogo!= null && !jogo.getJogoPorData().isEmpty()) {
				countJogos++;
				for (JogoPorData jogoPorData : jogo.getJogoPorData()) {
					if(jogoPorData!= null && !jogoPorData.getNotasGols().isEmpty() && StatusJogoPorData.JAJOGADO.equals(jogoPorData.getStatus())) {
						for (NotasGols notasGols : jogoPorData.getNotasGols()) {
							if(notasGols.getUserId().intValue() == user.getId()) {
								countMedia++;
								media = media + notasGols.getNota();
								countGols = countGols + notasGols.getQntGols();
							}
						}
					}
				}
			}
			
		}
		//InfoUser(Integer qntJogos, Integer qntGols, Double mediaNota, Double mediaGols)
		return new InfoUser(countJogos,countGols,(media/countMedia),new Double(countGols/countJogos));
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/findUserByEmail", method = RequestMethod.POST)
	public User findUserByEmail(@RequestBody String email, HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		User user =  userService.findUserByEmail(email);
	//	user.setInfoUser(getInfoUser(user));
		return user;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/fetchByUser", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<UserDTO>> fetchByUser(@RequestBody String userString,
			HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		List<String> erros = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userString, User.class);
		User userExists = userService.findUserByEmail(user.getEmail());
		// List<Jogo> jogos= jogoService.findJogoByUser(userExists);
		UserDTO dto = new UserDTO();
		dto.setId(userExists.getId().intValue());
		dto.setEmail(userExists.getEmail());
		dto.setPassword(userExists.getPassword());
		dto.setName(userExists.getUsername());
		//dto.setActive(userExists.getActive());
	//	dto.setRoles(userExists.getRoles());
		dto.setEnabled(userExists.getEnabled());
		// dto.setJogos(jogos);

		return new ResponseEntity<List<UserDTO>>(Arrays.asList(dto), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user/fetchAll", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<User>> fetchByAllUser(@RequestBody String userString,
			HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {

		return new ResponseEntity<List<User>>(userService.findAllUser(), HttpStatus.OK);
	}


}
