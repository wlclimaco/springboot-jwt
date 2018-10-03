package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
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
import javax.validation.Valid;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.domain.Category;
import com.nouhoun.springboot.jwt.integration.domain.Empresa;
import com.nouhoun.springboot.jwt.integration.domain.EmpresaDTO;
import com.nouhoun.springboot.jwt.integration.domain.Horarios;
import com.nouhoun.springboot.jwt.integration.domain.Job;
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Dias;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.domain.UserDTO;
import com.nouhoun.springboot.jwt.integration.service.EmpresaService;
import com.nouhoun.springboot.jwt.integration.service.JobService;
import com.nouhoun.springboot.jwt.integration.service.JogoService;

@Controller
public class EmpresaController {
	private static Logger LOG = LoggerFactory.getLogger(EmpresaController.class);
	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private JogoService jogoService;
	
    @Autowired
    private JobService jobService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/empresa/insert", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse createNewMensagem(@RequestBody String user)
			throws JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		EmpresaDTO empresaDTO = mapper.readValue(user, EmpresaDTO.class);
		
		Empresa empresa = new  Empresa(empresaDTO.getId(),
		empresaDTO.getNome(),
		empresaDTO.getNomeResponsavel(),
		empresaDTO.getEmail(),
		empresaDTO.getTelefone(),
		empresaDTO.getEndereco(),
		empresaDTO.getEnderecoId(),
		empresaDTO.getQuadras(),
		empresaDTO.getNotificacoes());

		empresaService.saveEmpresa(empresa);
		
		jogoService.saveJogo(generateJogos(empresa));
		
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	        Job job = new Job();
	        job.setName("JOB001");
	        job.setMetadataJson("{}");
	        job.setCategory(new Category());
	        job.setCallbackUrl("");
	        job.setSubmitTime(new Date(System.currentTimeMillis()));
	        job.setStatus(Job.Status.NEW);
	        job.setRetryCount(0);

	        try {
				jobService.insert(job);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return APIResponse.toOkResponse(authResp);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/empresa/update", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateMensagem(@Valid Empresa user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();
		Empresa userExists = empresaService.findEmpresaByEmail(user.getEmail());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

		empresaService.updateEmpresa(user);
		modelAndView.addObject("successMessage", "User has been registered successfully");
		modelAndView.addObject("user", new Empresa());

		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/empresa/delete", method = RequestMethod.POST)
	public @ResponseBody APIResponse deleteMensagem(@Valid Empresa user, BindingResult bindingResult) {

		List<String> erros = new ArrayList<String>();

		empresaService.deleteEmpresa(user);

		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		//createAuthResponse(user, authResp);

		return APIResponse.toOkResponse(authResp);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/empresa/fetchByUser", method = RequestMethod.POST)
	public @ResponseBody APIResponse fetchByUser(@Valid String user, BindingResult bindingResult) {

		List<String> erros = new ArrayList<String>();

		List<Empresa> empresas = empresaService.findEmpresaByUser(user);

		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("empresaList", empresas);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/empresa/fetchAllEmpresa", method = RequestMethod.POST)
	public ResponseEntity<List<Empresa>> fetchAllEmpresa(@Valid Empresa user, BindingResult bindingResult) {

		List<String> erros = new ArrayList<String>();

		List<Empresa> empresas = empresaService.findAllEmpresa();

		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("empresaList", empresas);
		authResp.put("Error", erros);

		return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
	}

	public List<Jogo> generateJogos(Empresa empresa) {
		Jogo jogo = new Jogo();
		List<Jogo> jogos = new ArrayList<Jogo>();
		for (Quadra quadra : empresa.getQuadras()) {

			for (Horarios horario : quadra.getHorarioAberto()) {
				if (horario.getDom() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.DOMINGO);
				}
				if (horario.getSeg() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.SEGUNDA);
				}
				if (horario.getTer() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.TERCA);
				}
				if (horario.getQua() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.QUARTA);
				}
				if (horario.getQui() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.QUINTA);
				}
				if (horario.getSex() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.SEXTA);
				}
				if (horario.getSab() == 1) {
					GravarJogo(jogos, quadra, horario, Dias.SABADO);
				}	

			}

		}

		return jogos;
	}

	private void GravarJogo(List<Jogo> jogos, Quadra quadra, Horarios horario, Dias dia) {

		
		Date dateInicial = new Date();
		String[] horas = horario.getHoraInicial().split(":");
		dateInicial.setHours(Integer.parseInt(horas[0]));
		dateInicial.setMinutes(Integer.parseInt(horas[1]));

		Date dateFinal = new Date();
		horas = horario.getHoraFinal().split(":");
		dateFinal.setHours(Integer.parseInt(horas[0]));
		dateFinal.setMinutes(Integer.parseInt(horas[1]));
		String ultData = "";
		while (!(ultData.equals(horario.getHoraFinal() ))) {
			//date = new Date(dateInicial.getTime() + Integer.parseInt(quadra.getTempoJogo()) * 60 * 1000);
			Jogo jogo = new Jogo();
			jogo.setQuadraId(quadra.getId());
			jogo.setDia(dia);
			jogo.setHoraInicial(dateInicial.getHours() + ":" + dateInicial.getMinutes());
			dateInicial = new Date(dateInicial.getTime() + Integer.parseInt(quadra.getTempoJogo()) * 60 * 1000);
			jogo.setHoraFinal(dateInicial.getHours() + ":" + dateInicial.getMinutes());
			jogo.setStatus(Status.DISPONIVEL);
			ultData = jogo.getHoraFinal();
			jogos.add(jogo);
		}
	}
	private String decryptPassword(UserDTO userDTO) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
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
        }
        catch (DecoderException e) {
            throw new IllegalStateException(e);
        }
    }
}
