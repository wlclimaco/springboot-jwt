package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.config.JWTTokenAuthFilter;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDTO;
import com.nouhoun.springboot.jwt.integration.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

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
        Validate.isTrue(StringUtils.isNotBlank(userDTO.getNome()), "Display name is blank");
      //  String password = decryptPassword(userDTO);

        LOG.info("Looking for user by email: "+userDTO.getEmail());
      //  if(userService.isEmailExists(userDTO.getEmail())) {
      //      return APIResponse.toErrorResponse("Email is taken");
      //  }

        LOG.info("Creating user: "+userDTO.getEmail());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setRoles(userDTO.getRoles());
        user.setNome(userDTO.getNome());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(true);

        userService.saveUser(user, request);

        HashMap<String, Object> authResp = new HashMap<>();
        createAuthResponse(user, authResp);

        return APIResponse.toOkResponse(authResp);
    }

    private void createAuthResponse(User user, HashMap<String, Object> authResp) {
        String token = Jwts.builder().setSubject(user.getEmail())
                .claim("role", user.getRoles().get(0).getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, JWTTokenAuthFilter.JWT_KEY).compact();
        authResp.put("token", token);
        authResp.put("user", user);
    }

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateMensagem(@Valid User user, BindingResult bindingResult,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

		userService.saveUser(user, request);
		modelAndView.addObject("successMessage", "User has been registered successfully");
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("registration");

		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/findUserById", method = RequestMethod.POST)
	public User getUsers(@RequestBody Integer id, HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		return userService.findUserById(id);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/findUserByEmail", method = RequestMethod.POST)
	public User findUserByEmail(@RequestBody String email, HttpServletRequest request, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		return userService.findUserByEmail(email);
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
		dto.setId(userExists.getId());
		dto.setEmail(userExists.getEmail());
		dto.setPassword(userExists.getPassword());
		dto.setNome(userExists.getNome());
		dto.setActive(userExists.getActive());
		dto.setRoles(userExists.getRoles());
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

	private String base64(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	private byte[] base64(String str) {
		return Base64.decodeBase64(str);
	}

	private String hex(byte[] bytes) {
		return Hex.encodeHexString(bytes);
	}

	private byte[] hex(String str) {
		try {
			return Hex.decodeHex(str.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalStateException(e);
		}
	}

	private String decryptPassword(UserDTO userDTO) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, InvalidKeySpecException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException {
		String passPhrase = "biZndDtCMkdeP8K0V15OKMKnSi85";
		String salt = userDTO.getSalt();
		String iv = userDTO.getIv();
		int iterationCount = userDTO.getIterations();
		int keySize = userDTO.getKeySize();

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), hex(salt), iterationCount, keySize);
		SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(hex(iv)));
		byte[] decrypted = cipher.doFinal(base64(userDTO.getEncryptedPassword()));

		return new String(decrypted, "UTF-8");
	}

}
